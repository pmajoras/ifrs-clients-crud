package ifrs.crud.clients;

import ifrs.crud.clients.core.UserInterfaceHelper;
import ifrs.crud.clients.repositories.ClientsRepository;

public class Main {

	public static void main(String[] args) {
		UserInterfaceHelper userInterface = new UserInterfaceHelper();
		ClientsRepository repository = new ClientsRepository();
		IStep firstStep = new RequestCreateUpdateStep(userInterface, repository);
		
		ClientsManagerApp appManager = new ClientsManagerApp(repository, userInterface, firstStep);
		
		appManager.runSteps();
	}
}
