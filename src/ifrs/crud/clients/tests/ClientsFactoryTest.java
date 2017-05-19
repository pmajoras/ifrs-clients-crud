package ifrs.crud.clients.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ifrs.crud.clients.core.ClientsFactory;
import ifrs.crud.clients.models.Client;
import ifrs.crud.clients.models.LegalClient;
import ifrs.crud.clients.models.PersonalClient;

public class ClientsFactoryTest {
	
	@Before 
	public void beforeEach() {
	}
	
	@Test
	public void Should_ReturnNull_WhenInValidCpfCnpj() {
		Client client = ClientsFactory.createClient("");
		
		Assert.assertNull(client);
	}
	
	@Test
	public void Should_PersonalClient_WhenValidCpf() {
		Client client = ClientsFactory.createClient("12345678911");
		
		Assert.assertNotNull(client);
		Assert.assertEquals("12345678911", client.getCpfCnpj());
		Assert.assertEquals(true, client instanceof PersonalClient);
	}
	
	@Test
	public void Should_LegaClient_WhenValidCnpj() {
		Client client = ClientsFactory.createClient("12345678955555");
		
		Assert.assertNotNull(client);
		Assert.assertEquals("12345678955555", client.getCpfCnpj());
		Assert.assertEquals(true, client instanceof LegalClient);
	}
}
