package ifrs.crud.clients.repositories;

import ifrs.crud.clients.models.Client;

public interface IClientsRepository extends IRepository<Client> {

	Client getByCpfCnpj(String cpfCnpj);
}
