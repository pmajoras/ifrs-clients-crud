package ifrs.crud.clients;

import ifrs.crud.clients.core.ClientsConstants;
import ifrs.crud.clients.core.ClientsValidator;
import ifrs.crud.clients.core.GenericValidators;
import ifrs.crud.clients.core.IUserInterfaceHelper;
import ifrs.crud.clients.models.Client;
import ifrs.crud.clients.models.PersonalClient;
import ifrs.crud.clients.repositories.IClientsRepository;

public class SaveOrUpdateClientStep implements IStep {

	private IUserInterfaceHelper userInterface;
	private Client client;
	private IClientsRepository repository;
	
	public SaveOrUpdateClientStep(Client client, 
			IUserInterfaceHelper userInterface,
			IClientsRepository repository) {
		this.client = client;
		this.userInterface = userInterface;
		this.repository = repository;
	}
	
	@Override
	public IStep run() {
		ClientsValidator validator = new ClientsValidator(this.repository);
		
		this.client.setName(this.userInterface.RequestField("Nome", 
				(String fieldValue) -> validator.validateName(fieldValue)));
		
		this.client.setAddress(this.userInterface.RequestField("Endereço", 
				(String fieldValue) -> GenericValidators.validateFieldLength(fieldValue, 1, "Endereço")));
		
		this.client.setCep(this.userInterface.RequestField("CEP", 
				(String fieldValue) -> GenericValidators.validateFieldLength(fieldValue, 1, "CEP")));

		this.client.setPhone(this.userInterface.RequestField("Telefone", 
				(String fieldValue) -> GenericValidators.validateFieldLength(fieldValue, 8, "Telefone")));
		
		this.client.setEmail(this.userInterface.RequestField("Email", 
				(String fieldValue) -> GenericValidators.validateFieldLength(fieldValue, 1, "Email")));
		
		if (this.client.getClientType() == ClientsConstants.PERSONAL) {
			PersonalClient personalClient = (PersonalClient)this.client;
			
			personalClient.setRg(this.userInterface.RequestField("RG", 
					(String fieldValue) -> validator.validateRg(fieldValue)));
			
			personalClient.setCnh(this.userInterface.RequestField("CNH", 
					(String fieldValue) -> validator.validateCnh(fieldValue)));
			
			personalClient.setFatherName(this.userInterface.RequestField("Nome do Pai", null));
			personalClient.setMotherName(this.userInterface.RequestField("Nome da Mãe", null));
		}
		
		try {
			this.repository.saveOrUpdate(this.client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
		return new PrintClientDataStep(this.userInterface, this.repository, this.client);
	}
}
