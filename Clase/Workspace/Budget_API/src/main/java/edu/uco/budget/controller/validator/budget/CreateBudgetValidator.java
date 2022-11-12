package edu.uco.budget.controller.validator.budget;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.uco.budget.controller.validator.Validator;
import edu.uco.budget.crosscutting.helper.UUIDHelper;
import edu.uco.budget.crosscutting.messages.enumeration.Message;
import edu.uco.budget.domain.BudgetDTO;

public class CreateBudgetValidator implements Validator<BudgetDTO>{

	@Override
	public List<Message> validate(BudgetDTO dto) {
		List<Message> messages = new ArrayList<>();
		
		validatePersonId(dto.getPerson().getId(), messages);
		
		return messages;
	}
	
	private void validatePersonId(UUID personId, List<Message> messages) {
		
		if(UUIDHelper.isDefaultUUID(personId)) {
			messages.add(Message.createErrorMessage("Person id is equal to default value"));
		}
		
	}

}
