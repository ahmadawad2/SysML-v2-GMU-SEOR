/*
 * generated by Xtext 2.22.0
 */
package org.omg.kerml.expressions.xtext.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.omg.kerml.expressions.xtext.ide.contentassist.antlr.internal.InternalKerMLExpressionsParser;
import org.omg.kerml.expressions.xtext.services.KerMLExpressionsGrammarAccess;

public class KerMLExpressionsParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(KerMLExpressionsGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, KerMLExpressionsGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getOwnedExpressionAccess().getAlternatives(), "rule__OwnedExpression__Alternatives");
			builder.put(grammarAccess.getEqualityOperatorAccess().getAlternatives(), "rule__EqualityOperator__Alternatives");
			builder.put(grammarAccess.getClassificationExpressionAccess().getAlternatives(), "rule__ClassificationExpression__Alternatives");
			builder.put(grammarAccess.getClassificationOperatorAccess().getAlternatives(), "rule__ClassificationOperator__Alternatives");
			builder.put(grammarAccess.getRelationalOperatorAccess().getAlternatives(), "rule__RelationalOperator__Alternatives");
			builder.put(grammarAccess.getAdditiveOperatorAccess().getAlternatives(), "rule__AdditiveOperator__Alternatives");
			builder.put(grammarAccess.getMultiplicativeOperatorAccess().getAlternatives(), "rule__MultiplicativeOperator__Alternatives");
			builder.put(grammarAccess.getUnaryExpressionAccess().getAlternatives(), "rule__UnaryExpression__Alternatives");
			builder.put(grammarAccess.getUnaryOperatorAccess().getAlternatives(), "rule__UnaryOperator__Alternatives");
			builder.put(grammarAccess.getExtentExpressionAccess().getAlternatives(), "rule__ExtentExpression__Alternatives");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getAlternatives_1(), "rule__PrimaryExpression__Alternatives_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getAlternatives_1_1_3(), "rule__PrimaryExpression__Alternatives_1_1_3");
			builder.put(grammarAccess.getBaseExpressionAccess().getAlternatives(), "rule__BaseExpression__Alternatives");
			builder.put(grammarAccess.getSequenceExpressionAccess().getAlternatives_1(), "rule__SequenceExpression__Alternatives_1");
			builder.put(grammarAccess.getArgumentListAccess().getAlternatives_1(), "rule__ArgumentList__Alternatives_1");
			builder.put(grammarAccess.getNullExpressionAccess().getAlternatives_1(), "rule__NullExpression__Alternatives_1");
			builder.put(grammarAccess.getLiteralExpressionAccess().getAlternatives(), "rule__LiteralExpression__Alternatives");
			builder.put(grammarAccess.getBooleanValueAccess().getAlternatives(), "rule__BooleanValue__Alternatives");
			builder.put(grammarAccess.getRealValueAccess().getAlternatives(), "rule__RealValue__Alternatives");
			builder.put(grammarAccess.getRealValueAccess().getAlternatives_0_2(), "rule__RealValue__Alternatives_0_2");
			builder.put(grammarAccess.getLiteralUnlimitedNaturalAccess().getAlternatives(), "rule__LiteralUnlimitedNatural__Alternatives");
			builder.put(grammarAccess.getNameAccess().getAlternatives(), "rule__Name__Alternatives");
			builder.put(grammarAccess.getExpressionBodyAccess().getGroup(), "rule__ExpressionBody__Group__0");
			builder.put(grammarAccess.getExpressionBodyAccess().getGroup_1(), "rule__ExpressionBody__Group_1__0");
			builder.put(grammarAccess.getBodyParameterMemberAccess().getGroup(), "rule__BodyParameterMember__Group__0");
			builder.put(grammarAccess.getConditionalExpressionAccess().getGroup(), "rule__ConditionalExpression__Group__0");
			builder.put(grammarAccess.getConditionalExpressionAccess().getGroup_1(), "rule__ConditionalExpression__Group_1__0");
			builder.put(grammarAccess.getNullCoalescingExpressionAccess().getGroup(), "rule__NullCoalescingExpression__Group__0");
			builder.put(grammarAccess.getNullCoalescingExpressionAccess().getGroup_1(), "rule__NullCoalescingExpression__Group_1__0");
			builder.put(grammarAccess.getConditionalOrExpressionAccess().getGroup(), "rule__ConditionalOrExpression__Group__0");
			builder.put(grammarAccess.getConditionalOrExpressionAccess().getGroup_1(), "rule__ConditionalOrExpression__Group_1__0");
			builder.put(grammarAccess.getConditionalAndExpressionAccess().getGroup(), "rule__ConditionalAndExpression__Group__0");
			builder.put(grammarAccess.getConditionalAndExpressionAccess().getGroup_1(), "rule__ConditionalAndExpression__Group_1__0");
			builder.put(grammarAccess.getOrExpressionAccess().getGroup(), "rule__OrExpression__Group__0");
			builder.put(grammarAccess.getOrExpressionAccess().getGroup_1(), "rule__OrExpression__Group_1__0");
			builder.put(grammarAccess.getXorExpressionAccess().getGroup(), "rule__XorExpression__Group__0");
			builder.put(grammarAccess.getXorExpressionAccess().getGroup_1(), "rule__XorExpression__Group_1__0");
			builder.put(grammarAccess.getAndExpressionAccess().getGroup(), "rule__AndExpression__Group__0");
			builder.put(grammarAccess.getAndExpressionAccess().getGroup_1(), "rule__AndExpression__Group_1__0");
			builder.put(grammarAccess.getEqualityExpressionAccess().getGroup(), "rule__EqualityExpression__Group__0");
			builder.put(grammarAccess.getEqualityExpressionAccess().getGroup_1(), "rule__EqualityExpression__Group_1__0");
			builder.put(grammarAccess.getClassificationExpressionAccess().getGroup_0(), "rule__ClassificationExpression__Group_0__0");
			builder.put(grammarAccess.getClassificationExpressionAccess().getGroup_0_1(), "rule__ClassificationExpression__Group_0_1__0");
			builder.put(grammarAccess.getClassificationExpressionAccess().getGroup_1(), "rule__ClassificationExpression__Group_1__0");
			builder.put(grammarAccess.getRelationalExpressionAccess().getGroup(), "rule__RelationalExpression__Group__0");
			builder.put(grammarAccess.getRelationalExpressionAccess().getGroup_1(), "rule__RelationalExpression__Group_1__0");
			builder.put(grammarAccess.getRangeExpressionAccess().getGroup(), "rule__RangeExpression__Group__0");
			builder.put(grammarAccess.getRangeExpressionAccess().getGroup_1(), "rule__RangeExpression__Group_1__0");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getGroup_1(), "rule__AdditiveExpression__Group_1__0");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1(), "rule__MultiplicativeExpression__Group_1__0");
			builder.put(grammarAccess.getExponentiationExpressionAccess().getGroup(), "rule__ExponentiationExpression__Group__0");
			builder.put(grammarAccess.getExponentiationExpressionAccess().getGroup_1(), "rule__ExponentiationExpression__Group_1__0");
			builder.put(grammarAccess.getUnitsExpressionAccess().getGroup(), "rule__UnitsExpression__Group__0");
			builder.put(grammarAccess.getUnitsExpressionAccess().getGroup_1(), "rule__UnitsExpression__Group_1__0");
			builder.put(grammarAccess.getUnaryExpressionAccess().getGroup_0(), "rule__UnaryExpression__Group_0__0");
			builder.put(grammarAccess.getExtentExpressionAccess().getGroup_0(), "rule__ExtentExpression__Group_0__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup(), "rule__PrimaryExpression__Group__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_1_0(), "rule__PrimaryExpression__Group_1_0__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_1_1(), "rule__PrimaryExpression__Group_1_1__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_1_2(), "rule__PrimaryExpression__Group_1_2__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_1_3(), "rule__PrimaryExpression__Group_1_3__0");
			builder.put(grammarAccess.getBaseExpressionAccess().getGroup_4(), "rule__BaseExpression__Group_4__0");
			builder.put(grammarAccess.getSequenceExpressionAccess().getGroup(), "rule__SequenceExpression__Group__0");
			builder.put(grammarAccess.getSequenceExpressionAccess().getGroup_1_1(), "rule__SequenceExpression__Group_1_1__0");
			builder.put(grammarAccess.getInvocationExpressionAccess().getGroup(), "rule__InvocationExpression__Group__0");
			builder.put(grammarAccess.getArgumentListAccess().getGroup(), "rule__ArgumentList__Group__0");
			builder.put(grammarAccess.getPositionalArgumentListAccess().getGroup(), "rule__PositionalArgumentList__Group__0");
			builder.put(grammarAccess.getPositionalArgumentListAccess().getGroup_1(), "rule__PositionalArgumentList__Group_1__0");
			builder.put(grammarAccess.getNamedArgumentListAccess().getGroup(), "rule__NamedArgumentList__Group__0");
			builder.put(grammarAccess.getNamedArgumentListAccess().getGroup_1(), "rule__NamedArgumentList__Group_1__0");
			builder.put(grammarAccess.getNamedExpressionMemberAccess().getGroup(), "rule__NamedExpressionMember__Group__0");
			builder.put(grammarAccess.getNullExpressionAccess().getGroup(), "rule__NullExpression__Group__0");
			builder.put(grammarAccess.getNullExpressionAccess().getGroup_1_1(), "rule__NullExpression__Group_1_1__0");
			builder.put(grammarAccess.getRealValueAccess().getGroup_0(), "rule__RealValue__Group_0__0");
			builder.put(grammarAccess.getLiteralUnboundedAccess().getGroup(), "rule__LiteralUnbounded__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getOwnedExpressionMemberAccess().getOwnedRelatedElementAssignment(), "rule__OwnedExpressionMember__OwnedRelatedElementAssignment");
			builder.put(grammarAccess.getExpressionBodyAccess().getOwnedRelationshipAssignment_1_0(), "rule__ExpressionBody__OwnedRelationshipAssignment_1_0");
			builder.put(grammarAccess.getExpressionBodyAccess().getOwnedRelationshipAssignment_2(), "rule__ExpressionBody__OwnedRelationshipAssignment_2");
			builder.put(grammarAccess.getResultExpressionMemberAccess().getOwnedRelatedElementAssignment(), "rule__ResultExpressionMember__OwnedRelatedElementAssignment");
			builder.put(grammarAccess.getBodyParameterMemberAccess().getMemberNameAssignment_1(), "rule__BodyParameterMember__MemberNameAssignment_1");
			builder.put(grammarAccess.getBodyParameterMemberAccess().getOwnedRelatedElementAssignment_2(), "rule__BodyParameterMember__OwnedRelatedElementAssignment_2");
			builder.put(grammarAccess.getConditionalExpressionAccess().getOperatorAssignment_1_1(), "rule__ConditionalExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getConditionalExpressionAccess().getOperandAssignment_1_2(), "rule__ConditionalExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getConditionalExpressionAccess().getOperandAssignment_1_4(), "rule__ConditionalExpression__OperandAssignment_1_4");
			builder.put(grammarAccess.getNullCoalescingExpressionAccess().getOperatorAssignment_1_1(), "rule__NullCoalescingExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getNullCoalescingExpressionAccess().getOperandAssignment_1_2(), "rule__NullCoalescingExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getConditionalOrExpressionAccess().getOperatorAssignment_1_1(), "rule__ConditionalOrExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getConditionalOrExpressionAccess().getOperandAssignment_1_2(), "rule__ConditionalOrExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getConditionalAndExpressionAccess().getOperatorAssignment_1_1(), "rule__ConditionalAndExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getConditionalAndExpressionAccess().getOperandAssignment_1_2(), "rule__ConditionalAndExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getOrExpressionAccess().getOperatorAssignment_1_1(), "rule__OrExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getOrExpressionAccess().getOperandAssignment_1_2(), "rule__OrExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getXorExpressionAccess().getOperatorAssignment_1_1(), "rule__XorExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getXorExpressionAccess().getOperandAssignment_1_2(), "rule__XorExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getAndExpressionAccess().getOperatorAssignment_1_1(), "rule__AndExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getAndExpressionAccess().getOperandAssignment_1_2(), "rule__AndExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getEqualityExpressionAccess().getOperatorAssignment_1_1(), "rule__EqualityExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getEqualityExpressionAccess().getOperandAssignment_1_2(), "rule__EqualityExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getClassificationExpressionAccess().getOperatorAssignment_0_1_1(), "rule__ClassificationExpression__OperatorAssignment_0_1_1");
			builder.put(grammarAccess.getClassificationExpressionAccess().getOwnedRelationshipAssignment_0_1_2(), "rule__ClassificationExpression__OwnedRelationshipAssignment_0_1_2");
			builder.put(grammarAccess.getClassificationExpressionAccess().getOperandAssignment_1_1(), "rule__ClassificationExpression__OperandAssignment_1_1");
			builder.put(grammarAccess.getClassificationExpressionAccess().getOperatorAssignment_1_2(), "rule__ClassificationExpression__OperatorAssignment_1_2");
			builder.put(grammarAccess.getClassificationExpressionAccess().getOwnedRelationshipAssignment_1_3(), "rule__ClassificationExpression__OwnedRelationshipAssignment_1_3");
			builder.put(grammarAccess.getTypeReferenceMemberAccess().getOwnedRelatedElementAssignment(), "rule__TypeReferenceMember__OwnedRelatedElementAssignment");
			builder.put(grammarAccess.getTypeReferenceAccess().getOwnedRelationshipAssignment(), "rule__TypeReference__OwnedRelationshipAssignment");
			builder.put(grammarAccess.getOwnedFeatureTypingAccess().getTypeAssignment(), "rule__OwnedFeatureTyping__TypeAssignment");
			builder.put(grammarAccess.getSelfReferenceExpressionAccess().getOwnedRelationshipAssignment(), "rule__SelfReferenceExpression__OwnedRelationshipAssignment");
			builder.put(grammarAccess.getSelfReferenceMemberAccess().getOwnedRelatedElementAssignment(), "rule__SelfReferenceMember__OwnedRelatedElementAssignment");
			builder.put(grammarAccess.getRelationalExpressionAccess().getOperatorAssignment_1_1(), "rule__RelationalExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getRelationalExpressionAccess().getOperandAssignment_1_2(), "rule__RelationalExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getRangeExpressionAccess().getOperatorAssignment_1_1(), "rule__RangeExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getRangeExpressionAccess().getOperandAssignment_1_2(), "rule__RangeExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getOperatorAssignment_1_1(), "rule__AdditiveExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getOperandAssignment_1_2(), "rule__AdditiveExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_1(), "rule__MultiplicativeExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getOperandAssignment_1_2(), "rule__MultiplicativeExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getExponentiationExpressionAccess().getOperatorAssignment_1_1(), "rule__ExponentiationExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getExponentiationExpressionAccess().getOperandAssignment_1_2(), "rule__ExponentiationExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getUnitsExpressionAccess().getOperatorAssignment_1_1(), "rule__UnitsExpression__OperatorAssignment_1_1");
			builder.put(grammarAccess.getUnitsExpressionAccess().getOperandAssignment_1_2(), "rule__UnitsExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getUnaryExpressionAccess().getOperatorAssignment_0_1(), "rule__UnaryExpression__OperatorAssignment_0_1");
			builder.put(grammarAccess.getUnaryExpressionAccess().getOperandAssignment_0_2(), "rule__UnaryExpression__OperandAssignment_0_2");
			builder.put(grammarAccess.getExtentExpressionAccess().getOperatorAssignment_0_1(), "rule__ExtentExpression__OperatorAssignment_0_1");
			builder.put(grammarAccess.getExtentExpressionAccess().getOwnedRelationshipAssignment_0_2(), "rule__ExtentExpression__OwnedRelationshipAssignment_0_2");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getOperatorAssignment_1_0_1(), "rule__PrimaryExpression__OperatorAssignment_1_0_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getOperandAssignment_1_0_2(), "rule__PrimaryExpression__OperandAssignment_1_0_2");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getOwnedRelationshipAssignment_1_1_2(), "rule__PrimaryExpression__OwnedRelationshipAssignment_1_1_2");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getOwnedRelationshipAssignment_1_1_3_0(), "rule__PrimaryExpression__OwnedRelationshipAssignment_1_1_3_0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getOwnedRelationshipAssignment_1_1_3_1(), "rule__PrimaryExpression__OwnedRelationshipAssignment_1_1_3_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getOperandAssignment_1_2_2(), "rule__PrimaryExpression__OperandAssignment_1_2_2");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getOwnedRelationshipAssignment_1_3_2(), "rule__PrimaryExpression__OwnedRelationshipAssignment_1_3_2");
			builder.put(grammarAccess.getExpressionBodyMemberAccess().getOwnedRelatedElementAssignment(), "rule__ExpressionBodyMember__OwnedRelatedElementAssignment");
			builder.put(grammarAccess.getFunctionReferenceMemberAccess().getOwnedRelatedElementAssignment(), "rule__FunctionReferenceMember__OwnedRelatedElementAssignment");
			builder.put(grammarAccess.getFunctionReferenceAccess().getOwnedRelationshipAssignment(), "rule__FunctionReference__OwnedRelationshipAssignment");
			builder.put(grammarAccess.getSequenceExpressionAccess().getOperatorAssignment_1_1_1(), "rule__SequenceExpression__OperatorAssignment_1_1_1");
			builder.put(grammarAccess.getSequenceExpressionAccess().getOperandAssignment_1_1_2(), "rule__SequenceExpression__OperandAssignment_1_1_2");
			builder.put(grammarAccess.getFeatureReferenceExpressionAccess().getOwnedRelationshipAssignment(), "rule__FeatureReferenceExpression__OwnedRelationshipAssignment");
			builder.put(grammarAccess.getFeatureReferenceMemberAccess().getMemberElementAssignment(), "rule__FeatureReferenceMember__MemberElementAssignment");
			builder.put(grammarAccess.getInvocationExpressionAccess().getOwnedRelationshipAssignment_0(), "rule__InvocationExpression__OwnedRelationshipAssignment_0");
			builder.put(grammarAccess.getPositionalArgumentListAccess().getOwnedRelationshipAssignment_0(), "rule__PositionalArgumentList__OwnedRelationshipAssignment_0");
			builder.put(grammarAccess.getPositionalArgumentListAccess().getOwnedRelationshipAssignment_1_1(), "rule__PositionalArgumentList__OwnedRelationshipAssignment_1_1");
			builder.put(grammarAccess.getNamedArgumentListAccess().getOwnedRelationshipAssignment_0(), "rule__NamedArgumentList__OwnedRelationshipAssignment_0");
			builder.put(grammarAccess.getNamedArgumentListAccess().getOwnedRelationshipAssignment_1_1(), "rule__NamedArgumentList__OwnedRelationshipAssignment_1_1");
			builder.put(grammarAccess.getNamedExpressionMemberAccess().getMemberNameAssignment_0(), "rule__NamedExpressionMember__MemberNameAssignment_0");
			builder.put(grammarAccess.getNamedExpressionMemberAccess().getOwnedRelatedElementAssignment_2(), "rule__NamedExpressionMember__OwnedRelatedElementAssignment_2");
			builder.put(grammarAccess.getLiteralBooleanAccess().getValueAssignment(), "rule__LiteralBoolean__ValueAssignment");
			builder.put(grammarAccess.getLiteralStringAccess().getValueAssignment(), "rule__LiteralString__ValueAssignment");
			builder.put(grammarAccess.getLiteralIntegerAccess().getValueAssignment(), "rule__LiteralInteger__ValueAssignment");
			builder.put(grammarAccess.getLiteralRealAccess().getValueAssignment(), "rule__LiteralReal__ValueAssignment");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private KerMLExpressionsGrammarAccess grammarAccess;

	@Override
	protected InternalKerMLExpressionsParser createParser() {
		InternalKerMLExpressionsParser result = new InternalKerMLExpressionsParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_NOTE", "RULE_SL_NOTE" };
	}

	public KerMLExpressionsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(KerMLExpressionsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
