package org.holyo.jmodelizer.model;

import org.holyo.jmodelizer.api.Model;

/**
 * The class is the most common type in the (java) programming language.
 *
 * @author olaf
 */
public class Class extends Type {

  private Container container;

  protected Class() {
    super(null, null);
  }

  public Class(Container container, String name) {
    super(name);
    this.container = container;
    container.types.add(this);
  }

  public Container getContainer() {
    return this.container;
  }

  public void setModel(Model model) {
    this.model = model;
  }
}
