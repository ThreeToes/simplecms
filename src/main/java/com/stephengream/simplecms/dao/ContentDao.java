package com.stephengream.simplecms.dao;

import com.stephengream.simplecms.domain.model.Content;

/**
 *
 * @author Stephen
 */
public interface ContentDao extends Dao<Content> {
    public void create(Content content);
}
