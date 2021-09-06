package br.com.frwk.services;

import br.com.frwk.exceptions.BadRequestException;
import br.com.frwk.mappers.PostMapper;
import br.com.frwk.models.Image;
import br.com.frwk.models.Post;
import br.com.frwk.models.User;
import br.com.frwk.repositories.ImageRepository;
import br.com.frwk.repositories.PostRepository;
import br.com.frwk.repositories.UserRepository;
import br.com.frwk.requests.DeletePostORCommentRequestBody;
import br.com.frwk.requests.ImageRequestBody;
import br.com.frwk.requests.PostRequestBody;
import br.com.frwk.responses.CommentResponseBody;
import br.com.frwk.responses.PostResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;
    private static final String USER_MSG = "the user id is not valid";


    @Transactional
    public PostResponseBody create(PostRequestBody postRequestBody) {
        Post post = PostMapper.INSTANCE.toPost(postRequestBody);
        User user = userRepository.findById(postRequestBody.getUserId())
                .orElseThrow(() -> new BadRequestException(USER_MSG));
        post.setUser(user);
        Post savePost = repository.save(post);
        Image image = new Image();
        if (postRequestBody.getImage() != null) {
            byte[] decodedBytes = Base64.getDecoder().decode(postRequestBody.getImage().getContent());
            image.setContent(decodedBytes);
            image.setName(postRequestBody.getImage().getName());
            image.setPost(savePost);
        }
        imageRepository.save(image);
        PostResponseBody postResponseBody = PostMapper.INSTANCE.toPostResponseBody(savePost);
        postResponseBody.setUserId(user.getId());
        return postResponseBody;
    }

    public List<PostResponseBody> getAll() {
        List<PostResponseBody> list = new ArrayList<>();

        List<Post> posts = repository.findAll();
        posts.forEach(p -> {
            List<CommentResponseBody> commentResponseBodies = new ArrayList<>();
            ImageRequestBody imageRequestBody = new ImageRequestBody();
            PostResponseBody postResponseBody = PostMapper.INSTANCE.toPostResponseBody(p);
            postResponseBody.setUserId(p.getUser().getId());
            if (p.getImages() != null) {
                p.getImages().forEach(i -> {
                    String base64 = Base64Utils.encodeToString(i.getContent());
                    imageRequestBody.setContent(base64);
                    imageRequestBody.setName(i.getName());
                });
            }
            p.getComments().forEach(c -> {
                CommentResponseBody build = new CommentResponseBody();
                build.setUserID(c.getUser().getId());
                build.setText(c.getText());
                commentResponseBodies.add(build);
            });

            postResponseBody.setComments(commentResponseBodies);
            postResponseBody.setImage(imageRequestBody);
            list.add(postResponseBody);
        });
        return list;
    }


    @Transactional
    public Boolean deleteByAuthor(DeletePostORCommentRequestBody postRequestBody) {
        User user = userRepository.findById(postRequestBody.getUserId())
                .orElseThrow(() -> new BadRequestException("this post doesn't belong to you"));
        Post post = repository.findById(postRequestBody.getPostId())
                .orElseThrow(() -> new BadRequestException("the Post id is invalid"));
        repository.deleteByIdAndUser(post.getId(), user);
        return true;
    }

    public PostResponseBody update(PostRequestBody postRequestBody) {
        if (postRequestBody.getPostId() == null) {
            throw new BadRequestException("the post id is required");
        }
        Post post = repository.findById(postRequestBody.getPostId())
                .orElseThrow(() -> new BadRequestException("the post id is not valid"));
        post.setText(postRequestBody.getText());
        if (postRequestBody.getImage() != null) {
/*            Image image = imageRepository.save(postRequestBody.getImage());
            post.setImages(List.of(image));*/
        }
        return PostMapper.INSTANCE.toPostResponseBody(repository.save(post));
    }
}
