package ifrs.crud.clients.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ifrs.crud.clients.DeleteStep;
import ifrs.crud.clients.IStep;
import ifrs.crud.clients.RequestCreateUpdateStep;
import ifrs.crud.clients.RequestUpdateDeleteStep;
import ifrs.crud.clients.SaveOrUpdateClientStep;
import ifrs.crud.clients.core.IUserInterfaceHelper;
import ifrs.crud.clients.models.Client;
import ifrs.crud.clients.models.PersonalClient;
import ifrs.crud.clients.repositories.ClientsRepository;

public class RequestUpdateDeleteStepTest {

	private ClientsRepository repository;
	private IUserInterfaceHelper interfaceHelper;
	private RequestUpdateDeleteStep target;
	
	@Before 
	public void beforeEach() {
		Client client = new PersonalClient();
		this.repository = new ClientsRepository();
		this.repository.save(client);
		this.interfaceHelper = Mockito.mock(IUserInterfaceHelper.class);
		
		this.target = new RequestUpdateDeleteStep(this.interfaceHelper, this.repository, client);
	}
	
	@Test
	public void Should_ReturnSaveOrUpdateClientStepStep_WhenRequestUpdateIsTrue() {
		 Mockito.when(this.interfaceHelper.RequestUpdateDelete()).thenReturn(true);
		 
		 IStep nextStep = this.target.run();
		 
		 Assert.assertTrue(nextStep instanceof SaveOrUpdateClientStep);
	}
	
	@Test
	public void Should_ReturnDeleteStep_WhenRequestUpdateIsFalse() {
		 Mockito.when(this.interfaceHelper.RequestUpdateDelete()).thenReturn(false);
		 
		 IStep nextStep = this.target.run();
		 
		 Assert.assertTrue(nextStep instanceof DeleteStep);
	}
	
}
