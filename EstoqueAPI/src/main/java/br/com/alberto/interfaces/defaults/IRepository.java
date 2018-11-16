package br.com.alberto.interfaces.defaults;

import java.io.Serializable;
import java.util.List;

import br.com.alberto.exceptions.RapierException;

public interface IRepository<T, Pk extends Serializable> {

	public Serializable save(T entity) throws RapierException;
	
	public T update(T entity) throws RapierException;
	
	public void delete(T entity) throws RapierException;
	
	public T findById(Pk pk) throws RapierException;
	
	public List<T> list() throws RapierException;
}
