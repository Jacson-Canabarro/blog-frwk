package br.com.frwk.controller;


import br.com.frwk.requests.DeletePostORCommentRequestBody;
import br.com.frwk.requests.PostRequestBody;
import br.com.frwk.responses.PostResponseBody;
import br.com.frwk.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/post")
@AllArgsConstructor
public class PostController {

    private final PostService service;



    @GetMapping
    public ResponseEntity<List<PostResponseBody>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<PostResponseBody> create(@RequestBody @Valid PostRequestBody postRequestBody){
        return ResponseEntity.ok(service.create(postRequestBody));
    }


    @DeleteMapping
    public ResponseEntity<Boolean> deleteByAuthor(@RequestBody @Valid DeletePostORCommentRequestBody deletePostORCommentRequestBody){
        return ResponseEntity.ok(service.deleteByAuthor(deletePostORCommentRequestBody));
    }


    @PutMapping
    public ResponseEntity<PostResponseBody> update(@RequestBody @Valid PostRequestBody postRequestBody){
        return ResponseEntity.ok(service.update(postRequestBody));
    }

}
