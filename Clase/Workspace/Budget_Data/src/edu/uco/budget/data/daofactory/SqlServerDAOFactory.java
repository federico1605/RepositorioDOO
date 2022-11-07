package edu.uco.budget.data.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;

import edu.uco.budget.crosscutting.customException.Data.DataCustomException;
import edu.uco.budget.crosscutting.customException.crossctting.CrosscutingCustomException;
import edu.uco.budget.crosscutting.helper.SqlConnectionHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.dao.relational.sqlserver.BudgetSqlServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.PersonSqlServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.YearSqlServerDAO;

final class SqlServerDAOFactory extends DAOFactory {

	private Connection connection;

	SqlServerDAOFactory() {
		openConnection();
	}

	@Override
	protected void openConnection() {
		final String url = "jdbc:sqlserver://rg-wf.database.windows.net:1433;" + "database=db-budget;"
				+ "user=userDmlBudget;" + "password=us3rDmlBudg3t;" + "encrypt=true;" + "trustServerCertificate=false;"
				+ "hostNameInCertificate=*.database.windows.net;" + "loginTimeout=30;";
		try {
			connection = DriverManager.getConnection(url);
		} catch (Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_CLOSED,
					exception);
		}
	}

	@Override
	public void initTransaction() {
		try {
			SqlConnectionHelper.initTransation(connection);
		} catch (CrosscutingCustomException exception) {
			throw DataCustomException.createTechnicalException(Messages.SqlServerDAOFactory.TECHNICAL_PROBLEM_INIT_TRANSACTION, exception);
		}
	}

	@Override
	public void confirmTransaction() {
		try {
			SqlConnectionHelper.commitTransation(connection);
		} catch (Exception exception) {

		}
	}

	@Override
	public void cancelTransaction() {
		try {
		SqlConnectionHelper.rollbackTransation(connection);
		} catch (Exception exception) {
			// TODO: handle exception
		}

	}

	@Override
	public void closeConnection() {
		try {
		SqlConnectionHelper.closeConnection(connection);
		} catch (Exception exception) {
			// TODO: handle exception
		}

	}

	@Override
	public BudgetDAO getBudgetDAO() {
		return new BudgetSqlServerDAO(connection);
	}

	@Override
	public PersonDAO getPersonDAO() {
		return new PersonSqlServerDAO(connection);
	}

	@Override
	public YearDAO getYearDAO() {
		return new YearSqlServerDAO(connection);
	}
}