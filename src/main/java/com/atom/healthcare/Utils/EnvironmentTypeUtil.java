package com.atom.healthcare.Utils;

public class EnvironmentTypeUtil {

	public enum EnvironmentType {
		DEV, DEMO, PROD
	}

	/**
	 * Desc:-Method will get the DEV as default emulator if there is no value for
	 * test.environment in property file else it will return the environment which
	 * is mentioned in the property
	 * 
	 * @param env
	 * @return
	 */

	public static EnvironmentType getEnvironmentType(String env) {
		if (env == null)
			return EnvironmentType.DEV;
		if (env.equalsIgnoreCase("DEMO"))
			return EnvironmentType.DEMO;
		else if (env.equalsIgnoreCase("PROD"))
			return EnvironmentType.PROD;
		else if (env.equalsIgnoreCase("DEV3"))
			return EnvironmentType.DEV;
		else
			return EnvironmentType.DEV;
	}

}
