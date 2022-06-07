/*****************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2019 Model Driven Solutions, Inc.
 *    
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of theGNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * @license LGPL-3.0-or-later <http://spdx.org/licenses/LGPL-3.0-or-later>
 * 
 * Contributors:
 *  Ed Seidewitz
 * 
 *****************************************************************************/
package org.omg.sysml.util.traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;

import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.Expression;
import org.omg.sysml.lang.sysml.LiteralInteger;
import org.omg.sysml.lang.sysml.Membership;
import org.omg.sysml.lang.sysml.MultiplicityRange;
import org.omg.sysml.lang.sysml.Relationship;
import org.omg.sysml.lang.sysml.Type;
import org.omg.sysml.lang.sysml.Usage;
import org.omg.sysml.util.traversal.facade.ElementProcessingFacade;
import org.omg.sysml.util.traversal.facade.impl.BandedGraphProcessingFacade;

/**
 * Implement the traversal of a graph of SysML Elements in which non-Relationship Elements are
 * connected only by Relationship Elements.
 * 
 * @author Ed Seidewitz
 *
 */
public class NestedFeatureTraversal extends Traversal {
	
	public enum DebugLevel {
		INFO,
		TRACE,
		ERROR
	}
	
	public DebugLevel currentDebug = DebugLevel.TRACE;
	
	private HashMap<Element, ArrayList<Element>> pathToElement = new HashMap<Element, ArrayList<Element>>();
	
	public NestedFeatureTraversal() {
		super(null);
	}

	/**
	 * Create an Element visitor for the given element.
	 */
	@Override
	public NestedFeatureVisitor createVisitor(Element element) {
		return new NestedFeatureVisitor(element, this);
	}
	
	public NestedFeatureVisitor createVisitor(Element element, Element visitingFrom) {
		return new NestedFeatureVisitor(element, this, visitingFrom);
	}
	
	public BandedRelationshipVisitor createRelationshipVisitor(Relationship element, Element visitingFrom) {
		return new BandedRelationshipVisitor(element, this, visitingFrom);
	}
	
	/**
	 * Check whether the given Element has been visited previously. If so, then return
	 * that identifier without doing any processing. Otherwise, create a visitor and
	 * use it to visit the given Element.
	 * 
	 * @param 	element			the Element to be visited
	 * @return	the identifier to be used for that Element
	 */
	@Override
	public Object visit(Element element) {
		Object identifier = this.getIdentifier(element);
		return identifier != null? identifier:
				this.visit(this.createVisitor(element));
	}
	
	public Object visit(Element visitingFrom, Relationship relation) {
		Object identifier = this.getIdentifier(relation);
		if (identifier != null) {
			return identifier;
		}
		else {
			return this.visit(this.createRelationshipVisitor(relation, visitingFrom));
		}
	}
	
	/**
	 * Check whether the given Element has been visited previously. If so, then return
	 * that identifier without doing any processing. Otherwise, create a visitor and
	 * use it to visit the given Element.
	 * 
	 * @param 	element			the Element to be visited
	 * @return	the identifier to be used for that Element
	 */
	public Object visit(Element element, Element visitingFrom, Relationship relation) {
		Object identifier = this.getIdentifier(element);
			
		if (identifier != null) {
			return identifier;
		}
		else {
			return this.visit(this.createVisitor(element, visitingFrom));
		}
	}
	
	public String describePaths() {
		String description = "";
		for (ArrayList<Element> thisPath : pathToElement.values()) {
			description = description + "\nNext path:\n";
			for (Element el : thisPath) {
				description = description + BandedGraphProcessingFacade.descriptionOf(el) + ", ";
			}
		}
		return description;
	}
	
