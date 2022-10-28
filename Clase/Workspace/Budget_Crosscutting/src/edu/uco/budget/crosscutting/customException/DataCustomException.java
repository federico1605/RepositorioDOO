package edu.uco.budget.crosscutting.customException;

import edu.uco.budget.crosscutting.customException.enumeration.LayerException;
import static edu.uco.budget.crosscutting.helper.StringHelper.EMPTY;

public class DataCustomException  extends BudgetCustomException{

	private DataCustomException(Exception rootException, String technicalMessage, String userMessage) {
		super(rootException, technicalMessage, userMessage, LayerException.DATA);
	}

	private static final long serialVersionUID = -7581138972968503560L;

	public static final BudgetCustomException create(final String userMessage, final String technicalMessage) {
		return new DataCustomException(new Exception(), technicalMessage, userMessage);
	}

	public static final BudgetCustomException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DataCustomException(rootException, technicalMessage, userMessage);
	}

	public static final BudgetCustomException createTechnicalException(final String technicalMessage) {
		return new DataCustomException(new Exception(), technicalMessage,EMPTY);
	}
	
	public static final BudgetCustomException createTechnicalException(final String technicalMessage, final Exception rootException) {
		return new DataCustomException(rootException, technicalMessage,EMPTY);
	}
	
	public static final BudgetCustomException createUserException(final String userMessage, final Exception rootException) {
		return new DataCustomException(rootException, userMessage, userMessage);
	}
}
