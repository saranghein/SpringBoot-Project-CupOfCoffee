package lion.like.backend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity//엔티티로 지정
@Getter//게테 메서드는 @Getter, @NoArgsConstructor로 대치
@NoArgsConstructor(access = AccessLevel.PROTECTED)//protected인 기본생성자 생성
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username; // 아이디

//    @Column(nullable = false)
//    private String nickname;
 
    @Column(nullable = false, length = 100)
    private String password;
 
//    @Column(nullable = false, length = 50)
//    private String email;
 
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String username, String password,Role role) {
        this.username = username;
        this.password = password;
        this.role=role;
    }
}
