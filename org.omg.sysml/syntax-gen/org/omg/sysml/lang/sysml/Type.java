/**
 */
package org.omg.sysml.lang.sysml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>Types is the most general element supporting classification.&nbsp; They must be Classifiers or Features.&nbsp; Both give conditions on what&nbsp;they classify, see isSufficient.</p>
 * 
 * ownedGeneralization = generalization->intersection(ownedElement)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getOwnedGeneralization <em>Owned Generalization</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getOwnedFeatureMembership_comp <em>Owned Feature Membership comp</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getOwnedFeature <em>Owned Feature</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getInput <em>Input</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getOutput <em>Output</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#isAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getInheritedMembership <em>Inherited Membership</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getEndFeature <em>End Feature</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getOwnedEndFeature <em>Owned End Feature</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#isSufficient <em>Is Sufficient</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getOwnedConjugator <em>Owned Conjugator</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getConjugator <em>Conjugator</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#isConjugated <em>Is Conjugated</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getFeatureMembership <em>Feature Membership</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getInheritedFeature <em>Inherited Feature</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.Type#getOwnedFeatureMembership <em>Owned Feature Membership</em>}</li>
 * </ul>
 *
 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType()
 * @model
 * @generated
 */
public interface Type extends org.omg.sysml.lang.sysml.Package {
	/**
	 * Returns the value of the '<em><b>Owned Generalization</b></em>' reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.Generalization}.
	 * It is bidirectional and its opposite is '{@link org.omg.sysml.lang.sysml.Generalization#getOwningType <em>Owning Type</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Element#getOwnedElement() <em>Owned Element</em>}'</li>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Element#getOwnedRelationship_comp() <em>Owned Relationship comp</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Generalization</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The Generalizations owned by this Type.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Generalization</em>' reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_OwnedGeneralization()
	 * @see org.omg.sysml.lang.sysml.Generalization#getOwningType
	 * @model opposite="owningType" transient="true" volatile="true" derived="true"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Generalization> getOwnedGeneralization();

	/**
	 * Returns the value of the '<em><b>Owned Feature Membership comp</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.FeatureMembership}.
	 * It is bidirectional and its opposite is '{@link org.omg.sysml.lang.sysml.FeatureMembership#getOwningType <em>Owning Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Feature Membership comp</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>All FeatureMemberships that have the Type as source and are owned by it. Each FeatureMembership identifies a Feature of the Type.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Feature Membership comp</em>' containment reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_OwnedFeatureMembership_comp()
	 * @see org.omg.sysml.lang.sysml.FeatureMembership#getOwningType
	 * @model opposite="owningType" containment="true"
	 * @generated
	 */
	EList<FeatureMembership> getOwnedFeatureMembership_comp();

