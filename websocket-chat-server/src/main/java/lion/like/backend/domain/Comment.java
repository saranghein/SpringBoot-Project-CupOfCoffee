package lion.like.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/*
<댓글(+대댓글?)>
content varcahr 댓글내용
isDeleted boolean 삭제유무(true시 삭제된 댓글, default는 false)
writer varchar 작성자
post: varchar 게시글
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Comment {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "comment_id", updatable = false)
private Long id;

@Column(columnDefinition = "TEXT", nullable = false)
private String comment; // 댓글 내용

@Column(name = "created_date")
@CreatedDate
private String createdDate;

@Column(name = "modified_date")
@LastModifiedDate
private String modifiedDate;

@ManyToOne
@JoinColumn(name = "post_id")
private Post post;

@ManyToOne
@JoinColumn(name = "user_id")
private User user; // 작성자

    /* 댓글 수정 */
    public void update(String comment) {
        this.comment = comment;
    }
}