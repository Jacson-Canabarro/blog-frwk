package br.com.frwk.services;

import br.com.frwk.mappers.UserMapper;
import br.com.frwk.models.User;
import br.com.frwk.repositories.UserRepository;
import br.com.frwk.requests.UserPostRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public User create(UserPostRequestBody postRequestBody) {
        User user =  userRepository.save(UserMapper.INSTANCE.toUser(postRequestBody));
        user.setPassword(null);
        return user;
    }
}
