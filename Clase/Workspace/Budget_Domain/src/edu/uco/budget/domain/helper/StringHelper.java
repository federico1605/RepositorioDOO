package edu.uco.budget.domain.helper;

import static edu.uco.budget.crosscutting.helper.ObjectHelper.getDefaultIfNull;

public class StringHelper {
	
	private StringHelper() {
		super();
	}
	
	public static final String EMPTY  = " ";
	
	public static final String getDafuaultString (String value, String defaultValue) {
		return getDefaultIfNull(value, defaultValue);
	}
	
	public static final String getDafuaultString (String value) {
		return getDefaultIfNull(value, EMPTY);
	}
	
	public static final String applyTrim(String value) {
		return getDafuaultString(value).trim();
	}
}
