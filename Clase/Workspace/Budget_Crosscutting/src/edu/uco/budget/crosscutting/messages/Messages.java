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
		public static final String TECNICAL_UUID_FROM_STRING_UNEXPECTED_ERROR = "copiar error";
	}
	
	/*public stactic class BudgetSqlServerDAO{
	 	private BudgetSqlServerDAO(){
	 		super();
	 	}*/
}
