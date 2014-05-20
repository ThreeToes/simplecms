/*
 * Copyright (C) 2014 Stephen
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package com.stephengream.simplecms.dao;

import com.stephengream.simplecms.domain.model.CmsUser;
import com.stephengream.simplecms.domain.utilities.PasswordHash;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl.CriterionEntry;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stephen
 */
@Repository
public class HibernateUserDaoImpl extends AbstractHbnDao<CmsUser> implements UserDao{

    @Override
    public Boolean isValid(String username, String password) {
        Boolean ret = false;
        CmsUser user = loadByUsername(username);
        String correctHash = user.getPassHash();
        try{
        ret = !user.getIsLocked() && PasswordHash.validatePassword(password, correctHash);
        }catch(NoSuchAlgorithmException e){
            //I hate check exceptions, they were a dumb idea
            Logger.getLogger(HibernateUserDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(HibernateUserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return ret;
    }

    @Override
    public CmsUser loadByUsername(String username) {
        CmsUser ret = null;
        Session sess = getSession();
        Transaction tx = sess.beginTransaction();
        try{
            Criteria criteria = sess.createCriteria(CmsUser.class);
            criteria.add(Restrictions.eq("username", username));
            ret = (CmsUser)criteria.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            throw e;
        }
        return ret;
    }

    @Override
    public CmsUser createNewUser(String username, String password) {
        try {
            String hash = PasswordHash.createHash(password);
            CmsUser user = new CmsUser();
            user.setDisplayName(username);
            user.setUsername(username);
            user.setIsLocked(false);
            user.setPassHash(hash);
            this.create(user);
            return user;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HibernateUserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(HibernateUserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
