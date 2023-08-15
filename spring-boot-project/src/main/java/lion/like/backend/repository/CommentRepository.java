package lion.like.backend.repository;

import lion.like.backend.domain.Comment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Override
    @EntityGraph(attributePaths = {"user"})
    Optional<Comment> findById(Long postId);

    @Override
    @EntityGraph(attributePaths = {"user"})
    List<Comment>findAll();

}
