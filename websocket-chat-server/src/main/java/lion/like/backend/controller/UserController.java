package lion.like.backend.controller;

import lion.like.backend.domain.User;
import lion.like.backend.dto.User.UserRequest;
import lion.like.backend.dto.User.UserResponse;
import lion.like.backend.service.UserService;
import lion.like.backend.validator.CheckUsernameValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;
    private final CheckUsernameValidator checkUsernameValidator;
    @InitBinder
    public void validatorBinder(WebDataBinder binder){
        binder.addValidators(checkUsernameValidator);
    }

    /* CREATE */
    @PostMapping
    public ResponseEntity userSave(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.userSave(userRequest));
    }

    /*READ*/
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllusers() {
        List<UserResponse> users = userService.findAll()
                .stream()
                .map(UserResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findUser(@PathVariable Long id) {
        User user = userService.findById(id);

        return ResponseEntity.ok()
                .body(new UserResponse(user));
    }

    /*DELETE*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

//update기능은 없음

}
