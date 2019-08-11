/**
 */
package org.omg.sysml.lang.sysml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.omg.sysml.lang.sysml.AcceptAction;
import org.omg.sysml.lang.sysml.Activity;
import org.omg.sysml.lang.sysml.Annotation;
import org.omg.sysml.lang.sysml.Association;
import org.omg.sysml.lang.sysml.AtomicInteraction;
import org.omg.sysml.lang.sysml.Behavior;
import org.omg.sysml.lang.sysml.BindingConnector;
import org.omg.sysml.lang.sysml.Block;
import org.omg.sysml.lang.sysml.BlockExpression;
import org.omg.sysml.lang.sysml.CallAction;
import org.omg.sysml.lang.sysml.Classifier;
import org.omg.sysml.lang.sysml.Type;
import org.omg.sysml.lang.sysml.ValueProperty;
import org.omg.sysml.lang.sysml.ValueType;
import org.omg.sysml.lang.sysml.Comment;
import org.omg.sysml.lang.sysml.Connection;
import org.omg.sysml.lang.sysml.Connector;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.EndFeatureMembership;
import org.omg.sysml.lang.sysml.Expression;
import org.omg.sysml.lang.sysml.Feature;
import org.omg.sysml.lang.sysml.FeatureDirectionKind;
import org.omg.sysml.lang.sysml.FeatureMembership;
import org.omg.sysml.lang.sysml.FeatureReferenceExpression;
import org.omg.sysml.lang.sysml.FeatureTyping;
import org.omg.sysml.lang.sysml.FeatureValue;
import org.omg.sysml.lang.sysml.ForkAction;
import org.omg.sysml.lang.sysml.Function;
import org.omg.sysml.lang.sysml.Generalization;
import org.omg.sysml.lang.sysml.Import;
import org.omg.sysml.lang.sysml.InstanceCreationExpression;
import org.omg.sysml.lang.sysml.Interaction;
import org.omg.sysml.lang.sysml.InterfaceDefinition;
import org.omg.sysml.lang.sysml.InterfaceUsage;
import org.omg.sysml.lang.sysml.InvocationExpression;
import org.omg.sysml.lang.sysml.ItemFeature;
import org.omg.sysml.lang.sysml.ItemFlow;
import org.omg.sysml.lang.sysml.ItemFlowEnd;
import org.omg.sysml.lang.sysml.ItemFlowFeature;
import org.omg.sysml.lang.sysml.JoinAction;
import org.omg.sysml.lang.sysml.LiteralBoolean;
import org.omg.sysml.lang.sysml.LiteralExpression;
import org.omg.sysml.lang.sysml.LiteralInteger;
import org.omg.sysml.lang.sysml.LiteralReal;
import org.omg.sysml.lang.sysml.LiteralString;
import org.omg.sysml.lang.sysml.LiteralUnbounded;
import org.omg.sysml.lang.sysml.Membership;
import org.omg.sysml.lang.sysml.MergeAction;
import org.omg.sysml.lang.sysml.Multiplicity;
import org.omg.sysml.lang.sysml.NullExpression;
import org.omg.sysml.lang.sysml.OfSuccession;
import org.omg.sysml.lang.sysml.OperatorExpression;
import org.omg.sysml.lang.sysml.OrderedFeature;
import org.omg.sysml.lang.sysml.Ownership;
import org.omg.sysml.lang.sysml.Parameter;
import org.omg.sysml.lang.sysml.ParameterMembership;
import org.omg.sysml.lang.sysml.PartProperty;
import org.omg.sysml.lang.sysml.PerformAction;
import org.omg.sysml.lang.sysml.PortDefinition;
import org.omg.sysml.lang.sysml.PortUsage;
import org.omg.sysml.lang.sysml.Predicate;
import org.omg.sysml.lang.sysml.QueryPathExpression;
import org.omg.sysml.lang.sysml.QueryPathStepExpression;
import org.omg.sysml.lang.sysml.QueryQualifierExpression;
import org.omg.sysml.lang.sysml.Redefinition;
import org.omg.sysml.lang.sysml.ReferenceProperty;
import org.omg.sysml.lang.sysml.Relationship;
import org.omg.sysml.lang.sysml.ReturnParameterMembership;
import org.omg.sysml.lang.sysml.SendAction;
import org.omg.sysml.lang.sysml.SequenceConstructionExpression;
import org.omg.sysml.lang.sysml.SourceEnd;
import org.omg.sysml.lang.sysml.Step;
import org.omg.sysml.lang.sysml.StructuredFeature;
import org.omg.sysml.lang.sysml.Subsetting;
import org.omg.sysml.lang.sysml.Succession;
import org.omg.sysml.lang.sysml.SuccessionItemFlow;
import org.omg.sysml.lang.sysml.Superclassing;
import org.omg.sysml.lang.sysml.SysMLFactory;
import org.omg.sysml.lang.sysml.SysMLPackage;
import org.omg.sysml.lang.sysml.TargetEnd;
import org.omg.sysml.lang.sysml.DataType;
import org.omg.sysml.lang.sysml.DecisionAction;
import org.omg.sysml.lang.sysml.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SysMLFactoryImpl extends EFactoryImpl implements SysMLFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SysMLFactory init() {
		try {
			SysMLFactory theSysMLFactory = (SysMLFactory)EPackage.Registry.INSTANCE.getEFactory(SysMLPackage.eNS_URI);
			if (theSysMLFactory != null) {
				return theSysMLFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SysMLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SysMLFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SysMLPackage.QUERY_QUALIFIER_EXPRESSION: return createQueryQualifierExpression();
			case SysMLPackage.OPERATOR_EXPRESSION: return createOperatorExpression();
			case SysMLPackage.INVOCATION_EXPRESSION: return createInvocationExpression();
			case SysMLPackage.EXPRESSION: return createExpression();
			case SysMLPackage.STEP: return createStep();
			case SysMLPackage.FEATURE: return createFeature();
			case SysMLPackage.TYPE: return createType();
			case SysMLPackage.PACKAGE: return createPackage();
			case SysMLPackage.ELEMENT: return createElement();
			case SysMLPackage.MEMBERSHIP: return createMembership();
			case SysMLPackage.RELATIONSHIP: return createRelationship();
			case SysMLPackage.IMPORT: return createImport();
			case SysMLPackage.PREDICATE: return createPredicate();
			case SysMLPackage.FUNCTION: return createFunction();
			case SysMLPackage.BEHAVIOR: return createBehavior();
			case SysMLPackage.CLASSIFIER: return createClassifier();
			case SysMLPackage.SUPERCLASSING: return createSuperclassing();
			case SysMLPackage.GENERALIZATION: return createGeneralization();
			case SysMLPackage.PARAMETER: return createParameter();
			case SysMLPackage.FEATURE_MEMBERSHIP: return createFeatureMembership();
			case SysMLPackage.REDEFINITION: return createRedefinition();
			case SysMLPackage.SUBSETTING: return createSubsetting();
			case SysMLPackage.FEATURE_VALUE: return createFeatureValue();
			case SysMLPackage.MULTIPLICITY: return createMultiplicity();
			case SysMLPackage.FEATURE_TYPING: return createFeatureTyping();
			case SysMLPackage.QUERY_PATH_EXPRESSION: return createQueryPathExpression();
			case SysMLPackage.FEATURE_REFERENCE_EXPRESSION: return createFeatureReferenceExpression();
			case SysMLPackage.QUERY_PATH_STEP_EXPRESSION: return createQueryPathStepExpression();
			case SysMLPackage.INSTANCE_CREATION_EXPRESSION: return createInstanceCreationExpression();
			case SysMLPackage.SEQUENCE_CONSTRUCTION_EXPRESSION: return createSequenceConstructionExpression();
			case SysMLPackage.BLOCK_EXPRESSION: return createBlockExpression();
			case SysMLPackage.LITERAL_UNBOUNDED: return createLiteralUnbounded();
			case SysMLPackage.LITERAL_EXPRESSION: return createLiteralExpression();
			case SysMLPackage.LITERAL_INTEGER: return createLiteralInteger();
			case SysMLPackage.LITERAL_STRING: return createLiteralString();
			case SysMLPackage.LITERAL_REAL: return createLiteralReal();
			case SysMLPackage.NULL_EXPRESSION: return createNullExpression();
			case SysMLPackage.LITERAL_BOOLEAN: return createLiteralBoolean();
			case SysMLPackage.CONNECTOR: return createConnector();
			case SysMLPackage.ASSOCIATION: return createAssociation();
			case SysMLPackage.CLASS: return createClass();
			case SysMLPackage.BINDING_CONNECTOR: return createBindingConnector();
			case SysMLPackage.ITEM_FEATURE: return createItemFeature();
			case SysMLPackage.ITEM_FLOW_FEATURE: return createItemFlowFeature();
			case SysMLPackage.ATOMIC_INTERACTION: return createAtomicInteraction();
			case SysMLPackage.ITEM_FLOW_END: return createItemFlowEnd();
			case SysMLPackage.INTERACTION: return createInteraction();
			case SysMLPackage.SUCCESSION_ITEM_FLOW: return createSuccessionItemFlow();
			case SysMLPackage.SUCCESSION: return createSuccession();
			case SysMLPackage.ITEM_FLOW: return createItemFlow();
			case SysMLPackage.TARGET_END: return createTargetEnd();
			case SysMLPackage.PARAMETER_MEMBERSHIP: return createParameterMembership();
			case SysMLPackage.SOURCE_END: return createSourceEnd();
			case SysMLPackage.RETURN_PARAMETER_MEMBERSHIP: return createReturnParameterMembership();
			case SysMLPackage.STRUCTURED_FEATURE: return createStructuredFeature();
			case SysMLPackage.ORDERED_FEATURE: return createOrderedFeature();
			case SysMLPackage.OF_SUCCESSION: return createOfSuccession();
			case SysMLPackage.DATA_TYPE: return createDataType();
			case SysMLPackage.PORT_USAGE: return createPortUsage();
			case SysMLPackage.PORT_DEFINITION: return createPortDefinition();
			case SysMLPackage.ACTIVITY: return createActivity();
			case SysMLPackage.MERGE_ACTION: return createMergeAction();
			case SysMLPackage.PERFORM_ACTION: return createPerformAction();
			case SysMLPackage.ACCEPT_ACTION: return createAcceptAction();
			case SysMLPackage.FORK_ACTION: return createForkAction();
			case SysMLPackage.JOIN_ACTION: return createJoinAction();
			case SysMLPackage.CALL_ACTION: return createCallAction();
			case SysMLPackage.DECISION_ACTION: return createDecisionAction();
			case SysMLPackage.SEND_ACTION: return createSendAction();
			case SysMLPackage.VALUE_TYPE: return createValueType();
			case SysMLPackage.CONNECTION: return createConnection();
			case SysMLPackage.INTERFACE_USAGE: return createInterfaceUsage();
			case SysMLPackage.INTERFACE_DEFINITION: return createInterfaceDefinition();
			case SysMLPackage.BLOCK: return createBlock();
			case SysMLPackage.REFERENCE_PROPERTY: return createReferenceProperty();
			case SysMLPackage.PART_PROPERTY: return createPartProperty();
			case SysMLPackage.VALUE_PROPERTY: return createValueProperty();
			case SysMLPackage.END_FEATURE_MEMBERSHIP: return createEndFeatureMembership();
			case SysMLPackage.OWNERSHIP: return createOwnership();
			case SysMLPackage.ANNOTATION: return createAnnotation();
			case SysMLPackage.COMMENT: return createComment();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SysMLPackage.VISIBILITY_KIND:
				return createVisibilityKindFromString(eDataType, initialValue);
			case SysMLPackage.FEATURE_DIRECTION_KIND:
				return createFeatureDirectionKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SysMLPackage.VISIBILITY_KIND:
				return convertVisibilityKindToString(eDataType, instanceValue);
			case SysMLPackage.FEATURE_DIRECTION_KIND:
				return convertFeatureDirectionKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EndFeatureMembership createEndFeatureMembership() {
		EndFeatureMembershipImpl endFeatureMembership = new EndFeatureMembershipImpl();
		return endFeatureMembership;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureMembership createFeatureMembership() {
		FeatureMembershipImpl featureMembership = new FeatureMembershipImpl();
		return featureMembership;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Membership createMembership() {
		MembershipImpl membership = new MembershipImpl();
		return membership;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relationship createRelationship() {
		RelationshipImpl relationship = new RelationshipImpl();
		return relationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Element createElement() {
		ElementImpl element = new ElementImpl();
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.omg.sysml.lang.sysml.Package createPackage() {
		PackageImpl package_ = new PackageImpl();
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Import createImport() {
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Predicate createPredicate() {
		PredicateImpl predicate = new PredicateImpl();
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Behavior createBehavior() {
		BehaviorImpl behavior = new BehaviorImpl();
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Classifier createClassifier() {
		ClassifierImpl classifier = new ClassifierImpl();
		return classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type createType() {
		TypeImpl type = new TypeImpl();
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Generalization createGeneralization() {
		GeneralizationImpl generalization = new GeneralizationImpl();
		return generalization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Feature createFeature() {
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Redefinition createRedefinition() {
		RedefinitionImpl redefinition = new RedefinitionImpl();
		return redefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Subsetting createSubsetting() {
		SubsettingImpl subsetting = new SubsettingImpl();
		return subsetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureValue createFeatureValue() {
		FeatureValueImpl featureValue = new FeatureValueImpl();
		return featureValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Step createStep() {
		StepImpl step = new StepImpl();
		return step;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Multiplicity createMultiplicity() {
		MultiplicityImpl multiplicity = new MultiplicityImpl();
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureTyping createFeatureTyping() {
		FeatureTypingImpl featureTyping = new FeatureTypingImpl();
		return featureTyping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Superclassing createSuperclassing() {
		SuperclassingImpl superclassing = new SuperclassingImpl();
		return superclassing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Association createAssociation() {
		AssociationImpl association = new AssociationImpl();
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Connector createConnector() {
		ConnectorImpl connector = new ConnectorImpl();
		return connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType createDataType() {
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortUsage createPortUsage() {
		PortUsageImpl portUsage = new PortUsageImpl();
		return portUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortDefinition createPortDefinition() {
		PortDefinitionImpl portDefinition = new PortDefinitionImpl();
		return portDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Activity createActivity() {
		ActivityImpl activity = new ActivityImpl();
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MergeAction createMergeAction() {
		MergeActionImpl mergeAction = new MergeActionImpl();
		return mergeAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PerformAction createPerformAction() {
		PerformActionImpl performAction = new PerformActionImpl();
		return performAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AcceptAction createAcceptAction() {
		AcceptActionImpl acceptAction = new AcceptActionImpl();
		return acceptAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForkAction createForkAction() {
		ForkActionImpl forkAction = new ForkActionImpl();
		return forkAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JoinAction createJoinAction() {
		JoinActionImpl joinAction = new JoinActionImpl();
		return joinAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CallAction createCallAction() {
		CallActionImpl callAction = new CallActionImpl();
		return callAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DecisionAction createDecisionAction() {
		DecisionActionImpl decisionAction = new DecisionActionImpl();
		return decisionAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SendAction createSendAction() {
		SendActionImpl sendAction = new SendActionImpl();
		return sendAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueType createValueType() {
		ValueTypeImpl valueType = new ValueTypeImpl();
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Connection createConnection() {
		ConnectionImpl connection = new ConnectionImpl();
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InterfaceUsage createInterfaceUsage() {
		InterfaceUsageImpl interfaceUsage = new InterfaceUsageImpl();
		return interfaceUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InterfaceDefinition createInterfaceDefinition() {
		InterfaceDefinitionImpl interfaceDefinition = new InterfaceDefinitionImpl();
		return interfaceDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReferenceProperty createReferenceProperty() {
		ReferencePropertyImpl referenceProperty = new ReferencePropertyImpl();
		return referenceProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PartProperty createPartProperty() {
		PartPropertyImpl partProperty = new PartPropertyImpl();
		return partProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueProperty createValueProperty() {
		ValuePropertyImpl valueProperty = new ValuePropertyImpl();
		return valueProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.omg.sysml.lang.sysml.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OfSuccession createOfSuccession() {
		OfSuccessionImpl ofSuccession = new OfSuccessionImpl();
		return ofSuccession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OrderedFeature createOrderedFeature() {
		OrderedFeatureImpl orderedFeature = new OrderedFeatureImpl();
		return orderedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructuredFeature createStructuredFeature() {
		StructuredFeatureImpl structuredFeature = new StructuredFeatureImpl();
		return structuredFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BindingConnector createBindingConnector() {
		BindingConnectorImpl bindingConnector = new BindingConnectorImpl();
		return bindingConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Succession createSuccession() {
		SuccessionImpl succession = new SuccessionImpl();
		return succession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Comment createComment() {
		CommentImpl comment = new CommentImpl();
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AtomicInteraction createAtomicInteraction() {
		AtomicInteractionImpl atomicInteraction = new AtomicInteractionImpl();
		return atomicInteraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Interaction createInteraction() {
		InteractionImpl interaction = new InteractionImpl();
		return interaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Ownership createOwnership() {
		OwnershipImpl ownership = new OwnershipImpl();
		return ownership;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralBoolean createLiteralBoolean() {
		LiteralBooleanImpl literalBoolean = new LiteralBooleanImpl();
		return literalBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InvocationExpression createInvocationExpression() {
		InvocationExpressionImpl invocationExpression = new InvocationExpressionImpl();
		return invocationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BlockExpression createBlockExpression() {
		BlockExpressionImpl blockExpression = new BlockExpressionImpl();
		return blockExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterMembership createParameterMembership() {
		ParameterMembershipImpl parameterMembership = new ParameterMembershipImpl();
		return parameterMembership;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReturnParameterMembership createReturnParameterMembership() {
		ReturnParameterMembershipImpl returnParameterMembership = new ReturnParameterMembershipImpl();
		return returnParameterMembership;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QueryPathStepExpression createQueryPathStepExpression() {
		QueryPathStepExpressionImpl queryPathStepExpression = new QueryPathStepExpressionImpl();
		return queryPathStepExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QueryQualifierExpression createQueryQualifierExpression() {
		QueryQualifierExpressionImpl queryQualifierExpression = new QueryQualifierExpressionImpl();
		return queryQualifierExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QueryPathExpression createQueryPathExpression() {
		QueryPathExpressionImpl queryPathExpression = new QueryPathExpressionImpl();
		return queryPathExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralExpression createLiteralExpression() {
		LiteralExpressionImpl literalExpression = new LiteralExpressionImpl();
		return literalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralReal createLiteralReal() {
		LiteralRealImpl literalReal = new LiteralRealImpl();
		return literalReal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralUnbounded createLiteralUnbounded() {
		LiteralUnboundedImpl literalUnbounded = new LiteralUnboundedImpl();
		return literalUnbounded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralInteger createLiteralInteger() {
		LiteralIntegerImpl literalInteger = new LiteralIntegerImpl();
		return literalInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ItemFlowEnd createItemFlowEnd() {
		ItemFlowEndImpl itemFlowEnd = new ItemFlowEndImpl();
		return itemFlowEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ItemFlowFeature createItemFlowFeature() {
		ItemFlowFeatureImpl itemFlowFeature = new ItemFlowFeatureImpl();
		return itemFlowFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ItemFeature createItemFeature() {
		ItemFeatureImpl itemFeature = new ItemFeatureImpl();
		return itemFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceEnd createSourceEnd() {
		SourceEndImpl sourceEnd = new SourceEndImpl();
		return sourceEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetEnd createTargetEnd() {
		TargetEndImpl targetEnd = new TargetEndImpl();
		return targetEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperatorExpression createOperatorExpression() {
		OperatorExpressionImpl operatorExpression = new OperatorExpressionImpl();
		return operatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralString createLiteralString() {
		LiteralStringImpl literalString = new LiteralStringImpl();
		return literalString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ItemFlow createItemFlow() {
		ItemFlowImpl itemFlow = new ItemFlowImpl();
		return itemFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SuccessionItemFlow createSuccessionItemFlow() {
		SuccessionItemFlowImpl successionItemFlow = new SuccessionItemFlowImpl();
		return successionItemFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstanceCreationExpression createInstanceCreationExpression() {
		InstanceCreationExpressionImpl instanceCreationExpression = new InstanceCreationExpressionImpl();
		return instanceCreationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NullExpression createNullExpression() {
		NullExpressionImpl nullExpression = new NullExpressionImpl();
		return nullExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SequenceConstructionExpression createSequenceConstructionExpression() {
		SequenceConstructionExpressionImpl sequenceConstructionExpression = new SequenceConstructionExpressionImpl();
		return sequenceConstructionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureReferenceExpression createFeatureReferenceExpression() {
		FeatureReferenceExpressionImpl featureReferenceExpression = new FeatureReferenceExpressionImpl();
		return featureReferenceExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisibilityKind createVisibilityKindFromString(EDataType eDataType, String initialValue) {
		VisibilityKind result = VisibilityKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVisibilityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureDirectionKind createFeatureDirectionKindFromString(EDataType eDataType, String initialValue) {
		FeatureDirectionKind result = FeatureDirectionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeatureDirectionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SysMLPackage getSysMLPackage() {
		return (SysMLPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SysMLPackage getPackage() {
		return SysMLPackage.eINSTANCE;
	}

} //SysMLFactoryImpl
