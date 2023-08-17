package lion.like.backend.dto.Comment;

import lion.like.backend.domain.Comment;
import lion.like.backend.domain.Post;
import lion.like.backend.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequest {
 private Long id;
 private String comment;
 private User user;
 private Post post;
 @Builder.Default
 private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
 @Builder.Default
 private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));


 /* Dto -> Entity */
         public Comment toEntity() {
  Comment comments = Comment.builder()
    .id(id)
    .comment(comment)
    .user(user)
    .post(post)
          .createdDate(createdDate)
          .modifiedDate(modifiedDate)
    .build();

  return comments;
 }

}
