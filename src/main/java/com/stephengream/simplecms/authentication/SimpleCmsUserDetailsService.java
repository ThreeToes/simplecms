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

package com.stephengream.simplecms.authentication;

import com.stephengream.simplecms.dao.UserDao;
import com.stephengream.simplecms.domain.model.CmsUser;
import com.stephengream.simplecms.domain.model.Role;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import org.jboss.logging.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Class to integrate our user type with 
 * @author Stephen
 */
public class SimpleCmsUserDetailsService implements UserDetailsService{
    @Inject
    private UserDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CmsUser u = userDao.loadByUsername(username);
        if(u == null){
            throw new UsernameNotFoundException(username + " not found");
        }
        HashSet<GrantedAuthority> roles = new HashSet<>();
        try{
            final Set<Role> userRoles = u.getRoles();
            if(userRoles != null && userRoles.size() > 0){
                for(Role role : userRoles){
                    roles.add(new SimpleGrantedAuthority(role.getRoleName()));
                }
            }
        }catch(Exception e){
            Logger.getLogger(UserDetails.class.getName()).log(Logger.Level.INFO, e.getStackTrace());
        }
        
        return new User(u.getUsername(), u.getPassHash(), roles);
    }
    
}
