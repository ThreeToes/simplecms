/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.stephengream.simplecms.dao;

import com.stephengream.domain.model.Content;

/**
 *
 * @author Stephen
 */
public interface ContentDao extends Dao<Content> {
    public void create(Content content);
}
