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
import java.util.Set;

/**
 *
 * @author Stephen
 */
public interface UserDao extends Dao<CmsUser>{
    /**
     * Check to see if a username/password combination is valid
     * @param username
     * @param passwordHash
     * @return 
     */
    Boolean isValid(String username, String passwordHash);
    
    /**
     * Load a user object by username
     * @param username
     * @return 
     */
    CmsUser loadByUsername(String username);
    
    /**
     * Create a new user
     * @param username
     * @param password
     * @return 
     */
    CmsUser createNewUser(String username, String password, String email, Set<Role> roles);
}
