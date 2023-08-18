package lion.like.backend.dto.User;

import lion.like.backend.domain.Role;
import lion.like.backend.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
 
    private String username;
 
    private String password;
 
    //private String nickname;
 
    //private String email;
 
    private Role role;
 
    /* DTO -> Entity */
    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                //.nickname(nickname)
                //.email(email)
                .role(role)
                .build();
        //return user;
    }
}