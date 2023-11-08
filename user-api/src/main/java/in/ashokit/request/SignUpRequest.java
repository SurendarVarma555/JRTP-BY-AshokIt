package in.ashokit.request;

import java.time.LocalDate;

/*To sign up, User needs to provide UserInfo details
 * SignUpRequest is binding entity,
 * */
public class SignUpRequest {
    private Integer userId;
    private String name;
    private String email;
    private String pwd;
    private String gender;
    private LocalDate dob;
    private Long phone;
    private long ssn;
    private String userType;
    private String pwdChanged;

    public Integer getUserId (){
        return userId;
    }

    public void setUserId (Integer userId){
        this.userId = userId;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getEmail (){
        return email;
    }

    public void setEmail (String email){
        this.email = email;
    }

    public String getPwd (){
        return pwd;
    }

    public void setPwd (String pwd){
        this.pwd = pwd;
    }

    public String getGender (){
        return gender;
    }

    public void setGender (String gender){
        this.gender = gender;
    }

    public LocalDate getDob (){
        return dob;
    }

    public void setDob (LocalDate dob){
        this.dob = dob;
    }

    public Long getPhone (){
        return phone;
    }

    public void setPhone (Long phone){
        this.phone = phone;
    }

    public long getSsn (){
        return ssn;
    }

    public void setSsn (long ssn){
        this.ssn = ssn;
    }

    public String getUserType (){
        return userType;
    }

    public void setUserType (String userType){
        this.userType = userType;
    }

    public String getPwdChanged (){
        return pwdChanged;
    }

    public void setPwdChanged (String pwdChanged){
        this.pwdChanged = pwdChanged;
    }
}
