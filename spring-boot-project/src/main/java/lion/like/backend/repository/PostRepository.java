package lion.like.backend.repository;

import lion.like.backend.domain.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    @EntityGraph(attributePaths = {"user"})
    Optional<Post> findById(Long postId);
    @Override
    @EntityGraph(attributePaths = {"user"})
    List<Post>findAll();

}

