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

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.omg.sysml.lang.sysml.Type;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.Import;
import org.omg.sysml.lang.sysml.Membership;
import org.omg.sysml.lang.sysml.Namespace;
import org.omg.sysml.lang.sysml.Relationship;
import org.omg.sysml.lang.sysml.SysMLPackage;
import org.omg.sysml.lang.sysml.VisibilityKind;
import org.omg.sysml.lang.sysml.util.SysMLLibraryUtil;
import org.omg.sysml.util.ElementUtil;
import org.omg.sysml.util.NamespaceUtil;
import org.omg.sysml.util.NonNotifyingEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Namespace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.NamespaceImpl#getMembership <em>Membership</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.NamespaceImpl#getOwnedRelationship <em>Owned Relationship</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.NamespaceImpl#getOwnedMembership <em>Owned Membership</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.NamespaceImpl#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.NamespaceImpl#getOwnedImport <em>Owned Import</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.NamespaceImpl#getMember <em>Member</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.NamespaceImpl#getImportedMembership <em>Imported Membership</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamespaceImpl extends ElementImpl implements Namespace {
	/**
	 * The cached setting delegate for the '{@link #getOwnedMembership() <em>Owned Membership</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembership()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate OWNED_MEMBERSHIP__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SysMLPackage.Literals.NAMESPACE__OWNED_MEMBERSHIP).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getOwnedMember() <em>Owned Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMember()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate OWNED_MEMBER__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SysMLPackage.Literals.NAMESPACE__OWNED_MEMBER).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getOwnedImport() <em>Owned Import</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedImport()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate OWNED_IMPORT__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SysMLPackage.Literals.NAMESPACE__OWNED_IMPORT).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getMember() <em>Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate MEMBER__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SysMLPackage.Literals.NAMESPACE__MEMBER).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getImportedMembership() <em>Imported Membership</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedMembership()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate IMPORTED_MEMBERSHIP__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SysMLPackage.Literals.NAMESPACE__IMPORTED_MEMBERSHIP).getSettingDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamespaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SysMLPackage.Literals.NAMESPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Membership> getMembership() {
		return new DerivedUnionEObjectEList<Membership>(Membership.class, this, SysMLPackage.NAMESPACE__MEMBERSHIP, MEMBERSHIP_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getMembership() <em>Membership</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembership()
	 * @generated
	 * @ordered
	 */
	protected static final int[] MEMBERSHIP_ESUBSETS = new int[] {SysMLPackage.NAMESPACE__OWNED_MEMBERSHIP, SysMLPackage.NAMESPACE__IMPORTED_MEMBERSHIP};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Relationship> getOwnedRelationship() {
		if (ownedRelationship == null) {
			ownedRelationship = new EObjectContainmentWithInverseEList<Relationship>(Relationship.class, this, SysMLPackage.NAMESPACE__OWNED_RELATIONSHIP, SysMLPackage.RELATIONSHIP__OWNING_RELATED_ELEMENT);
		}
		return ownedRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public EList<Element> getMember() {
		return (EList<Element>)MEMBER__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Import> getOwnedImport() {
		return (EList<Import>)OWNED_IMPORT__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Element> getOwnedMember() {
		return (EList<Element>)OWNED_MEMBER__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public EList<Membership> getImportedMembership() {
		return (EList<Membership>)IMPORTED_MEMBERSHIP__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Membership> getOwnedMembership() {
		return (EList<Membership>)OWNED_MEMBERSHIP__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMembership() {
		return eIsSet(SysMLPackage.NAMESPACE__OWNED_MEMBERSHIP)
			|| eIsSet(SysMLPackage.NAMESPACE__IMPORTED_MEMBERSHIP);
	}

	/**
	 * The array of superset feature identifiers for the '{@link #getOwnedMembership() <em>Owned Membership</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembership()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_MEMBERSHIP_ESUPERSETS = new int[] {SysMLPackage.NAMESPACE__OWNED_RELATIONSHIP};

	/**
	 * The array of superset feature identifiers for the '{@link #getOwnedImport() <em>Owned Import</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedImport()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_IMPORT_ESUPERSETS = new int[] {SysMLPackage.NAMESPACE__OWNED_RELATIONSHIP};

	// Operations

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<String> namesOf(Element element) {
		EList<String> names = new EDataTypeUniqueEList<>(String.class, this, SysMLPackage.NAMESPACE___NAMES_OF__ELEMENT);
		getMembership().stream().
			filter(mem->mem.getMemberElement() == element).
			forEach(mem->{
				String shortName = mem.getMemberShortName();
				String name = mem.getMemberName();
				if (shortName != null) {
					names.add(shortName);
				}
				if (name != null) {
					names.add(name);
				}
			});
		return names;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Membership> visibleMemberships(EList<Namespace> excluded, boolean isRecursive, boolean includeAll) {
		return getVisibleMemberships(new HashSet<>(excluded), new HashSet<Type>(), includeAll);
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public VisibilityKind visibilityOf(Membership mem) {
		Optional<Import> membershipImport = getOwnedImport().stream().
				filter(imp->imp.importedMemberships(new BasicEList<>()).contains(mem)).
				findAny();
		return membershipImport.isPresent()? membershipImport.get().getVisibility():
			   getMembership().contains(mem)? mem.getVisibility():
			   VisibilityKind.PRIVATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Membership> importedMemberships(EList<Namespace> excluded) {
		return getImportedMembership(new HashSet<>(excluded), new HashSet<Type>(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Membership resolve(String qualifiedName) {
		return NamespaceUtil.getNamedMembershipFor(this, qualifiedName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Membership resolveGlobal(String qualifiedName) {
		// TODO: Resolve elements other than to owning membership.
		Element element = SysMLLibraryUtil.getLibraryElement(this, qualifiedName);
		return element.getOwningMembership();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Membership resolveLocal(String name) {
		String escapedName = ElementUtil.escapeName(name);
		return getOwningNamespace() == null?
				resolveGlobal(escapedName):
				NamespaceUtil.getNamedMembershipFor(this, escapedName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Membership resolveVisible(String name) {
		return visibleMemberships(new BasicEList<>(), false, false).stream().
				filter(mem->
						name.equals(mem.getMemberShortName()) || 
						name.equals(mem.getMemberName())).
				findFirst().orElse(null);		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String qualificationOf(String qualifiedName) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String unqualifiedNameOf(String qualifiedName) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	// Note: The excludedTypes parameter is need when this operation is overridden in class Type.
	public EList<Membership> getVisibleMemberships(Collection<org.omg.sysml.lang.sysml.Namespace> excludedNamespaces, Collection<Type> excludedTypes, boolean includeAll) {
		EList<Membership> visibleMembership;
		if (includeAll) {
			visibleMembership = new BasicInternalEList<Membership>(Membership.class);
			visibleMembership.addAll(getOwnedMembership());
		} else {
			visibleMembership = getVisibleOwnedMembership(VisibilityKind.PUBLIC);
		}
		visibleMembership.addAll(this.getImportedMembership(excludedNamespaces, excludedTypes, includeAll));
		return visibleMembership;
	}

	public EList<Membership> getVisibleOwnedMembership(VisibilityKind visibility) {
		EList<Membership> publicMembership = new BasicInternalEList<Membership>(Membership.class);
		publicMembership.addAll(getOwnedMembership().stream().
				filter(membership->visibility.equals(membership.getVisibility())).collect(Collectors.toList()));
		return publicMembership;
	}

	public EList<Membership> getImportedMembership(Collection<org.omg.sysml.lang.sysml.Namespace> excludedNamespaces, Collection<Type> excludedTypes, boolean includeAll) {
		EList<Membership> importedMembership = new NonNotifyingEObjectEList<>(Membership.class, this, SysMLPackage.NAMESPACE__IMPORTED_MEMBERSHIP);
		Collection<Membership> nonpublicMembership = includeAll? null: new HashSet<Membership>();
		if (!excludedNamespaces.contains(this)) {
			for (Import _import: this.getOwnedImport()) {
				((ImportImpl)_import).importMemberships(importedMembership, nonpublicMembership, excludedNamespaces, excludedTypes);
			}
		}
		if (!includeAll) {
			importedMembership.removeAll(nonpublicMembership);
		}
		return importedMembership;
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
			case SysMLPackage.NAMESPACE__MEMBERSHIP:
				return getMembership();
			case SysMLPackage.NAMESPACE__OWNED_MEMBERSHIP:
				return getOwnedMembership();
			case SysMLPackage.NAMESPACE__OWNED_MEMBER:
				return getOwnedMember();
			case SysMLPackage.NAMESPACE__OWNED_IMPORT:
				return getOwnedImport();
			case SysMLPackage.NAMESPACE__MEMBER:
				return getMember();
			case SysMLPackage.NAMESPACE__IMPORTED_MEMBERSHIP:
				return getImportedMembership();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SysMLPackage.NAMESPACE__OWNED_MEMBERSHIP:
				getOwnedMembership().clear();
				getOwnedMembership().addAll((Collection<? extends Membership>)newValue);
				return;
			case SysMLPackage.NAMESPACE__OWNED_MEMBER:
				getOwnedMember().clear();
				getOwnedMember().addAll((Collection<? extends Element>)newValue);
				return;
			case SysMLPackage.NAMESPACE__OWNED_IMPORT:
				getOwnedImport().clear();
				getOwnedImport().addAll((Collection<? extends Import>)newValue);
				return;
			case SysMLPackage.NAMESPACE__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends Element>)newValue);
				return;
			case SysMLPackage.NAMESPACE__IMPORTED_MEMBERSHIP:
				getImportedMembership().clear();
				getImportedMembership().addAll((Collection<? extends Membership>)newValue);
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
			case SysMLPackage.NAMESPACE__OWNED_MEMBERSHIP:
				getOwnedMembership().clear();
				return;
			case SysMLPackage.NAMESPACE__OWNED_MEMBER:
				getOwnedMember().clear();
				return;
			case SysMLPackage.NAMESPACE__OWNED_IMPORT:
				getOwnedImport().clear();
				return;
			case SysMLPackage.NAMESPACE__MEMBER:
				getMember().clear();
				return;
			case SysMLPackage.NAMESPACE__IMPORTED_MEMBERSHIP:
				getImportedMembership().clear();
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
			case SysMLPackage.NAMESPACE__MEMBERSHIP:
				return isSetMembership();
			case SysMLPackage.NAMESPACE__OWNED_RELATIONSHIP:
				return ownedRelationship != null && !ownedRelationship.isEmpty();
			case SysMLPackage.NAMESPACE__OWNED_MEMBERSHIP:
				return OWNED_MEMBERSHIP__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case SysMLPackage.NAMESPACE__OWNED_MEMBER:
				return OWNED_MEMBER__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case SysMLPackage.NAMESPACE__OWNED_IMPORT:
				return OWNED_IMPORT__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case SysMLPackage.NAMESPACE__MEMBER:
				return MEMBER__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case SysMLPackage.NAMESPACE__IMPORTED_MEMBERSHIP:
				return IMPORTED_MEMBERSHIP__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SysMLPackage.NAMESPACE___NAMES_OF__ELEMENT:
				return namesOf((Element)arguments.get(0));
			case SysMLPackage.NAMESPACE___VISIBILITY_OF__MEMBERSHIP:
				return visibilityOf((Membership)arguments.get(0));
			case SysMLPackage.NAMESPACE___VISIBLE_MEMBERSHIPS__ELIST_BOOLEAN_BOOLEAN:
				return visibleMemberships((EList<Namespace>)arguments.get(0), (Boolean)arguments.get(1), (Boolean)arguments.get(2));
			case SysMLPackage.NAMESPACE___IMPORTED_MEMBERSHIPS__ELIST:
				return importedMemberships((EList<Namespace>)arguments.get(0));
			case SysMLPackage.NAMESPACE___RESOLVE__STRING:
				return resolve((String)arguments.get(0));
			case SysMLPackage.NAMESPACE___RESOLVE_GLOBAL__STRING:
				return resolveGlobal((String)arguments.get(0));
			case SysMLPackage.NAMESPACE___RESOLVE_LOCAL__STRING:
				return resolveLocal((String)arguments.get(0));
			case SysMLPackage.NAMESPACE___RESOLVE_VISIBLE__STRING:
				return resolveVisible((String)arguments.get(0));
			case SysMLPackage.NAMESPACE___QUALIFICATION_OF__STRING:
				return qualificationOf((String)arguments.get(0));
			case SysMLPackage.NAMESPACE___UNQUALIFIED_NAME_OF__STRING:
				return unqualifiedNameOf((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SysMLPackage.NAMESPACE__OWNED_RELATIONSHIP:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelationship()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SysMLPackage.NAMESPACE__OWNED_RELATIONSHIP:
				return ((InternalEList<?>)getOwnedRelationship()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

} //NamespaceImpl
