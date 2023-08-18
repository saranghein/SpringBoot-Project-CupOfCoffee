package lion.like.backend.domain;
import jakarta.persistence.*;
//import jakarta.
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
//user: 실제 로그인 구현이 아님
/*
user_id int 유저id
password varchar 비번
role varchar 역할(학생, 선배)
username varchar 유저이름(사용자 입력 이름)
 */

@Entity//엔티티로 지정
@Getter//게테 메서드는 @Getter, @NoArgsConstructor로 대치
@NoArgsConstructor(access = AccessLevel.PROTECTED)//protected인 기본생성자 생성
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username; // 아이디(unique해야함)

@Column(nullable = false, length = 100)
private String password;//비번

    @Enumerated(EnumType.STRING)//관리자(작성자), 사용자
    @Column(nullable = false)
    private Role role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Builder
    public User(String username, String password,Role role) {
        //this.id=id;
        this.username = username;
        this.password = password;
        this.role=role;
    }
}
