package ifrs.crud.clients.core;

import java.util.function.Predicate;

import ifrs.crud.clients.models.Client;
import ifrs.crud.clients.models.PersonalClient;
import ifrs.crud.clients.repositories.IClientsRepository;

public class ClientsValidator {
	
	private IClientsRepository repository;
	
	public ClientsValidator(IClientsRepository repository) {
		this.repository = repository;
	}
	
	public String validateName(String value) {
		String errorMessage = GenericValidators.validateFieldLength(value, 5, "Nome");
		
		if (errorMessage == null) {
			errorMessage = this.repository
				.findBy(client -> value.equalsIgnoreCase(client.getName())) != null ? 
				String.format(MessagesConstants.INVALID_ALREADY_EXISTS_FIELD, "nome"): null;
		}
		
		return errorMessage;
	}
	
	public String validateRg(String value) {
		String errorMessage = GenericValidators.validateFieldLength(value, 1, "RG");
		
		if (errorMessage == null) {
			Predicate<Client> condition = (client -> client.getClientType() == ClientsConstants.PERSONAL && 
					value.equalsIgnoreCase(((PersonalClient) client).getRg()));
					
			errorMessage = this.repository
				.findBy(condition) != null ? 
				String.format(MessagesConstants.INVALID_ALREADY_EXISTS_FIELD, "RG"): null;
		}
		
		return errorMessage;
	}
	
	public String validateCnh(String value) {
		String errorMessage = GenericValidators.validateFieldLength(value, 1, "CNH");
		
		if (errorMessage == null) {
			Predicate<Client> condition = (client -> client.getClientType() == ClientsConstants.PERSONAL && 
					value.equalsIgnoreCase(((PersonalClient) client).getCnh()));
					
			errorMessage = this.repository
				.findBy(condition) != null ? 
				String.format(MessagesConstants.INVALID_ALREADY_EXISTS_FIELD, "CNH"): null;
		}
		
		return errorMessage;
	}
}
