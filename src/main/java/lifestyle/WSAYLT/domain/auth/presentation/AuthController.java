package lifestyle.WSAYLT.domain.auth.presentation;

import io.swagger.annotations.ApiOperation;
import lifestyle.WSAYLT.domain.auth.presentation.dto.request.SignUpRequest;
import lifestyle.WSAYLT.domain.auth.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final SignUpService signUpService;

    @PostMapping("/signup")
    @ApiOperation(value = "회원가입")
    public ResponseEntity<Void> signUp(@RequestBody @Valid SignUpRequest signUpRequest) throws Exception{
        signUpService.signUp(signUpRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
