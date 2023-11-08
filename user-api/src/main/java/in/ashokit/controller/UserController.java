package in.ashokit.controller;

import in.ashokit.request.SignUpRequest;
import in.ashokit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/user")
    public ResponseEntity<String> userRegistration (SignUpRequest request){

        boolean isSaved = service.saveUser(request);

        if (isSaved) {
            return new ResponseEntity<>("User Registration Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User Registration Failed ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
