package in.ashokit.service.impl;

import in.ashokit.binding.*;
import in.ashokit.entity.*;
import in.ashokit.repository.*;
import in.ashokit.service.DcService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DcServiceImpl implements DcService {

    @Autowired
    private CitizenAppRepo citizenAppRepo;

    @Autowired
    private DcEducationRepo educationRepo;

    @Autowired
    private DcIncomeRepo incomeRepo;

    @Autowired
    private DcKidRepo kidRepo;

    @Autowired
    private PlanMasterRepo planMasterRepo;

    @Autowired
    private UserInfoRepo userInfoRepo;

    @Override
    public Map<Integer, String> getPlanNames (){
        List<DcPlanMasterEntity> listOfPlans = planMasterRepo.findAll();
        HashMap<Integer, String> map = new HashMap<>();
        for (DcPlanMasterEntity entity : listOfPlans) {
            map.put(entity.getPlanId(), entity.getPlanName());
        }
        return map;
    }

    @Override
    public boolean updatePlanSelection (PlanSelection planSelection){
        Integer caseNum = planSelection.getCaseNum();
        Optional<CitizenAppEntity> citizenAppEntity = citizenAppRepo.findById(caseNum);
        UserInfoEntity userEntity = userInfoRepo.findById(planSelection.getUserId()).get();
        if (citizenAppEntity.isPresent()) {
            CitizenAppEntity entityApp = citizenAppEntity.get();
            entityApp.setPlanId(planSelection.getPlanId());
            entityApp.setUser(userEntity);
            citizenAppRepo.save(entityApp);
            return true;
        }
        return false;
    }

    @Override
    public boolean saveIncome (Income income){

        DcIncomeEntity incomeEntity = new DcIncomeEntity();
        BeanUtils.copyProperties(income, incomeEntity);

        Integer caseNum = income.getCaseNum();
        Integer userId = income.getUserId();

        CitizenAppEntity citizenAppEntity = citizenAppRepo.findById(caseNum).get();
        UserInfoEntity userInfoEntity = userInfoRepo.findById(userId).get();

        incomeEntity.setApp(citizenAppEntity);
        incomeEntity.setUser(userInfoEntity);

        incomeRepo.save(incomeEntity);

        return true;
    }

    @Override
    public boolean saveEducation (Education education){

        Integer caseNum = education.getCaseNum();
        Integer userId = education.getUserId();

        CitizenAppEntity citizenAppEntity = citizenAppRepo.findById(caseNum).get();
        UserInfoEntity userInfoEntity = userInfoRepo.findById(userId).get();

        DcEducationEntity dcEducationEntity = new DcEducationEntity();
        BeanUtils.copyProperties(education, dcEducationEntity);

        dcEducationEntity.setApp(citizenAppEntity);
        dcEducationEntity.setUser(userInfoEntity);


        educationRepo.save(dcEducationEntity);

        return true;
    }

    @Override
    public boolean saveKids (Kids kids){

        Integer caseNum = kids.getCaseNum();
        Integer userId = kids.getUserId();

        CitizenAppEntity citizenAppEntity = citizenAppRepo.findById(caseNum).get();
        UserInfoEntity userInfoEntity = userInfoRepo.findById(userId).get();

        List<Kid> kidsList = kids.getKidsList();

        for (Kid kid : kidsList) {
            DcKidEntity kidEntity = new DcKidEntity();
            BeanUtils.copyProperties(kid, kidEntity);
            kidEntity.setApp(citizenAppEntity);
            kidEntity.setUser(userInfoEntity);
            kidRepo.save(kidEntity);
        }

        return true;
    }

    @Override
    public Summary getSummaryInfo (Integer caseNum){
        Summary summary = new Summary();

        CitizenAppEntity citizenAppEntity = citizenAppRepo.findById(caseNum).get();
        DcPlanMasterEntity planMasterEntity = planMasterRepo.findById(citizenAppEntity.getPlanId()).get();
        DcIncomeEntity incomeEntity = incomeRepo.findByCaseNum(caseNum);
        DcEducationEntity educationEntity = educationRepo.findByCaseNum(caseNum);
        List<DcKidEntity> KidEntities = kidRepo.findByCaseNum(caseNum);

        summary.setCaseNum(caseNum);
        summary.setPlanName(planMasterEntity.getPlanName());

        Income income = new Income();
        BeanUtils.copyProperties(incomeEntity, income);
        summary.setIncome(income);

        Education education = new Education();
        BeanUtils.copyProperties(educationEntity, education);
        summary.setEducation(education);

        List<Kid> kidList = new ArrayList<>();

        for (DcKidEntity kidEntity : KidEntities) {
            Kid kid = new Kid();
            BeanUtils.copyProperties(kidEntity, kid);
            kidList.add(kid);
        }

        Kids kids = new Kids();
        kids.setKidsList(kidList);
        summary.setKids(kids);

        return summary;
    }
}

