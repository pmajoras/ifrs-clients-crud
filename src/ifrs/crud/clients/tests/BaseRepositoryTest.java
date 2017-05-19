package ifrs.crud.clients.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ifrs.crud.clients.models.Client;
import ifrs.crud.clients.models.PersonalClient;
import ifrs.crud.clients.repositories.BaseRepository;

public class BaseRepositoryTest {

	private BaseRepository<Client> target;
	
	@Before 
	public void beforeEach() {
		target = new BaseRepository<Client>();
	}
	
	@Test
	public void Should_Save_NewClient() {
		Client client = new PersonalClient();
		
		target.save(client);
		Assert.assertEquals(1, client.getId());
		Assert.assertEquals(client, target.findById(1));
	}
	
	@Test
	public void Should_Update_ExistingClient() {
		Client client = new PersonalClient();
		target.save(client);
		
		Client updatedClient = new PersonalClient();
		updatedClient.setId(client.getId());
		
		try {
			target.update(updatedClient);
		} catch (Exception e) {
			Assert.fail();
		}
		
		Assert.assertEquals(updatedClient, target.findById(1));
	}
	
	@Test(expected=Exception.class)
	public void Should_Throw_ExceptionOnUpdateWhenIdIsWrong() throws Exception {
		Client client = new PersonalClient();
		target.save(client);
		Client updatedClient = new PersonalClient();
		
		target.update(updatedClient);
		
		Assert.fail();
	}
	
	@Test
	public void Should_Find_ByIdWhenIdIsRight() {
		Client client = new PersonalClient();
		
		target.save(client);
		Assert.assertEquals(client, target.findById(1));
	}
	
	@Test
	public void Should_ReturnNull_WhenIdIsWrong() {
		Client client = new PersonalClient();
		
		target.save(client);
		Assert.assertEquals(null, target.findById(5));
	}
	
	@Test
	public void Should_Find_WhenConditionIsRight() {
		Client client = new PersonalClient();
		client.setName("test");
		target.save(client);
		Assert.assertEquals(client, target.findBy(c -> c.getName() == "test"));
	}
	
	@Test
	public void Should_NotFind_WhenConditionIsWrong() {
		Client client = new PersonalClient();
		client.setName("test");
		target.save(client);
		Assert.assertEquals(null, target.findBy(c -> c.getName() == "test12"));
	}
	
	@Test
	public void Should_Remove_WhenIdIsRight() {
		Client client = new PersonalClient();
		target.save(client);
		
		try {
			target.removeById(1);
		} catch (Exception e) {
			Assert.fail();
		}
		
		Assert.assertEquals(null, target.findById(1));
	}
	
	@Test(expected=Exception.class)
	public void Should_Throw_WhenIdIsWrong() throws Exception {
		Client client = new PersonalClient();
		target.save(client);
		
		target.removeById(2);
		Assert.fail();
	}
}
