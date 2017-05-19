package ifrs.crud.clients;

import java.text.SimpleDateFormat;

import ifrs.crud.clients.core.ClientsConstants;
import ifrs.crud.clients.core.IUserInterfaceHelper;
import ifrs.crud.clients.core.MessagesConstants;
import ifrs.crud.clients.models.Client;
import ifrs.crud.clients.models.PersonalClient;
import ifrs.crud.clients.repositories.IClientsRepository;
import ifrs.crud.clients.repositories.IRepository;

public class PrintClientDataStep implements IStep {

	private Client client;
	private IUserInterfaceHelper userInterface;
	private IClientsRepository repository;
	
	public PrintClientDataStep(IUserInterfaceHelper userInterface,
			IClientsRepository repository,
			Client client) {
		this.userInterface = userInterface;
		this.repository = repository;
		this.client = client;
	}
	
	@Override
	public IStep run() {
		IStep nextStep = new RequestCreateUpdateStep(this.userInterface, this.repository);;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		this.printData("Nome", this.client.getName());
		this.printData("Endereço", this.client.getAddress());
		this.printData("CEP", this.client.getCep());
		this.printData("Telefone", this.client.getPhone());
		this.printData("Email", this.client.getEmail());
		
		if (this.client.getClientType() == ClientsConstants.PERSONAL) {
			PersonalClient personalClient = (PersonalClient)this.client;
			//this.printData("Data de Nascimento", sdf.format(personalClient.getBirthDate()));
			this.printData("CPF", personalClient.getCpfCnpj());
			this.printData("RG", personalClient.getRg());
			this.printData("CNH", personalClient.getCnh());
			this.printData("Tipo", "Física");
			this.printData("Nome da Mãe", personalClient.getFatherName());
			this.printData("Nome do Pai", personalClient.getMotherName());
			
		} else {
			this.printData("CNPJ", this.client.getCpfCnpj());
			this.printData("Tipo", "Jurídica");
		}
		
		this.printData("Data de Cadastro", sdf.format(this.client.getCreatedDate()));

		return nextStep;
	}
	
	private void printData(String fieldName, String value) {
		value = value != null ? value : "";
		System.out.println(String.format(MessagesConstants.FIELD_VALUE, fieldName, value));
	}
	
}
