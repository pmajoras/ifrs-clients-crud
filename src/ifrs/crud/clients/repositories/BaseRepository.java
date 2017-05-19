package ifrs.crud.clients.repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ifrs.crud.clients.models.Entity;

public class BaseRepository<T extends Entity> implements IRepository<T> {

	private long idCounter = 1;
	private List<T> fakeDatabase = new ArrayList<T>();
	
	public T saveOrUpdate(T entity) throws Exception {
		T savedEntity = null;
		
		if (entity.getId() == 0) {
			savedEntity = this.save(entity);
		} else {
			savedEntity = this.update(entity);
		}
		
		return savedEntity;
	}
	
	@Override
	public T save(T entity) {
		fakeDatabase.add(entity);
		entity.setId(idCounter++);
		entity.setCreatedDate(new Date());
		return entity;
	}

	@Override
	public T update(T entity) throws Exception {
		T databaseEntity = fakeDatabase.stream()
			.filter(dbEntity -> dbEntity.getId() == entity.getId())
            .findAny()
            .orElse(null);
		
		if (databaseEntity == null) {
			throw new Exception("The entity with the id " + entity.getId() + " was not found.");
		}
		
		int index = fakeDatabase.indexOf(databaseEntity);
		fakeDatabase.remove(index);
		fakeDatabase.add(index, entity);
		
		return entity;
	}

	@Override
	public T findById(long id) {
		return fakeDatabase.stream()
				.filter(dbEntity -> dbEntity.getId() == id)
	            .findAny()
	            .orElse(null);
	}
	
	@Override
	public T findBy(Predicate<? super T> condition) {
		return fakeDatabase.stream()
				.filter(condition)
	            .findAny()
	            .orElse(null);
	}

	@Override
	public List<T> findAll(Predicate<? super T> condition) {
		
		if (condition == null) {
			return fakeDatabase.stream().collect(Collectors.toList());
		}
		
		return fakeDatabase.stream().filter(condition).collect(Collectors.toList());
	}

	@Override
	public void removeById(long id) throws Exception {
		T dbEntity = this.findById(id);
		if (dbEntity == null) {
			throw new Exception("The entity with the id " + id + " was not found.");
		}
		
		fakeDatabase.remove(dbEntity);
	}
}
