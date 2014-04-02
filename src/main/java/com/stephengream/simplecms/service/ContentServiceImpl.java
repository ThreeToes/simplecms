/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.stephengream.simplecms.service;

import com.stephengream.domain.model.Content;
import com.stephengream.simplecms.dao.ContentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Stephen
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentDao _contentDao;
    
    @Override
    public void create(Content content) {
        _contentDao.create(content);
    }

    @Override
    public Content getContent(Long id) {
        return _contentDao.get(id);
    }
    
    @Override
    public Iterable<Content> getAll(){
        return _contentDao.getAll();
    }
}
