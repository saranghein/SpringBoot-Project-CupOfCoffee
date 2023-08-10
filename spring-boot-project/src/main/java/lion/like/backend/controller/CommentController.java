package lion.like.backend.controller;

import lion.like.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import lion.like.backend.dto.Comment.CommentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/posts")
@RestController
public class CommentController {

         private final CommentService commentService;

         /* CREATE */
                 @PostMapping("/{id}/comments")
         public ResponseEntity commentSave(@PathVariable Long id, @RequestBody CommentRequest dto) {
                  return ResponseEntity.ok(commentService.commentSave(id, dto));
         }
}
