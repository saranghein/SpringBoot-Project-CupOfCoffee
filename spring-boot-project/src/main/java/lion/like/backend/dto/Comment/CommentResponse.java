package lion.like.backend.dto.Comment;

import lion.like.backend.domain.Comment;
import lombok.Getter;

@Getter
public class CommentResponse {
private Long id;
     private String comment;
//     private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
//     private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
     //private String nickname;
     private Long postId;

     /* Entity -> Dto*/
     public CommentResponse(Comment comment) {
          this.id = comment.getId();
          this.comment = comment.getComment();
//          this.createdDate = comment.getCreatedDate();
//          this.modifiedDate = comment.getModifiedDate();
          //this.nickname = comment.getUser().getNickname();
          this.postId = comment.getPost().getId();
     }
}
