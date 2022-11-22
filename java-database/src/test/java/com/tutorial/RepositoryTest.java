package com.tutorial;

import com.tutorial.entity.Comments;
import com.tutorial.repository.CommentsRepositoryImpl;
import com.tutorial.repository.CommentsRespository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RepositoryTest {

    private CommentsRespository commentsRespository;

    @BeforeEach
    void setUp() {
        commentsRespository = new CommentsRepositoryImpl();
    }

    @Test
    void testInsert(){
        Comments comments = new Comments("mohammad@test.com","hai");
        commentsRespository.insert(comments);

        Assertions.assertNotNull(comments.getId());
        System.out.println(comments.getId());
    }

    @Test
    void testFindById(){
        Comments comments = commentsRespository.findById(3307);
        Assertions.assertNotNull(comments);
        System.out.println(comments.getId());
        System.out.println(comments.getEmail());
        System.out.println(comments.getComment());

        Comments notFound = commentsRespository.findById(10000);
        Assertions.assertNull(notFound);
    }

    @Test
    void testFindAll(){
        List<Comments> comments = commentsRespository.findAll();
        System.out.println(comments.size());
    }

    @Test
    void testFindByEmail(){
        List<Comments> comments = commentsRespository.findAllByEmail("ai@test.com");
        System.out.println(comments.size());
    }

}
