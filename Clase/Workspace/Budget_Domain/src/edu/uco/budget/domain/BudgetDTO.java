package edu.uco.budget.domain;

import static edu.uco.budget.crosscutting.helper.ObjectHelper.getDefaultIfNull;
import static edu.uco.budget.domain.builder.YearDTOBuilder.getYearDTOBuilder;
import static edu.uco.budget.domain.builder.PersonDTOBuilder.getPersonDTOBuilder;


public class BudgetDTO {
	
	private Year_DTO year;
	private PersonDTO person;

	public BudgetDTO() {
		super();
	}

	public Year_DTO getYear() {
		return year;
	}

	public void setYear(Year_DTO year) {
		this.year = getDefaultIfNull(year, getYearDTOBuilder().build());
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = getDefaultIfNull(person, getPersonDTOBuilder().build());
	}
}