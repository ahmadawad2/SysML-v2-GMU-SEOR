/*****************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2018 IncQuery Labs Ltd.
 * Copyright (c) 2018-2023 Model Driven Solutions, Inc.
 * Copyright (c) 2020 California Institute of Technology/Jet Propulsion Laboratory
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
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 * 
 * @license LGPL-3.0-or-later <http://spdx.org/licenses/LGPL-3.0-or-later>
 * 
 * Contributors:
 *  Zoltan Kiss, IncQuery
 *  Balazs Grill, IncQuery
 *  Ed Seidewitz, MDS
 *  Miyako Wilson, JPL
 * 
 *****************************************************************************/
package org.omg.kerml.xtext.validation

import java.util.List
import org.eclipse.xtext.validation.Check
import org.omg.sysml.lang.sysml.Type
import org.omg.sysml.lang.sysml.SysMLPackage
import org.omg.sysml.lang.sysml.Connector
import org.omg.sysml.lang.sysml.Element
import org.omg.sysml.lang.sysml.BindingConnector
import org.omg.sysml.lang.sysml.Feature
import org.omg.sysml.lang.sysml.InvocationExpression
import org.omg.sysml.lang.sysml.Membership
import org.omg.sysml.lang.sysml.FeatureReferenceExpression
import org.omg.sysml.lang.sysml.LiteralExpression
import org.omg.sysml.lang.sysml.NullExpression
import org.omg.sysml.lang.sysml.ElementFilterMembership
import org.omg.sysml.lang.sysml.ItemFlow
import org.omg.sysml.util.TypeUtil
import org.omg.sysml.util.ElementUtil
import org.omg.sysml.util.ExpressionUtil
import org.omg.sysml.util.FeatureUtil
import org.omg.sysml.util.NamespaceUtil
import org.eclipse.emf.ecore.EClass
import org.omg.sysml.lang.sysml.Classifier
import org.omg.sysml.lang.sysml.FeatureChaining
import org.omg.sysml.lang.sysml.Subsetting
import org.omg.sysml.lang.sysml.Redefinition
import org.omg.sysml.lang.sysml.LiteralInfinity
import org.omg.sysml.lang.sysml.LiteralInteger
import org.omg.sysml.lang.sysml.Multiplicity
import org.omg.sysml.lang.sysml.FeatureChainExpression
import org.omg.sysml.lang.sysml.MetadataFeature
import org.omg.sysml.lang.sysml.util.SysMLLibraryUtil
import org.omg.sysml.util.ImplicitGeneralizationMap
import org.omg.sysml.lang.sysml.OwningMembership
import org.omg.sysml.lang.sysml.ReferenceSubsetting
import org.eclipse.emf.ecore.EObject
import org.omg.sysml.lang.sysml.LiteralBoolean
import org.omg.sysml.lang.sysml.Expression
import org.omg.sysml.lang.sysml.OperatorExpression
import org.omg.sysml.expressions.util.EvaluationUtil
import org.omg.sysml.lang.sysml.LibraryPackage
import org.omg.sysml.lang.sysml.ItemFlowEnd
import org.omg.sysml.lang.sysml.Namespace
import org.omg.sysml.lang.sysml.Association
import org.eclipse.emf.common.util.EList

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class KerMLValidator extends AbstractKerMLValidator {
	
	// ROOT //
	
	public static val INVALID_ELEMENT_IS_IMPLIED_INCLUDED = "validateElementIsImpliedIncluded"
	public static val INVALID_ELEMENT_IS_IMPLIED_INCLUDED_MSG = "Element cannot have implied relationships included"

	public static val INVALID_NAMESPACE_DISTINGUISHABILITY = "validateNamespaceDistinguishablity"
	public static val INVALID_NAMESPACE_DISTINGUISHABILITY_MSG = "Duplicate of other owned member name"
	public static val INVALID_NAMESPACE_DISTINGUISHABILITY_MSG_0 = "Duplicate of owned member name"
	public static val INVALID_NAMESPACE_DISTINGUISHABILITY_MSG_1 = "Duplicate of other alias name"
	public static val INVALID_NAMESPACE_DISTINGUISHABILITY_MSG_2 = "Duplicate of inherited member name"
	
	// CORE //
	
	public static val INVALID_TYPE_DIFFERENCING_TYPE_NOT_ONE = 'validateTypeDifferencingTypeNotOne'
	public static val INVALID_TYPE_DIFFERENCING_TYPE_NOT_ONE_MSG = 'Cannot have only one differencing'
	public static val INVALID_TYPE_INTERSECTING_TYPE_NOT_ONE = 'validateTypeIntersectingTypeNotOne'
	public static val INVALID_TYPE_INTERSECTING_TYPE_NOT_ONE_MSG = 'Cannot have only one intersecting'
	public static val INVALID_TYPE_OWNED_MULTIPLICITY = "validateTypeOwnedMultiplicity"
	public static val INVALID_TYPE_OWNED_MULTIPLICITY_MSG = "Only one multiplicity is allowed"
	public static val INVALID_TYPE_UNIONING_TYPE_NOT_ONE = 'validateTypeUnioningTypeNotOne'
	public static val INVALID_TYPE_UNIONING_TYPE_NOT_ONE_MSG = 'Cannot have only one unioning'
	
	// Note: validateClassifierDefaultSupertype is not in the spec as a single constraint.
	public static val INVALID_CLASSIFIER_DEFAULT_SUPERTYPE = 'validateClassifierDefaultSupertype_'
	public static val INVALID_CLASSIFIER_DEFAULT_SUPERTYPE_MSG = "Must directly or indirectly specialize {supertype}"

	// Note: validateFeatureHasType is not in the spec, but it is implied by semantic constraints on features
	public static val INVALID_FEATURE_HAS_TYPE = 'validateFeatureHasType_'
	public static val INVALID_FEATURE_HAS_TYPE_MSG = "Features must have at least one type"

	public static val INVALID_FEATURE_OWNED_REFERENCE_SUBSETTING = 'validateFeatureOwnedReferenceSubsetting'
	public static val INVALID_FEATURE_OWNED_REFERENCE_SUBSETTING_MSG = 'At most one reference subsetting is allowed'
	public static val INVALID_FEATURE_FEATURE_CHAINING_NOT_ONE = 'validateFeatureFeatureChainingNotOne'
	public static val INVALID_FEATURE_FEATURE_CHAINING_NOT_ONE_MSG = 'Cannot have only one feature chaining'

	public static val INVALID_FEATURE_CHAINING_FEATURE_CONFORMANCE = "validatFeatureChainingFeatureConformance"
	public static val INVALID_FEATURE_CHAINING__FEATURE_CONFORMANCE_MSG = "Must be a valid feature"

	public static val INVALID_REDEFINITION_FEATURING_TYPES = 'validateRedefinitionFeaturingTypes'
	public static val INVALID_REDEFINITION_FEATURING_TYPES_MSG_1 = "A package-level feature should not be redefined"
	public static val INVALID_REDEFINITION_FEATURING_TYPES_MSG_2 = "Owner of redefining feature should not be the same as owner of redefined feature"
	public static val INVALID_REDEFINITION_MULTIPLICITY_CONFORMANCE = "validateRedefinitionMultiplicityConformance"
	public static val INVALID_REDEFINITION_MULTIPLICITY_CONFORMANCE_MSG = "Redefining feature should not have smaller multiplicity lower bound"

	public static val INVALID_SUBSETTING_FEATURING_TYPES = "validateSubsettingFeaturingTypes"
	public static val INVALID_SUBSETTING_FEATURING_TYPES_MSG = "Must be an accessible feature (use dot notation for nesting)"
	public static val INVALID_SUBSETTING_MULTIPLICITY_CONFORMANCE = "validateSubsettingMultiplicityConformance"
	public static val INVALID_SUBSETTING_MULTIPLICITY_CONFORMANCE_MSG = "Subsetting/redefining feature should not have larger multiplicity upper bound"
	public static val INVALID_SUBSETTING_UNIQUENESS_CONFORMANCE = "validateSubsettingUniquenessConformance"
	public static val INVALID_SUBSETTING_UNIQUENESS_CONFORMANCE_MSG = "Subsetting/redefining feature should not be nonunique if subsetted/redefined feature is unique"
	
	// KERNEL //
	
	public static val INVALID_ASSOCIATION_RELATED_TYPES = "validateAssociationRelatedTypes"
	public static val INVALID_ASSOCIATION_RELATED_TYPES_MSG = "Must have at least two related elements"
		
	public static val INVALID_BINDING_CONNECTOR_TYPE_CONFORMANCE = "validateBindingConnectorTypeConformance"
	public static val INVALID_BINDING_CONNECTOR_TYPE_CONFORMANCE_MSG = "Bound features should have conforming types"

	// Note: This check is not currently implemented.
	public static val INVALID_BINDING_CONNECTOR_ARGUMENT_TYPE_CONFORMANCE = "validateBindingConnectorArgumentTypeConformance"
	public static val INVALID_BINDING_CONNECTOR_ARGUMENT_TYPE_CONFORMANCE_MSG = "Output feature must conform to input feature"

	public static val INVALID_CONNECTOR_RELATED_FEATURES = "validateConnectorRelatedFeatures"
	public static val INVALID_CONNECTOR_RELATED_FEATURES_MSG = "Must have at least two related elements"
	public static val INVALID_CONNECTOR_TYPE_FEATURING = "validateConnectorTypeFeaturing"
	public static val INVALID_CONNECTOR_TYPE_FEATURING_MSG = "Should be an accessible feature (use dot notation for nesting)"
		
	public static val INVALID_FEATURE_CHAIN_EXPRESSION_FEATURE_CONFORMANCE = "validateFeatureChainExpressionFeatureConformance"
	public static val INVALID_FEATURE_CHAIN_EXPRESSION_FEATURE_CONFORMANCE_MSG = "Must be a valid feature"

	public static val INVALID_FEATURE_REFERENCE_EXPRESSION_REFERENT_IS_FEATURE = "validateFeatureReferenceExpressionReferentIsFeature"
	public static val INVALID_FEATURE_REFERENCE_EXPRESSION_REFERENT_IS_FEATURE_MSG = "Must be a valid feature"

	public static val INVALID_INVOCATION_EXPRESSION_PARAMETER_REDEFINITION = "validateInvocationExpressionParameterRedefinition"
	public static val INVALID_INVOCATION_EXPRESSION_PARAMETER_REDEFINITION_MSG = "Must name an input or undirected feature"
	public static val INVALID_INVOCATION_EXPRESSION_NO_DUPLICATE_PARAMETER_REDEFINITION = "validateInvocationExpressionNoDuplicateParameterRedefinition"
	public static val INVALID_INVOCATION_EXPRESSION_NO_DUPLICATE_PARAMETER_REDEFINITION_MSG = "Feature already bound"

	public static val INVALID_OPERATOR_EXPRESSION_CAST_CONFORMANCE_TYPE = "validateOperatorExpressionCastConformance"
	public static val INVALID_OPERATOR_EXPRESSION_CAST_CONFORMANCE_MSG = "Cast argument should have conforming types"

	// Note: This validation is not in the spec.
	public static val INVALID_OPERATOR_EXPRESSION_BRACKET_OPERATOR = "validateOperatorExpressionBracketOperator_"
	public static val INVALID_OPERATOR_EXPRESSION_BRACKET_OPERATOR_MSG = "Use #(...) for indexing"
	
	public static val INVALID_ITEM_FLOW_END_SUBSETTING = 'validateItemFlowEndSubsetting'
	public static val INVALID_ITEM_FLOW_END_SUBSETTING_MSG = "Cannot identify item flow end (use dot notation)"
	public static val INVALID_ITEM_FLOW_END_IMPLICIT_SUBSETTING = 'validateItemFlowEndImplicitSubsetting'
	public static val INVALID_ITEM_FLOW_END_IMPLICIT_SUBSETTING_MSG = "Flow ends should use dot notation"
	
	public static val INVALID_METADATA_FEATURE_ANNOTATED_ELEMENT = "validateMetadataFeatureAnnotatedElement"
	public static val INVALID_METADATA_FEATURE_ANNOTATED_ELEMENT_MSG = "Cannot annotate {metaclass}"
	public static val INVALID_METADATA_FEATURE_BODY = "invalidateMetadataFeatureBody"
	public static val INVALID_METADATA_FEATURE_BODY_MSG_1 = "Must redefine an owning-type feature"
	public static val INVALID_METADATA_FEATURE_BODY_MSG_2 = "Must be model-level evaluable"
	public static val INVALID_METADATA_FEATURE_METACLASS_NOT_ABSTRACT = "validateMetadataFeatureMetadataNotAbstract"
	public static val INVALID_METADATA_FEATURE_METACLASS_NOT_ABSTRACT_MSG = "Must have a concrete type"

	public static val INVALID_ELEMENT_FILTER_MEMBERSHIP_IS_BOOLEAN = "validateElementFilterMembershipIsBoolean"
	public static val INVALID_ELEMENT_FILTER_MEMBERSHIP_IS_BOOLEAN_MSG = "Must have a Boolean result"
	public static val INVALID_ELEMENT_FILTER_MEMBERSHIP_IS_MODEL_LEVEL_EVALUABLE = "validateElementFilterMembershipIsModelLevelEvaluable"
	public static val INVALID_ELEMENT_FILTER_MEMBERSHIP_IS_MODEL_LEVEL_EVALUABLE_MSG = "Must be model-level evaluable"

	// Note: This validation is not formalized in the spec.
	public static val INVALID_LIBRARY_PACKAGE_NOT_STANDARD = "validateLibraryPackageNotStandard_"
	public static val INVALID_LIBRARY_PACKAGE_NOT_STANDARD_MSG = "User library packages should not be marked as standard"

	/* ROOT */
	
	@Check
	def checkElement(Element elm) {
		// validateElementIsImpliedIncluded	
		if (!elm.isImpliedIncluded) {
			if (elm.ownedRelationship.exists[isImplied]) {
				error(INVALID_ELEMENT_IS_IMPLIED_INCLUDED_MSG, elm, null, INVALID_ELEMENT_IS_IMPLIED_INCLUDED)
			}
		}
	}
	
	@Check
	def checkNamespace(Namespace namesp){
		// validateNamespaceDistinguishability
		// Do not check distinguishability for automatically constructed expressions and binding connectors (to improve performance).
		if (!(namesp instanceof InvocationExpression || namesp instanceof FeatureReferenceExpression || namesp instanceof LiteralExpression || 
				namesp instanceof NullExpression || namesp instanceof BindingConnector)) {
			// NOTE: Does not check distinguishibility for imported Memberships.
			val ownedMemberships = namesp.ownedMembership
			val owningMemberships = ownedMemberships.filter[m | m instanceof OwningMembership]
			val aliasMemberships = ownedMemberships.filter[m | !(m instanceof OwningMembership)]
			for (mem: owningMemberships) {
				checkDistinguishibility(mem, owningMemberships, INVALID_NAMESPACE_DISTINGUISHABILITY_MSG)				
			}
			for (mem: aliasMemberships) {
				checkDistinguishibility(mem, owningMemberships, INVALID_NAMESPACE_DISTINGUISHABILITY_MSG_0)
				checkDistinguishibility(mem, aliasMemberships, INVALID_NAMESPACE_DISTINGUISHABILITY_MSG_1)
			}
			if (namesp instanceof Type) {
				ElementUtil.clearCachesOf(namesp) // Force recomputation of inherited memberships.
				val inheritedMemberships = namesp.inheritedMembership
				for (mem: ownedMemberships) {
					checkDistinguishibility(mem, inheritedMemberships, INVALID_NAMESPACE_DISTINGUISHABILITY_MSG_2)
				}
			}
		}		
	}
	
	def checkDistinguishibility(Membership mem, Iterable<Membership> others, String msg) {
		val memShortName = mem.memberShortName
		val memName = mem.memberName
		
		val distinctOthers = others.filter[other | mem.memberElement !== other.memberElement]
		if (memShortName !== null && distinctOthers.exists[other | memShortName == other.memberShortName || memShortName == other.memberName]) {
				if (mem instanceof OwningMembership) {
					warning(msg, mem.ownedMemberElement, SysMLPackage.eINSTANCE.element_DeclaredShortName, INVALID_NAMESPACE_DISTINGUISHABILITY)
				} else {
					warning(msg, mem, SysMLPackage.eINSTANCE.membership_MemberShortName, INVALID_NAMESPACE_DISTINGUISHABILITY)
				}
		}
		if (memName !== null && distinctOthers.exists[other | memName == other.memberShortName || memName == other.memberName]) {
				if (mem instanceof OwningMembership) {
					warning(msg, mem.ownedMemberElement, SysMLPackage.eINSTANCE.element_DeclaredName, INVALID_NAMESPACE_DISTINGUISHABILITY)
				} else {
					warning(msg, mem, SysMLPackage.eINSTANCE.membership_MemberName, INVALID_NAMESPACE_DISTINGUISHABILITY)
				}
		}
	}
	
	/* CORE */
	
	// TODO: validateSpecializationSpecificNotConjugated
	
	@Check
	def checkType(Type t) {
		// TODO: Check validateTypeAtMostOneConjugator
		// TODO: Check validateTypeDifferencingTypesNotSelf
		// TODO: Check validateTypeIntersectingTypesNotSelf
		// TODO: Check validateTypeUnioningTypesNotSelf

		// TODO: Add validateTypeUnioningTypeNotOne
		checkNotOne(t.ownedUnioning, INVALID_TYPE_UNIONING_TYPE_NOT_ONE_MSG, INVALID_TYPE_UNIONING_TYPE_NOT_ONE)
		// TODO: Add validateTypeIntersectingTypeNotOne
		checkNotOne(t.ownedIntersecting, INVALID_TYPE_INTERSECTING_TYPE_NOT_ONE_MSG, INVALID_TYPE_INTERSECTING_TYPE_NOT_ONE)
		// TODO: Add validateTypeDifferencingTypeNotOne
		checkNotOne(t.ownedDifferencing, INVALID_TYPE_DIFFERENCING_TYPE_NOT_ONE_MSG, INVALID_TYPE_DIFFERENCING_TYPE_NOT_ONE)
		
		// validateTypeOwnedMultiplicity
		var multiplicityMemberships = t.ownedMembership.filter[memberElement instanceof Multiplicity];
		if (multiplicityMemberships.size > 1) {
			for (var i = 1; i < multiplicityMemberships.size; i++) {
				error(INVALID_TYPE_OWNED_MULTIPLICITY_MSG, multiplicityMemberships.get(i), SysMLPackage.eINSTANCE.membership_MemberElement, INVALID_TYPE_OWNED_MULTIPLICITY);			
			}
		}
	}
	
	
	// Check default supertype (semantic constraint)
	// Note: This check is not in the spec as a single constraint.
	@Check
	def checkClassifier(Classifier c){
		val defaultSupertype = ImplicitGeneralizationMap.getDefaultSupertypeFor(c.getClass())
		if (!TypeUtil.conforms(c, SysMLLibraryUtil.getLibraryType(c, defaultSupertype)))
			error(INVALID_CLASSIFIER_DEFAULT_SUPERTYPE_MSG.replace("{supertype}", defaultSupertype), c, SysMLPackage.eINSTANCE.classifier_OwnedSubclassification, INVALID_CLASSIFIER_DEFAULT_SUPERTYPE)
	}
	
	// @Check
	// def checkEndFeatureMembership(EndFeatureMembership m) {
	//    // validateEndFeatureMembershipIsEnd is automatically satisfied
	// }
	
	@Check
	def checkFeature(Feature f){
		val types = f.type;
		
		// TODO: Remove?
		if (types !== null && types.isEmpty)
			error(INVALID_FEATURE_HAS_TYPE_MSG, f, SysMLPackage.eINSTANCE.feature_Type, INVALID_FEATURE_HAS_TYPE)
			
		// validateFeatureOwnedReferenceSubsetting
		val refSubsettings = f.ownedRelationship.filter[r | r instanceof ReferenceSubsetting].toList
		if (refSubsettings.size > 1) {
			for (var i = 1; i < refSubsettings.size; i++)
				error(INVALID_FEATURE_OWNED_REFERENCE_SUBSETTING_MSG, refSubsettings.get(i), null, INVALID_FEATURE_OWNED_REFERENCE_SUBSETTING)
		}
		
		// validateFeatureChainingFeatureNotOne
		checkNotOne(f.ownedFeatureChaining, INVALID_FEATURE_FEATURE_CHAINING_NOT_ONE_MSG, INVALID_FEATURE_FEATURE_CHAINING_NOT_ONE)
	}
		
	@Check
	def checkFeatureChaining(FeatureChaining fc) {
		// TODO: Check validateFeatureChainingFeaturesNotSelf
		// TODO: Check validateFeatureMultiplicityDomain
		// TODO: Add validateFeatureChainingFeatureConformance
		val featureChainings = fc.featureChained.ownedFeatureChaining;
		val i = featureChainings.indexOf(fc);
		if (i > 0) {
			val prev = featureChainings.get(i-1).chainingFeature;
			if (!fc.chainingFeature.featuringType.forall[t2 | prev.conformsTo(t2)]) {
				error(INVALID_FEATURE_CHAINING__FEATURE_CONFORMANCE_MSG, fc, SysMLPackage.eINSTANCE.featureChaining_ChainingFeature, INVALID_FEATURE_CHAINING_FEATURE_CONFORMANCE)
			}
		}
	}
	
	@Check
	def checkRedefinition(Redefinition redef) {
		val redefiningFeature = redef.redefiningFeature
		val redefinedFeature = redef.redefinedFeature

		// TODO: Add/check validateRedefinitionDirectionConformance
		
		// validateRedefinitionFeaturingTypes
		if (redefiningFeature !== null && redefinedFeature !== null) {
			val redefiningFeaturingTypes = redefiningFeature.featuringType
			val redefinedFeaturingTypes = redefinedFeature.featuringType
						
			if (redefinedFeature.owningRelationship != redef &&
				redefinedFeaturingTypes.containsAll(redefiningFeaturingTypes) && 
				redefinedFeaturingTypes.size == redefiningFeaturingTypes.size){
				if (redefiningFeaturingTypes.isEmpty) {
					warning(INVALID_REDEFINITION_FEATURING_TYPES_MSG_1, redef, 
						SysMLPackage.eINSTANCE.redefinition_RedefinedFeature, INVALID_REDEFINITION_FEATURING_TYPES)
				} else {
					warning(INVALID_REDEFINITION_FEATURING_TYPES_MSG_2, redef, 
						SysMLPackage.eINSTANCE.redefinition_RedefinedFeature, INVALID_REDEFINITION_FEATURING_TYPES)
				}
			}
		}		
	}
	
	@Check
	def checkSubsetting(Subsetting sub) { 
		
		// Due to how connector is implemented, no validation is performed if the owner is a Connector.
		if ( sub.subsettingFeature.owningType instanceof Connector || sub.subsettedFeature.owningType instanceof Connector ) 
			return;

		val subsettingFeature = sub.subsettingFeature
		val subsettedFeature = sub.subsettedFeature

		// Multiplicity conformance
		
		var setted_m = FeatureUtil.getMultiplicityRangeOf(subsettedFeature?.multiplicity)
		var setting_m = FeatureUtil.getMultiplicityRangeOf(subsettingFeature?.multiplicity)
		
		// Only check multiplicity conformance if the subsettedFeature and subsettingFeature multiplicity elements are not the same, 
		// and the subsettingFeature and subsettedFeature either both are, or both are not, end Features.
		if (setted_m !== null && setting_m !== null && setted_m !== setting_m &&
			subsettingFeature.isEnd() == subsettedFeature.isEnd()) {
			var setted_m_l = setted_m.lowerBound
			val setted_m_u = setted_m.upperBound
			
			if (setted_m_l === null) {
				setted_m_l = setted_m_u
			}
			
			var setting_m_l = setting_m.lowerBound
			val setting_m_u = setting_m.upperBound
			
			if (setting_m_l === null) {
				setting_m_l = setting_m_u
			}
			
			// TODO: Add validateRedefinitionMultiplicityConformance
		
			// Lower bound (only check if the Subsetting is a Redefinition and Features are not ends): setting must be >= setted
			if (sub instanceof Redefinition && !subsettingFeature.isEnd()) {
				if (setting_m_l instanceof LiteralInteger && setted_m_l instanceof LiteralInteger && (setting_m_l as LiteralInteger).getValue < (setted_m_l as LiteralInteger).getValue ||
					setting_m_l instanceof LiteralInfinity && setted_m_l instanceof LiteralInteger && 0 < (setted_m_l as LiteralInteger).getValue) {
					warning(INVALID_REDEFINITION_MULTIPLICITY_CONFORMANCE_MSG, sub, 
						SysMLPackage.eINSTANCE.redefinition_RedefiningFeature, INVALID_REDEFINITION_MULTIPLICITY_CONFORMANCE)
				}
			}
			
			// TODO: Add validateSubsettingMultiplicityConformance
		
			// Upper bound: setting must be <= setted
			if (setting_m_u instanceof LiteralInfinity && !(setted_m_u instanceof LiteralInfinity) ||
				setting_m_u instanceof LiteralInteger && setted_m_u instanceof LiteralInteger && (setting_m_u as LiteralInteger).getValue > (setted_m_u as LiteralInteger).getValue) {
				warning(INVALID_SUBSETTING_MULTIPLICITY_CONFORMANCE_MSG, sub, SysMLPackage.eINSTANCE.subsetting_SubsettingFeature, INVALID_SUBSETTING_MULTIPLICITY_CONFORMANCE)
			}
		}
		
		// TODO: Add validateSubsettingUniquenessConformance

		// Uniqueness conformance
		if (subsettedFeature !== null && subsettedFeature.unique && subsettingFeature !== null && !subsettingFeature.unique){
			warning(INVALID_SUBSETTING_UNIQUENESS_CONFORMANCE_MSG, sub, SysMLPackage.eINSTANCE.subsetting_SubsettingFeature, INVALID_SUBSETTING_UNIQUENESS_CONFORMANCE)
		}
					
		// Featuring type conformance
		if (subsettingFeature !== null && subsettedFeature !== null) {
			val subsettingFeaturingTypes = subsettingFeature.featuringType
			val subsettedFeaturingTypes = subsettedFeature.featuringType
						
			// validateSubsettingFeaturingTypes
			if (!subsettedFeaturingTypes.isEmpty() && 
				!subsettedFeaturingTypes.forall[t | 
						subsettingFeaturingTypes.exists[ f | 
							// TODO: Remove "isFeaturedWithin" when possible
							f.conformsTo(t) || f instanceof Feature && (f as Feature).isFeaturedWithin(t)]]) {
				if (subsettingFeature.owningType instanceof ItemFlowEnd) {
					error(INVALID_SUBSETTING_FEATURING_TYPES_MSG, sub, SysMLPackage.eINSTANCE.subsetting_SubsettedFeature, INVALID_SUBSETTING_FEATURING_TYPES)
				} else {
					warning(INVALID_SUBSETTING_FEATURING_TYPES_MSG, sub, SysMLPackage.eINSTANCE.subsetting_SubsettedFeature, INVALID_SUBSETTING_FEATURING_TYPES)
				}
			}
		}
	}
	
	/* KERNEL */
	
	// TODO: Check validateDataTypeSpecialization
	
	// TODO: Check validateClassSpecialization
	
	@Check
	def checkAssociation(Association a){
		// TODO: Check validateAssociationBinarySpecialization
		// TODO: Check validateAssociationStructureIntersection

		// validateAssociationRelatedTypes
		if (!a.isAbstract) {
			val relatedElements = a.getRelatedElement
			if (relatedElements !== null && relatedElements.size < 2)
				error(INVALID_ASSOCIATION_RELATED_TYPES_MSG, a, SysMLPackage.eINSTANCE.relationship_RelatedElement, INVALID_ASSOCIATION_RELATED_TYPES)	
		}
	}
		
	@Check
	def checkBindingConnector(BindingConnector bc){
		doCheckBindingConnector(bc, bc)
	}
	
	@Check
	def checkImplicitBindingConnectors(Type type) {
		TypeUtil.forEachImplicitBindingConnectorOf(type, [connector, kind | 
			if (type instanceof FeatureReferenceExpression) {
				connector.doCheckConnector(type, kind) 
			}
			connector.doCheckBindingConnector(type)
		])
	}
	
	private def doCheckBindingConnector(BindingConnector bc, Element location) {
		val rf = bc.relatedFeature
		
		// TODO: Check validateBindingConnectorIsBinary
		if (rf.length !== 2) {
			return //ignore binding connectors with invalid syntax
		}
		
//		val inFeature = rf.map[owningFeatureMembership].filter[m|m !== null && m.direction == FeatureDirectionKind.IN].map[ownedMemberFeature_comp].findFirst[true]
//		val outFeature = rf.map[owningFeatureMembership].filter[m|m !== null && m.direction == FeatureDirectionKind.OUT].map[ownedMemberFeature_comp].findFirst[true]
//		
//		if (inFeature !== null && outFeature !== null){
//			//Argument type conformance
//			val inTypes = inFeature.type
//			val outTypes = outFeature.type
//			val outConformsToIn = inTypes.map[conformsFrom(outTypes)]
//			if (outConformsToIn.filter[!empty].length != inTypes.length)		
//				error(INVALID_BINDING_CONNECTOR_ARGUMENT_TYPE_CONFORMANCE_MSG, bc, SysMLPackage.eINSTANCE.type_EndFeature, INVALID_BINDING_CONNECTOR_ARGUMENT_TYPE_CONFORMANCE)
//		} else { 
			// TODO: Add validateBindingConnectorTypeConformance
			//Binding type conformance
			val f1types = rf.get(0).type
			val f2types = rf.get(1).type
						 
			if (!typesConform(f1types, f2types))
				warning(INVALID_BINDING_CONNECTOR_TYPE_CONFORMANCE_MSG, location, SysMLPackage.eINSTANCE.type_EndFeature, INVALID_BINDING_CONNECTOR_TYPE_CONFORMANCE)
//		}
	}
	
	
	@Check
	def checkConnector(Connector c){		
		// validateConnectorRelatedFeatures
		if (!c.isAbstract) {
			val relatedFeatures = c.getRelatedFeature
			if (relatedFeatures !== null && relatedFeatures.size < 2)
				error(INVALID_CONNECTOR_RELATED_FEATURES_MSG, c, SysMLPackage.eINSTANCE.relationship_RelatedElement, INVALID_CONNECTOR_RELATED_FEATURES)	
		}		
		
		doCheckConnector(c, c, null)
	}
	
	private def doCheckConnector(Connector c, Type location, EClass kind) {
		ElementUtil.transform(c)
		val cFeaturingTypes = c.featuringType
		
		if (kind == SysMLPackage.Literals.FEATURE_MEMBERSHIP) {
			cFeaturingTypes.add(location);
		}

		// TODO: Check validateConnectorBinarySpecialization
		
		// checkConnectorTypeFeaturing
		// TODO: Add validation for type featuring?
		val relatedFeatures = c.relatedFeature				
		val connectorEnds = c.connectorEnd
		for (var i = 0; i < relatedFeatures.size; i++) {
			val relatedFeature = relatedFeatures.get(i)
			if (!(relatedFeature.featuringType.empty || 
				cFeaturingTypes.exists[featuringType |
					relatedFeature.featuringType.exists[f | featuringType.conformsTo(f)]] ||
				(location instanceof FeatureReferenceExpression || location instanceof FeatureChainExpression) && 
					relatedFeature.getOwningType() == location ||
				c instanceof ItemFlow && c.owningNamespace instanceof Feature && c.owningType === null)) {
				warning(INVALID_CONNECTOR_TYPE_FEATURING_MSG, 
					if (location === c && i < connectorEnds.size) connectorEnds.get(i) else location, 
					null, INVALID_CONNECTOR_TYPE_FEATURING)
			}
		}
	}
	
	// TODO: Check validateParameterMembershipOwningType
	// validateParameterMembershipParameterHasDirection is automatically satisfied
	
	// TODO: Check validateExpressionResultParameterMembership
	
	// TODO: Check validateFunctionResultParameterMembership
	
	// TODO: Check validateResultExpressionMembershipOwningType
	
	// @Check
	// def checkReturnParameterMembership(ReturnParameterMembership m) {
	//     // validateReturnParameterMembershipParameterHasDirection is automatically satisfied
	// }
	
	// @Check
	// def checkCollectExpression(CollectExpression e) {
	//     // validateCollectExpressionOperator is automatically satisfied
	// }
	
	@Check
	def checkFeatureChainExpression(FeatureChainExpression e) {
		// TODO: Add validateFeatureChainExpressionFeatureConformance
		val feature = ExpressionUtil.getTargetFeatureFor(e)
		val rel = NamespaceUtil.getRelativeNamespaceFor(e)
		if (feature !== null &&
			(!(feature instanceof Feature) || 
				rel instanceof Type &&
				!(feature as Feature).featuringType.isEmpty &&
				!(feature as Feature).featuringType.exists[t | (rel as Type).conformsTo(t)]
			)) {
			error(INVALID_FEATURE_CHAIN_EXPRESSION_FEATURE_CONFORMANCE_MSG, e.ownedMembership.get(1), SysMLPackage.eINSTANCE.membership_MemberElement, INVALID_FEATURE_CHAIN_EXPRESSION_FEATURE_CONFORMANCE)
		}
	}
	
	@Check
	def checkFeatureReferenceExpression(FeatureReferenceExpression e) {
		// TODO: Add validateFeatureReferenceExpressionReferentIsFeature
		val feature = ExpressionUtil.getReferentFor(e)
		if (feature !== null && !(feature instanceof Feature)) {
			error(INVALID_FEATURE_REFERENCE_EXPRESSION_REFERENT_IS_FEATURE_MSG, e, null, INVALID_FEATURE_REFERENCE_EXPRESSION_REFERENT_IS_FEATURE)
		}
	}
	
	@Check
	def checkInvocationExpression(InvocationExpression e) {
		val type = ExpressionUtil.getExpressionTypeOf(e)
		if (type !== null) {
			val typeParams = type.feature.filter[p | FeatureUtil.getDirection(p) === null || FeatureUtil.isInputParameter(p)]
			val exprParams = e.ownedFeature.filter[p | FeatureUtil.isInputParameter(p)]
			val usedParams = newHashSet
			for (p: exprParams) {
				val redefinitions = p.ownedRedefinition
				if (!redefinitions.empty) {
					val redefParams = redefinitions.map[redefinedFeature].filter[f | typeParams.contains(f)]
					if (redefParams.empty) {
						// TODO: Add validateInvocationExpressionParameterRedefinition
						// Input parameter must redefine a parameter of the expression type
						error(INVALID_INVOCATION_EXPRESSION_PARAMETER_REDEFINITION_MSG, p, null, INVALID_INVOCATION_EXPRESSION_PARAMETER_REDEFINITION)
					} else if (redefParams.exists[f | usedParams.contains(f)]) {
						// TODO: Add validateInvocationExpressionNoDuplicateParameterRedefinition
						// Two parameters cannot redefine the same type parameter 
						error(INVALID_INVOCATION_EXPRESSION_NO_DUPLICATE_PARAMETER_REDEFINITION_MSG, p, null, INVALID_INVOCATION_EXPRESSION_NO_DUPLICATE_PARAMETER_REDEFINITION)
					}
					usedParams.addAll(redefParams)
				}
			}
		}
	}
	
	@Check
	def checkOperatorExpression(OperatorExpression e) {
		// TODO: Add validateOperatorExpressionCastConformance
		if (e.operator == "as") {
			val params = TypeUtil.getOwnedParametersOf(e)
			if (params.length >= 2) {
				val arg = FeatureUtil.getValueExpressionFor(params.get(0))
				if (arg !== null) {
					val argTypes = arg.result.type
					val targetTypes = params.get(1).type
					if (!typesConform(argTypes, targetTypes))
						warning(INVALID_OPERATOR_EXPRESSION_CAST_CONFORMANCE_MSG, e, null, INVALID_OPERATOR_EXPRESSION_CAST_CONFORMANCE_TYPE)
					}
			}
		} else if (e.operator == '[') {
			warning(INVALID_OPERATOR_EXPRESSION_BRACKET_OPERATOR_MSG, e, null, INVALID_OPERATOR_EXPRESSION_BRACKET_OPERATOR)
		}
	}
	
	// TODO: Add validateSelectExpressionOperator	
	
	@Check 
	def checkItemFlow(ItemFlow flow) {
		// TODO: Check validateItemFlowItemFeature
	}
	
	@Check
	def checkItemFlowEnd(ItemFlowEnd flowEnd) {
		// validateItemFlowEndIsEnd is automatically satisfied
		
		// TODO: Check validateItemFlowEndNestedFeature
		// TODO: Check validateItemFlowEndOwningType
	
		// TODO: Add validateItemFlowEndSubsetting? validateItemFlowEndImplicitSubsetting?
		if (FeatureUtil.getSubsettedNotRedefinedFeaturesOf(flowEnd).isEmpty) {
			error(INVALID_ITEM_FLOW_END_SUBSETTING_MSG, flowEnd, null, INVALID_ITEM_FLOW_END_SUBSETTING)
		} else if (flowEnd.ownedSubsetting.isEmpty) {
			val features = flowEnd.ownedFeature
			if (!features.isEmpty && !features.get(0).ownedRedefinition.isEmpty) {
				warning(INVALID_ITEM_FLOW_END_IMPLICIT_SUBSETTING_MSG, flowEnd, null, INVALID_ITEM_FLOW_END_IMPLICIT_SUBSETTING)
			}
		}
	}
	
	// TODO: Add (and check) validateFeatureValueOverriding
	
	// TODO: Check validateMultiplicityRangeBoundResultTypes (need type inference first?)
	
	@Check
	def checkMetadataFeature(MetadataFeature mf) {
		
		// TODO: Add validateMetadataFeatureMetaclassNotAbstract
		if (mf.type.exists[abstract]) {
			error(INVALID_METADATA_FEATURE_METACLASS_NOT_ABSTRACT_MSG, mf, null, INVALID_METADATA_FEATURE_METACLASS_NOT_ABSTRACT)
		}
		
		// TODO: Add validateMetadataFeatureAnnotatedElement
		var annotatedElementFeatures = FeatureUtil.getAllSubsettingFeaturesIn(mf, EvaluationUtil.getAnnotatedElementFeature(mf));
		if (annotatedElementFeatures.exists[!abstract]) {
			annotatedElementFeatures = annotatedElementFeatures.filter[!abstract].toList
		}
		if (!annotatedElementFeatures.empty) {
			for (element: mf.annotatedElement) {
				val metaclass = ElementUtil.getMetaclassOf(element)
				if (metaclass !== null && !annotatedElementFeatures.exists[f | f.type.forall[t | TypeUtil.conforms(metaclass, t)]]) {
					error(INVALID_METADATA_FEATURE_ANNOTATED_ELEMENT_MSG.replace("{metaclass}", metaclass.declaredName), mf, null, INVALID_METADATA_FEATURE_ANNOTATED_ELEMENT)
				}
			}
		}
		
		// TODO: Add validateMetadataFeatureBody
		checkMetadataBody(mf)
	}
	
	
	def void checkMetadataBody(Feature t) {
		for (f: t.ownedFeature) {
			checkMetadataBodyFeature(f)
		}
	}
	
	def checkMetadataBodyFeature(Feature f) {
		// Must redefine a feature owned by a supertype of its owner.
		if (!f.ownedRedefinition.map[redefinedFeature?.owningType].exists[t | t !== null && TypeUtil.conforms(f.owningType, t)]) {
			error(INVALID_METADATA_FEATURE_BODY_MSG_1, f, null, INVALID_METADATA_FEATURE_BODY)
		}
		
		// Feature value, if any, must be model-level evaluable.
		val fv = FeatureUtil.getValuationFor(f)
		val value = fv?.value
		if (value !== null && !value.isModelLevelEvaluable) {
			error(INVALID_METADATA_FEATURE_BODY_MSG_2, fv, SysMLPackage.eINSTANCE.featureValue_Value, INVALID_METADATA_FEATURE_BODY)
		}
		
		// Must have a valid metadata body.
		checkMetadataBody(f)		
	}
	
	@Check
	def checkElementFilterMembership(ElementFilterMembership efm) {
		val condition = efm.condition
		if (condition !== null)
			// validateElementFilterMembershipIsModelLevelEvaluable
			if (!condition.isModelLevelEvaluable)
				error(INVALID_ELEMENT_FILTER_MEMBERSHIP_IS_MODEL_LEVEL_EVALUABLE_MSG, efm, SysMLPackage.eINSTANCE.elementFilterMembership_Condition, INVALID_ELEMENT_FILTER_MEMBERSHIP_IS_MODEL_LEVEL_EVALUABLE)
				
			// validateElementFilterMembershipIsBoolean
			else if (!condition.isBoolean)
				error(INVALID_ELEMENT_FILTER_MEMBERSHIP_IS_BOOLEAN_MSG, efm, SysMLPackage.eINSTANCE.elementFilterMembership_Condition, INVALID_ELEMENT_FILTER_MEMBERSHIP_IS_BOOLEAN)
	}
	
	@Check
	def checkLibraryPackage(LibraryPackage pkg) {
		// Note: Can't suppress the warning in Xtend.
		if (pkg.isStandard && !SysMLLibraryUtil.isModelLibrary(pkg.eResource)) {
			warning(INVALID_LIBRARY_PACKAGE_NOT_STANDARD_MSG, pkg, SysMLPackage.eINSTANCE.libraryPackage_IsStandard, INVALID_LIBRARY_PACKAGE_NOT_STANDARD)
		}
	}
	
	/* Utility Methods */
	
	def boolean isBoolean(Expression condition) {
		TypeUtil.conforms(condition.result, getBooleanType(condition)) ||
		// LiteralBooleans currently don't have an inferred Boolean result type.
		condition instanceof LiteralBoolean ||
		// Non-conditional "Boolean" operations in DataFunctions actually have result DataValue.
		// This infers that they are actually BooleanFunctions if their arguments are Boolean.
		condition instanceof OperatorExpression && 
			(condition as OperatorExpression).operator.booleanOperator && 
			(condition as OperatorExpression).argument.forall[isBoolean]
	}
	
	def getBooleanType(Element context) {
		SysMLLibraryUtil.getLibraryElement(context, "ScalarValues::Boolean") as Type
	}
	
	def isBooleanOperator(String operator) {
		newArrayList("not", "xor", "&", "|").contains(operator)
	}
	
	def checkNotOne( List<? extends EObject> list, String msg, String code) {
		if (list.size == 1) {
			error(msg, list.get(0), null, code)
		}
	}
	
	def typesConform(List<Type> t1, List<Type> t2) {
		val t1ConformsTot2 = t2.map[conformsFrom(t1)]
		val t2ConformsTot1 = t1.map[conformsFrom(t2)]
		t1ConformsTot2.filter[!empty].length == t2.length ||
			t2ConformsTot1.filter[!empty].length == t1.length
	}
	
	// Return conforming subtypes
	protected def Iterable<Type> conformsFrom(Type supertype, List<Type> subtypes) 
	{
		subtypes.filter[subtype|subtype.conformsTo(supertype)]
	}
	
	// Return conformed supertypes
    protected def Iterable<Type> conformsTo(Type subtype, List<Type> supertypes) 
	{
		supertypes.filter[supertype|subtype.conformsTo(supertype)]
	}

	protected def boolean conformsTo(Type subtype, Type supertype) {
		supertype === null || TypeUtil.conforms(subtype, supertype);
	}
	
}
