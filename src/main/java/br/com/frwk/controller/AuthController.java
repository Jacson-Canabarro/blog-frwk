package br.com.frwk.controller;

import br.com.frwk.requests.UserAuthRequestBody;
import br.com.frwk.responses.TokenResponseBody;
import br.com.frwk.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenResponseBody> auth(@RequestBody @Valid UserAuthRequestBody authRequestBody){
        UsernamePasswordAuthenticationToken data = authRequestBody.converter();
        try {
            Authentication authenticate = authManager.authenticate(data);
            String token = tokenService.generateToken(authenticate);
            return ResponseEntity.ok(new TokenResponseBody(token, "Bearer"));
        }catch (AuthenticationException ex){
            return ResponseEntity.badRequest().build();
        }

    }

}
