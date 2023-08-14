package lion.like.backend.controller;

import lion.like.backend.domain.Comment;
import lion.like.backend.dto.Comment.CommentResponse;
import lion.like.backend.dto.Post.PostRequest;
import lion.like.backend.dto.Post.PostResponse;
import lion.like.backend.service.CommentService;
import lion.like.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import lion.like.backend.dto.Comment.CommentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/posts")
@RestController
public class CommentController {

         private final CommentService commentService;
         private final PostService postService;
         /* CREATE */
         @PostMapping("/{username}/{id}/comments")//id:post번호, username: 작성자
         public ResponseEntity commentSave(@PathVariable String username,@PathVariable Long id, @RequestBody CommentRequest dto) {
             //String username=postService.findById(id).getUser().getUsername();
                  return ResponseEntity.ok(commentService.commentSave(username, id, dto));
         }
//         @GetMapping("/{id}/comments")
//        public String read(@PathVariable Long id, Model model){
//             PostResponse postResponse=postService.findById(id);
//             List<CommentResponse> comments=postResponse.getComments();
//             if(comments!=null&&!comments.isEmpty()){
//                 model.addAttribute("comments",comments);
//             }
//         }
//@GetMapping("/{id}/comments")
//public List<CommentResponse> read(@PathVariable Long id) {
//
//    return commentService.findAll(id);
//}

    /* READ */
    //존재하는 모든 댓글 조회
    @GetMapping("/comments")
public ResponseEntity<List<CommentResponse>> findAllcomments() {
    List<CommentResponse> comments = commentService.findAll()
            .stream()
            .map(CommentResponse::new)
            .toList();

    return ResponseEntity.ok()
            .body(comments);
}

    //post의 모든 댓글 조회
    @GetMapping("/{id}/comments")//id:post번호, username: 작성자
    public ResponseEntity<List<CommentResponse>>findAllById(@PathVariable("id")long id) {
        //String username=postService.findById(id).getUser().getUsername();
        List<CommentResponse>comments=postService.findById(id).getComments()
                .stream()
                .map(CommentResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(comments);
    }
//
//    //user의 모든 댓글 조회
//    @GetMapping("/{username}/comments")//id:post번호, username: 작성자
//    public ResponseEntity<List<CommentResponse>>findAllByUsername(@PathVariable String username, @RequestBody CommentRequest dto) {
//        //String username=postService.findById(id).getUser().getUsername();
//        List<CommentResponse>comments=commentService.findAllByUsername(username) ;
//        return ResponseEntity.ok()
//                .body(comments);
//    }
//    @GetMapping("/{username}/{id}/comments")//id:post번호, username: 작성자
//    public ResponseEntity<List<CommentResponse>>findAllByUsernameAndPostId(@PathVariable String username,@PathVariable Long id, @RequestBody CommentRequest dto){
//        List<CommentResponse>comments=commentService.findAllByUsernameAndPostId(username,id) ;
//        return ResponseEntity.ok()
//                .body(comments);
//
//    }
//

    }
