package edu.uco.budget.domain;

import static edu.uco.budget.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.budget.domain.builder.YearDTOBuilder.getYearDTOBuilder;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;

import java.util.UUID;

import edu.uco.budget.crosscutting.customException.crossctting.CrosscutingCustomException;
import edu.uco.budget.crosscutting.helper.StringHelper;
import edu.uco.budget.crosscutting.messages.Messages;

import static edu.uco.budget.domain.builder.PersonDTOBuilder.getPersonDTOBuilder;


public class BudgetDTO {
	
	private UUID id;
	private YearDTO year;
	private PersonDTO person;

	public BudgetDTO() {
		setId(getNewUUID());
		setPerson(getPersonDTOBuilder().build());
		setYear(getYearDTOBuilder().build());
	}
	
	public BudgetDTO(final UUID id,final YearDTO year,final PersonDTO person ) {
		setId(id);
		setPerson(person);
		setYear(year);
	}
	
	public static final BudgetDTO create(final UUID id,final YearDTO year,final PersonDTO  person) {
		return new BudgetDTO(id,year,person);
	}
	
	public static final BudgetDTO create(final String id,final YearDTO year,final PersonDTO  person) {
		return new BudgetDTO(getUUIDFromString(id),year,person);
	}
	
	public static final String getUUIDAsString(final UUID value) {
		return getDefaultUUID(value).toString();
	}
	
	public static final UUID getUUIDFromString(final String value) {
		try {
			return UUID.fromString(StringHelper.getDafuaultString(value));
		} catch (IllegalArgumentException exception) {
			throw CrosscutingCustomException.createTechnicalException(Messages.UUIDHelper.TECHICAL_UUID_FROM_STRING_INAVLID, exception);
		}
		
	}
	
	public UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = getDefaultUUID(id);
	}

	public YearDTO getYear() {
		return year;
	}

	public void setYear(YearDTO year) {
		this.year = getDefaultIfNull(year, getYearDTOBuilder().build());
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = getDefaultIfNull(person, getPersonDTOBuilder().build());
	}	
	
	public final String getIdAsString() {
		return getUUIDAsString(getId());
	}
}