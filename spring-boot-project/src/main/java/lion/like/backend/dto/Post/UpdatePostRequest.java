package lion.like.backend.dto.Post;

import lion.like.backend.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdatePostRequest {
    //private Long id;
    private String contentType;
    private String title;
    private String content;
    private int like_num;
    private int dislike_num;
    private User user_id;
    private String image_id;
    private String file_id;
    private String user_type;
}
