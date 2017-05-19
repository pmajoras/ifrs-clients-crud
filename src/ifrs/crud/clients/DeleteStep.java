package ifrs.crud.clients;

import ifrs.crud.clients.core.IUserInterfaceHelper;
import ifrs.crud.clients.models.Client;
import ifrs.crud.clients.repositories.IClientsRepository;

public class DeleteStep implements IStep {
	private IUserInterfaceHelper userInterface;
	private IClientsRepository repository;
	private Client client;
	
	public DeleteStep(IUserInterfaceHelper userInterface, 
			IClientsRepository repository,
			Client client) {
		this.userInterface = userInterface;
		this.repository = repository;
		this.client = client;
	}
	
	@Override
	public IStep run() {
		IStep nextStep = new RequestCreateUpdateStep(this.userInterface, this.repository);
		
		if (this.userInterface.RequestDelete()) {
			try {
				this.repository.removeById(this.client.getId());
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
				
			System.out.println("O registro foi excluído com sucesso.");	
		}
		
		return nextStep;
	}	
}
