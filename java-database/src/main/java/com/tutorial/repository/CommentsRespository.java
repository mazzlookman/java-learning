package com.tutorial.repository;

import com.tutorial.entity.Comments;

import java.util.List;

public interface CommentsRespository {

    void insert(Comments comments);

    Comments findById(Integer id);

    List<Comments> findAll();

    List<Comments> findAllByEmail(String email);

}
