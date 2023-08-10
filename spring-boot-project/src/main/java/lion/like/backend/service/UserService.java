package lion.like.backend.service;

import jakarta.transaction.Transactional;
import lion.like.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lion.like.backend.dto.User.UserDTO;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public Long join(UserDTO dto){
        return null;
        //return userRepository.save(dto.toEntity().getId());
    }
}
