package org.holyo.jmodelizer.scanner;

import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class ScannerConfiguration {
	public static class Builder {

		private ScannerConfiguration configuration = new ScannerConfiguration();

		public static Builder begin(String packageName) {
			Validate.notBlank(packageName);
			Builder result = new Builder();
			result.configuration.typeNameWhitelistRegex.add(StringUtils.appendIfMissing(packageName, ".*"));
			return result;
		}

		private Builder() {
		}

		public Builder allowPackage(String... packageNames) {
			appendPackageNamesAsRegex(configuration.typeNameWhitelistRegex, packageNames);
			return this;
		}

		public Builder disallowPackage(String... packageNames) {
			appendPackageNamesAsRegex(configuration.typeNameBlacklistRegex, packageNames);
			return this;
		}

		private void appendPackageNamesAsRegex(Collection<String> typeNamelist, String... packageNames) {
			if (ArrayUtils.isNotEmpty(packageNames)) {
				for (String packageName : packageNames) {
					CollectionUtils.addIgnoreNull(typeNamelist, StringUtils.appendIfMissing(packageName, ".*"));
				}
			}
		}

		public ScannerConfiguration build() {
			return this.configuration;
		}

	}

	public Collection<String> typeNameWhitelistRegex = new HashSet<String>();

	public Collection<String> typeNameBlacklistRegex = new HashSet<String>();

	public String[] packages() {
		String[] result = ArrayUtils.EMPTY_STRING_ARRAY;
		for (String packageName : typeNameWhitelistRegex) {
			result = ArrayUtils.add(result, StringUtils.removeEnd(packageName, ".*"));
		}
		return result;
	}

}
