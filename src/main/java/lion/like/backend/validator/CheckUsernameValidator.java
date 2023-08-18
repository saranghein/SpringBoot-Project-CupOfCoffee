package lion.like.backend.validator;

import lion.like.backend.dto.User.UserRequest;
import lion.like.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component
public class CheckUsernameValidator extends AbstractValidator<UserRequest> {
    private Logger logger= LoggerFactory.getLogger(CheckUsernameValidator.class);
    private final UserRepository userRepository;
    @Override
    protected void doValidate(UserRequest dto, Errors errors) {
        String username=dto.toEntity().getUsername();
        if (userRepository.existsByUsername(username)) {//유저 이름이 같다면 비번이 같아야함
            logger.info("중복");
            if(userRepository.existsByPassword(dto.toEntity().getPassword())){
                errors.rejectValue("username", "아이디 중복,비밀번호 불일치", "아이디와 비번이 일치하지 않습니다..");

            }
        }
    }
}