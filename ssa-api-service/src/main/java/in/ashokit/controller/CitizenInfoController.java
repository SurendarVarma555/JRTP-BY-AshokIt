package in.ashokit.controller;

import in.ashokit.request.InputRequest;
import in.ashokit.response.OutputResponse;
import in.ashokit.service.CitizenInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CitizenInfoController {

    @Autowired
    private CitizenInfoService service;

    @PostMapping("/")
    public ResponseEntity<String> saveCitizenInfo (@RequestBody InputRequest inputRequest){
        String infoSaved = service.saveCitizenInfo(inputRequest);
        return new ResponseEntity<>("CitizenInfo Saved Succeffully", HttpStatus.CREATED);
    }

    @GetMapping("/{ssn}")
    public ResponseEntity<OutputResponse> getCitizenInfoBySsn(@PathVariable("ssn") String ssn) {
        OutputResponse response = service.getCitizenInfoBySSN(ssn);

        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
