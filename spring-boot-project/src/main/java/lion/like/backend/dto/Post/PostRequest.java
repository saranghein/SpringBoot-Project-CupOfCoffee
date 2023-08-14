package lion.like.backend.dto.Post;

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
public class PostRequest {
    private Long id;
    private String content_type;
    private String title;
    private String content;
    private int like_num;
    private int dislike_num;
    //@JsonProperty("user_id")
    private User user;
    //    @JsonProperty("user_id")
//    private void unpackNested(Long user_id){
//        //this.user =new User();
//        user.setId(user_id);
//    }
    private String image_id;
    private String file_id;
    private String user_type;
    private String createdAt;
    private String updatedAt;


    public Post toEntity() {
        return Post.builder()
                .id(id)
                .content_type(content_type)
                .title(title)
                .content(content)
                .like_num(like_num)
                .dislike_num(dislike_num)
                //.user(user)
                .image_id(image_id)
                .file_id(file_id)
                .user_type(user_type)
                //.createdAt(createdAt)
                //.updatedAt(updatedAt)
                .build();
    }


}