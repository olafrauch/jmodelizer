package org.holyo.jmodelizer.model;

import java.util.Collection;
import java.util.HashSet;

import org.holyo.jmodelizer.api.Model;
import org.holyo.jmodelizer.api.ModelAware;
import org.holyo.jmodelizer.api.NamedElement;

/**
 * A type reflects a programming language type like classes, enums etc.
 * 
 * @author olaf
 *
 */
public abstract class Type implements ModelAware, NamedElement {

	public final Collection<? extends Attribute> attributes = new HashSet<Attribute>();

	protected Model model;

	protected String name;

	protected Type(String name) {
		this(name, null);
	}

	protected Type(String name, Model model) {
		this.name = name;
		this.model = model;
	}

	public Model getModel() {
		return this.model;
	}

	public String getName() {
		return this.name;
	}

}
