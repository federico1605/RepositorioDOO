package edu.uco.budget.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import edu.uco.budget.domain.BudgetDTO;

public class BudgetSqlServerDAO extends DAORelational implements BudgetDAO {

	public BudgetSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(BudgetDTO budget) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BudgetDTO> find(BudgetDTO budget) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BudgetDTO budget) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
