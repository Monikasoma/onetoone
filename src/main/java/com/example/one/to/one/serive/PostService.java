package com.example.one.to.one.serive;


import com.example.one.to.one.entity.Comment;
import com.example.one.to.one.entity.Post;

public interface PostService {
    Post createPost(Post post);
    Comment createComment(Comment comment, long postId);
    Post getPostById(Long id);
    Post updatePost(Long id, Post postDetails);
    void deletePost(Long id);
}
