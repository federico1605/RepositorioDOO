package edu.uco.budget.service.command.implementation;

import edu.uco.budget.crosscutting.customException.BudgetCustomException;
import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.command.CreateBudgetCommand;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;
import edu.uco.budget.service.usecase.budget.implemetation.CreateBudgetUseCaseImpl;

public class CreateBudgetCommandImpl implements CreateBudgetCommand{
	
	private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.SQL_SERVER);
	private final CreateBudgetUseCase useCase = new CreateBudgetUseCaseImpl(factory);
	
	@Override
	public final void execute(final BudgetDTO budget) {
		try {
			factory.initTransaction();
			//use case execution
			useCase.execute(budget);
			factory.confirmTransaction();
		} catch (BudgetCustomException exception) {
			factory.cancelTransaction();
			throw exception;
		} catch (final Exception exception) {
			factory.cancelTransaction();
			throw exception;
		}finally {
			factory.closeConnection();
		}
	}

}
