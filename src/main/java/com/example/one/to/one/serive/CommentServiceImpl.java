package com.example.one.to.one.serive;


import com.example.one.to.one.entity.Comment;
import com.example.one.to.one.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    @Override
    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.setEmail(commentDetails.getEmail());
        comment.setContent(commentDetails.getContent());
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        commentRepository.delete(comment);
    }
}