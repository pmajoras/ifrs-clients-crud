package ifrs.crud.clients.repositories;

import java.util.List;

import ifrs.crud.clients.models.Entity;

public interface IRepository<T extends Entity> {

	T save(T entity);
	T update(T entity) throws Exception;
	T findById(long id);
	List<T> findAll();
	void removeById(long id) throws Exception;
}
