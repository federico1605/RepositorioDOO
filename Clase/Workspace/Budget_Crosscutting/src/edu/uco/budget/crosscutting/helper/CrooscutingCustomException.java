package edu.uco.budget.crosscutting.helper;

import static edu.uco.budget.crosscutting.messages.Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_NULL;;

public class CrooscutingCustomException extends Exception {

	private static final long serialVersionUID = 1L;

	protected CrooscutingCustomException() {
		super(TECHNICAL_CONNECTION_IS_NULL);
	}

}
