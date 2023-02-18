package lifestyle.WSAYLT.domain.auth.presentation;

import io.swagger.annotations.ApiOperation;
import lifestyle.WSAYLT.domain.auth.presentation.dto.request.LoginRequest;
import lifestyle.WSAYLT.domain.auth.presentation.dto.request.SignUpRequest;
import lifestyle.WSAYLT.domain.auth.presentation.dto.response.LoginResponse;
import lifestyle.WSAYLT.domain.auth.service.LoginService;
import lifestyle.WSAYLT.domain.auth.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final SignUpService signUpService;
    private final LoginService loginService;

    @PostMapping
    @ApiOperation(value = "회원가입")
    public ResponseEntity<Void> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        signUpService.execute(signUpRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        LoginResponse loginResponse = loginService.execute(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }
}