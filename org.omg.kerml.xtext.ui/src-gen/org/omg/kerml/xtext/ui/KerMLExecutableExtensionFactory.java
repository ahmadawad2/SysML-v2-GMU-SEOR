/*
 * generated by Xtext 2.28.0
 */
package org.omg.kerml.xtext.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.omg.kerml.xtext.ui.internal.XtextActivator;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class KerMLExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(XtextActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		XtextActivator activator = XtextActivator.getInstance();
		return activator != null ? activator.getInjector(XtextActivator.ORG_OMG_KERML_XTEXT_KERML) : null;
	}

}
