package br.com.frwk.controller;


import br.com.frwk.models.User;
import br.com.frwk.requests.UserPostRequestBody;
import br.com.frwk.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@Valid UserPostRequestBody userPostRequestBody){
        return ResponseEntity.ok(userService.create(userPostRequestBody));
    }


}
