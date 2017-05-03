package ifrs.crud.clients;
import ifrs.crud.clients.core.IReaderHelper;
import ifrs.crud.clients.core.MessagesConstants;
import ifrs.crud.clients.repositories.IRepository;

public class ClientsManagerApp {

	private IRepository<?> repository;
	private IReaderHelper reader;
	
	public ClientsManagerApp(IRepository<?> repository, IReaderHelper reader) {
		this.repository = repository;
		this.reader = reader;
	}
	
	public void run() {
		System.out.println(MessagesConstants.STEP_1_QUESTION);
		System.out.println(MessagesConstants.OPTION_YES);
		System.out.println(MessagesConstants.OPTION_NO);
	}
	
	private void exitApp() {
		System.exit(0);
	}
}
