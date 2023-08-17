package lion.like.backend.service;

import jakarta.transaction.Transactional;
import lion.like.backend.domain.Post;
import lion.like.backend.domain.User;
import lion.like.backend.dto.Post.PostRequest;
import lion.like.backend.dto.Post.PostResponse;
import lion.like.backend.repository.PostRepository;
import lion.like.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor//final이 붙거나 @NOTNULL이 붙은 필드의 생성자 추가
@Service//빈으로 등록
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    /*CREATE*/
    //블로그 글 추가 메서드
    //user정보를 dto에 저장
    @Transactional
    public Long save(PostRequest request,String username)
    {
        Optional<User> user=userRepository.findByUsername(username);
        request.setUser(user.get());
        Post post=request.toEntity();
        postRepository.save(post);
        return post.getId();
    }

    /*READ*/
    @Transactional

    public List<Post> findAll() {
        return postRepository.findAll();    }

    public PostResponse findById(Long id) {

        Post post = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));

        return new PostResponse(post);    }

    /*DELETE*/
    public void delete(long id) {

        //postRepository.deleteById(id);
        Optional<Post> targetEntity=this.postRepository.findById(id);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.postRepository.delete(targetEntity.get());

    }

    /*UPDATE*/
    @Transactional
    public Post update(Long id, PostRequest request,String username) {
        Optional<Post>targetArticle=this.postRepository.findById(id);
        if(targetArticle.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Post post =targetArticle.get();
        post.setContent_type(request.getContent_type()==null? post.getContent_type() : request.getContent_type());
        post.setTitle(request.getTitle()==null? post.getTitle():request.getTitle());
        post.setContent(request.getContent()==null? post.getContent(): request.getContent());
        post.setLike_num(Integer.toString(request.getLike_num())==null? post.getLike_num() : request.getLike_num());
        post.setDislike_num(Integer.toString(request.getDislike_num())==null? post.getDislike_num() : request.getDislike_num());
        //post.setUser(request.getUser()==null? post.getUser() : request.getUser());
        post.setImage_id(request.getImage_id()==null? post.getImage_id() : request.getImage_id());
        post.setFile_id(request.getFile_id()==null? post.getFile_id() : request.getFile_id());
        //post.setUser_type(request.getUser_type()==null? post.getUser_type() : request.getUser_type());
        return post;
    }
}
