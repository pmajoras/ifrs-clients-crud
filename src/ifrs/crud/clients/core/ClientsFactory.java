package ifrs.crud.clients.core;

import ifrs.crud.clients.models.Client;
import ifrs.crud.clients.models.LegalClient;
import ifrs.crud.clients.models.PersonalClient;

public class ClientsFactory {

	public static Client createClient(String cpfCnpj) {
		Client client = null;
		
		if (GenericValidators.validateCpfCnpj(cpfCnpj)) {
			client = GenericValidators.isCpf(cpfCnpj) ? new PersonalClient() : new LegalClient();
			client.setCpfCnpj(cpfCnpj);
		}
		
		return client;
	}
}
