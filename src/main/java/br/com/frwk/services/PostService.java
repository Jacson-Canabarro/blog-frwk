package br.com.frwk.services;

import br.com.frwk.mappers.PostMapper;
import br.com.frwk.models.Post;
import br.com.frwk.models.User;
import br.com.frwk.repositories.PostRepository;
import br.com.frwk.repositories.UserRepository;
import br.com.frwk.requests.PostRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;
    private final UserRepository userRepository;


    public Post create(PostRequestBody postRequestBody){
        Post post = PostMapper.INSTANCE.toPost(postRequestBody);
        User user = userRepository.findById(postRequestBody.getUserId())
                .orElseThrow(() -> new UsernameNotFoundException("the user id is not valid"));
        post.setUser(user);
        return repository.save(post);
    }
}
