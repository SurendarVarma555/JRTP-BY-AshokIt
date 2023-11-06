package in.ashokit.response;

/*If the User is logging successfully then
we need to display the dashboard details along with User Info*/

public class LoginResponse {

    private Integer userId;
    private String name;
    private String userType;

    private boolean pwdChanged;

    private boolean isValidLogin;

    private DashboardResponse dashboardResponse;

    public void setValidLogin (boolean validLogin){
        isValidLogin = validLogin;
    }

    public void setPwdChanged (boolean pwdChanged){
        this.pwdChanged = pwdChanged;
    }

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

    public String getUserType (){
        return userType;
    }

    public void setUserType (String userType){
        this.userType = userType;
    }

    public DashboardResponse getDashboardResponse (){
        return dashboardResponse;
    }

    public void setDashboardResponse (DashboardResponse dashboardResponse){
        this.dashboardResponse = dashboardResponse;
    }
}
