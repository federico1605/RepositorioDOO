package edu.uco.budget.crosscutting.customException;

import static edu.uco.budget.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import edu.uco.budget.crosscutting.customException.enumeration.LayerException;
import static edu.uco.budget.crosscutting.helper.StringHelper.isEmpty;

public class BudgetCustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String userMessage;
	private LayerException layer;

	protected BudgetCustomException(final Exception rootException,final String technicalMessage,final String userMessage,
			final LayerException layer) {
		super(technicalMessage, getDefaultIfNull(rootException, new Exception()));
	}

	public final String getUserMessage() {
		return userMessage;
	}

	public final void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public final LayerException getLayer() {
		return layer;
	}

	public final void setLayer(LayerException layer) {
		this.layer = layer;
	}
	
	public final boolean isTechnicalException() {
		return isEmpty(getUserMessage());
	}
}
