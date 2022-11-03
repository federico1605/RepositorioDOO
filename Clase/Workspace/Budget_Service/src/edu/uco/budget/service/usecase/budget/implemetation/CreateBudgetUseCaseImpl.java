package edu.uco.budget.service.usecase.budget.implemetation;

import edu.uco.budget.data.daofactory.DAOFactory;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.usecase.budget.CreateBudgetUseCase;

public final class CreateBudgetUseCaseImpl implements CreateBudgetUseCase {
	
	private final DAOFactory factory;

	public CreateBudgetUseCaseImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public final void execute(BudgetDTO budget) {
		factory.getBudgetDAO().create(budget);
	}
	
	/*public static void main(String[] args) {
		List<BudgetDTO> results = DAOFactory.getDAOFactory(DAOFactoryType.SQL_SERVER).getBudgetDAO().find(null);
		
		for (BudgetDTO budgetDTO : results) {
			System.out.println(budgetDTO.toString());
			
		}
	}*/
}
