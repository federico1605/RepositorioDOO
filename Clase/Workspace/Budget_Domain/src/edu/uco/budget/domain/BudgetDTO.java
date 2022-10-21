package edu.uco.budget.domain;

import static edu.uco.budget.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.budget.domain.builder.YearDTOBuilder.getYearDTOBuilder;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getNewUUID;


import java.util.UUID;

import static edu.uco.budget.domain.builder.PersonDTOBuilder.getPersonDTOBuilder;


public class BudgetDTO {
	
	private UUID id;
	private YearDTO year;
	private PersonDTO person;

	public BudgetDTO() {
		setId(getNewUUID());
		setPerson(person);
		setYear(year);
	}
	
	public BudgetDTO(final UUID id,final YearDTO year,final PersonDTO person ) {
		setId(id);
		setPerson(person);
		setYear(year);
	}
	
	public static final BudgetDTO create(final UUID id,final YearDTO year,final PersonDTO  person) {
		return new BudgetDTO();
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
}