package in.ashokit.service;

import in.ashokit.request.LoginRequest;
import in.ashokit.request.PwdChangeRequest;
import in.ashokit.request.SignUpRequest;
import in.ashokit.response.LoginResponse;

public interface UserService {

    public boolean saveUser(SignUpRequest signUpRequest);
    public LoginResponse userLogin(LoginRequest loginRequest);
    public LoginResponse updatePwd(PwdChangeRequest pwdChangeRequest);
    public boolean recoverPwd(String email);


}
