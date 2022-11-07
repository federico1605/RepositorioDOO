package edu.uco.budget.data.daofactory;

import edu.uco.budget.crosscutting.customException.BudgetCustomException;
import edu.uco.budget.crosscutting.customException.Data.DataCustomException;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.YearDAO;
import edu.uco.budget.data.enumeration.DAOFactoryType;

public abstract class DAOFactory {
	
	public static final DAOFactory getDAOFactory(final DAOFactoryType factory) {
		
		DAOFactory daoFactory;
		
		switch (factory) {
		case SQL_SERVER: 
			try {
				daoFactory = new SqlServerDAOFactory();
			} catch (BudgetCustomException excetion) {
				throw DataCustomException.createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_CONNECTION_IS_NULL, 
						excetion);
			}
			break;
		case CASSANDRA: 
			try {
				daoFactory = new SqlServerDAOFactory();
			} catch (BudgetCustomException excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_CASSANDRA_NOT_IMPLEMENTED, 
						excetion);
			}
			break;
		case MARIADB: 
			try {
				daoFactory = new SqlServerDAOFactory();
			} catch (Exception excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_MARIADB_NOT_IMPLEMENTED, 
						excetion);
			}
			break;
		case MONGODB: 
			try {
				daoFactory = new SqlServerDAOFactory();
			} catch (Exception excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_MONGDB_NOT_IMPLEMENTED, 
						excetion);
			}
			break;
		case MYSQL: 
			try {
				daoFactory = new SqlServerDAOFactory();
			} catch (Exception excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_MYSQL_NOT_IMPLEMENTED, 
						excetion);
			}
			break;
		case ORACLE: 
			try {
				daoFactory = new SqlServerDAOFactory();
			} catch (Exception excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_ORACLE_NOT_IMPLEMENTED, 
						excetion);
			}
			break;
		case POSTGRESQL: 
			try {
				daoFactory = new SqlServerDAOFactory();
			} catch (Exception excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_POSTGRESQL_NOT_IMPLEMENTED, 
						excetion);
			}
			break;
		default:
			try {
				daoFactory = new SqlServerDAOFactory();
			} catch (Exception excetion) {
				throw DataCustomException.createTechnicalException(Messages.DAOFactory.TECHNICAL_UNEXPECTED_DAOFACTORY, 
						excetion);
			}
			break;
		}
		return daoFactory;
	}

	protected abstract void openConnection();

	public abstract void initTransaction();
	
	public abstract void confirmTransaction();
	
	public abstract void cancelTransaction();
		
	public abstract void closeConnection();
	
	public abstract BudgetDAO getBudgetDAO();
	
	public abstract PersonDAO getPersonDAO();
	
	public abstract YearDAO getYearDAO();
}
