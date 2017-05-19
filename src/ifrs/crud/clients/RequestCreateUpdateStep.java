package ifrs.crud.clients;

import ifrs.crud.clients.core.ClientsFactory;
import ifrs.crud.clients.core.IUserInterfaceHelper;
import ifrs.crud.clients.models.Client;
import ifrs.crud.clients.repositories.IClientsRepository;

public class RequestCreateUpdateStep implements IStep {

	private IUserInterfaceHelper userInterface;
	private IClientsRepository repository;
	
	public RequestCreateUpdateStep(IUserInterfaceHelper userInterface, 
			IClientsRepository repository) {
		this.userInterface = userInterface;
		this.repository = repository;
	}
	
	@Override
	public IStep run() {
		IStep nextStep = null;
		
		if (this.userInterface.RequestCreateUpdate()) {
			//nextStep = 
			String cpfCnpj = this.userInterface.RequestCpfOrCnpj().toUpperCase();
			Client client = this.repository.getByCpfCnpj(cpfCnpj);
			
			if (client == null) {
				client = ClientsFactory.createClient(cpfCnpj);
				nextStep = new SaveOrUpdateClientStep(client, this.userInterface, this.repository);
			} else {
				nextStep = new RequestUpdateDeleteStep(this.userInterface, this.repository, client);
			}
		}
		
		return nextStep;
	}
}
