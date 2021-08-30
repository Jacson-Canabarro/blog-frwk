package br.com.frwk.controller;


import br.com.frwk.models.User;
import br.com.frwk.requests.UserPostRequestBody;
import br.com.frwk.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<User> create(UserPostRequestBody userPostRequestBody){
        return ResponseEntity.ok(userService.create(userPostRequestBody));

    }


}
