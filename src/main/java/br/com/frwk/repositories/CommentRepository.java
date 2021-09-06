package br.com.frwk.repositories;

import br.com.frwk.models.Comment;
import br.com.frwk.models.Post;
import br.com.frwk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

    Optional<List<Comment>> findByUserAndPost(User user, Post post);
}
