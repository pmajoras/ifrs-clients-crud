package ifrs.crud.clients;
import ifrs.crud.clients.core.IUserInterfaceHelper;
import ifrs.crud.clients.core.MessagesConstants;
import ifrs.crud.clients.repositories.IRepository;

public class ClientsManagerApp {

	private IRepository<?> repository;
	private IUserInterfaceHelper userInterface;
	private IStep firstStep;
	
	public ClientsManagerApp(IRepository<?> repository, 
			IUserInterfaceHelper userInterface,
			IStep firstStep) {
		this.repository = repository;
		this.userInterface = userInterface;
		this.firstStep = firstStep;
	}
	
	public void runSteps() {
		IStep currentStep = this.firstStep;
		
		while (currentStep != null) {
			currentStep = currentStep.run();
		}
		
		this.exitApp();
	}
	
	private void exitApp() {
		System.out.println("O sistema será finalizado");
		System.exit(0);
	}
}
