package edu.uco.budget.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uco.budget.controller.response.Response;
import edu.uco.budget.controller.validator.Validator;
import edu.uco.budget.controller.validator.budget.CreateBudgetValidator;
import edu.uco.budget.crosscutting.customException.BudgetCustomException;
import edu.uco.budget.crosscutting.messages.enumeration.Message;
import edu.uco.budget.domain.BudgetDTO;
import edu.uco.budget.service.command.CreateBudgetCommand;
import edu.uco.budget.service.command.implementation.CreateBudgetCommandImpl;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {
	
	public CreateBudgetCommand createBudgetCommand = new CreateBudgetCommandImpl();
	
	@GetMapping("/dummy")
	public BudgetDTO holaMundo() {
		return new BudgetDTO();
	}
	
	@PostMapping
	public ResponseEntity<Response<BudgetDTO>> create(@RequestBody BudgetDTO budget) {
		
		final Response<BudgetDTO> response = new Response<>();
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			Validator<BudgetDTO> validator = new CreateBudgetValidator();
			List<Message> messages = validator.validate(budget);
			
			if(messages.isEmpty()) {
				createBudgetCommand.execute(budget);
			}
			
			final List<BudgetDTO> data = new ArrayList<>();
			data.add(budget);
			response.setData(data);
			
			response.addSuccesMessages("The budget has been create succesfully");
		} catch (final BudgetCustomException exception) {
			if(exception.isTechnicalException()) {
				response.addErrorMessages("There was an error trying to create the budget. Please try again...");
			}else {
				//Error 400
				httpStatus = HttpStatus.BAD_REQUEST;
				response.addErrorMessages(exception.getMessage());
				
			}
			
			//Imprimiendo traza de la excepcion
			exception.printStackTrace();
		} catch (final Exception exception) {
			//Error 500
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response.addFatalMessages("Thera was a unexpected error trying to create budget. Please try again...");
			
			//Imprimiendo traza de la excepcion
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response, httpStatus);
	}
}
