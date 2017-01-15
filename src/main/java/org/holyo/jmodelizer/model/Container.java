package org.holyo.jmodelizer.model;

import java.util.Collection;
import java.util.HashSet;

import org.holyo.jmodelizer.api.Model;
import org.holyo.jmodelizer.api.ModelAware;
import org.holyo.jmodelizer.api.NamedElement;

/**
 * A container holds 0..n {@link Type} Elements
 * 
 * @author olaf
 *
 */
public class Container implements ModelAware, NamedElement {
	public final Collection<Type> types = new HashSet<Type>();
	public String fullQualifiedName;

	public Model model;

	protected Container() {
	}

	public Container(String name) {
		super();
		this.fullQualifiedName = name;
	}

	public Container(Model model) {
		setModel(model);
	}

	public Model getModel() {
		return this.model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getName() {
		return fullQualifiedName;
	}

}
