package lion.like.backend.controller;

import lion.like.backend.dto.Comment.CommentRequest;
import lion.like.backend.dto.Comment.CommentResponse;
import lion.like.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/posts")
@RestController
public class CommentController {

    private final CommentService commentService;

    /* CREATE */
    @PostMapping("/{id}/{username}/comments")//id:post번호, username: 작성자
    public ResponseEntity save(@PathVariable String username, @PathVariable Long id, @RequestBody CommentRequest dto) {
        return ResponseEntity.ok(commentService.save(username, id, dto));
    }

    /* READ */
    //해당 post의 모든 댓글 조회
    @GetMapping("{id}/comments")
    public List<CommentResponse> read(@PathVariable Long id) {
        return commentService.findAll(id);
    }

}
