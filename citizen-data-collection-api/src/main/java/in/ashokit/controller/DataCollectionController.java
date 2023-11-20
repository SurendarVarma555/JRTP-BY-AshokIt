package in.ashokit.controller;

import in.ashokit.binding.*;
import in.ashokit.service.DcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DataCollectionController {

    @Autowired
    private DcService dcService;

    /*
    This api will get the plan names available in the table,
    so that user can select the plan by drop down in UI screen
    */

    @GetMapping("/plan-names")
    public ResponseEntity<Map<Integer, String>> getPlanNames (){

        Map<Integer, String> planNames = dcService.getPlanNames();

        return new ResponseEntity<>(planNames, HttpStatus.OK);
    }

    /*
    Once the plan selection got completed ,
    if User press the submit button then we need to save that data(planId) in DB table : CitizenAppEntity
    which case num and which plan they have selected
    */

    @PostMapping("/save-plan")
    public ResponseEntity<String> updatePlanSelection (@RequestBody PlanSelection requestPlan){

        boolean isSavedPlan = dcService.updatePlanSelection(requestPlan);

        if (isSavedPlan) {
            return new ResponseEntity<>("Plan Selection Details Saved Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed To Save Plan Selection Details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/income")
    public ResponseEntity<String> saveIncome (@RequestBody Income requestIncomeDetails){

        boolean isSavedIncomeInfo = dcService.saveIncome(requestIncomeDetails);

        if (isSavedIncomeInfo) {
            return new ResponseEntity<>("Citizen Income Details Saved Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to Save Citizen Income Details ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/education")
    public ResponseEntity<String> saveEducationInfo (@RequestBody Education requestEducationInfo){

        boolean isSavedEduCtnInfo = dcService.saveEducation(requestEducationInfo);

        if (isSavedEduCtnInfo) {
            return new ResponseEntity<>("Citizen Education Details Saved Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to Save Citizen Education Details ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/kids")
    public ResponseEntity<String> saveKidsInfo (@RequestBody Kids requestKidsInfo){

        boolean isSavedKidsInfo = dcService.saveKids(requestKidsInfo);

        if (isSavedKidsInfo) {
            return new ResponseEntity<>("Kids data Saved Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed To Save Kids Data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/summary/{caseNum}")
    public ResponseEntity<Summary> getSummaryInfo (@PathVariable Integer caseNum){

        Summary summaryInfo = dcService.getSummaryInfo(caseNum);

        return new ResponseEntity<>(summaryInfo, HttpStatus.OK);
    }

}