	/**
	 * Returns the value of the '<em><b>Owned Feature Membership</b></em>' reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.FeatureMembership}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Package#getOwnedMembership_comp() <em>Owned Membership comp</em>}'</li>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Type#getFeatureMembership() <em>Feature Membership</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Feature Membership</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Feature Membership</em>' reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_OwnedFeatureMembership()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<FeatureMembership> getOwnedFeatureMembership();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>If the given feature is a feature of this type, then return its direction relative to this type, taking conjugation into account.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @model ordered="false" featureRequired="true" featureOrdered="false"
	 * @generated
	 */
	FeatureDirectionKind directionOf(Feature feature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Type> allSupertypes();

	/**
	 * Returns the value of the '<em><b>Owned Feature</b></em>' reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.Feature}.
	 * It is bidirectional and its opposite is '{@link org.omg.sysml.lang.sysml.Feature#getOwningType <em>Owning Type</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Type#getFeature() <em>Feature</em>}'</li>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Package#getOwnedMember() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Feature</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The result of&nbsp;navigating from <code>ownedFeatureMembership</code> to that FeatureMembership&#39;s <code>ownedMemberFeature</code> attribute values.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Feature</em>' reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_OwnedFeature()
	 * @see org.omg.sysml.lang.sysml.Feature#getOwningType
	 * @model opposite="owningType" transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Feature> getOwnedFeature();

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.Feature}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Package#getMember() <em>Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The result of navigating from <code>featureMembership</code> to that FeatureMembership&#39;s <code>memberFeature</code> property values.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature</em>' reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_Feature()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='featuringType'"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Feature> getFeature();

	/**
	 * Returns the value of the '<em><b>Input</b></em>' reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.Feature}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Type#getFeature() <em>Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>All&nbsp;<code>features</code>&nbsp;identified by&nbsp;FeatureMemberships that have&nbsp;an &quot;in&quot; ??or inout?? <code>direction</code>. See FeatureDirectionKind.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input</em>' reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_Input()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='typeWithInput'"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Feature> getInput();

	/**
	 * Returns the value of the '<em><b>Output</b></em>' reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.Feature}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Type#getFeature() <em>Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>All&nbsp;<code>features</code> identified by&nbsp;FeatureMemberships that have&nbsp;&quot;out&quot; ??or inout?? <code>direction</code>. See FeatureDirectionKind.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output</em>' reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_Output()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='typeWithOutput'"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Feature> getOutput();

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Indicates whether instances of this Type must also be instances of at least one of its specialized Types.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_IsAbstract()
	 * @model default="false" dataType="org.omg.sysml.lang.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.omg.sysml.lang.sysml.Type#isAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Inherited Membership</b></em>' reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.Membership}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Package#getMembership() <em>Membership</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Membership</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Placeholder</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inherited Membership</em>' reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_InheritedMembership()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='inheritingType'"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Membership> getInheritedMembership();

	/**
	 * Returns the value of the '<em><b>End Feature</b></em>' reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.Feature}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Type#getFeature() <em>Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Feature</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The result of navigating from <code>featureMembership</code> to that EndFeatureMembership&#39;s <code>memberFeature</code> property values.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>End Feature</em>' reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_EndFeature()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='endFeaturingType'"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Feature> getEndFeature();

	/**
	 * Returns the value of the '<em><b>Is Sufficient</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Sufficient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>A Type&nbsp;gives conditions that must be met by whatever it classifies, but when isSufficient is false or absent, things meeting those conditions might not be classified.&nbsp; For example, a type Car that is not sufficient could require everything it classifies to have four wheels, but not all four wheeled things would need to be cars.&nbsp; If isSufficient is true, all things that meet conditions of a Type must be classified by that Type.&nbsp; For example, if the type Car were sufficient, it would classify all four-wheeled things.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Sufficient</em>' attribute.
	 * @see #setIsSufficient(boolean)
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_IsSufficient()
	 * @model default="false" dataType="org.omg.sysml.lang.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isSufficient();

	/**
	 * Sets the value of the '{@link org.omg.sysml.lang.sysml.Type#isSufficient <em>Is Sufficient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Sufficient</em>' attribute.
	 * @see #isSufficient()
	 * @generated
	 */
	void setIsSufficient(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Conjugator</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.omg.sysml.lang.sysml.Conjugation#getOwningType <em>Owning Type</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Element#getOwnedRelationship_comp() <em>Owned Relationship comp</em>}'</li>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Element#getOwnedElement() <em>Owned Element</em>}'</li>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Type#getConjugator() <em>Conjugator</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Conjugator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The <code>ownedConjugator</code> attribute references the Conjugation that defines the Type that is also owned by it.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Conjugator</em>' reference.
	 * @see #setOwnedConjugator(Conjugation)
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_OwnedConjugator()
	 * @see org.omg.sysml.lang.sysml.Conjugation#getOwningType
	 * @model opposite="owningType" transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	Conjugation getOwnedConjugator();

	/**
	 * Sets the value of the '{@link org.omg.sysml.lang.sysml.Type#getOwnedConjugator <em>Owned Conjugator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Conjugator</em>' reference.
	 * @see #getOwnedConjugator()
	 * @generated
	 */
	void setOwnedConjugator(Conjugation value);

	/**
	 * Returns the value of the '<em><b>Conjugator</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.omg.sysml.lang.sysml.Conjugation#getConjugatedType <em>Conjugated Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conjugator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The <code>conjugator</code> attribute references the Conjugation that defines the Type.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conjugator</em>' reference.
	 * @see #setConjugator(Conjugation)
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_Conjugator()
	 * @see org.omg.sysml.lang.sysml.Conjugation#getConjugatedType
	 * @model opposite="conjugatedType" ordered="false"
	 * @generated
	 */
	Conjugation getConjugator();

	/**
	 * Sets the value of the '{@link org.omg.sysml.lang.sysml.Type#getConjugator <em>Conjugator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conjugator</em>' reference.
	 * @see #getConjugator()
	 * @generated
	 */
	void setConjugator(Conjugation value);

	/**
	 * Returns the value of the '<em><b>Is Conjugated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Conjugated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Indicates whether this Type is is conjugated.&nbsp; See Conjugation.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Conjugated</em>' attribute.
	 * @see #setIsConjugated(boolean)
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_IsConjugated()
	 * @model dataType="org.omg.sysml.lang.types.Boolean" required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isConjugated();

	/**
	 * Sets the value of the '{@link org.omg.sysml.lang.sysml.Type#isConjugated <em>Is Conjugated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Conjugated</em>' attribute.
	 * @see #isConjugated()
	 * @generated
	 */
	void setIsConjugated(boolean value);

	/**
	 * Returns the value of the '<em><b>Feature Membership</b></em>' reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.FeatureMembership}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Membership</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>All FeatureMemberships that have the Type as source. Each FeatureMembership identifies a Feature of the Type.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature Membership</em>' reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_FeatureMembership()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='type'"
	 * @generated
	 */
	EList<FeatureMembership> getFeatureMembership();

	/**
	 * Returns the value of the '<em><b>Inherited Feature</b></em>' reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.Feature}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Type#getFeature() <em>Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Feature</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Placeholder</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inherited Feature</em>' reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_InheritedFeature()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='inheritingType'"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Feature> getInheritedFeature();

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Type#getFeature() <em>Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The one feature (at most) of a Type that is a Multiplicity, which constrains the cardinality of the Type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Multiplicity</em>' reference.
	 * @see #setMultiplicity(Multiplicity)
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_Multiplicity()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='typeWithMultiplicity'"
	 *        annotation="subsets"
	 * @generated
	 */
	Multiplicity getMultiplicity();

	/**
	 * Sets the value of the '{@link org.omg.sysml.lang.sysml.Type#getMultiplicity <em>Multiplicity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' reference.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(Multiplicity value);

	/**
	 * Returns the value of the '<em><b>Owned End Feature</b></em>' reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.Feature}.
	 * It is bidirectional and its opposite is '{@link org.omg.sysml.lang.sysml.Feature#getEndOwningType <em>End Owning Type</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Type#getEndFeature() <em>End Feature</em>}'</li>
	 *   <li>'{@link org.omg.sysml.lang.sysml.Type#getOwnedFeature() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned End Feature</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The result of navigating from <code>ownedFeatureMembership</code> to that EndFeatureMembership&#39;s <code>ownedMemberFeature</code> attribute values.</p>
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned End Feature</em>' reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getType_OwnedEndFeature()
	 * @see org.omg.sysml.lang.sysml.Feature#getEndOwningType
	 * @model opposite="endOwningType" transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Feature> getOwnedEndFeature();

} // Type
