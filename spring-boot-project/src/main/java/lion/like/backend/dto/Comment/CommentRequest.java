package lion.like.backend.dto.Comment;

import lion.like.backend.domain.Comment;
import lion.like.backend.domain.Post;
import lion.like.backend.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequest {
 private Long id;
 private String comment;
 private User user;
 private Post post;


 /* Dto -> Entity */
         public Comment toEntity() {
  Comment comments = Comment.builder()
    .id(id)
    .comment(comment)
    .user(user)
    .post(post)
    .build();

  return comments;
 }

}
