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

package org.omg.sysml.lang.sysml.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.omg.sysml.expressions.ModelLevelExpressionEvaluator;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.Expression;
import org.omg.sysml.lang.sysml.Feature;
import org.omg.sysml.lang.sysml.FeatureReferenceExpression;
import org.omg.sysml.lang.sysml.Metaclass;
import org.omg.sysml.lang.sysml.MetadataFeature;
import org.omg.sysml.lang.sysml.SysMLPackage;
import org.omg.sysml.lang.sysml.Type;
import org.omg.sysml.util.ExpressionUtil;
import org.omg.sysml.util.FeatureUtil;
import org.omg.sysml.util.TypeUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Feature
 * Reference Expression</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.FeatureReferenceExpressionImpl#getReferent <em>Referent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureReferenceExpressionImpl extends ExpressionImpl implements FeatureReferenceExpression {
	
	/**
	 * The cached setting delegate for the '{@link #getReferent() <em>Referent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferent()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate REFERENT__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SysMLPackage.Literals.FEATURE_REFERENCE_EXPRESSION__REFERENT).getSettingDelegate();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureReferenceExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SysMLPackage.Literals.FEATURE_REFERENCE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Feature getReferent() {
		return (Feature)REFERENT__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetReferent() {
		return (Feature)REFERENT__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferent(Feature newReferent) {
		REFERENT__ESETTING_DELEGATE.dynamicSet(this, null, 0, newReferent);
	}
	
	// Additional overrides
	
	@Override
	public boolean modelLevelEvaluable(EList<Feature> visited) {
		Feature referent = getReferent();
		if (referent == null || TypeUtil.conforms(referent, ExpressionUtil.getSelfReferenceFeature(referent))) {
			return true;
		} else if (visited.contains(referent)) {
			return false;
		} else {
			visited.add(referent);
			if (referent instanceof Expression && ((Expression) referent).modelLevelEvaluable(visited)) {
				return true;
			} else {
				Type owningType = referent.getOwningType();
				if (owningType instanceof Metaclass || owningType instanceof MetadataFeature) {
					return true;
				} else if (!referent.getFeaturingType().isEmpty()) {
					return false;
				} else {
					Expression valueExpression = FeatureUtil.getValueExpressionFor(referent);
					return valueExpression == null || valueExpression.modelLevelEvaluable(visited);
				}
			}
		}
	}
	
	@Override
	public EList<Element> evaluate(Element target) {
		return ModelLevelExpressionEvaluator.INSTANCE.evaluateFeatureReference(this, target);
	}
	
	//
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SysMLPackage.FEATURE_REFERENCE_EXPRESSION__REFERENT:
				if (resolve) return getReferent();
				return basicGetReferent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SysMLPackage.FEATURE_REFERENCE_EXPRESSION__REFERENT:
				setReferent((Feature)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SysMLPackage.FEATURE_REFERENCE_EXPRESSION__REFERENT:
				setReferent((Feature)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SysMLPackage.FEATURE_REFERENCE_EXPRESSION__REFERENT:
				return REFERENT__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

} // FeatureReferenceExpressionImpl
