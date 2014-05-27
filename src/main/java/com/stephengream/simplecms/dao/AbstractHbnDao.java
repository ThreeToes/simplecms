package com.stephengream.simplecms.dao;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.util.ReflectionUtils;

/**
 * Abstract base DAO to make implementations easier
 * @author Stephen
 */
public abstract class AbstractHbnDao<T extends Object> 
    implements Dao<T> {
    @Inject
    private SessionFactory sessionFactory;
    private Class<T> domainClass;
    
    /**
     * Get the session object
     * @return get the current session
     */
    protected Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }
    
    /**
     * Get the class being handled
     * @return The class type
     */
    @SuppressWarnings("unchecked")
    private Class<T> getDomainClass(){
        if(domainClass == null){
            ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }
    
    /**
     * Get the name of the class being held
     * @return The name of the class being handled
     */
    private String getDomainClassName(){
        return getDomainClass().getName();
    }
    
    /**
     * Create a row for the object t
     * @param t The object to insert into the database
     */
    @Override
    public void create(T t){
        Transaction tx = getSession().beginTransaction();
        Method method = ReflectionUtils.findMethod(getDomainClass(), "setDateCreated", new Class[]{Date.class});
        if(method != null){
            try{
                method.invoke(t, new Date());
            }catch(Exception e){/*Ignore*/}
        }
        getSession().persist(t);
        tx.commit();
    }
    
    /**
     * Get an object by ID
     * @param id The id of the object
     * @return The object
     */
    @Override
    public T get(Serializable id){
        Transaction tx = getSession().beginTransaction();
        final T t = (T) getSession().get(getDomainClass(), id);
        tx.commit();
        return t;
    }
    
    /**
     * Load an object by ID
     * @param id ID of the object
     * @return The object loaded
     */
    @Override
    public T load(Serializable id){
        Transaction tx = getSession().beginTransaction();
        T t = (T) getSession().get(getDomainClass(), id);
        tx.commit();
        return t;
    }
    
    /**
     * Get all instances of T from the database
     * @return All instances of T
     */
    @Override
    public List<T> getAll(){
        Transaction tx = getSession().beginTransaction();
        final List list = getSession()
                .createQuery("from " + getDomainClassName())
                .list();
        tx.commit();
        return list;
    }
    
    /**
     * Delete t from the database
     * @param t Object to delete
     */
    @Override
    public void delete(T t){
        Transaction tx = getSession().beginTransaction();
        getSession().delete(t);
        tx.commit();
    }
    
    /**
     * Update an object in the database
     * @param t The object to update
     */
    @Override
    public void update(T t){
        Transaction tx = getSession().beginTransaction();
        getSession().persist(t);
        tx.commit();
    }
    
    /**
     * Delete an object from the database
     * @param id ID of the object to delete
     */
    @Override
    public void deleteById(Serializable id){
        Transaction tx = getSession().beginTransaction();
        delete(load(id));
        tx.commit();
    }
    
    /**
     * Delete all instances of T in the database
     */
    @Override
    public void deleteAll(){
        Transaction tx = getSession().beginTransaction();
        getSession()
                .createQuery("delete " + getDomainClassName())
                .executeUpdate();
        tx.commit();
    }
    
    /**
     * The count of instances of T in the database
     * @return 
     */
    @Override
    public long count(){
        Transaction tx = getSession().beginTransaction();
        final Long count = (Long) getSession()
                .createQuery("select count(*) from " + getDomainClassName())
                .uniqueResult();
        tx.commit();
        return count;
    }
    
    /**
     * If object with ID id exists in the database
     * @param id ID to check
     * @return Whether the instance exists
     */
    @Override
    public boolean exists(Serializable id){
        return get(id) != null;
    }
}
