package in.ashokit.service;

import in.ashokit.entity.CitizenInfo;
import in.ashokit.request.InputRequest;
import in.ashokit.response.OutputResponse;
import org.springframework.http.ResponseEntity;

public interface CitizenInfoService {

    public String saveCitizenInfo(InputRequest inputRequest);

    public OutputResponse getCitizenInfoBySSN(String ssn);

}
