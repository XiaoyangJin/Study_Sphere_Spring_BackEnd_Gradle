package com.backend.studysphere.service;

import com.backend.studysphere.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post findById(long theId);

    Post save(Post thePost);

    void deleteById(long theId);
}
