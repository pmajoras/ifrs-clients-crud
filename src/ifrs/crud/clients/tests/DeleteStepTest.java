package ifrs.crud.clients.tests;

import static org.mockito.Mockito.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ifrs.crud.clients.DeleteStep;
import ifrs.crud.clients.IStep;
import ifrs.crud.clients.RequestCreateUpdateStep;
import ifrs.crud.clients.core.ClientsValidator;
import ifrs.crud.clients.core.IUserInterfaceHelper;
import ifrs.crud.clients.models.Client;
import ifrs.crud.clients.models.PersonalClient;
import ifrs.crud.clients.repositories.ClientsRepository;

public class DeleteStepTest {
	private ClientsRepository repository;
	private IUserInterfaceHelper interfaceHelper;
	private DeleteStep target;
	
	@Before 
	public void beforeEach() {
		Client client = new PersonalClient();
		this.repository = new ClientsRepository();
		this.repository.save(client);
		this.interfaceHelper = Mockito.mock(IUserInterfaceHelper.class);
		
		this.target = new DeleteStep(this.interfaceHelper, this.repository, client);
	}
	
	@Test
	public void Should_Remove_WhenRequestDeleteIsTrue() {
		 Mockito.when(this.interfaceHelper.RequestDelete()).thenReturn(true);
		 
		 IStep nextStep = this.target.run();
		 
		 Assert.assertNull(this.repository.findById(1));
		 Assert.assertTrue(nextStep instanceof RequestCreateUpdateStep);
	}
	
	@Test
	public void Should_NotRemove_WhenRequestDeleteIsFalse() {
		 Mockito.when(this.interfaceHelper.RequestDelete()).thenReturn(false);
		 
		 IStep nextStep = this.target.run();
		 
		 Assert.assertNotNull(this.repository.findById(1));		 
		 Assert.assertTrue(nextStep instanceof RequestCreateUpdateStep);
	}
}
