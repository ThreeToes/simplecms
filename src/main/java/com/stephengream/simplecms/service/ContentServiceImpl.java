/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.stephengream.simplecms.service;

import com.stephengream.simplecms.domain.model.Content;
import com.stephengream.simplecms.dao.ContentDao;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Stephen
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Inject
    private ContentDao contentDao;
    
    @Override
    @Transactional
    public void create(Content content) {
        contentDao.create(content);
    }

    @Override
    @Transactional
    public Content getContent(Long id) {
        return contentDao.get(id);
    }
    
    @Override
    @Transactional
    public Iterable<Content> getAll(){
        return contentDao.getAll();
    }
}
