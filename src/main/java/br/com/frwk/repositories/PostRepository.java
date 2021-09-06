package br.com.frwk.repositories;

import br.com.frwk.models.Post;
import br.com.frwk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findByUser(User user);

    void deleteByIdAndUser(UUID uuid, User user);


}
