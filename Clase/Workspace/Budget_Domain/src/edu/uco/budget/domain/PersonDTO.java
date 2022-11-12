package edu.uco.budget.domain;

import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;
import static edu.uco.budget.crosscutting.helper.StringHelper.applyTrim;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;
import static edu.uco.budget.crosscutting.helper.StringHelper.EMPTY;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

import edu.uco.budget.crosscutting.helper.UUIDHelper;

public class PersonDTO {
	
	private UUID id;
	private String idCard;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	
	public PersonDTO() {
		setId(getNewUUID());
		setIdCard(EMPTY);
		setFirstName(EMPTY);
		setSecondName(EMPTY);
		setFirstSurname(EMPTY);
		setSecondSurname(EMPTY);
	}
	
	public PersonDTO(final UUID id, final String idCard, final String firstName, final String secondName, 
			final String firstSurname, final String secondSurname) {
		setId(id);
		setIdCard(idCard);
		setFirstName(firstName);
		setSecondName(secondName);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
	}
	
	public static final PersonDTO create (final UUID id, final String idCard, 
			final String firstName, final String secondName, 
			final String firstSurname, final String secondSurname) {
		return new PersonDTO(id, idCard, firstName, secondName, firstSurname, secondSurname);
	}
	
	public static final PersonDTO create (final String id, final String idCard, 
			final String firstName, final String secondName, 
			final String firstSurname, final String secondSurname) {
		return new PersonDTO(getUUIDFromString(id), idCard, firstName, secondName, firstSurname, secondSurname);
	}
	
	public static final PersonDTO create(final UUID id) {
		return new PersonDTO(id, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY);
	}
	
	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}
	
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(final String idCard) {
		this.idCard = applyTrim(idCard);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = applyTrim(firstName);
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(final String secondName) {
		this.secondName = applyTrim(secondName);
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(final String firstSurname) {
		this.firstSurname = applyTrim(firstSurname);
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(final String secondSurname) {
		this.secondSurname = applyTrim(secondSurname);
		
	}
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
	
	public boolean exist() {
		return !UUIDHelper.isDefaultUUID(id);
	}
	
	public boolean notExist() {
		return !exist();
	}

}
