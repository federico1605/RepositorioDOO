package edu.uco.budget.service.usecase.person.implementacion;


import java.util.List;
import java.util.UUID;

import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.service.usecase.person.FindPersonById;
import edu.uco.budget.data.daofactory.DAOFactory;


public class FindPersonByIdImpl implements FindPersonById{

    private final DAOFactory factory;

    public FindPersonByIdImpl(DAOFactory factory){
        this.factory = factory;
    }
    
	@Override
	public PersonDTO execute(UUID id) {
		PersonDTO result = new PersonDTO();
        final PersonDTO person = PersonDTO.create(id);
        final List<PersonDTO> results = factory.getPersonDAO().find(person);

        if (!results.isEmpty()){
        	result = results.get(0);
        }
        return null;
	}

}
