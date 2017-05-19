package ifrs.crud.clients.repositories;

import java.util.List;

import ifrs.crud.clients.models.Client;

public class ClientsRepository extends BaseRepository<Client> 
	implements IClientsRepository {

	@Override
	public Client getByCpfCnpj(String cpfCnpj) {		
		return this.findBy(client -> client.getCpfCnpj().equalsIgnoreCase(cpfCnpj) == true);
	}
}
