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

package com.stephengream.simplecms.service;

import com.stephengream.simplecms.domain.model.CmsUser;
import org.springframework.stereotype.Service;

/**
 *
 * @author Stephen
 */
@Service
public interface UserService {
    /**
     * Load a user object by username
     * @param username The username to find
     * @return The CMS user
     */
    public CmsUser loadCmsUserByName(String username);
    /**
     * Save a user's details
     * @param user The user to save
     */
    public void saveUser(CmsUser user);
    /**
     * See if a user exists
     * @param username The user name to check
     */
    public Boolean hasUser(String username);
    
    /**
     * Create a new user
     * @param username
     * @param password Plain text password
     */
    public void createUser(String username, String password, String email);
}
