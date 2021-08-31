package br.com.frwk.controller;


import br.com.frwk.models.Post;
import br.com.frwk.requests.PostRequestBody;
import br.com.frwk.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/post")
@AllArgsConstructor
public class PostController {

    private final PostService service;


    @PostMapping
    public ResponseEntity<Post> create(@Valid PostRequestBody postRequestBody){
        return ResponseEntity.ok(service.create(postRequestBody));
    }
}