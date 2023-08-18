package lion.like.backend.dto.User;

import lion.like.backend.domain.Role;
import lion.like.backend.domain.User;
import lombok.Getter;

import java.io.Serializable;
//사용자 정보 저장 dto
@Getter
public class UserResponse implements Serializable {
    //private Long id;
    private String username;
    private String password;
    //private String nickname;
    //private String email;
    private Role role;
	
    /* Entity -> Dto */
            public UserResponse(User user) {
                //this.id=user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        //this.nickname = user.getNickname();
        //this.email = user.getEmail();
        this.role = user.getRole();
    }
}
