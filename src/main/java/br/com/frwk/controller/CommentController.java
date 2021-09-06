package br.com.frwk.controller;

import br.com.frwk.requests.CommentRequestBody;
import br.com.frwk.requests.DeletePostORCommentRequestBody;
import br.com.frwk.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentRequestBody> create(@RequestBody @Valid CommentRequestBody commentRequestBody){
        return ResponseEntity.ok(commentService.create(commentRequestBody));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> create(@RequestBody @Valid DeletePostORCommentRequestBody deletePostORCommentRequestBody){
        return ResponseEntity.ok(commentService.delete(deletePostORCommentRequestBody));
    }


}
