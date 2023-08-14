package lion.like.backend.service;

import jakarta.transaction.Transactional;
import lion.like.backend.domain.User;
import lion.like.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lion.like.backend.dto.User.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public Long userSave(UserRequest dto){
        //return null;
        return userRepository.save(dto.toEntity()).getId();//user정보 저장

    }
    public List<User> findAll() {

        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }

    public void delete(Long id) {

        //postRepository.deleteById(id);
        Optional<User> targetEntity=this.userRepository.findById(id);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.userRepository.delete(targetEntity.get());

    }

}
