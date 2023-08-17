package lion.like.backend.service;

import jakarta.transaction.Transactional;
import lion.like.backend.domain.Comment;
import lion.like.backend.domain.Post;
import lion.like.backend.domain.User;
import lion.like.backend.dto.Comment.CommentRequest;
import lion.like.backend.dto.Comment.CommentResponse;
import lion.like.backend.repository.CommentRepository;
import lion.like.backend.repository.PostRepository;
import lion.like.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {
 
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
 
    /* CREATE */
    @Transactional
    public Long save(String username, Long id, CommentRequest dto) {//id: postid
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패" + username));
        Post post = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + id));
        dto.setUser(user);
        dto.setPost(post);

        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return dto.getId();
    }
    /* READ */
    @Transactional
    public List<CommentResponse> findAll(Long id) {//postId
        Post post = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));
        List<Comment> comments = post.getComments();
        return comments.stream().map(CommentResponse::new).collect(Collectors.toList());
    }
}