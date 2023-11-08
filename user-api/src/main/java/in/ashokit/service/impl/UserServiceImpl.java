package in.ashokit.service.impl;

import in.ashokit.entity.UserInfoEntity;
import in.ashokit.repo.UserInfoRepository;
import in.ashokit.request.LoginRequest;
import in.ashokit.request.PwdChangeRequest;
import in.ashokit.request.SignUpRequest;
import in.ashokit.response.DashboardResponse;
import in.ashokit.response.LoginResponse;
import in.ashokit.service.UserService;
import in.ashokit.utils.EmailUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

        signUpRequest.setPwdChanged("false");

        // save userinfo record in db
        UserInfoEntity entity = new UserInfoEntity();

        BeanUtils.copyProperties(signUpRequest, entity);

        userInfoRepository.save(entity);

        // send email to user with credentials

        String subject = "IES - Account created";

        String body = "Yours Pwd To Login into IES ::  " + tempPwd;

        boolean isSent = emailUtils.sendEmail(signUpRequest.getEmail(), subject, body);

        return (isSent) ? true : false;

    }

    @Override
    public LoginResponse userLogin (LoginRequest loginRequest){

        LoginResponse response = new LoginResponse();

        // 1. findByMethod 2.Custom Query 3.QBE

        UserInfoEntity entity = new UserInfoEntity();
        entity.setEmail(loginRequest.getEmail());
        entity.setPwd(loginRequest.getPwd());
        Example<UserInfoEntity> of = Example.of(entity);
        List<UserInfoEntity> entities = userInfoRepository.findAll(of);
        if (!entities.isEmpty()) {

            UserInfoEntity user = entities.get(0);

            response.setUserId(user.getUserid());
            response.setUserType(user.getUserType());

            if (user.getPwdChanged().equals("true")) {
                //second login
                response.setPwdChanged(true);
                response.setValidLogin(true);

                // set dashboard data
                DashboardResponse dashboard = new DashboardResponse();
                dashboard.setPlansCount(61L);
                dashboard.setCitizensApCnt(10001l);
                dashboard.setBenefitAmtTotal(3400.66);
                dashboard.setCitizensDnCnt(45l);
                response.setDashboardResponse(dashboard);

            } else {
                //first login
                response.setPwdChanged(false);
                response.setValidLogin(true);
            }
        } else {
            response.setValidLogin(false);
        }

        return response;
    }

    @Override
    public LoginResponse updatePwd (PwdChangeRequest pwdChangeRequest){
        LoginResponse response = new LoginResponse();
        Integer userId = pwdChangeRequest.getUserId();
        Optional<UserInfoEntity> userById = userInfoRepository.findById(userId);
        if (userById.isPresent()) {

            // update pwd
            UserInfoEntity entity = userById.get();
            entity.setPwd(pwdChangeRequest.getPwd());
            entity.setPwdChanged("true");
            userInfoRepository.save(entity);

            // construct dashboard response

            response.setUserId(entity.getUserid());
            response.setUserType(entity.getUserType());


            DashboardResponse dashboard = new DashboardResponse();
            dashboard.setPlansCount(61L);
            dashboard.setCitizensApCnt(10001l);
            dashboard.setBenefitAmtTotal(3400.66);
            dashboard.setCitizensDnCnt(45l);
            response.setDashboardResponse(dashboard);
        }
        return response;
    }

    @Override
    public boolean recoverPwd (String email){

        UserInfoEntity user = userInfoRepository.findByEmail(email);

        if (user == null) {
            return false;
        }

        String subject = "IES - Recover password";

        String body = "Yours Pwd To Login into IES :: " + user.getPwd();

        boolean isSent = emailUtils.sendEmail(email, subject, body);


        return (isSent) ? true : false;

    }

    public String generateTempPwd (){

        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 5;

        for (int i = 0; i < length; i++) {

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
