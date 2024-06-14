package com.backend.studysphere.rest;

import com.backend.studysphere.dao.PostRepository;
import com.backend.studysphere.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostRepository postRepository;

    @Test
    public void testCreatePost() throws Exception{
        Post post = new Post();
        Post savedPost = new Post();

    }
}
