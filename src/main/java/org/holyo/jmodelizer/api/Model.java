package org.holyo.jmodelizer.api;

import org.holyo.jmodelizer.model.Class;
import org.holyo.jmodelizer.model.Type;

import java.util.Collection;

public interface Model {
  Collection<? extends Type> findType(String name);

  Collection<? extends Class> findClass(String name);
}
