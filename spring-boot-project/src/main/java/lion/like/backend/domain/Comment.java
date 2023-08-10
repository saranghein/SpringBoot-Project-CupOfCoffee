package lion.like.backend.domain;

import jakarta.persistence.*;
import lombok.*;

/*
<댓글(+대댓글?)>
content varcahr 댓글내용
isDeleted boolean 삭제유무(true시 삭제된 댓글, default는 false)
writer varchar 작성자
parent varchar 부모 댓글(null: 최상위 댓글)
children varcahr 자식댓글
post: varchar 게시글
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
//@Table(name = "comments")
@Entity
public class Comment {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(columnDefinition = "TEXT", nullable = false)
private String comment; // 댓글 내용

//@Column(name = "created_date")
//@CreatedDate
//private String createdDate;
//
//@Column(name = "modified_date")
//@LastModifiedDate
//private String modifiedDate;

@ManyToOne
@JoinColumn(name = "post_id")
private Post post;

@ManyToOne
@JoinColumn(name = "user_id")
private User user; // 작성자
}