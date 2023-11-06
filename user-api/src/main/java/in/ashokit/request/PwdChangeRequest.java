package in.ashokit.request;
/*when the user sing up is succefull then that user
needs to be change the pwd for the first time
* */
public class PwdChangeRequest {

    private Integer userId;
    private String email;
    private String pwd;
    private String confirmPwd;

    public Integer getUserId (){
        return userId;
    }

    public void setUserId (Integer userId){
        this.userId = userId;
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

    public String getConfirmPwd (){
        return confirmPwd;
    }

    public void setConfirmPwd (String confirmPwd){
        this.confirmPwd = confirmPwd;
    }
}
