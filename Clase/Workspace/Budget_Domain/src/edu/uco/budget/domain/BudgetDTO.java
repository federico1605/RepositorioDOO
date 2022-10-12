package edu.uco.budget.domain;

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
		this.year = year;
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
	}
}