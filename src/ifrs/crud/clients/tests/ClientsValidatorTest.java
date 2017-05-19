package ifrs.crud.clients.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ifrs.crud.clients.core.ClientsValidator;
import ifrs.crud.clients.core.MessagesConstants;
import ifrs.crud.clients.models.Client;
import ifrs.crud.clients.models.PersonalClient;
import ifrs.crud.clients.repositories.ClientsRepository;

public class ClientsValidatorTest {
	private ClientsRepository repository;
	private ClientsValidator target;
	
	@Before 
	public void beforeEach() {
		this.repository = new ClientsRepository();
		this.target = new ClientsValidator(this.repository);
	}
	
	@Test
	public void Should_ReturnNoError_WhenValidName() {
		String error = this.target.validateName("NameTest");
		
		Assert.assertNull(error);
	}
	
	@Test
	public void Should_ReturnError_WhenInvalidNameLength() {
		String error = this.target.validateName("abcd");
		
		Assert.assertEquals(String.format(MessagesConstants.INVALID_lENGTH_FIELD, 
				"Nome", 5), error);
	}
	
	@Test
	public void Should_ReturnError_WhenUserWithNameExists() {
		Client client = new PersonalClient();
		client.setName("abcde");
		this.repository.save(client);
		String error = this.target.validateName("abcde");
		
		Assert.assertEquals(String.format(MessagesConstants.INVALID_ALREADY_EXISTS_FIELD, "nome"), error);
	}
}
