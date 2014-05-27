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
import com.stephengream.simplecms.domain.model.Role;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stephen
 */
@Repository
public class HibernateRoleDaoImpl extends AbstractHbnDao<Role> implements RoleDao{

    @Override
    public Role loadByName(String name) {
        Role ret = null;
        Session sess = getSession();
        Transaction tx = sess.beginTransaction();
        try{
            Criteria criteria = sess.createCriteria(Role.class);
            criteria.add(Restrictions.eq("roleName", name));
            ret = (Role)criteria.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            throw e;
        }
        return ret;
    }
    
}
