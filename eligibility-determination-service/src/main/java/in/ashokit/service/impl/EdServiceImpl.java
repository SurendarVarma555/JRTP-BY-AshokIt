package in.ashokit.service.impl;

import in.ashokit.bindings.EligInfo;
import in.ashokit.entity.*;
import in.ashokit.repository.*;
import in.ashokit.service.EdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/*
Fetch required info
check conditions
construct response
 */

@Service
public class EdServiceImpl implements EdService {

    @Autowired
    private AppRepo appRepo;

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private KidRepo kidRepo;

    @Autowired
    private IncomeRepo incomeRepo;

    @Autowired
    private EducationRepo educationRepo;

    @Autowired
    private CoRepo coRepo;

    @Override
    public EligInfo determineEligibility (Integer caseNum){

        EligInfo eligInfo = new EligInfo();

        AppEntity appEntity = appRepo.findById(caseNum).get();
        Integer planId = appEntity.getPlanId();

        PlanEntity planEntity = planRepo.findById(planId).get();
        String planName = planEntity.getPlanName();

        eligInfo.setCaseNum(caseNum);
        eligInfo.setPlanName(planName);

        IncomeEntity incomeInfo = incomeRepo.findByCaseNum(caseNum);

        if (planName.equals("SNAP")) {
            if (incomeInfo.getSalaryIncome() <= 300) {
                eligInfo.setPlanStatus("Approved");
            } else {
                eligInfo.setPlanStatus("Denied");
                eligInfo.setDenialRsn("High Income");
            }
        } else if (planName.equals("CCAP")) {
            Double income = incomeInfo.getSalaryIncome();
            List<KidEntity> kids = kidRepo.findByCaseNum(caseNum);

            boolean isValid = true;
            for (KidEntity kid : kids) {
                LocalDate kidDob = kid.getKidDob();
                int kidAge = Period.between(kidDob, LocalDate.now()).getYears();
                if (kidAge > 16) {
                    isValid = false;
                    break;
                }
            }

            if (isValid && income <= 300 && !kids.isEmpty()) {
                eligInfo.setPlanStatus("Approved");
            } else {
                eligInfo.setPlanStatus("Denied");
            }
            if (!isValid) {
                eligInfo.setDenialRsn("Kid age above 16");
            }
            if (income > 300) {
                eligInfo.setDenialRsn("High Income");
            }
            if (kids.isEmpty()) {
                eligInfo.setDenialRsn("No Kids Available");
            }
        } else if (planName.equals("Medicaid")) {
            Double salaryIncome = incomeInfo.getSalaryIncome();
            Double propertyIncome = incomeInfo.getPropertyIncome();
            Double rentIncome = incomeInfo.getRentIncome();

            if (salaryIncome <= 300 && ((propertyIncome + rentIncome)) <= 0) {
                eligInfo.setPlanStatus("Approved");
            } else {
                eligInfo.setPlanStatus("Denied");
                eligInfo.setDenialRsn("High Income");
            }

        } else if (planName.equals("Medicare")) {
            LocalDate citizenDob = appEntity.getDob();
            int citizenAge = Period.between(citizenDob, LocalDate.now()).getYears();
            if (citizenAge >= 65) {
                eligInfo.setPlanStatus("Approved");
            } else {
                eligInfo.setPlanStatus("Denied");
                eligInfo.setDenialRsn("Age Not Matched");
            }

        } else if (planName.equals("RIW")) {
            EducationEntity educationEntity = educationRepo.findByCaseNum(caseNum);
            Integer graduationYear = educationEntity.getGraduationYear();
            if (graduationYear != null && incomeInfo == null) {
                eligInfo.setPlanStatus("Approved");
            } else {
                eligInfo.setPlanStatus("Denied");
            }
            if (graduationYear == null) {
                eligInfo.setDenialRsn("Under Graduate");
            }
            if (incomeInfo != null) {
                eligInfo.setDenialRsn("Already Employee");
            }
        }
        if (eligInfo.getPlanStatus().equals("Approved")) {
            eligInfo.setPlanStartDate(LocalDate.now());
            eligInfo.setPlanEndDate(LocalDate.now().plusMonths(6));
            eligInfo.setBenfitAmt(2000.00);
        }

        generateCorrespondence(appEntity);

        return eligInfo;
    }

    private void generateCorrespondence (AppEntity app){
        CoEntity coEntity = new CoEntity();
        coEntity.setNoticeStatus("Pending");
        coEntity.setApp(app);
        coRepo.save(coEntity);
    }
}
