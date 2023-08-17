package lion.like.backend.dto.Comment;

import lion.like.backend.domain.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
public class CommentResponse {
private Long id;
     private String comment;
     private String username;
     private Long userId;
     private Long postId;
     private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
     private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));


     /* Entity -> Dto*/
     public CommentResponse(Comment comment) {
          this.id = comment.getId();
          this.comment = comment.getComment();
          this.username = comment.getUser().getUsername();
          this.userId=comment.getUser().getId();
          this.postId = comment.getPost().getId();
          this.createdDate = comment.getCreatedDate();
          this.modifiedDate = comment.getModifiedDate();

     }
}
