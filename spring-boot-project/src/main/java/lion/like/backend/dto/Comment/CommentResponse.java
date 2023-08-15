package lion.like.backend.dto.Comment;

import lion.like.backend.domain.Comment;
import lombok.Getter;


@Getter
public class CommentResponse {
private Long id;
     private String comment;
     private String username;
     private Long userId;
     private Long postId;

     /* Entity -> Dto*/
     public CommentResponse(Comment comment) {
          this.id = comment.getId();
          this.comment = comment.getComment();
          this.username = comment.getUser().getUsername();
          this.userId=comment.getUser().getId();
          this.postId = comment.getPost().getId();
     }
}
