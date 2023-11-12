package in.ashokit.service.impl;

import in.ashokit.binding.CitizenApp;
import in.ashokit.entity.CitizenAppEntity;
import in.ashokit.repository.CitizenAppRepository;
import in.ashokit.service.AppRegService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AppRegServiceImpl implements AppRegService {

    private String SSA_API_URL = "http://192.168.3.1:8080/ssn/{ssn}";

    @Autowired
    private CitizenAppRepository repository;

    @Override
    public String createCitizenApp (CitizenApp citizenApp){
        Long citizenSsn = citizenApp.getCitizenSsn();

        CitizenAppEntity citizenBySsn = repository.findByCitizenBySsn(citizenSsn);

        if (citizenBySsn != null) {
            return "Duplication Application";

        }


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(SSA_API_URL, String.class, citizenSsn);
        String body = forEntity.getBody();
        if (body.equals("Rhode Island")) {
            CitizenAppEntity entity = new CitizenAppEntity();
            BeanUtils.copyProperties(citizenApp, entity);
            CitizenAppEntity save = repository.save(entity);
            return "Application Created With case number - " + save.getCaseNum();
        }


        return "Invalid Ssn";
    }

    @Override
    public List<CitizenApp> getApplications (Integer userId, String userType){
        return null;
    }
}
