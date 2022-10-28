package edu.uco.budget.crosscutting.helper;

import static edu.uco.budget.crosscutting.helper.ObjectHelper.getDefaultIfNull;

import java.util.Objects;

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
	
	public static final boolean isEmpty(String value) {
		return Objects.equals(value, EMPTY);
	}
}
