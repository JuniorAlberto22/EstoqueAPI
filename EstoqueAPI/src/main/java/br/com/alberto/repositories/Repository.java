package br.com.alberto.repositories;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import br.com.alberto.exceptions.RapierException;
import br.com.alberto.interfaces.defaults.IRepository;
import br.com.alberto.util.StringUtil;

@Stateful
public class Repository<T, Pk extends Serializable> implements IRepository<T, Pk>{

	private Class<T> classType;
	
	public Repository() {
		this.classType = (Class<T>)((T) new Object()).getClass();
	}
	
	@PersistenceContext
	protected EntityManager em;
	
	private Session getSession() {
		return (Session) em.getDelegate();
	}
	
	@Override
	public Serializable save(T entity) throws RapierException {
		try {
			return getSession().save(entity);
		} catch (Exception e) {
			String className = classType.getName();
			throw new RapierException(StringUtil.concat("Error when tried to save the entity: ", className));
		}
	}
	
	@Override
	public T update(T entity) throws RapierException {
		try {
			getSession().update(entity);
			return entity;
		} catch (Exception e) {
			String className = classType.getName();
			throw new RapierException(StringUtil.concat("Error when tried to update the entity: ", className));
		}
	}
	
	@Override
	public void delete(T entity) throws RapierException {
		try {
			getSession().delete(entity);
		} catch (Exception e) {
			String className = classType.getName();
			throw new RapierException(StringUtil.concat("Error when tried to delete the entity: ", className));
		}
	}

	@Override
	public void deleteById(Pk pk) throws RapierException {
		try {
			T entity = findById(pk);
			getSession().delete(entity);
		} catch (Exception e) {
			String className = classType.getName();
			throw new RapierException(StringUtil.concat("Error when tried to delete the entity: ", className));
		}
	}
	
	@Override
	public T findById(Pk pk) throws RapierException {
		try {
			return em.find(this.classType, pk);
		} catch (Exception e) {
			String className = classType.getName();
			throw new RapierException(StringUtil.concat("Error when tried to find by id the entity: ", className));
		}
	}
	
	@Override
	public List<T> list() throws RapierException{
		try {
			return getSession().createCriteria(classType).list();
		} catch (Exception e) {
			String className = classType.getName();
			throw new RapierException(StringUtil.concat("Error when tried to list the entity: ", className));
		}
	}
	
}
