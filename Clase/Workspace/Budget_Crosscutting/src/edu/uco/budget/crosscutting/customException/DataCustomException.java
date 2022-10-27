package edu.uco.budget.crosscutting.customException;

public class DataCustomException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private Exception exceptionConnection;
	private String mensajeUsuario;
	
	protected DataCustomException(Exception exceptionConnection,String mensajeUsuario) {
		super();
		this.exceptionConnection = exceptionConnection;
		this.mensajeUsuario = mensajeUsuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Exception getExceptionConnection() {
		return exceptionConnection;
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}
}
