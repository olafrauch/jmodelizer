package org.holyo.jmodelizer.api;

import java.util.Collection;

import org.holyo.jmodelizer.model.Class;
import org.holyo.jmodelizer.model.Type;

public interface Model {
	public abstract Collection<? extends Type> findType(String name);
	public abstract Collection<? extends Class> findClass(String name);
}
