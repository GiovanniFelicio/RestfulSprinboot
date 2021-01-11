/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwery.endpoint;

import com.google.gson.Gson;
import com.softwery.error.ResourceNotFoundException;
import com.softwery.models.Post;
import com.softwery.repository.PostRepository;
import com.softwery.utils.DateUtil;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author engcarvalho
 */
@RestController
@RequestMapping(value = "/posts", method = RequestMethod.GET)
public class PostEndpoint {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private DateUtil dateUtil;

    @GetMapping(path = "/list")
    public ResponseEntity<?> listPost(Pageable pageable) {

        return new ResponseEntity<>(postRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasRole('ADMINN')")
    public ResponseEntity<?> getPostById(@PathVariable("id") Long id) {

        Post post = getIfPostExists(id);

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping(path = "/author/{name}")
    public ResponseEntity<?> getPostByAuthor(@PathVariable("name") String name) {

        return new ResponseEntity<>(postRepository.findPostsByAuthor(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Post post) {

        postRepository.save(post);
        
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Post post) {

        post = getIfPostExists(post.getId());

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        Post post = getIfPostExists(id);

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    private Post getIfPostExists(Long id) {
        Optional optional = postRepository.findById(id);

        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Post Not Found");
        }

        Post post = (Post) optional.get();

        return post;
    }
}