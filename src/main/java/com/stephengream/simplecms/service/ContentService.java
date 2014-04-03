/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.stephengream.simplecms.service;

import com.stephengream.simplecms.domain.model.Content;
import org.springframework.stereotype.Service;

/**
 *
 * @author Stephen
 */
public interface ContentService {
    public void create(Content content);
    public Content getContent(Long id);

    Iterable<Content> getAll();
}
