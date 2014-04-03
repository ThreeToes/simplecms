package com.stephengream.simplecms.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Stephen
 * @param <T> Type to store in the database
 */
public interface Dao<T extends Object> {
    /**
     * Create t
     * @param t The object to insert into the database 
     */
    void create(T t);
    /**
     * Get an object by id
     * @param id
     * @return the object with ID id
     */
    T get(Serializable id);
    /**
     * Load an object by ID
     * @param id
     * @return the loaded object
     */
    T load(Serializable id);
    /**
     * Get all objects of type T from the database
     * @return All instances of T
     */
    List<T> getAll();
    /**
     * Update t in the database
     * @param t The object to update
     */
    void update(T t);
    /**
     * Delete t from the database
     * @param t The object to delete
     */
    void delete(T t);
    /**
     * Delete an object by id
     * @param id ID of the object to delete
     */
    void deleteById(Serializable id);
    /**
     * Delete all instances of T from the database
     */
    void deleteAll();
    /**
     * Count of T in the database
     * @return 
     */
    long count();
    /**
     * See if object with ID id exists
     * @param id ID to check
     * @return Whether the ID exists
     */
    boolean exists(Serializable id);
}
