/**
 */
package org.omg.sysml.lang.sysml.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectContainmentWithInverseEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.common.util.UnionEObjectEList;
import org.omg.sysml.lang.sysml.Type;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.Import;
import org.omg.sysml.lang.sysml.Membership;
import org.omg.sysml.lang.sysml.Predicate;
import org.omg.sysml.lang.sysml.SysMLPackage;
import org.omg.sysml.lang.sysml.VisibilityKind;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Import</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.omg.sysml.lang.sysml.impl.ImportImpl#getTarget
 * <em>Target</em>}</li>
 * <li>{@link org.omg.sysml.lang.sysml.impl.ImportImpl#getOwnedRelatedElement
 * <em>Owned Related Element</em>}</li>
 * <li>{@link org.omg.sysml.lang.sysml.impl.ImportImpl#getOwningRelatedElement
 * <em>Owning Related Element</em>}</li>
 * <li>{@link org.omg.sysml.lang.sysml.impl.ImportImpl#getImportedPackage
 * <em>Imported Package</em>}</li>
 * <li>{@link org.omg.sysml.lang.sysml.impl.ImportImpl#getSelecter
 * <em>Selecter</em>}</li>
 * <li>{@link org.omg.sysml.lang.sysml.impl.ImportImpl#getVisibility
 * <em>Visibility</em>}</li>
 * <li>{@link org.omg.sysml.lang.sysml.impl.ImportImpl#getImportOwningPackage
 * <em>Import Owning Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportImpl extends RelationshipImpl implements Import {
	/**
	 * The cached value of the '{@link #getImportedPackage() <em>Imported
	 * Package</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getImportedPackage()
	 * @generated
	 * @ordered
	 */
	protected org.omg.sysml.lang.sysml.Package importedPackage;

	/**
	 * The cached value of the '{@link #getSelecter() <em>Selecter</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSelecter()
	 * @generated
	 * @ordered
	 */
	protected Predicate selecter;

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final VisibilityKind VISIBILITY_EDEFAULT = VisibilityKind.PUBLIC;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected VisibilityKind visibility = VISIBILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImportOwningPackage() <em>Import Owning
	 * Package</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getImportOwningPackage()
	 * @generated
	 * @ordered
	 */
	protected org.omg.sysml.lang.sysml.Package importOwningPackage;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ImportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SysMLPackage.Literals.IMPORT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public org.omg.sysml.lang.sysml.Package getImportedPackage() {
		if (importedPackage != null && importedPackage.eIsProxy()) {
			InternalEObject oldImportedPackage = (InternalEObject) importedPackage;
			importedPackage = (org.omg.sysml.lang.sysml.Package) eResolveProxy(oldImportedPackage);
			if (importedPackage != oldImportedPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SysMLPackage.IMPORT__IMPORTED_PACKAGE,
							oldImportedPackage, importedPackage));
			}
		}
		return importedPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.omg.sysml.lang.sysml.Package basicGetImportedPackage() {
		return importedPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setImportedPackage(org.omg.sysml.lang.sysml.Package newImportedPackage) {
		org.omg.sysml.lang.sysml.Package oldImportedPackage = importedPackage;
		importedPackage = newImportedPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SysMLPackage.IMPORT__IMPORTED_PACKAGE,
					oldImportedPackage, importedPackage));
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newImportedPackage != null) {
				EList<Element> target = getTarget();
				if (!target.contains(newImportedPackage)) {
					target.add(newImportedPackage);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Predicate getSelecter() {
		if (selecter != null && selecter.eIsProxy()) {
			InternalEObject oldSelecter = (InternalEObject) selecter;
			selecter = (Predicate) eResolveProxy(oldSelecter);
			if (selecter != oldSelecter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SysMLPackage.IMPORT__SELECTER,
							oldSelecter, selecter));
			}
		}
		return selecter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT // TODO check, not derived
	 */
	public Predicate basicGetSelecter() {
		return getFirstOwnedRelatedElement(Predicate.class);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT // TODO check, not derived
	 */
	@Override
	public void setSelecter(Predicate newSelecter) {
		// TODO: implement this method to set the 'Selecter' reference
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public VisibilityKind getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setVisibility(VisibilityKind newVisibility) {
		VisibilityKind oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SysMLPackage.IMPORT__VISIBILITY, oldVisibility,
					visibility));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public org.omg.sysml.lang.sysml.Package getImportOwningPackage() {
		if (importOwningPackage != null && importOwningPackage.eIsProxy()) {
			InternalEObject oldImportOwningPackage = (InternalEObject) importOwningPackage;
			importOwningPackage = (org.omg.sysml.lang.sysml.Package) eResolveProxy(oldImportOwningPackage);
			if (importOwningPackage != oldImportOwningPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							SysMLPackage.IMPORT__IMPORT_OWNING_PACKAGE, oldImportOwningPackage, importOwningPackage));
			}
		}
		return importOwningPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT // TODO check, not derived
	 */
	public org.omg.sysml.lang.sysml.Package basicGetImportOwningPackage() {
		return getOwningRelatedElement(org.omg.sysml.lang.sysml.Package.class);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetImportOwningPackage(org.omg.sysml.lang.sysml.Package newImportOwningPackage,
			NotificationChain msgs) {
		org.omg.sysml.lang.sysml.Package oldImportOwningPackage = importOwningPackage;
		importOwningPackage = newImportOwningPackage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					SysMLPackage.IMPORT__IMPORT_OWNING_PACKAGE, oldImportOwningPackage, newImportOwningPackage);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newImportOwningPackage != null) {
				Element owningRelatedElement = getOwningRelatedElement();
				if (newImportOwningPackage != owningRelatedElement) {
					setOwningRelatedElement(newImportOwningPackage);
				}
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT // TODO check, not derived
	 */
	@Override
	public void setImportOwningPackage(org.omg.sysml.lang.sysml.Package newImportOwningPackage) {
		// TODO: implement this method to set the 'Import Owning Package' reference
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetImportOwningPackage() {
		return importOwningPackage != null;
	}

	// Operations

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT // EOperation
	 */
	public EList<Membership> importedMembership() {
		return this.importMembership(new BasicInternalEList<Membership>(Membership.class), null,
				new HashSet<org.omg.sysml.lang.sysml.Package>(), new HashSet<Type>());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SysMLPackage.IMPORT__OWNED_RELATED_ELEMENT:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedRelatedElement()).basicAdd(otherEnd,
					msgs);
		case SysMLPackage.IMPORT__OWNING_RELATED_ELEMENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetOwningRelatedElement((Element) otherEnd, msgs);
		case SysMLPackage.IMPORT__IMPORT_OWNING_PACKAGE:
			if (importOwningPackage != null)
				msgs = ((InternalEObject) importOwningPackage).eInverseRemove(this,
						SysMLPackage.PACKAGE__OWNED_IMPORT_COMP, org.omg.sysml.lang.sysml.Package.class, msgs);
			return basicSetImportOwningPackage((org.omg.sysml.lang.sysml.Package) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SysMLPackage.IMPORT__OWNED_RELATED_ELEMENT:
			return ((InternalEList<?>) getOwnedRelatedElement()).basicRemove(otherEnd, msgs);
		case SysMLPackage.IMPORT__OWNING_RELATED_ELEMENT:
			return basicSetOwningRelatedElement(null, msgs);
		case SysMLPackage.IMPORT__IMPORT_OWNING_PACKAGE:
			return basicSetImportOwningPackage(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case SysMLPackage.IMPORT__OWNING_RELATED_ELEMENT:
			return eInternalContainer().eInverseRemove(this, SysMLPackage.ELEMENT__OWNED_RELATIONSHIP, Element.class,
					msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	// Note: The excludedCategories parameter is needed in case the imported Package
	// is a Type that has one or more Generalizations.
	public EList<Membership> importMembership(EList<Membership> importedMembership,
			Collection<Membership> nonpublicMembership, Collection<org.omg.sysml.lang.sysml.Package> excludedPackages,
			Collection<Type> excludedTypes) {
		// TODO Implement predicate-based selection of importMembership.
		org.omg.sysml.lang.sysml.Package importedPackage = this.getImportedPackage();
		if (importedPackage != null && !excludedPackages.contains(importedPackage)) {
			org.omg.sysml.lang.sysml.Package owningPackage = this.getImportOwningPackage();
			excludedPackages.add(owningPackage);
			EList<Membership> packageMembership = ((PackageImpl) importedPackage).getPublicMembership(excludedPackages,
					excludedTypes);
			importedMembership.addAll(packageMembership);
			if (nonpublicMembership != null && !VisibilityKind.PUBLIC.equals(this.getVisibility())) {
				nonpublicMembership.addAll(packageMembership);
			}
			excludedPackages.remove(owningPackage);
		}
		return importedMembership;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SysMLPackage.IMPORT__IMPORTED_PACKAGE:
			if (resolve)
				return getImportedPackage();
			return basicGetImportedPackage();
		case SysMLPackage.IMPORT__SELECTER:
			if (resolve)
				return getSelecter();
			return basicGetSelecter();
		case SysMLPackage.IMPORT__VISIBILITY:
			return getVisibility();
		case SysMLPackage.IMPORT__IMPORT_OWNING_PACKAGE:
			if (resolve)
				return getImportOwningPackage();
			return basicGetImportOwningPackage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SysMLPackage.IMPORT__IMPORTED_PACKAGE:
			setImportedPackage((org.omg.sysml.lang.sysml.Package) newValue);
			return;
		case SysMLPackage.IMPORT__SELECTER:
			setSelecter((Predicate) newValue);
			return;
		case SysMLPackage.IMPORT__VISIBILITY:
			setVisibility((VisibilityKind) newValue);
			return;
		case SysMLPackage.IMPORT__IMPORT_OWNING_PACKAGE:
			setImportOwningPackage((org.omg.sysml.lang.sysml.Package) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SysMLPackage.IMPORT__IMPORTED_PACKAGE:
			setImportedPackage((org.omg.sysml.lang.sysml.Package) null);
			return;
		case SysMLPackage.IMPORT__SELECTER:
			setSelecter((Predicate) null);
			return;
		case SysMLPackage.IMPORT__VISIBILITY:
			setVisibility(VISIBILITY_EDEFAULT);
			return;
		case SysMLPackage.IMPORT__IMPORT_OWNING_PACKAGE:
			setImportOwningPackage((org.omg.sysml.lang.sysml.Package) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SysMLPackage.IMPORT__TARGET:
			return target != null && !target.isEmpty();
		case SysMLPackage.IMPORT__OWNED_RELATED_ELEMENT:
			return ownedRelatedElement != null && !ownedRelatedElement.isEmpty();
		case SysMLPackage.IMPORT__OWNING_RELATED_ELEMENT:
			return getOwningRelatedElement() != null;
		case SysMLPackage.IMPORT__SOURCE:
			return isSetSource();
		case SysMLPackage.IMPORT__IMPORTED_PACKAGE:
			return importedPackage != null;
		case SysMLPackage.IMPORT__SELECTER:
			return selecter != null;
		case SysMLPackage.IMPORT__VISIBILITY:
			return visibility != VISIBILITY_EDEFAULT;
		case SysMLPackage.IMPORT__IMPORT_OWNING_PACKAGE:
			return isSetImportOwningPackage();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case SysMLPackage.IMPORT___IMPORTED_MEMBERSHIP:
			return importedMembership();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (visibility: ");
		result.append(visibility);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT // TODO check, not derived, inherited from Relationship
	 */
	@Override
	public EList<Element> getTarget() {
		EList<Element> target = new EObjectResolvingEList<Element>(Element.class, this, SysMLPackage.IMPORT__TARGET);
		// NOTE: The "importedPackage" object must not be resolved here, in order to
		// avoid Xtext lazy linking errors.
		Element importedPackage = basicGetImportedPackage();
		if (importedPackage != null) {
			target.add(importedPackage);
		}
		return target;
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getTarget()
	 * <em>Target</em>}' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected static final int[] TARGET_ESUBSETS = new int[] { SysMLPackage.IMPORT__IMPORTED_PACKAGE,
			SysMLPackage.IMPORT__SELECTER };

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Element> getOwnedRelatedElement() {
		if (ownedRelatedElement == null) {
			ownedRelatedElement = new SubsetSupersetEObjectContainmentWithInverseEList<Element>(Element.class, this,
					SysMLPackage.IMPORT__OWNED_RELATED_ELEMENT, null, OWNED_RELATED_ELEMENT_ESUBSETS,
					SysMLPackage.ELEMENT__OWNING_RELATIONSHIP);
		}
		return ownedRelatedElement;
	}

	/**
	 * The array of subset feature identifiers for the
	 * '{@link #getOwnedRelatedElement() <em>Owned Related Element</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOwnedRelatedElement()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_RELATED_ELEMENT_ESUBSETS = new int[] { SysMLPackage.IMPORT__SELECTER };

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Element getOwningRelatedElement() {
		if (eContainerFeatureID() != SysMLPackage.IMPORT__OWNING_RELATED_ELEMENT)
			return null;
		return (Element) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetOwningRelatedElement(Element newOwningRelatedElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newOwningRelatedElement,
				SysMLPackage.IMPORT__OWNING_RELATED_ELEMENT, msgs);
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (importOwningPackage != null && importOwningPackage != newOwningRelatedElement) {
				setImportOwningPackage(null);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setOwningRelatedElement(Element newOwningRelatedElement) {
		if (newOwningRelatedElement != eInternalContainer()
				|| (eContainerFeatureID() != SysMLPackage.IMPORT__OWNING_RELATED_ELEMENT
						&& newOwningRelatedElement != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRelatedElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRelatedElement != null)
				msgs = ((InternalEObject) newOwningRelatedElement).eInverseAdd(this,
						SysMLPackage.ELEMENT__OWNED_RELATIONSHIP, Element.class, msgs);
			msgs = basicSetOwningRelatedElement(newOwningRelatedElement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SysMLPackage.IMPORT__OWNING_RELATED_ELEMENT,
					newOwningRelatedElement, newOwningRelatedElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Element> getSource() {
		EList<Element> source = new UniqueEList<Element>();
		org.omg.sysml.lang.sysml.Package importOwningPackage = getImportOwningPackage();
		if (importOwningPackage != null) {
			source.add(importOwningPackage);
		}
		return new UnionEObjectEList<Element>(this, SysMLPackage.Literals.RELATIONSHIP__SOURCE, source.size(),
				source.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetSource() {
		return false;
	}

} // ImportImpl
