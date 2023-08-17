package lion.like.backend.controller;

import lion.like.backend.domain.Post;
import lion.like.backend.dto.Post.PostRequest;
import lion.like.backend.dto.Post.PostResponse;
import lion.like.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/posts")
@RequiredArgsConstructor
@RestController//HTTP Response Body에 객체 데이터를 JSON형식으로 반환하는 컨트롤러
public class PostController {

    private final PostService postService;
    /*CREATE*/
    //HTTP메서드가 POST일 때 전달 받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/{username}/write")//username의 post작성
    public ResponseEntity save(@RequestBody PostRequest dto,@PathVariable String username) {//@RequestBody로 요청 본문값 매핑
        //요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답객체에 담아 전송
        return ResponseEntity.ok(postService.save(dto,username));
    }
    /*READ*/
    @GetMapping("")
    public ResponseEntity<List<PostResponse>> findAllposts() {
        List<PostResponse> posts = postService.findAll()
                .stream()
                .map(PostResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(posts);
    }
    @GetMapping("/{id}")
    public ResponseEntity findpost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    /*DELETE*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok()
                .build();
    }
    /*UPDATE*/
    @PutMapping("/{id}/{username}/write")
    public ResponseEntity<Post> update(@PathVariable Long id,
                                              @RequestBody PostRequest request,@PathVariable String username) {
        Post updatedPost = postService.update(id, request,username);

        return ResponseEntity.ok()
                .body(updatedPost);
    }

}

