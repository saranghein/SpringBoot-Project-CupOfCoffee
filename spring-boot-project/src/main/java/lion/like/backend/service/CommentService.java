package lion.like.backend.service;

import jakarta.transaction.Transactional;
import lion.like.backend.domain.Comment;
import lion.like.backend.domain.Post;
import lion.like.backend.domain.User;
import lion.like.backend.dto.Comment.CommentResponse;
import lombok.RequiredArgsConstructor;
import lion.like.backend.dto.Comment.CommentRequest;
import lion.like.backend.repository.CommentRepository;
import lion.like.backend.repository.PostRepository;
import lion.like.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {
 
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
 
    /* CREATE */
    @Transactional
    public Long commentSave(String username, Long id, CommentRequest dto) {//id: postid
        //Optional<User> user=userRepository.findByUsername(username);
        //Optional<User> targetPost = userRepository.findById(id);
        User user =userRepository.findByUsername(username).orElseThrow(()->
                new IllegalArgumentException("댓글 쓰기 실패"+username));
        Post post = postRepository.findById(id).orElseThrow(() ->
                                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + id));
        //Post post=targetPost.get();
        //Optional<User> targetUser=post.getUser();
        //User user =targetPost.get();
        dto.setUser(user);
        dto.setPost(post);

        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return dto.getId();
        //User user = userRepository.findByUsername(username).get();
//        Post posts = postRepository.findById(id).orElseThrow(() ->
//                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다. " + id));
//
//        //dto.setUser(user);
//        dto.setPost(posts);
//
//        Comment comment = dto.toEntity();
//        commentRepository.save(comment);
//
//        return comment.getId();
    }
    public List<Comment> findAll() {

        return commentRepository.findAll();
    }

    /* READ */
//    @Transactional
//    public Optional<Comment> findAllById(Long id) {//postId
////        Post post = postRepository.findById(id).orElseThrow(() ->
////                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));
////        List<Comment> comments = commentRepository.findAllById(post.getId());
////        return comments.stream().map(CommentResponse::new).collect(Collectors.toList());
//        Optional<Comment> comments=commentRepository.findById(id);
////        return commentRepository.findAllById(id)
////                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
//        return comments;
//    }
//    @Transactional
//    public List<CommentResponse> findAllByUsername(String username) {
//        User user=userRepository.findByUsername(username).orElseThrow(() ->
//                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + username));
//        Post post = postRepository.findById(user.getId()).orElseThrow(() ->
//                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + username));
//        List<Comment> comments = post.getComments();
//        return comments.stream().map(CommentResponse::new).collect(Collectors.toList());
//    }
//    @Transactional
//
//    public List<CommentResponse> findAllByUsernameAndPostId(String username,Long id) {//해당 postId의 해당 user가 작성한 post 조회//필요없을 것 같아서 일단 pass...
//        //수정 필요!!
//        User user=userRepository.findByUsername(username).orElseThrow(() ->
//                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + username));
//        Post post = postRepository.findById(id).orElseThrow(() ->
//                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + username));
//
//        List<Comment> comments = post.getComments();
//        return comments.stream().map(CommentResponse::new).collect(Collectors.toList());
//
//    }


//
//    /* UPDATE */
//    @Transactional
//    public void update(Long postsId, Long id, CommentRequest dto) {
//        Comment comment = commentRepository.findByPostsIdAndId(postsId, id).orElseThrow(() ->
//                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. " + id));
//
//        comment.update(dto.getComment());
//    }
//
//    /* DELETE */
//    @Transactional
//    public void delete(Long postsId, Long id) {
//        Comment comment = commentRepository.findByPostsIdAndId(postsId, id).orElseThrow(() ->
//                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id=" + id));
//
//        commentRepository.delete(comment);
//    }
}