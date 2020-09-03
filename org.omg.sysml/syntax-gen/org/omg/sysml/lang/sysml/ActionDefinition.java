/**
 */
package org.omg.sysml.lang.sysml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>An ActionDefinition is a Definition that is also a Behavior that defines an action performed by a system or part of a system.</p>
 * 
 * <p>An ActionDefinition must subclass, directly or indirectly, the base ActionDefinition Action from the Systems model library.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.sysml.lang.sysml.ActionDefinition#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @see org.omg.sysml.lang.sysml.SysMLPackage#getActionDefinition()
 * @model
 * @generated
 */
public interface ActionDefinition extends Definition, Behavior {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.ActionUsage}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Behavior#getStep() <em>Step</em>}'</li>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Definition#getUsage() <em>Usage</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The ActionUsages that are Steps in this Activity, which define the actions that specify the behavior of the Activity.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Action</em>' reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getActionDefinition_Action()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='featuringActionDefinition'"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<ActionUsage> getAction();

} // Activity
