package edu.uco.budget.crosscutting.helper;

import java.util.UUID;

import edu.uco.budget.crosscutting.customException.crossctting.CrosscutingCustomException;
import edu.uco.budget.crosscutting.messages.Messages;

public class UUIDHelper {
	private static final String DEFAULT_UUID_AS_STRING = "00000000-0000-0000-0000-00000000000";
	private static final UUID DEFAULT_UUDI = UUID.fromString(DEFAULT_UUID_AS_STRING);
	
	private UUIDHelper() {
		super();
	}
	
	public static final UUID getDefaultUUID(final UUID value) {
		return ObjectHelper.getDefaultIfNull(value, DEFAULT_UUDI);
	}
	
	public static final UUID getNewUUID() {
		
		UUID uuid;
		
		do {
			uuid = UUID.randomUUID();
		} while(isDefaultUUID(uuid));
		return uuid;			
	}
	
	public static final String getUUIDAsString(final UUID value) {
		return getDefaultUUID(value).toString();
	}
	
	public static final UUID getUUIDFromString(final String value) {
		try {
			return UUID.fromString(StringHelper.getDafuaultString(value, DEFAULT_UUID_AS_STRING));
		} catch (IllegalArgumentException exception) {
			throw CrosscutingCustomException.createTechnicalException(Messages.UUIDHelper.TECHICAL_UUID_FROM_STRING_INAVLID, exception);
		}catch (final Exception exception) {
			throw CrosscutingCustomException.createTechnicalException(Messages.UUIDHelper.TECNICAL_UUID_FROM_STRING_UNEXPECTED_ERROR, exception);
		}
	}
	
	public static final boolean isDefaultUUID(final UUID value) {
		return DEFAULT_UUDI.equals(value);
	}
}
