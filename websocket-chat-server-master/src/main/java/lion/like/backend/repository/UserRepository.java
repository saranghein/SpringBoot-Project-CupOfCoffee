package lion.like.backend.repository;

import lion.like.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);//username의 데이터를 가져올 수 있도록 설정
    boolean existsByUsername(String username);//해당 username이 존재하는 지 검사(존재할 경우 true)
    boolean existsByPassword(String password);

}
