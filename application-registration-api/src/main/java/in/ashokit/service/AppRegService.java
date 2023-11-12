package in.ashokit.service;

import in.ashokit.binding.CitizenApp;

import java.util.List;

public interface AppRegService {

    public String createCitizenApp (CitizenApp app);

    public List<CitizenApp> getApplications (Integer userId, String userType);


}
