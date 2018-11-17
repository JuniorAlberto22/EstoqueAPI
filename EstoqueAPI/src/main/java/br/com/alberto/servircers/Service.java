package br.com.alberto.servircers;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.alberto.exceptions.RapierException;
import br.com.alberto.interfaces.defaults.IRepository;
import br.com.alberto.interfaces.defaults.IService;
import br.com.alberto.repositories.Repository;

public class Service<T, Pk extends Serializable> implements IService<T, Pk>{

	@Inject
	private IRepository<T, Pk> repository = new Repository<T, Pk>();
	
	@Override
	public Serializable save(T entity) throws RapierException {
		return this.repository.save(entity);
	}

	@Override
	public T update(T entity) throws RapierException {
		return this.repository.update(entity);
	}

	@Override
	public void delete(T entity) throws RapierException {
		this.repository.delete(entity);
		
	}

	@Override
	public void deleteById(Pk pk) throws RapierException {
		this.repository.deleteById(pk);
	}

	@Override
	public T findById(Pk pk) throws RapierException {
		return this.repository.findById(pk);
	}

	@Override
	public List<T> list() throws RapierException {
		return this.repository.list();
	}

}
