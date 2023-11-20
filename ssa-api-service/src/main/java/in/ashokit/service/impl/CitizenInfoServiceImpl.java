package in.ashokit.service.impl;

import in.ashokit.entity.CitizenInfo;
import in.ashokit.repository.CitizenInfoRepository;
import in.ashokit.request.InputRequest;
import in.ashokit.response.OutputResponse;
import in.ashokit.service.CitizenInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CitizenInfoServiceImpl implements CitizenInfoService {

    @Autowired
    private CitizenInfoRepository repository;

    @Override
    public String saveCitizenInfo (InputRequest inputRequest){

        CitizenInfo info = new CitizenInfo();
        info.setSsn(inputRequest.getSsn());
        info.setCitizenName(inputRequest.getCitizenName());
        info.setCitizenDob(inputRequest.getCitizenDob());
        info.setCitizenGender(inputRequest.getCitizenGender());
        CitizenInfo save = repository.save(info);
        return "Citizen Information Added Successfully SSN :" + save.getSsn();
    }

    @Override
    public OutputResponse getCitizenInfoBySSN (String ssn){
        OutputResponse response = new OutputResponse();
        String stateName = getStateName(ssn.substring(0, 1));
        Optional<CitizenInfo> citizenInfoBySSn = repository.findById(ssn);
        if (citizenInfoBySSn.isPresent()) {
            CitizenInfo citizenInfo = citizenInfoBySSn.get();
            response.setCitizenName(citizenInfo.getCitizenName());
            response.setCitizenDob(citizenInfo.getCitizenDob());
            response.setCitizenGender(citizenInfo.getCitizenGender());
            response.setSsn(citizenInfo.getSsn());
            response.setStateName(getStateName(ssn.substring(0, 1)));
            return response;
        } else {
            return null;
        }
    }

    private String getStateName (String ssnPrefix){
        switch (ssnPrefix) {
            case "1":
                return "New Jersey";
            case "2":
                return "Ohio";
            case "3":
                return "Texas";
            case "4":
                return "California";
            case "5":
                return "Rhode Island";
            case "6":
                return "Kentucky";
            case "7":
            case "8":
            case "9":
                return "Invalid SSN";
            default:
                return "Unknown State";
        }
    }
}

