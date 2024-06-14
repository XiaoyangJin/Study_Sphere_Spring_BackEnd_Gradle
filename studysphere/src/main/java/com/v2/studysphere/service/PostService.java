package com.v2.studysphere.service;

import com.v2.studysphere.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {
    List<Post> findAll();
    Optional<Post> findById(Long id);
    Post save(Post post);
    void deleteById(Long id);
}
