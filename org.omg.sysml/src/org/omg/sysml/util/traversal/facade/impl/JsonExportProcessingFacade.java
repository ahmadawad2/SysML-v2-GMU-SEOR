/*****************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2019-2021 Model Driven Solutions, Inc.
 * Copyright (c) 2021 Twingineer LLC
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
 *  Ivan Gomes
 * 
 *****************************************************************************/
package org.omg.sysml.util.traversal.facade.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.util.SysMLLibraryUtil;
import org.omg.sysml.model.ElementIdentity;
import org.omg.sysml.model.ElementVersion;
import org.omg.sysml.model.Identified;
import org.omg.sysml.util.traversal.Traversal;
import org.omg.sysml.util.traversal.facade.ElementProcessingFacade;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

/**
 * This is an element-processing facade that uses the SysML v2 REST API client to export Elements to JSON.
 * A list of ElementVersions is constructed during traversal of the model. Once the traversal is
 * completed, this change set can be exported to JSON.
 * 
 * @author Ed Seidewitz
 * @author Ivan Gomes
 *
 */
public class JsonExportProcessingFacade implements ElementProcessingFacade {

	private static final int ELEMENTS_PER_DOT = 100;
	private static final int DOTS_PER_LINE = 50;

	private Traversal traversal;
	private Gson gson;
	
	private boolean isVerbose = false;
	private int elementCount = 0;
	private int dotCount = "Processing".length();
	
	private final List<ElementVersion> versions = new ArrayList<>();
	
	/**
	 * Set the source SysML model traversal.
	 * 
	 * @param 	traversal			the source SysML model traversal from which Elements are being saved
	 */
	public void setTraversal(Traversal traversal) {
		this.traversal = traversal;
	}
	
	/**
	 * Get the source SysML model traversal.
	 * 
	 * @return	the source SysML model traversal from which Elements are being saved
	 */
	public Traversal getTraversal() {
		return this.traversal;
	}
	
	/**
	 * Set whether the facade prints a detailed trace of what is being traversed.
	 * 
	 * @param 	isVerbose		whether verbose mode is to be activated
	 */
	public void setIsVerbose(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}
	
	/**
	 * Return whether verbose mode is active.
	 * 
	 * @return whether verbose mode is active
	 */
	public boolean isVerbose() {
		return this.isVerbose;
	}

	/**
	 * Return the change set of ElementVersions to be committed.
	 * 
	 * @return	the change set of ElementsVersions to be committed. 
	 */
	List<ElementVersion> getVersions() {
		return Collections.unmodifiableList(this.versions);
	}
	
	/**
	 * Add an ElementVersion to the change set.
	 * 
	 * @param 	elementVersion	the ElementVersion to be added to the change set
	 */
	protected void addVersion(ElementVersion elementVersion) {
		this.versions.add(elementVersion);
	}
	
	/**
	 * Create an Identified object with the given identifier.
	 * 
	 * @param 	identifier			the UUID of the object being identified
	 * @return	an Identified object with the given identifier
	 */
	protected static Identified identified(UUID identifier) {
		return new Identified().atId(identifier);
	}
	
	/**
	 * Create an Identified object containing the identifier of the given element.
	 * 
	 * @param 	element				the Element to be identified
	 * @return	an Identified object the the given Element (or null if the input is null).
	 */
	protected Identified getIdentified(Element element) {
		Object identifier = this.traversal.getIdentifier(element);
		return identifier instanceof UUID? identified((UUID)identifier): null;
	}
	
	/**
	 * Create a list of Identified objects corresponding to the identifiers of a given list of Elements.
	 * 
	 * @param 	elements			the Elements being identified
	 * @return	a list of Identified objects with the identifiers of the given elements
	 */
	protected List<Identified> getIdentified(List<Element> elements) {
		return elements.stream().
				map(this::getIdentified).
				filter(id->id != null).
				collect(Collectors.toList());
	}

	/**
	 * Create an ElementVersion for the given model Element including the values of all its attributes 
	 * (unless it is a library model element, in which case only its non-referential attribute values 
	 * are included). The ID for the ElementVersion uses the identifier from the model Element.
	 * 
	 * @param 	element				the source model Element as it is represented in Ecore
	 * @return	an ElementVersion with the API representation of the given Element as its data
	 */
	@SuppressWarnings("unchecked")
	protected org.omg.sysml.model.ElementVersion createElementVersion(Element element) {
		org.omg.sysml.model.Element apiElement = new org.omg.sysml.model.Element();
		EClass eClass = element.eClass();
		apiElement.put("@type", eClass.getName());
		boolean isLibraryElement = SysMLLibraryUtil.isModelLibrary(element.eResource());
		for (EStructuralFeature feature: eClass.getEAllStructuralFeatures()) {
			String name = feature.getName();
			if (name == null || !(name.endsWith("_comp") || apiElement.containsKey(name))) {
				Object value = element.eGet(feature);
				if (feature instanceof EReference) {
					value = isLibraryElement? null:
							feature.isMany()?
								getIdentified((List<Element>)value):
								getIdentified((Element)value);
				}
				apiElement.put(feature.getName(), value);
			}
		}
		return new ElementVersion().data(apiElement).
				identity(new ElementIdentity().atId(UUID.fromString(element.getIdentifier())));
	}
	
	/**
	 * Create a description of the given SysML model Element, for use in logging.
	 * 
	 * @param 	element				the Element to be described
	 * @return	a description of the Element, in terms of its EClass name, hash code, Element name 
	 * 			and whether it is a proxy.
	 */
	public static String descriptionOf(Element element) {
		String s = element.eClass().getName();
		String name = element.getName();
		if (name != null) {
			s += " (" + name + ")";
		}		
		if (element.eIsProxy()) {
			s += " PROXY";
		}
		return s + " " + element.getIdentifier();
	}
	
	/**
	 * Record that the given Element is being processed by returning a UUID constructed
	 * from its identifier.
	 * 
	 * @param 	element				the Element to be processed
	 * @return	a unique identifier for the processed Element
	 */
	@Override
	public Object process(Element element) {
		if (this.isVerbose()) {
			System.out.println("Processing " + descriptionOf(element));
		} else {
			if (elementCount == ELEMENTS_PER_DOT) {
				System.out.print(".");
				elementCount = 0;
				dotCount++;
				if (dotCount == DOTS_PER_LINE) {
					System.out.println();
					dotCount = 0;
				}
			}
			elementCount++;
		}
		return UUID.fromString(element.getIdentifier());
	}
	
	/**
	 * Post-process the given Element by creating an ElementVersion for it and adding that
	 * to the change set being constructed. This is done as a post-processing step so that
	 * derived references to library model Elements not included in the change set can be
	 * excluded.
	 * 
	 * @param 	element				the Element to be post-processed
	 */
	@Override
	public void postProcess(Element element) {
		this.addVersion(this.createElementVersion(element));
	}
	
	public String toJson() {
		if (gson == null) {
			gson = new GsonBuilder().setPrettyPrinting().create();
		}
		return gson.toJson(versions);
	}
	
	public JsonElement toJsonTree() {
		if (gson == null) {
			gson = new GsonBuilder().setPrettyPrinting().create();
		}
		return gson.toJsonTree(versions);
	}
}