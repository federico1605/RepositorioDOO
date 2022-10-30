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
	public final void create(final BudgetDTO budget) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final List<BudgetDTO> find(final BudgetDTO budget) {
		return null;
	}

	@Override
	public final void update(final BudgetDTO budget) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void delete(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	/*
	private final List<BudgetDTO> fillResult(final Resultset resultSet){
	try{
		var resultd = new ArrayList<BudgetDTO>;
		
		//while(resultset.next()) {
		
	}*/
	
	/*private final BudgetDTO fillBudgetDTO(final ResultSet resultset){
		try{
		 *  yearDTO yearTmp = YearDTO.create(resultset.getString("IdYear"),resultSet.getShort("NumberYear"));
			PersonDTO personTmp = PersonDTO.create(resultset.getString("IdPerson"),resultSet.getString("IdPerson"),
				resultSet.getString("IdCardPerson"));
				resultSet.getString("FirstName"));
				resultSet.getString("SecodName"));
				resultSet.getString("FirstSurname"));
				resultSet.getString("SecondSurname"));
				BudgetDTO budgetbudgetTmp = BudgetDTO.create("idBudget", personTPM, yearTmp);
			
			results.add(budgetTmp);
			return results;
			}catch (final SQLexception exception)
				throw DatacustongException.TEHCNICAL(Messages.BudgetSQLserverdao.TEHNICAL_, exception);
			catch (final Exception exception){
			throw DataCustonException.createTehcnicalExeception(null, exception);
			}catch (final SQLException exception){
			throw DataCutomException.create(añadir mensajes, exception)
			}catch(final Exeception exceptino) {
			 throw DataCutomException.create(añadir mensajes, exception)
			*/
	}
