package edu.uco.budget.crosscutting.helper;

import java.time.LocalDate;

public class DateHelper {

	private DateHelper() {
		super();
	}
	
	public final short getNextYear() {
		return (short) LocalDate.now().plusYears(1).getYear();
	}
}
