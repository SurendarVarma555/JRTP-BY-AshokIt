package in.ashokit.binding;

import java.util.List;

public class Kids {

    private Integer caseNum;
    private List<Kid> kidsList;
    private Integer userId;

    public Integer getCaseNum (){
        return caseNum;
    }

    public void setCaseNum (Integer caseNum){
        this.caseNum = caseNum;
    }

    public List<Kid> getKidsList (){
        return kidsList;
    }

    public void setKidsList (List<Kid> kidsList){
        this.kidsList = kidsList;
    }

    public Integer getUserId (){
        return userId;
    }

    public void setUserId (Integer userId){
        this.userId = userId;
    }
}
