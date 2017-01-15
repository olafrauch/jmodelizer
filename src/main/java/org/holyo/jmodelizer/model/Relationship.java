package org.holyo.jmodelizer.model;

import org.holyo.jmodelizer.api.Model;
import org.holyo.jmodelizer.api.ModelAware;
import org.holyo.jmodelizer.api.NamedElement;

public class Relationship implements ModelAware, NamedElement {

  private Model model;

  public Model getModel() {
    return this.model;
  }

  public void setModel(Model model) {
    this.model = model;
  }

  public Type getFrom() {
    return null;
  }

  public Type getTo() {
    return null;
  }

  public String getName() {
    return null;
  }
}
