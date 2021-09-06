package br.com.frwk.services;

import br.com.frwk.exceptions.BadRequestException;
import br.com.frwk.mappers.CommentMapper;
import br.com.frwk.models.Comment;
import br.com.frwk.models.Post;
import br.com.frwk.models.User;
import br.com.frwk.repositories.CommentRepository;
import br.com.frwk.repositories.PostRepository;
import br.com.frwk.repositories.UserRepository;
import br.com.frwk.requests.CommentRequestBody;
import br.com.frwk.requests.DeletePostORCommentRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository repository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    public CommentRequestBody create(CommentRequestBody commentRequestBody){
        User user = userRepository.findById(commentRequestBody.getUserId()).orElseThrow(() -> new BadRequestException("User id is not valid"));
        Post post = postRepository.findById(commentRequestBody.getPostId()).orElseThrow(() -> new BadRequestException("the post id is not valid."));
        Comment comment = CommentMapper.INSTANCE.toComment(commentRequestBody);
        comment.setUser(user);
        comment.setPost(post);
        repository.save(comment);
        return commentRequestBody;
    }


    public Boolean delete(DeletePostORCommentRequestBody deleteRequestBody){
        User user = userRepository.findById(deleteRequestBody.getUserId()).orElseThrow(() -> new BadRequestException("User id is not valid"));
        Post post = postRepository.findById(deleteRequestBody.getPostId()).orElseThrow(() -> new BadRequestException("the post id is not valid."));
        List<Comment> comments = repository.findByUserAndPost(user, post).orElseThrow(() -> new BadRequestException("this comment doesn't belong to you"));
        repository.deleteAll(comments);
        return true;
    }




}
