package org.example.controller;

import org.example.domain.Comment;
import org.example.dto.CommentDto;
import org.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    private CommentDto toEntity(CommentDto commentDto ){
        return new CommentDto(commentDto.commentId(), commentDto.description(), commentDto.taskId());
    }
    private Comment toDto(Comment comment){
        return new Comment(comment.getCommentId(), comment.getDescription(), comment.getTaskId());
    }

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
        return ResponseEntity.ok().body(commentService.addComment(comment));
    }
//     @PostMapping("/create")
//     public ResponseEntity<CommentDto> createComment(@RequestBody)


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable String id){
        final  var comment1=commentService.getCommentById(id);
        if(comment1.isPresent()){
            commentService.deleteCommentById(id);
            return ResponseEntity.ok().body(comment1.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/view/{taskId}")
    public ResponseEntity <Optional<List<Comment>>> getAllCommentsByTaskId(@PathVariable String taskId){
         Optional<List<Comment>> commentOptional=commentService.getComment(taskId);
        if (commentOptional.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(Optional.of(commentOptional.get()));
    }

}
