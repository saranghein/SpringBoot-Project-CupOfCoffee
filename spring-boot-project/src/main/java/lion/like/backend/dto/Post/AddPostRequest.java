package lion.like.backend.dto.Post;

import lion.like.backend.domain.Post;
import lion.like.backend.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//DTO: data transfer object, 계층끼리 데이터를 교환하기 위해 사용하는 객체
//DAO: 데이터베이스와 연결되고 데이터를 조회, 수정하는 데 사용하는 객체
@NoArgsConstructor//기본 생성자 추가
@AllArgsConstructor//모든 필드 값ㅇ르 파라미터로 받는 생성자 추가
@Getter//게터 메서드 생성
public class AddPostRequest {
//toEntity(): 빌더 패턴을 사용해 DTO를 엔티티로 만들어 주는 메서드,
// 블로그 글을 추가할 때 저장할 엔티티로 변환하는 용도

    private Long id;
    private String content_type;
    private String title;
    private String content;
    private int like_num;
    private int dislike_num;
    private User user_id;
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
                .user(user_id)
                .image_id(image_id)
                .file_id(file_id)
                .user_type(user_type)
                //.createdAt(createdAt)
                //.updatedAt(updatedAt)
                .build();
    }

}
