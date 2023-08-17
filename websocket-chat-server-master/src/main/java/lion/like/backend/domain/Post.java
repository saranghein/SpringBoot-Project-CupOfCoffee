package lion.like.backend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

/*
<게시글>
id content_id varchar(20)
글타입 contentType varchar(100)
제목 title varchar(50)
본문 content varchar(200)
추천 like_num int(11)
비추천 dislike_num int(11)
아이디 user_id varchar(20)
이미지아이디 image_id varcahr(20)
파일아이디 file_id varchar(20)
유저타입 userType varchar(10)
*/
@EntityListeners(AuditingEntityListener.class)
@Entity//엔티티로 지정
@Getter//게테 메서드는 @Getter, @NoArgsConstructor로 대치
@NoArgsConstructor(access = AccessLevel.PROTECTED)//protected인 기본생성자 생성
public class Post extends BaseEntity {
    @Id//id필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)//기본키를 자동으로 1씩 증가
    @Column(name = "post_id", updatable = false)
    private Long id;

    @Column(name = "content_type", nullable = false)
    private String content_type;

    @Column(name = "title", nullable = false)//title이라는 not null 컬럼과 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "like_num", nullable = false)
    private int like_num;
    @Column(name = "dislike_num", nullable = false)
    private int dislike_num;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //1개 글에 어러 개 댓글
    @OneToMany(mappedBy = "post",fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
    @OrderBy("id asc")//댓글 정렬
    private List<Comment> comments;

    @Column(name = "image_id", nullable = false)
    private String image_id;

    @Column(name = "file_id", nullable = false)
    private String file_id;

    @Column(name = "user_type", nullable = false)
    private String user_type;

    @Builder//builder패턴으로 객체 생성
    public Post(Long id, String content_type, String title, String content, int like_num, int dislike_num, User user,
                List<Comment>comments,String image_id, String file_id, String user_type) {
        this.id=id;
        this.content_type = content_type;
        this.title = title;
        this.content = content;
        this.like_num = like_num;
        this.dislike_num = dislike_num;
        this.user = user;
        this.comments=comments;
        this.image_id = image_id;
        this.file_id = file_id;
        this.user_type = user_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLike_num() {
        return like_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public int getDislike_num() {
        return dislike_num;
    }

    public void setDislike_num(int dislike_num) {
        this.dislike_num = dislike_num;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user_id) {
        this.user = user_id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }


    public void update(String contentType, String title, String content, int like_num, int dislike_num, User user_id, String image_id, String file_id, String user_type) {
        //this.id=id;
        this.content_type = contentType;
        this.title = title;
        this.content = content;
        this.like_num = like_num;
        this.dislike_num = dislike_num;
        this.user = user_id;
        this.image_id = image_id;
        this.file_id = file_id;
        this.user_type = user_type;
        //this.updatedAt=LocalDateTime.now();
    }
    /*@builder : 어느 필ㄷ에 어떤 값이 들어가는 지 명시적으로 파악가능
    //builder패턴을 사용하지 않았을 때
        new Post("abc", "def");
    //builder패턴을 사용했을 때
        Post.builder()
        .title("abc")
        .content("def")
        .build()
    */

}
