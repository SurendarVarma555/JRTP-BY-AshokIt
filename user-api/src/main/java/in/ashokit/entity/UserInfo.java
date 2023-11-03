package in.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer userid;
    private String name;
    private String email;
    private String pwd;
    private String gender;
    private LocalDate dob;
    private Long phone;
    private long ssn;
    private String userType;
    private boolean pwdChanged;

    public Integer getUserid (){
        return userid;
    }

    public void setUserid (Integer userid){
        this.userid = userid;
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

    public boolean isPwdChanged (){
        return pwdChanged;
    }

    public void setPwdChanged (boolean pwdChanged){
        this.pwdChanged = pwdChanged;
    }
}
