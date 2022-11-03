package edu.uco.budget.data.dao.relational;

import java.sql.Connection;

import edu.uco.budget.crosscutting.helper.SqlConnectionHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.crosscutting.customException.DataCustomException;


public class DAORelational {

	private Connection connection;
	
	protected DAORelational(final Connection connection) {
		
		if(!SqlConnectionHelper.connectionIsNull(connection)) {
			throw DataCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED);
		}		
	
		this.connection = connection;
	
	}

	protected final Connection getConnection() {
		return connection;
	}
}
