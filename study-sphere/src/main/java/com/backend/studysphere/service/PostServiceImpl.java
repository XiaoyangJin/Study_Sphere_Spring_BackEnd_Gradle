package com.backend.studysphere.service;

import com.backend.studysphere.dao.PostRepository;
import com.backend.studysphere.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository thePostRepository){
        postRepository = thePostRepository;
    }

    @Override
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    @Override
    public Post findById(long theId){
        Optional<Post> result = postRepository.findById(theId);

        Post thePost = null;

        if(result.isPresent()){
            thePost = result.get();
        } else{
            //didn't find the post
            throw new RuntimeException("Did not find post id - " + theId);
        }
        return thePost;
    }

    @Override
    public Post save(Post thePost){
        return postRepository.save(thePost);
    }

    @Override
    public void deleteById(long theId){
        postRepository.deleteById(theId);
    }
}
