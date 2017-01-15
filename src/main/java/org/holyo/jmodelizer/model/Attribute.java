package org.holyo.jmodelizer.model;

import org.holyo.jmodelizer.api.Model;
import org.holyo.jmodelizer.api.ModelAware;
import org.holyo.jmodelizer.api.NamedElement;

/**
 * Named and typed Data container for single values. Please note that
 * collections are reflected by {@link Container}
 *
 * @author olaf
 */
public class Attribute implements ModelAware, NamedElement {

  public String name;
  private Model model;

  public String getName() {
    return this.name;
  }

  public Model getModel() {
    return this.model;
  }

  public void setModel(Model model) {
    this.model = model;
  }

}
