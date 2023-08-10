package lion.like.backend.service;

import jakarta.transaction.Transactional;
import lion.like.backend.domain.Comment;
import lion.like.backend.domain.Post;
import lion.like.backend.domain.User;
import lombok.RequiredArgsConstructor;
import lion.like.backend.dto.Comment.CommentRequest;
import lion.like.backend.repository.CommentRepository;
import lion.like.backend.repository.PostRepository;
import lion.like.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {
 
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
 
    /* CREATE */
    @Transactional
    public Long commentSave( Long id, CommentRequest dto) {
        Optional<User> targetUser = userRepository.findById(id);
        Post post = postRepository.findById(id).orElseThrow(() ->
                                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + id));
        User user=targetUser.get();

        dto.setUser(user);
        dto.setPost(post);
 
        Comment comment = dto.toEntity();
        commentRepository.save(comment);
 
        return dto.getId();
    }
}