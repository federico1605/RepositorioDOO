package edu.uco.budget.service.usecase.budget.implemetation;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.data.enumeration.DAOFactoryType;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;

public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase {

	@Override
	public final void execute(BudgetDTO budget) {
		DAOFactory.getDAOFactory(DAOFactoryType.SQL_SERVER).getBudgetDAO().create(budget);
	}
}
