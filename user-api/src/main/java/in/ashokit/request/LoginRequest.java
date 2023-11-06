package in.ashokit.request;
/*When the user is trying to loging into our application, sing in then user needs fill the login form as request */
public class LoginRequest {
    private String email;

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

    private String pwd;

}
