package edu.uco.budget.crosscutting.customException.crossctting;

import edu.uco.budget.crosscutting.customException.BudgetCustomException;
import edu.uco.budget.crosscutting.customException.enumeration.LayerException;
import static edu.uco.budget.crosscutting.helper.StringHelper.EMPTY;

public class CrosscutingCustomException extends BudgetCustomException{
	
	private static final long serialVersionUID = 1L;

	protected CrosscutingCustomException(Exception rootException, String technicalMessage, String userMessage) {
		super(rootException, technicalMessage, userMessage, LayerException.CROSSCUTING);
	}
	
	public static final BudgetCustomException createTechnicalException(final String technicalMessage,final Exception rootException) {
		return new CrosscutingCustomException(rootException, technicalMessage, EMPTY);
	}
	
	public static final BudgetCustomException createTechnicalException(final String technicalMessage) {
		return new CrosscutingCustomException(new Exception(), technicalMessage, EMPTY);
	}
	
	public static final BudgetCustomException createUserException(final String userMessage, final Exception rootException) {
		return new CrosscutingCustomException(rootException, userMessage, userMessage);
	}
	
	public static final BudgetCustomException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new CrosscutingCustomException(rootException, technicalMessage, userMessage);
	}
	
	public static CrosscutingCustomException create(String userMessage, String technicalMessage) {
		return new CrosscutingCustomException(new Exception(), userMessage, technicalMessage);
	}
}
