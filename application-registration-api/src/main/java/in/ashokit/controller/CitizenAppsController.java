package in.ashokit.controller;

import in.ashokit.binding.CitizenApp;
import in.ashokit.service.AppRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CitizenAppsController {
    @Autowired
    private AppRegService appRegService;

    @PostMapping("/app")
    public ResponseEntity<String> createApp (@RequestBody CitizenApp citizenApp){

        String response = appRegService.createCitizenApp(citizenApp);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/applications/{userId}/{userType}")
    public ResponseEntity<List<CitizenApp>> getApplications (@PathVariable("UserId") Integer userId, @PathVariable("userType") String userType){

        List<CitizenApp> applications = appRegService.getApplications(userId, userType);

        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

}
