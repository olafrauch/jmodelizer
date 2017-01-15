package org.holyo.jmodelizer.scanner;

import org.apache.commons.lang3.Validate;
import org.holyo.jmodelizer.model.Class;
import org.holyo.jmodelizer.model.ModelRepository;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;

import java.util.Set;

public class ReflectionScanner {

  private ScannerConfiguration configuration = null;

  public ReflectionScanner(ScannerConfiguration configuration) {
    Validate.notNull(configuration);
    this.configuration = configuration;
  }

  public ModelRepository scan() {
    Validate.notNull(configuration);
    ConfigurationBuilder reflectionConfiguration = ConfigurationBuilder.build(configuration.packages(),
      new SubTypesScanner(false));

    Reflections reflections = new Reflections(reflectionConfiguration);
    Set<String> types = reflections.getAllTypes();
    ModelRepository repository = new ModelRepository();
    for (String type : types) {
      java.lang.Class<?> clazz = ReflectionUtils.forName(type);
      Class classElement = repository.add(clazz);
    }
    return repository;
  }

}
