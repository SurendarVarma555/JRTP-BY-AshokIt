package in.ashokit.service.impl;

import in.ashokit.entity.UserInfoEntity;
import in.ashokit.repo.UserInfoRepository;
import in.ashokit.request.LoginRequest;
import in.ashokit.request.PwdChangeRequest;
import in.ashokit.request.SignUpRequest;
import in.ashokit.response.LoginResponse;
import in.ashokit.service.UserService;
import in.ashokit.utils.EmailUtils;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private EmailUtils emailUtils;

    @Override
    public boolean saveUser (SignUpRequest signUpRequest){

        // generate temporary password
        String tempPwd = generateTempPwd();

        signUpRequest.setPwd(tempPwd);

        signUpRequest.setPwdChanged(false);

        // save userinfo record in db
        UserInfoEntity entity = new UserInfoEntity();

        BeanUtils.copyProperties(signUpRequest,entity);

        userInfoRepository.save(entity);

        // send email to user with credentials

        String subject = "IES - Account created";

        String body = "Your Pwd to login ::  " + tempPwd;

        boolean isSent = emailUtils.sendEmail(signUpRequest.getEmail(), subject, body);

        return (isSent) ? true : false;

    }

    @Override
    public LoginResponse userLogin (LoginRequest loginRequest){

        // 1. findByMethod 2.Custom Query 3.QBE






        return null;
    }

    @Override
    public LoginResponse updatePwd (PwdChangeRequest pwdChangeRequest){
        return null;
    }

    @Override
    public boolean recoverPwd (String email){
        return false;
    }

    public String generateTempPwd(){

        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 5;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }

}
