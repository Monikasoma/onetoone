package com.example.one.to.one.serive;


import com.example.one.to.one.entity.Comment;
import com.example.one.to.one.entity.Post;
import com.example.one.to.one.repository.CommentRepository;
import com.example.one.to.one.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Comment createComment(Comment comment, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @Override
    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(postDetails.getTitle());
        post.setDescription(postDetails.getDescription());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }
}