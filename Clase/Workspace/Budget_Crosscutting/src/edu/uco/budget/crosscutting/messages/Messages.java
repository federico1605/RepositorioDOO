package edu.uco.budget.crosscutting.messages;

public class Messages {
	
	private Messages() {
		super();
	}
	
	public static class DAOFactory{
		
		private DAOFactory() {
			super();
		}
		
		public static final String TECHNICAL_MONGDB_NOT_IMPLEMENTED = "DAOFactory for MongDB is not implemented yet";
		public static final String TECHNICAL_MARIADB_NOT_IMPLEMENTED = "DAOFactory for MARIADB is not implemented yet";
		public static final String TECHNICAL_CASSANDRA_NOT_IMPLEMENTED = "DAOFactory for CASSANDRA is not implemented yet";
		public static final String TECHNICAL_ORACLE_NOT_IMPLEMENTED = "DAOFactory for ORACLE is not implemented yet";
		public static final String TECHNICAL_POSTGRESQL_NOT_IMPLEMENTED = "DAOFactory for POSTGRESQL is not implemented yet";
		public static final String TECHNICAL_MYSQL_NOT_IMPLEMENTED = "DAOFactory for MYSQL is not implemented yet";
		public static final String TECHNICAL_UNEXPECTED_DAOFACTORY = "Unexpectef DAOfactory";
	}
	
	public static class SqlConnectionHelper{
		
		private SqlConnectionHelper() {
			super();
		}
		
		public static  final String TECHNICAL_CONNECTION_IS_NULL = "Connection is null";
		public static  final String TECHNICAL_CONNECTION_IS_CLOSED = "Connection is closed";
		public static  final String TECHNICAL_CONNECTION_ALREADY_IS_CLOSED = "Connection already is closed";
		public static  final String TECHNICAL_PROBLEM_CLOSING_CONNECTION = "There was a problem try to close connection. Please verify the technical details";
		public static  final String TECHNICAL_CONNETION_IS_CLOSED_FOR_INIT_TRANSACTION = "Connetion is closed to start a new init transaction";
		public static  final String TECHNICAL_CONNETION_IS_CLOSED_FOR_ROLLBACK_TRANSACTION = "Connetion is closed to rollback transaction";
		public static  final String TECHNICAL_CONNETION_IS_CLOSED_FOR_COMMIT_TRANSACTION = "Connetion is closed to commit the current transaction";
		public static  final String TECHNICAL_PROBLEM_TRY_INIT_TRANSACTION = "There was a problem trying to start the transaction. Please verify the technical details";
		public static  final String TECHNICAL_PROBLEM_TRY_COMMIT_TRANSACTION = "There was a problem trying to commit the current transaction. Please verify the technical details";
		public static  final String TECHNICAL_PROBLEM_TRY_ROLLBACK_TRANSACTION = "There was a problem trying to rollback the current transaction. Please verify the technical details";

	}
	
public static class SqlServerDAOFactory{
		
		private SqlServerDAOFactory() {
			super();
		}
		
		public static  final String TECHNICAL_PROBLEM_INIT_TRANSACTION = "There was a problem trying to init transaction with the current connection in SQLServerDaoFactory";

	}
	
	public static class UUIDHelper{
		private UUIDHelper() {
			super();
		}
		
		public static final String TECHICAL_UUID_FROM_STRING_INAVLID ="The UUID to covert does not have a valied";
		public static final String TECNICAL_UUID_FROM_STRING_UNEXPECTED_ERROR = "There was an unexpected exception trying to convert a UUID from String";
	}
	
	public static class BudgetSqlServerDAO{
	 	private BudgetSqlServerDAO(){
	 		super();	
	 	}	
	 	
	 	public static final String TECHNICAL_UNEXPECTED_PROBLEM_CREATE_BUDGET = "There was an unexpected problem trying to create the budget in SQLServerDaoFactory with id= ";
	 	public static final String TECHNICAL_PROBLEM_CREATE_BUDGET = "There was a problem trying to create the budget in SQLServerDaoFactory with id= ";
	 	public static final String TECHNICAL_PROBLEM_UPDATE_BUDGET = "There was a problem trying to update the budget in SQLServerDaoFactory with id= ";
	 	public static final String TECHNICAL_PROBLEM_DELETE_BUDGET = "There was a problem trying to delete the budget in SQLServerDaoFactory with id= ";
	 	public static final String TECHNICAL_PROBLEM_FILL_RESULTS = "There was a problem recovering results from the select ";
	 	public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS = "There was an unexpected problem trying recovering results from the select ";
	 	public static final String TECHNICAL_PROBLEM_FILL_BUDGET_DTO = "There was a problem filling BudgetDTO from the resultSet ";
	 	public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_BUDGET_DTO = "There was an unexpected problem trying fill BudgetDTO from the resultSet ";
	 	public static final String TECHNICAL_PROBLEM_FILL_YEAR_DTO = "There was a problem filling YearDTO from the resultSet ";
	 	public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_YEAR_DTO = "There was an unexpected problem trying fill YearDTO from the resultSet ";
	 	public static final String TECHNICAL_PROBLEM_FILL_PERSON_DTO = "There was a problem filling PersonDTO from the resultSet ";
	 	public static final String TECHNICAL_UNEXPECTED_PROBLEM_FILL_PERSON_DTO = "There was an unexpected problem trying fill PersonDTO from the resultSet ";
	 	public static final String TECHNICAL_PROBLEM_EXECUTE_QUERY = "There was a problem trying to excute query to find the specific budget";
	 	public static final String TECHNICAL_UNEXPECTED_PROBLEM_EXECEUTE_QUERY = "There was an unexpected problem trying to execute query to finad the specific budgets";
	 	public static final String TECHNICAL_PROBLEM_SET_PARAMETER_VALUES_QUERY = "There was a problem trying to set the parameters values to the query";
	 	public static final String TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMETER_VALUES_QUERY = "There was an unexpected problem trying to set the parameters values to the query";
	 	public static final String TECHNICAL_PROBLEM_PREPARED_STAMENT = "There was a problem trying to prepared the sql stament the parameters";
	 	public static final String TECHNICAL_UNEXPECTED_PROBLEM_PREPARED_STAMENT = "There was an unexpected problem trying to prepared the sql stament the parameters";
	 	
	}
}
