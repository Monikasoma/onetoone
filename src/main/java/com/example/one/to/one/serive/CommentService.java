package com.example.one.to.one.serive;
import com.example.one.to.one.entity.Comment;

public interface CommentService {
    Comment getCommentById(Long id);
    Comment updateComment(Long id, Comment commentDetails);
    void deleteComment(Long id);
}