package in.ashokit.controller;

import in.ashokit.request.SignUpRequest;
import in.ashokit.response.SignUpResponse;
import in.ashokit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
