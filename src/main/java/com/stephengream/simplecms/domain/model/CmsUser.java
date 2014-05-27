/*
 * Copyright (C) Error: on line 4, column 33 in Templates/Licenses/license-gpl20.txt
 The string doesn't match the expected date/time format. The string to parse was: "12/05/2014". The expected format was: "MMM d, yyyy". Stephen
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

package com.stephengream.simplecms.domain.model;

import com.stephengream.simplecms.domain.utilities.PasswordHash;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Stephen
 */
@Entity(name = "cmsuser")
public class CmsUser implements Serializable {
    private Long id;
    private String username;

    @NotNull
    @Column(name = "username", length = 32, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @Column(name = "pass_hash")
    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    @NotNull
    @Column(name = "display_name")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @NotNull
    @Column(name = "is_locked")
    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }
    private String passHash;
    private String displayName;
    private String email;

    @Column(name = "email", length = 512, nullable = false)
    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private Boolean isLocked;
    private Set<Role> roles;

    @ManyToMany(
            targetEntity = com.stephengream.simplecms.domain.model.Role.class,
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}
            )
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        //Lazy initialisation falls over if this is called outside of a session
        this.roles = new HashSet<>(roles);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Hash the password and set it
     * @param unhashed The plain text
     */
    public void setUnhashedPassword(String unhashed){
        try {
            setPassHash(PasswordHash.createHash(unhashed));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(CmsUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
