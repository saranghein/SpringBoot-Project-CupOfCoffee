package lion.like.backend.controller;

import lion.like.backend.domain.Post;
import lion.like.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import lion.like.backend.dto.Post.AddPostRequest;
import lion.like.backend.dto.Post.PostResponse;
import lion.like.backend.dto.Post.UpdatePostRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController//HTTP Response Body에 객체 데이터를 JSON형식으로 반환하는 컨트롤러
public class PostController {

    private final PostService postService;

    //HTTP메서드가 POST일 때 전달 받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/posts")
    public ResponseEntity<Post> addArticle(@RequestBody AddPostRequest request) {//@RequestBody로 요청 본문값 매핑
        Post savedPost = postService.save(request);

        //요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPost);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponse>> findAllposts() {
        List<PostResponse> posts = postService.findAll()
                .stream()
                .map(PostResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(posts);
    }
    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponse> findArticle(@PathVariable long id) {
        Post post = postService.findById(id);

        return ResponseEntity.ok()
                .body(new PostResponse(post));
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        postService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updateArticle(@PathVariable long id,
                                              @RequestBody UpdatePostRequest request) {
        Post updatedPost = postService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedPost);
    }

}

