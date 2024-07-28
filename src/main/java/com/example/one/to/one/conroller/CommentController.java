package com.example.one.to.one.conroller;


import com.example.one.to.one.entity.Comment;
import com.example.one.to.one.serive.CommentService;
import com.example.one.to.one.serive.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;

    @Autowired
    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(
            @Valid @RequestBody Comment comment,
            @RequestParam long postId
    ) {
        Comment savedEntity = postService.createComment(comment, postId);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @Valid @RequestBody Comment commentDetails) {
        Comment updatedComment = commentService.updateComment(id, commentDetails);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}