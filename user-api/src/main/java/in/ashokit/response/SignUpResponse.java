package in.ashokit.response;

public class SignUpResponse {

    private String successMsg;
    private String errorMsg;

    public String getSuccessMsg (){
        return successMsg;
    }

    public void setSuccessMsg (String successMsg){
        this.successMsg = successMsg;
    }

    public String getErrorMsg (){
        return errorMsg;
    }

    public void setErrorMsg (String errorMsg){
        this.errorMsg = errorMsg;
    }
}
