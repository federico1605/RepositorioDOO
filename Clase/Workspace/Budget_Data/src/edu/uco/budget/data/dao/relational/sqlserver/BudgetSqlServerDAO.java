package edu.uco.budget.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.crosscutting.customException.Data.DataCustomException;
import edu.uco.budget.crosscutting.helper.ObjectHelper;
import edu.uco.budget.crosscutting.helper.UUIDHelper;
import edu.uco.budget.crosscutting.messages.Messages;
import edu.uco.budget.data.dao.BudgetDAO;
import edu.uco.budget.data.dao.relational.DAORelational;
import static edu.uco.budget.crosscutting.helper.UUIDHelper.getUUIDAsString;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.domain.PersonDTO;
import edu.uco.budget.domain.YearDTO;

public class BudgetSqlServerDAO extends DAORelational implements BudgetDAO {

	public BudgetSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void create(final BudgetDTO budget) {
		final var sql = "INSERT INTO BUDGET(id,year,idPerson) VALUES (?,?,?)";
		
		try (final var preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setString(1, budget.getIdAsString());
			preparedStatement.setString(2, budget.getYear().getIdAsString());
			preparedStatement.setString(3, budget.getPerson().getIdAsString());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			String message = Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_CREATE_BUDGET.concat(budget.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		}catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_CREATE_BUDGET, exception);
		}
	}

	@Override
	public final List<BudgetDTO> find(final BudgetDTO budget) {
		
		
		var sqlBuilder = new StringBuilder();
		final var parameters = new ArrayList<Object>();
		
		createSelectFrom(sqlBuilder);
		createWhere(sqlBuilder, budget, parameters);
		createOrderBy(sqlBuilder);
		
		return prepareAndExecuteQuery(sqlBuilder, parameters);
	}
	
	private final List<BudgetDTO> prepareAndExecuteQuery(final StringBuilder sqlBuilder, final List<Object> parameters) {
		try (final var preparedStatement = getConnection().prepareStatement(sqlBuilder.toString())){
			
			setParameterValues(preparedStatement, parameters);
			
			return executeQuery(preparedStatement);
			
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_PREPARED_STAMENT, exception);
		} catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMETER_VALUES_QUERY, exception);
		}
	}

	private final void createSelectFrom(final StringBuilder sqlBuilder) {
		sqlBuilder.append("SELECT      Bu.Id AS IdBudget,");
		sqlBuilder.append("            Bu.idYear AS IdYear,");
		sqlBuilder.append("            Ye.yeaar AS NumberYear");
		sqlBuilder.append("            Bu.idPerson AS IdPerson,");
		sqlBuilder.append("            Pe.idCard AS IdCardPerson,");
		sqlBuilder.append("            Pe.firstName AS FirstNamePerson,");
		sqlBuilder.append("            Pe.secondName AS SecondNamePerson,");
		sqlBuilder.append("            Pe.firstSurname AS FirstSurnamePerson,");
		sqlBuilder.append("            Pe.secondSurname AS SecondSurnamePerson,");
		sqlBuilder.append("FROM        Budget BU");
		sqlBuilder.append("INNER JOIN  Year Ye");
		sqlBuilder.append("ON          Bu.idYear = Ye.id");
		sqlBuilder.append("INNER JOIN  Person Pe");
		sqlBuilder.append("ON          Bu.idPerson = Pe.id");
	}
	
	private final void createWhere(final StringBuilder sqlBuilder, final BudgetDTO budget, final List<Object> parameters) {
		if(!ObjectHelper.isNull(budget)) {
			var setWhere = true;
					
			if (!UUIDHelper.isDefaultUUID(budget.getId())) {
				sqlBuilder.append("WHERE Bu.id = ? ");
				setWhere = false;
				parameters.add(budget.getIdAsString());
			}
			
			if (!UUIDHelper.isDefaultUUID(budget.getYear().getId())) {
				sqlBuilder.append(setWhere ? "WHERE ": "AND ").append("Bu.idYear = ? ");
				parameters.add(budget.getYear().getIdAsString());
			}
			
			if (!UUIDHelper.isDefaultUUID(budget.getPerson().getId())) {
				sqlBuilder.append(setWhere ? "WHERE ": "AND ").append("Bu.idPerson = ? ");
				parameters.add(budget.getPerson().getIdAsString());
			}
		}
	}
	
	private void createOrderBy(final StringBuilder sqlBuilder) {
		sqlBuilder.append("ORDER BY   Pe.idCard ASC,");
		sqlBuilder.append("           Ye.year ASC");		
	}	
	
	private final List<BudgetDTO> executeQuery(PreparedStatement preparedStatement){
		try (final var resultset = preparedStatement.executeQuery()){
			return fillResults(resultset);	
		}catch (final DataCustomException exception) {
			throw exception;
		}catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_EXECUTE_QUERY, exception);
		}catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECEUTE_QUERY, exception);
		}
	}
	
	private void setParameterValues(PreparedStatement preparedStatement, final List<Object> parameters) {
		try {
			for(int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
		} catch (SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_SET_PARAMETER_VALUES_QUERY, exception);
		}catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_SET_PARAMETER_VALUES_QUERY, exception);
		}
	}

	
	private final List<BudgetDTO> fillResults(final ResultSet resultSet){
		
		try {
			var results = new ArrayList<BudgetDTO>();
			
			while(resultSet.next()) {
				results.add(fillBudgetDTO(resultSet));
			}
			
			return results;
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_FILL_RESULTS, exception);
		}
		catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_RESULTS, exception);
		}
		
	}
	
	private final BudgetDTO fillBudgetDTO(final ResultSet resultset) {
		try {
			
			return  BudgetDTO.create(resultset.getString("idBudget"), fillYearDTO(resultset), fillPersonDTO(resultset));
			
		} catch (final DataCustomException exception) {
			throw exception;
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_FILL_BUDGET_DTO, exception);
		}catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_BUDGET_DTO, exception);
		}	
	}
	
	private final YearDTO fillYearDTO(final ResultSet resultSet) {
		try {
			return YearDTO.create(resultSet.getString("IdYear"), resultSet.getShort("NumberYear"));
		} catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_FILL_YEAR_DTO, exception);
		}catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_YEAR_DTO, exception);
		}
	}
	
	private final PersonDTO fillPersonDTO(final ResultSet resultSet) {
		try {
			return PersonDTO.create(resultSet.getString("IdPerson"), resultSet.getString("IdCardPerson"), resultSet.getString("FirstNamePerson"), 
					resultSet.getString("SecondNamePerson"), resultSet.getString("FirstSurnamePerson"), resultSet.getString("SecondSurnamePerson"));
		}  catch (final SQLException exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_FILL_PERSON_DTO, exception);
		}catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_FILL_PERSON_DTO, exception);
		}
	}

	@Override
	public final void update(final BudgetDTO budget) {
		final var sql = "UPDATE BUDGET SET idYear = ?, idPerson = ? WHERE id = ?";
		
		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, budget.getYear().getIdAsString());
			preparedStatement.setString(2, budget.getPerson().getIdAsString());
			preparedStatement.setString(3, budget.getIdAsString());
			
			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			String message = Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_UPDATE_BUDGET.concat(budget.getIdAsString());
			throw DataCustomException.createTechnicalException(message, exception);
		}catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECEUTE_QUERY, exception);
		}
		
	}

	@Override
	public final void delete(final UUID id) {
		final var sql = "DELETE FROM BUDGET WHERE id = ?";
		final var idAsString = getUUIDAsString(id);
		
		try (final var preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, idAsString);
			
			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			String message = Messages.BudgetSqlServerDAO.TECHNICAL_PROBLEM_DELETE_BUDGET;
			throw DataCustomException.createTechnicalException(message, exception);
		}catch (final Exception exception) {
			throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_PROBLEM_EXECEUTE_QUERY, exception);
		}
	}
}
