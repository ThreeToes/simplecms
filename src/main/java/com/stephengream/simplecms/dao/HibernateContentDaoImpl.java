package com.stephengream.simplecms.dao;

import com.stephengream.simplecms.domain.model.Content;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stephen
 */
@Repository
public class HibernateContentDaoImpl extends AbstractHbnDao<Content> implements ContentDao {
    
}
