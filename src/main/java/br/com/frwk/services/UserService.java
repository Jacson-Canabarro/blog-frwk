package br.com.frwk.services;

import br.com.frwk.exceptions.BadRequestException;
import br.com.frwk.mappers.UserMapper;
import br.com.frwk.models.User;
import br.com.frwk.repositories.UserRepository;
import br.com.frwk.requests.UserPostRequestBody;
import br.com.frwk.responses.UserReponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email){
        return Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Transactional
    public UserReponseBody create(UserPostRequestBody postRequestBody){
        User userRepositoryByEmail = userRepository.findByEmail(postRequestBody.getEmail());
        if (userRepositoryByEmail != null){
            throw new BadRequestException("the e-mail is already registered");
        }
        User userMapper = UserMapper.INSTANCE.toUser(postRequestBody);
        userMapper.setPassword(passwordEncoder.encode(postRequestBody.getPassword()));
        User user =  userRepository.save(userMapper);
        return UserMapper.INSTANCE.toUserResponseBody(user);
    }
}
