package lion.like.backend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lion.like.backend.domain.Post;
import lion.like.backend.dto.Post.AddPostRequest;
import lion.like.backend.dto.Post.UpdatePostRequest;
import lion.like.backend.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor//final이 붙거나 @NOTNULL이 붙은 필드의 생성자 추가
@Service//빈으로 등록
public class PostService {

    private final PostRepository postRepository;

    //블로그 글 추가 메서드
    //AddArticleRequest클래스에 저장된 값들을 article데이터 베이스에 저장
    public Post save(AddPostRequest request) {
        return postRepository.save(request.toEntity());
    }

    public List<Post> findAll() {

        return postRepository.findAll();
    }

    public Post findById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }

    public void delete(long id) {

        //postRepository.deleteById(id);
        Optional<Post> targetEntity=this.postRepository.findById(id);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.postRepository.delete(targetEntity.get());

    }

    @Transactional
    public Post update(long id, UpdatePostRequest request) {
//        Post post = this.postRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
//        if(targetArticle.isEmpty()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
        //Post post=targetArticle;

//        post.update(
//                Long.toString(request.getId())==null?post.getId():request.getId(),
//                request.getContentType()==null?post.getContent_type():request.getContentType(),
//                request.getTitle()==null?post.getTitle():request.getTitle(),
//                request.getContent()==null?post.getContent():request.getContent(),
//                Integer.toString(request.getLike_num())==null?post.getLike_num():request.getLike_num(),
//                Integer.toString(request.getDislike_num())==null?post.getDislike_num():request.getDislike_num(),
//                request.getUser_id()==null?post.getUser_id():request.getUser_id(),
//                request.getImage_id()==null?post.getImage_id():request.getImage_id(),
//                request.getFile_id()==null?post.getFile_id():request.getFile_id(),
//                request.getUser_type()==null?post.getUser_type():request.getUser_type()
//        );
//        post.update(
//                //request.getId(),
//                request.getContentType(),
//                request.getTitle(),
//                request.getContent(),
//                request.getLike_num(),
//                request.getDislike_num(),
//                request.getUser_id(),
//                request.getImage_id(),
//                request.getFile_id(),
//                request.getUser_type()
//        );
        Optional<Post>targetArticle=this.postRepository.findById(id);
        if(targetArticle.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Post post =targetArticle.get();
        post.setContent_type(request.getContentType()==null? post.getContent_type() : request.getContentType());
        post.setTitle(request.getTitle()==null? post.getTitle():request.getTitle());
        post.setContent(request.getContent()==null? post.getContent(): request.getContent());
        post.setLike_num(Integer.toString(request.getLike_num())==null? post.getLike_num() : request.getLike_num());
        post.setDislike_num(Integer.toString(request.getDislike_num())==null? post.getDislike_num() : request.getDislike_num());
        post.setUser(request.getUser_id()==null? post.getUser() : request.getUser_id());
        post.setImage_id(request.getImage_id()==null? post.getImage_id() : request.getImage_id());
        post.setFile_id(request.getFile_id()==null? post.getFile_id() : request.getFile_id());
        post.setUser_type(request.getUser_type()==null? post.getUser_type() : request.getUser_type());
        return post;
    }
}
