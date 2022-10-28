package edu.uco.budget.data.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.dao.relational.sqlserver.BudgetSqlServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.PersonSqlServerDAO;
import edu.uco.budget.data.dao.relational.sqlserver.YearSqlServerDAO;
import edu.uco.budget.crosscutting.customException.CrosscutingCustomException;
import static edu.uco.budget.crosscutting.messages.Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_NULL;;

final class SqlServerDAOFactory extends DAOFactory {

	private Connection connection;

	SqlServerDAOFactory() throws CrosscutingCustomException {
		openConnection();
	}

	@Override
	protected void openConnection() throws CrosscutingCustomException {
		final String url = "jdbc:sqlserver://rg-wf.database.windows.net:1433;"
				+ "database=db-budget;"
				+ "user=userDmlBudget;"
				+ "password=us3rDmlBudg3t;"
				+ "encrypt=true;"
				+ "trustServerCertificate=false;"
				+ "hostNameInCertificate=*.database.windows.net;"
				+ "loginTimeout=30;";
		try {
			connection = DriverManager.getConnection(url);
		}catch (SQLException exception) {
			throw CrosscutingCustomException.create(TECHNICAL_CONNECTION_IS_NULL);
		}
	}

	@Override
	public void initTransaction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirmTransaction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelTransaction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub

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