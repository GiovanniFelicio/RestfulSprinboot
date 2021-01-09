package com.softwery.utils;


import com.softwery.models.Post;
import com.softwery.repository.PostRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author engcarvalho
 */
@Component
public class SeederPostUtils {
    
    @Autowired
    private PostRepository postRepository;
    
//    @PostConstruct
    public void seederPosts() {
        
        List<Post> posts = new ArrayList<>();
        
        Post post1 = new Post();
        post1.setAuthor("Giovanni Felicio Carvalho");
        post1.setTitle("Laravel");
        post1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc non enim auctor lorem mattis auctor sed ut nulla. Cras eu egestas dolor, vitae porta odio.");
//        post1.setDateTime(LocalDate.now());
        
        posts.add(post1);
        
        Post post2 = new Post();
        post2.setAuthor("Giovanni Felicio Carvalho");
        post2.setTitle("Django");
        post2.setText("Vivamus pharetra dui enim, non aliquet purus tempus et. In hac habitasse platea dictumst. Donec scelerisque ligula sit amet bibendum lobortis.");
//        post2.setDateTime(LocalDate.now());
        
        posts.add(post2);
        
        Post post3 = new Post();
        post3.setAuthor("Giovanni Felicio Carvalho");
        post3.setTitle("Spring Boot");
        post3.setText("Pellentesque quis venenatis nibh, tempus scelerisque mauris. Ut mattis tempus justo, quis volutpat magna tincidunt nec.");
//        post3.setDateTime(LocalDate.now());
        
        posts.add(post3);
        
        Post post4 = new Post();
        post4.setAuthor("Giovanni Felicio Carvalho");
        post4.setTitle("Vue.Js");
        post4.setText("Aenean in congue tortor, at lobortis quam. Curabitur aliquam placerat malesuada. Sed est est, tempus sit amet enim eget, egestas fermentum lorem.");
//        post4.setDateTime(LocalDate.now());
        
        posts.add(post4);
        
        for (Post post : posts) {
            Post postSaved = postRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
    
}
