package lion.like.backend.dto.Post;

import lion.like.backend.domain.Post;
import lion.like.backend.dto.Comment.CommentResponse;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostResponse {
    private final Long id;
    private final String content_type;
    private final String title;
    private final String content;
    private final int like_num;
    private final int dislike_num;
    private final Long user_id;
    private final String image_id;
    private final String file_id;
    private final String user_type;
    private final List<CommentResponse> comments;
    private final String createdDate, modifiedDate;


    public PostResponse(Post post) {
        this.id= post.getId();
        this.content_type = post.getContent_type();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.like_num= post.getLike_num();
        this.dislike_num= post.getDislike_num();
        this.user_id = post.getUser().getId();
        this.image_id= post.getImage_id();
        this.file_id= post.getFile_id();
        this.user_type= post.getUser_type();

        //list타입을 dto로 하여 엔티티간 무한 참조 방지
        this.comments=post.getComments().stream().map(CommentResponse::new).collect(Collectors.toList());
        this.createdDate = post.getCreatedDate();
        this.modifiedDate = post.getModifiedDate();

    }
}
