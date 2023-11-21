package in.ashokit.controller;

import in.ashokit.bindings.EligInfo;
import in.ashokit.service.EdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdController {

    @Autowired
    private EdService edService;

    @GetMapping("/elig/{caseNum}")
    public ResponseEntity<EligInfo> fetchEligInfo (@PathVariable("caseNum") Integer caseNum){
        EligInfo eligInfo = edService.determineEligibility(caseNum);
        return new ResponseEntity<>(eligInfo, HttpStatus.OK);

    }

}
