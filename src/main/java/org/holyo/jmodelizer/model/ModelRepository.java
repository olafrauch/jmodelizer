package org.holyo.jmodelizer.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.Validate;
import org.holyo.jmodelizer.api.Model;

public class ModelRepository implements Model {

	public final Map<String, Container> packages = new ConcurrentHashMap<String, Container>();
	public final Collection<Type> types = new HashSet<Type>();
	public final Collection<Relationship> relationships = new HashSet<Relationship>();

	public Collection<? extends Type> findType(String name) {
		Validate.notBlank(name);
		return null;
	}

	public Collection<? extends Class> findClass(String name) {
		Validate.notBlank(name);
		return null;
	}

	public Container findPackage(String name) {
		Validate.notBlank(name);
		if (!packages.containsKey(name)) {
			packages.put(name, new Container(this));
		}
		Container result = packages.get(name);
		return result;
	}

	public Class add(java.lang.Class<?> clazz) {
		Validate.notNull(clazz);
		String packageName = clazz.getPackage().getName();
		Container p = findPackage(packageName);
		String clazzName = clazz.getSimpleName();
		Class classElement = new Class(p, clazzName);
		classElement.setModel(this);
		types.add(classElement);
		return classElement;
	}

}
