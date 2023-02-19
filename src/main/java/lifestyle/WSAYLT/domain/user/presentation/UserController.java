package lifestyle.WSAYLT.domain.user.presentation;

import lifestyle.WSAYLT.domain.user.presentation.dto.request.ChangePasswordRequest;
import lifestyle.WSAYLT.domain.user.presentation.dto.request.DeleteUserRequest;
import lifestyle.WSAYLT.domain.user.service.ChangePasswordService;
import lifestyle.WSAYLT.domain.user.service.DeleteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final ChangePasswordService changePasswordService;
    private final DeleteUserService deleteUserService;

    @PatchMapping
    public ResponseEntity<Void> changePassword(@RequestBody @Valid ChangePasswordRequest changePasswordRequest) {
        changePasswordService.changePassword(changePasswordRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestBody @Valid DeleteUserRequest deleteUserRequest) {
        deleteUserService.withdrawUser(deleteUserRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
