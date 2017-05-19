package ifrs.crud.clients;

import ifrs.crud.clients.core.IUserInterfaceHelper;
import ifrs.crud.clients.models.Client;
import ifrs.crud.clients.repositories.IClientsRepository;

public class RequestUpdateDeleteStep implements IStep  {

	private IUserInterfaceHelper userInterface;
	private IClientsRepository repository;
	private Client client;
	
	public RequestUpdateDeleteStep(IUserInterfaceHelper userInterface, 
			IClientsRepository repository,
			Client client) {
		this.userInterface = userInterface;
		this.repository = repository;
		this.client = client;
	}
	
	@Override
	public IStep run() {
		IStep nextStep = null;
		
		if (this.userInterface.RequestUpdateDelete()) {
			nextStep = new SaveOrUpdateClientStep(this.client, this.userInterface, this.repository);
		} else {
			nextStep = new DeleteStep(this.userInterface, this.repository, this.client);
		}
		
		return nextStep;
	}	
}
