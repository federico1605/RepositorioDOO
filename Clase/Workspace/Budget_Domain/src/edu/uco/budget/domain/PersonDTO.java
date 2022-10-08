package edu.uco.budget.domain;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;

import java.util.UUID;

public class PersonDTO {
	
	private UUID id;
	private String idCard;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	
	public PersonDTO() {
		
	}
	
	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}
	
	
}
