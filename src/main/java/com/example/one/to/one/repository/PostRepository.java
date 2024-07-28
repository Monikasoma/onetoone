package com.example.one.to.one.repository;

import com.example.one.to.one.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}