/*******************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2020-2022 Model Driven Solutions, Inc.
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
 *******************************************************************************/
/**
 */
package org.omg.sysml.lang.sysml.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.Expression;
import org.omg.sysml.lang.sysml.LiteralInfinity;
import org.omg.sysml.lang.sysml.LiteralInteger;
import org.omg.sysml.lang.sysml.MultiplicityRange;
import org.omg.sysml.lang.sysml.SysMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.MultiplicityRangeImpl#getBound <em>Bound</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.MultiplicityRangeImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.MultiplicityRangeImpl#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiplicityRangeImpl extends MultiplicityImpl implements MultiplicityRange {

	/**
	 * The cached setting delegate for the '{@link #getLowerBound() <em>Lower Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate LOWER_BOUND__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SysMLPackage.Literals.MULTIPLICITY_RANGE__LOWER_BOUND).getSettingDelegate();
	/**
	 * The cached setting delegate for the '{@link #getUpperBound() <em>Upper Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate UPPER_BOUND__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SysMLPackage.Literals.MULTIPLICITY_RANGE__UPPER_BOUND).getSettingDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicityRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SysMLPackage.Literals.MULTIPLICITY_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getLowerBound() {
		return (Expression)LOWER_BOUND__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetLowerBound() {
		return (Expression)LOWER_BOUND__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLowerBound(Expression newLowerBound) {
		LOWER_BOUND__ESETTING_DELEGATE.dynamicSet(this, null, 0, newLowerBound);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getUpperBound() {
		return (Expression)UPPER_BOUND__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetUpperBound() {
		return (Expression)UPPER_BOUND__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUpperBound(Expression newUpperBound) {
		UPPER_BOUND__ESETTING_DELEGATE.dynamicSet(this, null, 0, newUpperBound);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Expression> getBound() {
		return new DerivedUnionEObjectEList<Expression>(Expression.class, this, SysMLPackage.MULTIPLICITY_RANGE__BOUND, BOUND_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getBound() <em>Bound</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBound()
	 * @generated
	 * @ordered
	 */
	protected static final int[] BOUND_ESUBSETS = new int[] {SysMLPackage.MULTIPLICITY_RANGE__LOWER_BOUND, SysMLPackage.MULTIPLICITY_RANGE__UPPER_BOUND};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBound() {
		return !getBound().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Element> getOwnedMember() {
		@SuppressWarnings("unchecked")
		EList<Element> bound = (EList<Element>)((EList<?>)getBound());
		return bound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedMember() {
  		return false;
	}
	
	// Operations
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasBounds(int lower, int upper) {
		if (valueOf(getUpperBound()) != upper) {
			return false;
		} else {
			int lowerValue = valueOf(getLowerBound());
			return lowerValue == lower ||
				   lowerValue < -1 &&
				   		(lower == upper || lower == 0 && upper == -1);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int valueOf(Expression bound) {
		if (bound != null && bound.isModelLevelEvaluable()) {
			EList<Element> boundEval = bound.evaluate(getOwningNamespace());
			if (boundEval.size() == 1) {
				Element valueEval = boundEval.get(0);
				if (valueEval instanceof LiteralInfinity) {
					// Return -1 to represent "*".
					return -1;
				} else if (valueEval instanceof LiteralInteger) {
					int value = ((LiteralInteger)valueEval).getValue();
					if (value >= 0) {
						return value;
					}
				}
			}
		}
		// Return -2 to represent a "null" result.
		return -2;
	}

	//

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SysMLPackage.MULTIPLICITY_RANGE__BOUND:
				return getBound();
			case SysMLPackage.MULTIPLICITY_RANGE__LOWER_BOUND:
				if (resolve) return getLowerBound();
				return basicGetLowerBound();
			case SysMLPackage.MULTIPLICITY_RANGE__UPPER_BOUND:
				if (resolve) return getUpperBound();
				return basicGetUpperBound();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SysMLPackage.MULTIPLICITY_RANGE__LOWER_BOUND:
				setLowerBound((Expression)newValue);
				return;
			case SysMLPackage.MULTIPLICITY_RANGE__UPPER_BOUND:
				setUpperBound((Expression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SysMLPackage.MULTIPLICITY_RANGE__LOWER_BOUND:
				setLowerBound((Expression)null);
				return;
			case SysMLPackage.MULTIPLICITY_RANGE__UPPER_BOUND:
				setUpperBound((Expression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SysMLPackage.MULTIPLICITY_RANGE__BOUND:
				return isSetBound();
			case SysMLPackage.MULTIPLICITY_RANGE__OWNED_MEMBER:
				return isSetOwnedMember();
			case SysMLPackage.MULTIPLICITY_RANGE__LOWER_BOUND:
				return LOWER_BOUND__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case SysMLPackage.MULTIPLICITY_RANGE__UPPER_BOUND:
				return UPPER_BOUND__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SysMLPackage.MULTIPLICITY_RANGE___HAS_BOUNDS__INT_INT:
				return hasBounds((Integer)arguments.get(0), (Integer)arguments.get(1));
			case SysMLPackage.MULTIPLICITY_RANGE___VALUE_OF__EXPRESSION:
				return valueOf((Expression)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //MultiplicityRangeImpl
