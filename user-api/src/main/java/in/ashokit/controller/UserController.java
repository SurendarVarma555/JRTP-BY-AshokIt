package in.ashokit.controller;

import in.ashokit.request.LoginRequest;
import in.ashokit.request.PwdChangeRequest;
import in.ashokit.request.SignUpRequest;
import in.ashokit.response.LoginResponse;
import in.ashokit.response.SignUpResponse;
import in.ashokit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/user")
    public ResponseEntity<SignUpResponse> userRegistration (@RequestBody SignUpRequest request){

        SignUpResponse response = service.saveUser(request);

        if (response.getSuccessMsg()!=null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else if(response.getErrorMsg().contains("Duplicate Email")){
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> userLogin (@RequestBody LoginRequest request){
        LoginResponse response = service.userLogin(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/pwd-change")
    public ResponseEntity<LoginResponse> updatePwd (@RequestBody PwdChangeRequest request){
        LoginResponse login = service.updatePwd(request);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @GetMapping("recover-pwd/{email}")
    public ResponseEntity<String> recoverPwd (@PathVariable String email){
        boolean isValid = service.recoverPwd(email);
        if (isValid) {
            return new ResponseEntity<>("Password sent to your registratered email", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Email", HttpStatus.BAD_REQUEST);
        }


    }

}
