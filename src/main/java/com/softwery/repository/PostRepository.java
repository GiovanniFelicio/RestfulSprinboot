/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwery.repository;

import com.softwery.models.Post;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author engcarvalho
 */
@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {
    
    @Query(value = "SELECT p FROM Post p WHERE p.author LIKE %:author%")
    List<Post> findPostsByAuthor(@Param("author") String author);
}
