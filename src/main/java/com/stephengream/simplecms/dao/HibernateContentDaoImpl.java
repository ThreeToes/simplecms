/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.stephengream.simplecms.dao;

import com.stephengream.domain.model.Content;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stephen
 */
@Repository
public class HibernateContentDaoImpl extends AbstractHbnDao<Content> implements ContentDao {
    
}