	public String writePathConstraint() {
		String description = "";
		for (Element pathKey : pathToElement.keySet()) {
			ArrayList<Element> thisPath = pathToElement.get(pathKey);
			int counter = 0;
			int lowMultiplicity = 1;
			int highMultiplicity = 1;
			description = description + "\nNext constraint:\n";
			description = description + "# of ";
			for (Element el : thisPath) {
				
				if (counter < thisPath.size() - 1) {
					description = description + describeElement(el, false);
					description = description +".";
				}
				else {
					description = description + describeElement(el, true);
				}
				MultiplicityRange mult = null;
				Expression lowerExpr = null;
				Expression upperExpr = null;
				
				if (el instanceof Usage) {
					mult = getMultiplicity((Usage) el);
				}
				if (mult != null) {
					lowerExpr = mult.getLowerBound();
					upperExpr = mult.getUpperBound();
				}
				if (lowerExpr == null && upperExpr != null) {
					int newUpper = 1;
					newUpper = decodeMultExpression(upperExpr);
					highMultiplicity = highMultiplicity * newUpper;
					if (newUpper == 0) {
						lowMultiplicity = 0;
					}
				}
				else if (lowerExpr != null && upperExpr != null) {
					int newLower = 1;
					int newUpper = 1;
					newLower = decodeMultExpression(lowerExpr);
					newUpper = decodeMultExpression(upperExpr);
					lowMultiplicity = lowMultiplicity * newLower;
					highMultiplicity = highMultiplicity * newUpper;
				}
				counter++;
			}
			if (lowMultiplicity == highMultiplicity) {
				//description = description + describeElement(pathKey) + " " + pathKey.getIdentifier() +  " : ";
				description = description + "= " + String.valueOf(lowMultiplicity);
			}
			else if (lowMultiplicity != highMultiplicity) {
				//description = description + describeElement(pathKey) + " " + pathKey.getIdentifier() +  " : ";
				description = description + ">= " + String.valueOf(lowMultiplicity);
				description = description + " and <= " + String.valueOf(highMultiplicity);
			}
			
		}
		
		return description;
	}
	
	public MultiplicityRange getMultiplicity(Usage usedElement) {
		for (Relationship ownedRel : usedElement.getOwnedRelationship()) {
			if (ownedRel instanceof Membership) {
				for (Element el : ownedRel.getRelatedElement()) {
					if (!el.equals(usedElement) && el instanceof MultiplicityRange) {
						return (MultiplicityRange) el;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Create a description of the given SysML model Element, for use in logging.
	 * 
	 * @param 	element				the Element to be described
	 * @return	a description of the Element, in terms of its EClass name, hash code, Element name 
	 * 			and whether it is a proxy.
	 */
	public String describeElement(Element element, Boolean showMeta) {
		
		String s = "";
		String name = element.getName();
		if (name != null) {
			s += name;
		}
		else if (element instanceof Usage) {
			if (((Usage) element).getOwnedRedefinition().size() > 0) {
				s += ((Usage) element).getOwnedRedefinition().get(0).getRedefinedFeature().getName() + " (implied)";
			}
		}
		if (showMeta) {
			s += " [" + element.getClass().getName() + "]";
		}
		if (element.eIsProxy()) {
			s += " PROXY";
		}
		
		return s;
	}
	
	public ArrayList<Element> getBaseFeatures() {
		ArrayList<Element> baseElements = new ArrayList<Element>();
		for (Element object : pathToElement.keySet()) {
			if (pathToElement.get(object).size() == 1) {
				baseElements.add(object);
			}
		}
		return baseElements;
	}
	
	public void mapIntoPath(Element element, ArrayList<Element> workingPath) {
		pathToElement.put(element, workingPath);
	}
	
	public ArrayList<Element> getPathFor(Element element) {
		return pathToElement.get(element);
	}
	
	public void startNewPath(Element indexElement) {
		ArrayList<Element> selfList = new ArrayList<Element>();
		selfList.add(indexElement);
		pathToElement.put(indexElement, selfList);
	}
	
	public DebugLevel getCurrentDebug() {
		return this.currentDebug;
	}
	
	public int decodeMultExpression(Expression expr) {
		if (expr instanceof LiteralInteger) {
			return ((LiteralInteger) expr).getValue();
		}
		return 1;
	}
	
}