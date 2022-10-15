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
	}
}
