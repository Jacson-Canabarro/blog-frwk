package br.com.frwk.controller;


import br.com.frwk.requests.UserPostRequestBody;
import br.com.frwk.responses.UserReponseBody;
import br.com.frwk.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<UserReponseBody>getById(Authentication authenticate){
        return ResponseEntity.ok(userService.getUserById(authenticate));
    }

    @PostMapping
    public ResponseEntity<UserReponseBody> create(@RequestBody @Valid UserPostRequestBody userPostRequestBody){
        return ResponseEntity.ok(userService.create(userPostRequestBody));
    }


}
