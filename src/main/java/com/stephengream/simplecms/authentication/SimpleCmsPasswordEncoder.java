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

import com.stephengream.simplecms.domain.utilities.PasswordHash;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Stephen
 */
public class SimpleCmsPasswordEncoder implements PasswordEncoder{

    @Override
    public String encode(CharSequence cs) {
        String pt = cs.toString();
        try {
            return PasswordHash.createHash(pt);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(SimpleCmsPasswordEncoder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean matches(CharSequence submitted, String retrieved) {
        Logger.getLogger(SimpleCmsPasswordEncoder.class.getName())
                .log(Level.INFO, "submitted = " + submitted.toString() + ", retrieved = " + retrieved);
        try {
            //String hash = PasswordHash.createHash(submitted.toString());
            return PasswordHash.validatePassword(submitted.toString(), retrieved);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(SimpleCmsPasswordEncoder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
