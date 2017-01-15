package org.holyo.jmodelizer.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.holyo.jmodelizer.api.Model;
import org.holyo.jmodelizer.scanner.ReflectionScanner;
import org.holyo.jmodelizer.scanner.ScannerConfiguration;
import org.holyo.jmodelizer.scanner.ScannerConfiguration.Builder;
import org.holyo.jmodelizer.testdata.packagea.MainClassA;
import org.junit.Test;

public class ReflectionedModelTest {

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgument() {
		ModelRepository model = new ModelRepository();
		model.findClass("");
	}

	@Test
	public void testSimpleTree() throws Exception {
		Model model = new ModelRepository();
		Container c = new Container(model);
		Class clazz = new Class(c, "test");
		assertThat(c.types).contains(clazz);
	}

	@Test
	public void testScanner() {
		Builder c = ScannerConfiguration.Builder.begin(MainClassA.class.getPackage()
				.getName());
		ReflectionScanner scanner = new ReflectionScanner(c.build());
		ModelRepository repo = scanner.scan();
		assertThat(repo.types).hasSize(2);
		assertThat(repo.types.iterator()
				.next().name).startsWith("MainClass");
	}

}
