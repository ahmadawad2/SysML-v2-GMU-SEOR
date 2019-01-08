/*
 * generated by Xtext 2.12.0
 */
package org.omg.sysml.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.omg.sysml.ide.contentassist.antlr.internal.InternalAlfParser;
import org.omg.sysml.services.AlfGrammarAccess;

public class AlfParser extends AbstractContentAssistParser {

	@Inject
	private AlfGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalAlfParser createParser() {
		InternalAlfParser result = new InternalAlfParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getUnitDefinitionAccess().getAlternatives(), "rule__UnitDefinition__Alternatives");
					put(grammarAccess.getUnitPrefixAccess().getAlternatives_0(), "rule__UnitPrefix__Alternatives_0");
					put(grammarAccess.getPackageImportAccess().getAlternatives_3(), "rule__PackageImport__Alternatives_3");
					put(grammarAccess.getPackageImportAccess().getAlternatives_3_0_1(), "rule__PackageImport__Alternatives_3_0_1");
					put(grammarAccess.getNonFeatureDefinitionAccess().getAlternatives(), "rule__NonFeatureDefinition__Alternatives");
					put(grammarAccess.getPackageDefinitionAccess().getAlternatives_3(), "rule__PackageDefinition__Alternatives_3");
					put(grammarAccess.getPackageMemberAccess().getAlternatives_1(), "rule__PackageMember__Alternatives_1");
					put(grammarAccess.getNonFeatureMemberElementAccess().getAlternatives(), "rule__NonFeatureMemberElement__Alternatives");
					put(grammarAccess.getFeaturePackageMemberElementAccess().getAlternatives(), "rule__FeaturePackageMemberElement__Alternatives");
					put(grammarAccess.getFeaturePackageMemberElementAccess().getAlternatives_2_0(), "rule__FeaturePackageMemberElement__Alternatives_2_0");
					put(grammarAccess.getCategoryBodyAccess().getAlternatives(), "rule__CategoryBody__Alternatives");
					put(grammarAccess.getCategoryBodyAccess().getAlternatives_1_1(), "rule__CategoryBody__Alternatives_1_1");
					put(grammarAccess.getCategoryMemberAccess().getAlternatives(), "rule__CategoryMember__Alternatives");
					put(grammarAccess.getFeatureCategoryMemberAccess().getAlternatives_1(), "rule__FeatureCategoryMember__Alternatives_1");
					put(grammarAccess.getFeatureMemberElementAccess().getAlternatives(), "rule__FeatureMemberElement__Alternatives");
					put(grammarAccess.getFeatureMemberElementAccess().getAlternatives_0_0(), "rule__FeatureMemberElement__Alternatives_0_0");
					put(grammarAccess.getFeatureMemberElementAccess().getAlternatives_1_0(), "rule__FeatureMemberElement__Alternatives_1_0");
					put(grammarAccess.getAssociationBodyAccess().getAlternatives(), "rule__AssociationBody__Alternatives");
					put(grammarAccess.getAssociationBodyAccess().getAlternatives_1_1(), "rule__AssociationBody__Alternatives_1_1");
					put(grammarAccess.getAssociationMemberAccess().getAlternatives(), "rule__AssociationMember__Alternatives");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getAlternatives_1(), "rule__AssociationEndFeatureMember__Alternatives_1");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getAlternatives_1_0_1(), "rule__AssociationEndFeatureMember__Alternatives_1_0_1");
					put(grammarAccess.getFeatureDefinitionAccess().getAlternatives(), "rule__FeatureDefinition__Alternatives");
					put(grammarAccess.getTypePartAccess().getAlternatives_2(), "rule__TypePart__Alternatives_2");
					put(grammarAccess.getSubsetOrRedefinitionAccess().getAlternatives(), "rule__SubsetOrRedefinition__Alternatives");
					put(grammarAccess.getConnectorDefinitionAccess().getAlternatives_0(), "rule__ConnectorDefinition__Alternatives_0");
					put(grammarAccess.getConnectorEndAccess().getAlternatives(), "rule__ConnectorEnd__Alternatives");
					put(grammarAccess.getBinaryExpressionAccess().getAlternatives_1_1(), "rule__BinaryExpression__Alternatives_1_1");
					put(grammarAccess.getBinaryOperatorAccess().getAlternatives(), "rule__BinaryOperator__Alternatives");
					put(grammarAccess.getUnaryExpressionAccess().getAlternatives(), "rule__UnaryExpression__Alternatives");
					put(grammarAccess.getUnaryOperatorAccess().getAlternatives(), "rule__UnaryOperator__Alternatives");
					put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
					put(grammarAccess.getTupleAccess().getAlternatives(), "rule__Tuple__Alternatives");
					put(grammarAccess.getLiteralExpressionAccess().getAlternatives(), "rule__LiteralExpression__Alternatives");
					put(grammarAccess.getRealValueAccess().getAlternatives(), "rule__RealValue__Alternatives");
					put(grammarAccess.getRealValueAccess().getAlternatives_0_2(), "rule__RealValue__Alternatives_0_2");
					put(grammarAccess.getUnlimitedNaturalLiteralExpressionAccess().getAlternatives(), "rule__UnlimitedNaturalLiteralExpression__Alternatives");
					put(grammarAccess.getNameAccess().getAlternatives(), "rule__Name__Alternatives");
					put(grammarAccess.getQualifiedNameAccess().getAlternatives(), "rule__QualifiedName__Alternatives");
					put(grammarAccess.getPackageElementVisibilityIndicatorAccess().getAlternatives(), "rule__PackageElementVisibilityIndicator__Alternatives");
					put(grammarAccess.getVisibilityIndicatorAccess().getAlternatives(), "rule__VisibilityIndicator__Alternatives");
					put(grammarAccess.getFeatureDirectionAccess().getAlternatives(), "rule__FeatureDirection__Alternatives");
					put(grammarAccess.getPackageUnitDefinitionAccess().getGroup(), "rule__PackageUnitDefinition__Group__0");
					put(grammarAccess.getClassUnitDefinitionAccess().getGroup(), "rule__ClassUnitDefinition__Group__0");
					put(grammarAccess.getAssociationUnitDefinitionAccess().getGroup(), "rule__AssociationUnitDefinition__Group__0");
					put(grammarAccess.getFeatureUnitDefinitionAccess().getGroup(), "rule__FeatureUnitDefinition__Group__0");
					put(grammarAccess.getUnitPrefixAccess().getGroup(), "rule__UnitPrefix__Group__0");
					put(grammarAccess.getPackageImportAccess().getGroup(), "rule__PackageImport__Group__0");
					put(grammarAccess.getPackageImportAccess().getGroup_3_0(), "rule__PackageImport__Group_3_0__0");
					put(grammarAccess.getPackageImportAccess().getGroup_3_1(), "rule__PackageImport__Group_3_1__0");
					put(grammarAccess.getPackageImportAccess().getGroup_3_2(), "rule__PackageImport__Group_3_2__0");
					put(grammarAccess.getElementImportAccess().getGroup(), "rule__ElementImport__Group__0");
					put(grammarAccess.getElementImportAccess().getGroup_3(), "rule__ElementImport__Group_3__0");
					put(grammarAccess.getPackageDefinitionAccess().getGroup(), "rule__PackageDefinition__Group__0");
					put(grammarAccess.getPackageMemberAccess().getGroup(), "rule__PackageMember__Group__0");
					put(grammarAccess.getPackageMemberPrefixAccess().getGroup(), "rule__PackageMemberPrefix__Group__0");
					put(grammarAccess.getNonFeatureMemberElementAccess().getGroup_1(), "rule__NonFeatureMemberElement__Group_1__0");
					put(grammarAccess.getNonFeatureMemberElementAccess().getGroup_2(), "rule__NonFeatureMemberElement__Group_2__0");
					put(grammarAccess.getNonFeatureMemberElementAccess().getGroup_3(), "rule__NonFeatureMemberElement__Group_3__0");
					put(grammarAccess.getNonFeatureMemberElementAccess().getGroup_4(), "rule__NonFeatureMemberElement__Group_4__0");
					put(grammarAccess.getNonFeatureMemberElementAccess().getGroup_4_2(), "rule__NonFeatureMemberElement__Group_4_2__0");
					put(grammarAccess.getFeaturePackageMemberElementAccess().getGroup_0(), "rule__FeaturePackageMemberElement__Group_0__0");
					put(grammarAccess.getFeaturePackageMemberElementAccess().getGroup_1(), "rule__FeaturePackageMemberElement__Group_1__0");
					put(grammarAccess.getFeaturePackageMemberElementAccess().getGroup_2(), "rule__FeaturePackageMemberElement__Group_2__0");
					put(grammarAccess.getFeaturePackageMemberElementAccess().getGroup_2_0_0(), "rule__FeaturePackageMemberElement__Group_2_0_0__0");
					put(grammarAccess.getCategoryBodyAccess().getGroup_1(), "rule__CategoryBody__Group_1__0");
					put(grammarAccess.getNonFeatureCategoryMemberAccess().getGroup(), "rule__NonFeatureCategoryMember__Group__0");
					put(grammarAccess.getFeatureCategoryMemberAccess().getGroup(), "rule__FeatureCategoryMember__Group__0");
					put(grammarAccess.getFeatureCategoryMemberAccess().getGroup_1_1(), "rule__FeatureCategoryMember__Group_1_1__0");
					put(grammarAccess.getFeatureCategoryMemberAccess().getGroup_1_2(), "rule__FeatureCategoryMember__Group_1_2__0");
					put(grammarAccess.getCategoryMemberPrefixAccess().getGroup(), "rule__CategoryMemberPrefix__Group__0");
					put(grammarAccess.getFeatureMemberElementAccess().getGroup_0(), "rule__FeatureMemberElement__Group_0__0");
					put(grammarAccess.getFeatureMemberElementAccess().getGroup_1(), "rule__FeatureMemberElement__Group_1__0");
					put(grammarAccess.getFeatureMemberElementAccess().getGroup_2(), "rule__FeatureMemberElement__Group_2__0");
					put(grammarAccess.getFeatureMemberElementAccess().getGroup_3(), "rule__FeatureMemberElement__Group_3__0");
					put(grammarAccess.getClassDefinitionAccess().getGroup(), "rule__ClassDefinition__Group__0");
					put(grammarAccess.getClassDeclarationAccess().getGroup(), "rule__ClassDeclaration__Group__0");
					put(grammarAccess.getClassDeclarationAccess().getGroup_3(), "rule__ClassDeclaration__Group_3__0");
					put(grammarAccess.getClassDeclarationAccess().getGroup_3_2(), "rule__ClassDeclaration__Group_3_2__0");
					put(grammarAccess.getAssociationDefinitionAccess().getGroup(), "rule__AssociationDefinition__Group__0");
					put(grammarAccess.getAssociationDeclarationAccess().getGroup(), "rule__AssociationDeclaration__Group__0");
					put(grammarAccess.getAssociationDeclarationAccess().getGroup_3(), "rule__AssociationDeclaration__Group_3__0");
					put(grammarAccess.getAssociationDeclarationAccess().getGroup_3_2(), "rule__AssociationDeclaration__Group_3_2__0");
					put(grammarAccess.getAssociationBodyAccess().getGroup_1(), "rule__AssociationBody__Group_1__0");
					put(grammarAccess.getAssociationFeatureMemberAccess().getGroup(), "rule__AssociationFeatureMember__Group__0");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getGroup(), "rule__AssociationEndFeatureMember__Group__0");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getGroup_1_0(), "rule__AssociationEndFeatureMember__Group_1_0__0");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getGroup_1_1(), "rule__AssociationEndFeatureMember__Group_1_1__0");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getGroup_1_2(), "rule__AssociationEndFeatureMember__Group_1_2__0");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getGroup_1_3(), "rule__AssociationEndFeatureMember__Group_1_3__0");
					put(grammarAccess.getNamedFeatureDefinitionAccess().getGroup(), "rule__NamedFeatureDefinition__Group__0");
					put(grammarAccess.getUnnamedFeatureDefinitionAccess().getGroup(), "rule__UnnamedFeatureDefinition__Group__0");
					put(grammarAccess.getFeatureBodyDefinitionAccess().getGroup(), "rule__FeatureBodyDefinition__Group__0");
					put(grammarAccess.getFeatureDeclarationAccess().getGroup(), "rule__FeatureDeclaration__Group__0");
					put(grammarAccess.getFeatureCompletionAccess().getGroup(), "rule__FeatureCompletion__Group__0");
					put(grammarAccess.getFeatureCompletionAccess().getGroup_0(), "rule__FeatureCompletion__Group_0__0");
					put(grammarAccess.getTypePartAccess().getGroup(), "rule__TypePart__Group__0");
					put(grammarAccess.getMultiplicityAccess().getGroup(), "rule__Multiplicity__Group__0");
					put(grammarAccess.getMultiplicityAccess().getGroup_1(), "rule__Multiplicity__Group_1__0");
					put(grammarAccess.getSubsetOrRedefinitionAccess().getGroup_0(), "rule__SubsetOrRedefinition__Group_0__0");
					put(grammarAccess.getSubsetOrRedefinitionAccess().getGroup_1(), "rule__SubsetOrRedefinition__Group_1__0");
					put(grammarAccess.getConnectorDefinitionAccess().getGroup(), "rule__ConnectorDefinition__Group__0");
					put(grammarAccess.getConnectorDefinitionAccess().getGroup_0_0(), "rule__ConnectorDefinition__Group_0_0__0");
					put(grammarAccess.getConnectorDefinitionAccess().getGroup_0_0_0(), "rule__ConnectorDefinition__Group_0_0_0__0");
					put(grammarAccess.getConnectorDefinitionAccess().getGroup_0_0_0_1(), "rule__ConnectorDefinition__Group_0_0_0_1__0");
					put(grammarAccess.getConnectorDefinitionAccess().getGroup_0_1(), "rule__ConnectorDefinition__Group_0_1__0");
					put(grammarAccess.getConnectorDefinitionAccess().getGroup_0_1_1(), "rule__ConnectorDefinition__Group_0_1_1__0");
					put(grammarAccess.getConnectorDefinitionAccess().getGroup_0_1_6(), "rule__ConnectorDefinition__Group_0_1_6__0");
					put(grammarAccess.getConnectorEndAccess().getGroup_0(), "rule__ConnectorEnd__Group_0__0");
					put(grammarAccess.getConnectorEndAccess().getGroup_0_0(), "rule__ConnectorEnd__Group_0_0__0");
					put(grammarAccess.getConnectorEndAccess().getGroup_1(), "rule__ConnectorEnd__Group_1__0");
					put(grammarAccess.getConnectorEndAccess().getGroup_1_0(), "rule__ConnectorEnd__Group_1_0__0");
					put(grammarAccess.getBinaryExpressionAccess().getGroup(), "rule__BinaryExpression__Group__0");
					put(grammarAccess.getBinaryExpressionAccess().getGroup_1(), "rule__BinaryExpression__Group_1__0");
					put(grammarAccess.getBinaryExpressionAccess().getGroup_1_1_0(), "rule__BinaryExpression__Group_1_1_0__0");
					put(grammarAccess.getBinaryExpressionAccess().getGroup_1_1_1(), "rule__BinaryExpression__Group_1_1_1__0");
					put(grammarAccess.getUnaryExpressionAccess().getGroup_1(), "rule__UnaryExpression__Group_1__0");
					put(grammarAccess.getSequenceAccessExpressionAccess().getGroup(), "rule__SequenceAccessExpression__Group__0");
					put(grammarAccess.getSequenceAccessExpressionAccess().getGroup_1(), "rule__SequenceAccessExpression__Group_1__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_4(), "rule__PrimaryExpression__Group_4__0");
					put(grammarAccess.getInstanceCreationExpressionAccess().getGroup(), "rule__InstanceCreationExpression__Group__0");
					put(grammarAccess.getPositionalTupleAccess().getGroup(), "rule__PositionalTuple__Group__0");
					put(grammarAccess.getPositionalTupleAccess().getGroup_1(), "rule__PositionalTuple__Group_1__0");
					put(grammarAccess.getNamedTupleAccess().getGroup(), "rule__NamedTuple__Group__0");
					put(grammarAccess.getNamedTupleAccess().getGroup_3(), "rule__NamedTuple__Group_3__0");
					put(grammarAccess.getSequenceConstructionExpressionAccess().getGroup(), "rule__SequenceConstructionExpression__Group__0");
					put(grammarAccess.getSequenceConstructionExpressionAccess().getGroup_2(), "rule__SequenceConstructionExpression__Group_2__0");
					put(grammarAccess.getSequenceConstructionExpressionAccess().getGroup_2_1(), "rule__SequenceConstructionExpression__Group_2_1__0");
					put(grammarAccess.getNullLiteralExpressionAccess().getGroup(), "rule__NullLiteralExpression__Group__0");
					put(grammarAccess.getRealValueAccess().getGroup_0(), "rule__RealValue__Group_0__0");
					put(grammarAccess.getUnlimitedNaturalLiteralExpressionAccess().getGroup_1(), "rule__UnlimitedNaturalLiteralExpression__Group_1__0");
					put(grammarAccess.getColonQualifiedNameAccess().getGroup(), "rule__ColonQualifiedName__Group__0");
					put(grammarAccess.getColonQualifiedNameAccess().getGroup_1(), "rule__ColonQualifiedName__Group_1__0");
					put(grammarAccess.getDotQualifiedNameAccess().getGroup(), "rule__DotQualifiedName__Group__0");
					put(grammarAccess.getDotQualifiedNameAccess().getGroup_1(), "rule__DotQualifiedName__Group_1__0");
					put(grammarAccess.getUnitPrefixAccess().getOwnedImportAssignment_0_0(), "rule__UnitPrefix__OwnedImportAssignment_0_0");
					put(grammarAccess.getUnitPrefixAccess().getOwnedMembershipAssignment_0_1(), "rule__UnitPrefix__OwnedMembershipAssignment_0_1");
					put(grammarAccess.getUnitPrefixAccess().getOwnedRelationshipAssignment_1(), "rule__UnitPrefix__OwnedRelationshipAssignment_1");
					put(grammarAccess.getAnnotationAccess().getOwnedRelatedElementAssignment(), "rule__Annotation__OwnedRelatedElementAssignment");
					put(grammarAccess.getCommentAccess().getBodyAssignment(), "rule__Comment__BodyAssignment");
					put(grammarAccess.getPackageImportAccess().getOwnedRelationshipAssignment_0(), "rule__PackageImport__OwnedRelationshipAssignment_0");
					put(grammarAccess.getPackageImportAccess().getVisibilityAssignment_1(), "rule__PackageImport__VisibilityAssignment_1");
					put(grammarAccess.getPackageImportAccess().getImportedPackageAssignment_3_0_0(), "rule__PackageImport__ImportedPackageAssignment_3_0_0");
					put(grammarAccess.getPackageImportAccess().getImportedPackageAssignment_3_1_0(), "rule__PackageImport__ImportedPackageAssignment_3_1_0");
					put(grammarAccess.getPackageImportAccess().getImportedPackageAssignment_3_2_0(), "rule__PackageImport__ImportedPackageAssignment_3_2_0");
					put(grammarAccess.getElementImportAccess().getMemberElementAssignment_2(), "rule__ElementImport__MemberElementAssignment_2");
					put(grammarAccess.getElementImportAccess().getMemberNameAssignment_3_1(), "rule__ElementImport__MemberNameAssignment_3_1");
					put(grammarAccess.getPackageDefinitionAccess().getNameAssignment_1(), "rule__PackageDefinition__NameAssignment_1");
					put(grammarAccess.getPackageDefinitionAccess().getOwnedMembershipAssignment_3_0(), "rule__PackageDefinition__OwnedMembershipAssignment_3_0");
					put(grammarAccess.getPackageDefinitionAccess().getOwnedImportAssignment_3_1(), "rule__PackageDefinition__OwnedImportAssignment_3_1");
					put(grammarAccess.getPackageMemberPrefixAccess().getOwnedRelationshipAssignment_0(), "rule__PackageMemberPrefix__OwnedRelationshipAssignment_0");
					put(grammarAccess.getPackageMemberPrefixAccess().getVisibilityAssignment_1(), "rule__PackageMemberPrefix__VisibilityAssignment_1");
					put(grammarAccess.getNonFeatureMemberElementAccess().getOwnedMemberElementAssignment_0(), "rule__NonFeatureMemberElement__OwnedMemberElementAssignment_0");
					put(grammarAccess.getNonFeatureMemberElementAccess().getMemberNameAssignment_1_1(), "rule__NonFeatureMemberElement__MemberNameAssignment_1_1");
					put(grammarAccess.getNonFeatureMemberElementAccess().getMemberElementAssignment_1_3(), "rule__NonFeatureMemberElement__MemberElementAssignment_1_3");
					put(grammarAccess.getNonFeatureMemberElementAccess().getMemberNameAssignment_2_1(), "rule__NonFeatureMemberElement__MemberNameAssignment_2_1");
					put(grammarAccess.getNonFeatureMemberElementAccess().getMemberElementAssignment_2_3(), "rule__NonFeatureMemberElement__MemberElementAssignment_2_3");
					put(grammarAccess.getNonFeatureMemberElementAccess().getMemberNameAssignment_3_1(), "rule__NonFeatureMemberElement__MemberNameAssignment_3_1");
					put(grammarAccess.getNonFeatureMemberElementAccess().getMemberElementAssignment_3_3(), "rule__NonFeatureMemberElement__MemberElementAssignment_3_3");
					put(grammarAccess.getNonFeatureMemberElementAccess().getMemberElementAssignment_4_1(), "rule__NonFeatureMemberElement__MemberElementAssignment_4_1");
					put(grammarAccess.getNonFeatureMemberElementAccess().getMemberNameAssignment_4_2_1(), "rule__NonFeatureMemberElement__MemberNameAssignment_4_2_1");
					put(grammarAccess.getFeaturePackageMemberElementAccess().getOwnedMemberElementAssignment_0_1(), "rule__FeaturePackageMemberElement__OwnedMemberElementAssignment_0_1");
					put(grammarAccess.getFeaturePackageMemberElementAccess().getOwnedMemberElementAssignment_1_1(), "rule__FeaturePackageMemberElement__OwnedMemberElementAssignment_1_1");
					put(grammarAccess.getFeaturePackageMemberElementAccess().getMemberNameAssignment_2_0_0_1(), "rule__FeaturePackageMemberElement__MemberNameAssignment_2_0_0_1");
					put(grammarAccess.getFeaturePackageMemberElementAccess().getMemberNameAssignment_2_0_1(), "rule__FeaturePackageMemberElement__MemberNameAssignment_2_0_1");
					put(grammarAccess.getFeaturePackageMemberElementAccess().getMemberElementAssignment_2_2(), "rule__FeaturePackageMemberElement__MemberElementAssignment_2_2");
					put(grammarAccess.getCategoryBodyAccess().getOwnedMembershipAssignment_1_1_0(), "rule__CategoryBody__OwnedMembershipAssignment_1_1_0");
					put(grammarAccess.getCategoryBodyAccess().getOwnedImportAssignment_1_1_1(), "rule__CategoryBody__OwnedImportAssignment_1_1_1");
					put(grammarAccess.getFeatureCategoryMemberAccess().getDirectionAssignment_1_1_0(), "rule__FeatureCategoryMember__DirectionAssignment_1_1_0");
					put(grammarAccess.getFeatureCategoryMemberAccess().getOwnedMemberFeatureAssignment_1_1_1(), "rule__FeatureCategoryMember__OwnedMemberFeatureAssignment_1_1_1");
					put(grammarAccess.getFeatureCategoryMemberAccess().getMemberNameAssignment_1_2_0(), "rule__FeatureCategoryMember__MemberNameAssignment_1_2_0");
					put(grammarAccess.getFeatureCategoryMemberAccess().getMemberFeatureAssignment_1_2_2(), "rule__FeatureCategoryMember__MemberFeatureAssignment_1_2_2");
					put(grammarAccess.getCategoryMemberPrefixAccess().getOwnedRelationshipAssignment_0(), "rule__CategoryMemberPrefix__OwnedRelationshipAssignment_0");
					put(grammarAccess.getCategoryMemberPrefixAccess().getVisibilityAssignment_1(), "rule__CategoryMemberPrefix__VisibilityAssignment_1");
					put(grammarAccess.getFeatureMemberElementAccess().getIsPartAssignment_0_0_1(), "rule__FeatureMemberElement__IsPartAssignment_0_0_1");
					put(grammarAccess.getFeatureMemberElementAccess().getIsPortAssignment_0_0_2(), "rule__FeatureMemberElement__IsPortAssignment_0_0_2");
					put(grammarAccess.getFeatureMemberElementAccess().getDirectionAssignment_0_1(), "rule__FeatureMemberElement__DirectionAssignment_0_1");
					put(grammarAccess.getFeatureMemberElementAccess().getOwnedMemberFeatureAssignment_0_2(), "rule__FeatureMemberElement__OwnedMemberFeatureAssignment_0_2");
					put(grammarAccess.getFeatureMemberElementAccess().getIsPartAssignment_1_0_1(), "rule__FeatureMemberElement__IsPartAssignment_1_0_1");
					put(grammarAccess.getFeatureMemberElementAccess().getMemberNameAssignment_1_1(), "rule__FeatureMemberElement__MemberNameAssignment_1_1");
					put(grammarAccess.getFeatureMemberElementAccess().getMemberFeatureAssignment_1_3(), "rule__FeatureMemberElement__MemberFeatureAssignment_1_3");
					put(grammarAccess.getFeatureMemberElementAccess().getOwnedMemberFeatureAssignment_2_1(), "rule__FeatureMemberElement__OwnedMemberFeatureAssignment_2_1");
					put(grammarAccess.getFeatureMemberElementAccess().getMemberNameAssignment_3_1(), "rule__FeatureMemberElement__MemberNameAssignment_3_1");
					put(grammarAccess.getFeatureMemberElementAccess().getMemberFeatureAssignment_3_3(), "rule__FeatureMemberElement__MemberFeatureAssignment_3_3");
					put(grammarAccess.getClassDeclarationAccess().getIsAbstractAssignment_0(), "rule__ClassDeclaration__IsAbstractAssignment_0");
					put(grammarAccess.getClassDeclarationAccess().getNameAssignment_2(), "rule__ClassDeclaration__NameAssignment_2");
					put(grammarAccess.getClassDeclarationAccess().getOwnedRelationshipAssignment_3_1(), "rule__ClassDeclaration__OwnedRelationshipAssignment_3_1");
					put(grammarAccess.getClassDeclarationAccess().getOwnedRelationshipAssignment_3_2_1(), "rule__ClassDeclaration__OwnedRelationshipAssignment_3_2_1");
					put(grammarAccess.getSuperclassingAccess().getSuperclassAssignment(), "rule__Superclassing__SuperclassAssignment");
					put(grammarAccess.getAssociationDeclarationAccess().getIsAbstractAssignment_0(), "rule__AssociationDeclaration__IsAbstractAssignment_0");
					put(grammarAccess.getAssociationDeclarationAccess().getNameAssignment_2(), "rule__AssociationDeclaration__NameAssignment_2");
					put(grammarAccess.getAssociationDeclarationAccess().getOwnedRelationshipAssignment_3_1(), "rule__AssociationDeclaration__OwnedRelationshipAssignment_3_1");
					put(grammarAccess.getAssociationDeclarationAccess().getOwnedRelationshipAssignment_3_2_1(), "rule__AssociationDeclaration__OwnedRelationshipAssignment_3_2_1");
					put(grammarAccess.getAssociationBodyAccess().getOwnedMembershipAssignment_1_1_0(), "rule__AssociationBody__OwnedMembershipAssignment_1_1_0");
					put(grammarAccess.getAssociationBodyAccess().getOwnedImportAssignment_1_1_1(), "rule__AssociationBody__OwnedImportAssignment_1_1_1");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getIsPartAssignment_1_0_1_0(), "rule__AssociationEndFeatureMember__IsPartAssignment_1_0_1_0");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getIsPortAssignment_1_0_1_1(), "rule__AssociationEndFeatureMember__IsPortAssignment_1_0_1_1");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getDirectionAssignment_1_0_2(), "rule__AssociationEndFeatureMember__DirectionAssignment_1_0_2");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getOwnedMemberFeatureAssignment_1_0_3(), "rule__AssociationEndFeatureMember__OwnedMemberFeatureAssignment_1_0_3");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getIsPartAssignment_1_1_1(), "rule__AssociationEndFeatureMember__IsPartAssignment_1_1_1");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getMemberNameAssignment_1_1_2(), "rule__AssociationEndFeatureMember__MemberNameAssignment_1_1_2");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getMemberFeatureAssignment_1_1_4(), "rule__AssociationEndFeatureMember__MemberFeatureAssignment_1_1_4");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getDirectionAssignment_1_2_0(), "rule__AssociationEndFeatureMember__DirectionAssignment_1_2_0");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getOwnedMemberFeatureAssignment_1_2_1(), "rule__AssociationEndFeatureMember__OwnedMemberFeatureAssignment_1_2_1");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getMemberNameAssignment_1_3_0(), "rule__AssociationEndFeatureMember__MemberNameAssignment_1_3_0");
					put(grammarAccess.getAssociationEndFeatureMemberAccess().getMemberFeatureAssignment_1_3_2(), "rule__AssociationEndFeatureMember__MemberFeatureAssignment_1_3_2");
					put(grammarAccess.getUnnamedFeatureDefinitionAccess().getOwnedRelationshipAssignment_0(), "rule__UnnamedFeatureDefinition__OwnedRelationshipAssignment_0");
					put(grammarAccess.getUnnamedFeatureDefinitionAccess().getMultiplicityAssignment_2(), "rule__UnnamedFeatureDefinition__MultiplicityAssignment_2");
					put(grammarAccess.getFeatureDeclarationAccess().getNameAssignment_0(), "rule__FeatureDeclaration__NameAssignment_0");
					put(grammarAccess.getFeatureDeclarationAccess().getMultiplicityAssignment_2(), "rule__FeatureDeclaration__MultiplicityAssignment_2");
					put(grammarAccess.getFeatureDeclarationAccess().getIsOrderedAssignment_3_0(), "rule__FeatureDeclaration__IsOrderedAssignment_3_0");
					put(grammarAccess.getFeatureDeclarationAccess().getIsNonuniqueAssignment_3_1(), "rule__FeatureDeclaration__IsNonuniqueAssignment_3_1");
					put(grammarAccess.getFeatureDeclarationAccess().getOwnedRelationshipAssignment_4(), "rule__FeatureDeclaration__OwnedRelationshipAssignment_4");
					put(grammarAccess.getFeatureCompletionAccess().getValuationAssignment_0_1(), "rule__FeatureCompletion__ValuationAssignment_0_1");
					put(grammarAccess.getFeatureValueAccess().getValueAssignment(), "rule__FeatureValue__ValueAssignment");
					put(grammarAccess.getTypePartAccess().getIsCompositeAssignment_1(), "rule__TypePart__IsCompositeAssignment_1");
					put(grammarAccess.getTypePartAccess().getOwnedRelationshipAssignment_2_0(), "rule__TypePart__OwnedRelationshipAssignment_2_0");
					put(grammarAccess.getFeatureTypingAccess().getTypeAssignment(), "rule__FeatureTyping__TypeAssignment");
					put(grammarAccess.getMultiplicityAccess().getLowerAssignment_1_0(), "rule__Multiplicity__LowerAssignment_1_0");
					put(grammarAccess.getMultiplicityAccess().getUpperAssignment_2(), "rule__Multiplicity__UpperAssignment_2");
					put(grammarAccess.getRedefinitionAccess().getRedefinedFeatureAssignment(), "rule__Redefinition__RedefinedFeatureAssignment");
					put(grammarAccess.getSubsetAccess().getSubsettedFeatureAssignment(), "rule__Subset__SubsettedFeatureAssignment");
					put(grammarAccess.getConnectorDefinitionAccess().getNameAssignment_0_0_0_0(), "rule__ConnectorDefinition__NameAssignment_0_0_0_0");
					put(grammarAccess.getConnectorDefinitionAccess().getOwnedRelationshipAssignment_0_0_0_1_1(), "rule__ConnectorDefinition__OwnedRelationshipAssignment_0_0_0_1_1");
					put(grammarAccess.getConnectorDefinitionAccess().getConnectorEndAssignment_0_0_1(), "rule__ConnectorDefinition__ConnectorEndAssignment_0_0_1");
					put(grammarAccess.getConnectorDefinitionAccess().getConnectorEndAssignment_0_0_3(), "rule__ConnectorDefinition__ConnectorEndAssignment_0_0_3");
					put(grammarAccess.getConnectorDefinitionAccess().getNameAssignment_0_1_0(), "rule__ConnectorDefinition__NameAssignment_0_1_0");
					put(grammarAccess.getConnectorDefinitionAccess().getOwnedRelationshipAssignment_0_1_1_1(), "rule__ConnectorDefinition__OwnedRelationshipAssignment_0_1_1_1");
					put(grammarAccess.getConnectorDefinitionAccess().getConnectorEndAssignment_0_1_3(), "rule__ConnectorDefinition__ConnectorEndAssignment_0_1_3");
					put(grammarAccess.getConnectorDefinitionAccess().getConnectorEndAssignment_0_1_5(), "rule__ConnectorDefinition__ConnectorEndAssignment_0_1_5");
					put(grammarAccess.getConnectorDefinitionAccess().getConnectorEndAssignment_0_1_6_1(), "rule__ConnectorDefinition__ConnectorEndAssignment_0_1_6_1");
					put(grammarAccess.getConnectorTypingAccess().getTypeAssignment(), "rule__ConnectorTyping__TypeAssignment");
					put(grammarAccess.getConnectorEndAccess().getEndAssignment_0_0_0(), "rule__ConnectorEnd__EndAssignment_0_0_0");
					put(grammarAccess.getConnectorEndAccess().getFeatureAssignment_0_1(), "rule__ConnectorEnd__FeatureAssignment_0_1");
					put(grammarAccess.getConnectorEndAccess().getMultiplicityAssignment_0_2(), "rule__ConnectorEnd__MultiplicityAssignment_0_2");
					put(grammarAccess.getConnectorEndAccess().getEndAssignment_1_0_0(), "rule__ConnectorEnd__EndAssignment_1_0_0");
					put(grammarAccess.getConnectorEndAccess().getMultiplicityAssignment_1_0_1(), "rule__ConnectorEnd__MultiplicityAssignment_1_0_1");
					put(grammarAccess.getConnectorEndAccess().getFeatureAssignment_1_1(), "rule__ConnectorEnd__FeatureAssignment_1_1");
					put(grammarAccess.getBinaryExpressionAccess().getOperatorAssignment_1_1_0_0(), "rule__BinaryExpression__OperatorAssignment_1_1_0_0");
					put(grammarAccess.getBinaryExpressionAccess().getOperandAssignment_1_1_0_1(), "rule__BinaryExpression__OperandAssignment_1_1_0_1");
					put(grammarAccess.getBinaryExpressionAccess().getOperatorAssignment_1_1_1_0(), "rule__BinaryExpression__OperatorAssignment_1_1_1_0");
					put(grammarAccess.getBinaryExpressionAccess().getOperandAssignment_1_1_1_2(), "rule__BinaryExpression__OperandAssignment_1_1_1_2");
					put(grammarAccess.getUnaryExpressionAccess().getOperatorAssignment_1_1(), "rule__UnaryExpression__OperatorAssignment_1_1");
					put(grammarAccess.getUnaryExpressionAccess().getOperandAssignment_1_2(), "rule__UnaryExpression__OperandAssignment_1_2");
					put(grammarAccess.getSequenceAccessExpressionAccess().getIndexAssignment_1_2(), "rule__SequenceAccessExpression__IndexAssignment_1_2");
					put(grammarAccess.getElementReferenceExpressionAccess().getReferentAssignment(), "rule__ElementReferenceExpression__ReferentAssignment");
					put(grammarAccess.getInstanceCreationExpressionAccess().getClassAssignment_0(), "rule__InstanceCreationExpression__ClassAssignment_0");
					put(grammarAccess.getPositionalTupleAccess().getArgumentAssignment_0(), "rule__PositionalTuple__ArgumentAssignment_0");
					put(grammarAccess.getPositionalTupleAccess().getArgumentAssignment_1_1(), "rule__PositionalTuple__ArgumentAssignment_1_1");
					put(grammarAccess.getNamedTupleAccess().getArgumentAssignment_2(), "rule__NamedTuple__ArgumentAssignment_2");
					put(grammarAccess.getNamedTupleAccess().getArgumentAssignment_3_3(), "rule__NamedTuple__ArgumentAssignment_3_3");
					put(grammarAccess.getSequenceConstructionExpressionAccess().getElementAssignment_2_0(), "rule__SequenceConstructionExpression__ElementAssignment_2_0");
					put(grammarAccess.getSequenceConstructionExpressionAccess().getElementAssignment_2_1_1(), "rule__SequenceConstructionExpression__ElementAssignment_2_1_1");
					put(grammarAccess.getBooleanLiteralExpressionAccess().getValueAssignment(), "rule__BooleanLiteralExpression__ValueAssignment");
					put(grammarAccess.getStringLiteralExpressionAccess().getValueAssignment(), "rule__StringLiteralExpression__ValueAssignment");
					put(grammarAccess.getRealLiteralExpressionAccess().getValueAssignment(), "rule__RealLiteralExpression__ValueAssignment");
					put(grammarAccess.getNaturalLiteralExpressionAccess().getValueAssignment(), "rule__NaturalLiteralExpression__ValueAssignment");
					put(grammarAccess.getFeatureDeclarationAccess().getUnorderedGroup_3(), "rule__FeatureDeclaration__UnorderedGroup_3");
				}
			};
		}
		return nameMappings.get(element);
	}
			
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public AlfGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(AlfGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
