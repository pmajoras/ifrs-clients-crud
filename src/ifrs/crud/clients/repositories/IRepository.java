package ifrs.crud.clients.repositories;

import java.util.List;
import java.util.function.Predicate;

import ifrs.crud.clients.models.Entity;

public interface IRepository<T extends Entity> {

	T save(T entity);
	T update(T entity) throws Exception;
	T saveOrUpdate(T entity) throws Exception;
	T findById(long id);
	T findBy(Predicate<? super T> condition);
	List<T> findAll(Predicate<? super T> filter);
	void removeById(long id) throws Exception;
}
