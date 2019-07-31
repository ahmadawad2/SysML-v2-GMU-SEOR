/*****************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2019 Model Driven Solutions, Inc.
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
 * Contributors:
 *  Ed Seidewitz
 * 
 *****************************************************************************/
package org.omg.sysml.interactive;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.util.traversal.Traversal;
import org.omg.sysml.util.traversal.facade.impl.DefaultElementProcessingFacadeImpl;
import org.omg.sysml.util.traversal.impl.TraversalImpl;
import org.omg.sysml.util.traversal.visitor.ElementVisitorFactory;
import org.omg.sysml.util.traversal.visitor.impl.ElementVisitorFactoryImpl;

public class SysMLInteractiveResult {
	
	private Element rootElement = null;
	private List<Issue> issues = null;
	private Exception exception = null;
	
	protected Traversal traversal;	
	protected StringBuilder outline;
	
	public SysMLInteractiveResult(Element rootElement, List<Issue> issues) {
		this.rootElement = rootElement;
		this.issues = issues;
	}
	
	public SysMLInteractiveResult(Exception exception) {
		this.exception = exception;
	}
	
	public Element getRootElement() {
		return this.rootElement;
	}
	
	public List<Issue> getIssues() {
		return this.issues == null? Collections.emptyList(): this.issues;
	}
	
	public List<Issue> getSyntaxErrors() {
		return this.getIssues().stream().filter(Issue::isSyntaxError).collect(Collectors.toList());
	}
	
	public List<Issue> getSemanticErrors() {
		return this.getIssues().stream().
				filter(issue->!issue.isSyntaxError() && issue.getSeverity().equals(Severity.ERROR)).
				collect(Collectors.toList());
	}
	
	public List<Issue> getWarnings() {
		return this.getIssues().stream().
				filter(issue->issue.getSeverity().equals(Severity.WARNING)).
				collect(Collectors.toList());
	}
	
	public Exception getException() {
		return this.exception;
	}
	
	protected ElementVisitorFactory createVisitorFactory() {
		return new ElementVisitorFactoryImpl(
				new DefaultElementProcessingFacadeImpl() {
					@Override
					public void println(String line) {
						outline.append(line);
						outline.append("\n");
					}
				});
	}
	
	protected String traverse(Element element) {
		if (this.traversal != null) {
			this.traversal.reset();
		} else {
			final ElementVisitorFactory visitorFactory = this.createVisitorFactory();
			this.traversal = new TraversalImpl(visitorFactory);
			visitorFactory.setTraversal(this.traversal);
		}
		this.outline = new StringBuilder();
		this.traversal.visit(this.rootElement);
		return this.outline.toString();
	}
	
	protected <T extends Object> String formatList(List<T> list) {
		StringBuilder buffer = new StringBuilder();
		list.stream().map(x->x.toString() + "\n").forEachOrdered(buffer::append);
		return buffer.toString();
	}
	
	public String formatRootElement() {
		return this.rootElement == null? "null": this.traverse(this.rootElement);
	}
	
	public String formatIssues() {
		return formatList(this.issues);
	}
	
	public String formatException() {
		StringWriter writer = new StringWriter();
		this.exception.printStackTrace(new PrintWriter(writer));
		return writer.toString();
	}
	
	@Override
	public String toString() {
		if (this.exception != null) {
			return this.formatException();
		} else {
			List<Issue> syntaxErrors = this.getSyntaxErrors();
			if (!syntaxErrors.isEmpty()) {
				return this.formatList(syntaxErrors);
			} else {
				return this.formatRootElement() + this.formatList(this.getSemanticErrors());
			}
		}
	}

}
