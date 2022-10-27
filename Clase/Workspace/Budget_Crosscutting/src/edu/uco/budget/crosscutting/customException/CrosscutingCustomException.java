package edu.uco.budget.crosscutting.customException;

public class CrosscutingCustomException extends DataCustomException{

	private CrosscutingCustomException(Exception exceptionConnection, String mensaje) {
		super(exceptionConnection, mensaje);
	}

	private static final long serialVersionUID = 1L;
	
	public static CrosscutingCustomException create(String mensajeUsuario) {
		return new CrosscutingCustomException(new Exception(), mensajeUsuario);
	}
}
