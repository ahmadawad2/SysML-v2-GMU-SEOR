/*
 * generated by Xtext 2.18.0.M3
 */
package org.omg.sysml.ui.tests;

import com.google.inject.Injector;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.omg.sysml.ui.internal.SysmlActivator;

public class AlfUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return SysmlActivator.getInstance().getInjector("org.omg.sysml.Alf");
	}

}
