package edu.uco.budget.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.data.dao.PersonDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.PersonDTO;

public class PersonSqlServerDAO extends DAORelational implements PersonDAO {

	public PersonSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(final PersonDTO person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final List<PersonDTO> find(final PersonDTO person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final void update(final PersonDTO person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void delete(final UUID id) {
		// TODO Auto-generated method stub
		
	}
}
