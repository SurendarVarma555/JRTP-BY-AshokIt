package in.ashokit.bindings;

import java.time.LocalDate;

public class EligInfo {
    private Integer caseNum;
    private String planName;
    private String planStatus;
    private LocalDate planStartDate;
    private LocalDate planEndDate;
    private Double benfitAmt;
    private String denialRsn;

    public Integer getCaseNum (){
        return caseNum;
    }

    public void setCaseNum (Integer caseNum){
        this.caseNum = caseNum;
    }

    public String getPlanName (){
        return planName;
    }

    public void setPlanName (String planName){
        this.planName = planName;
    }

    public String getPlanStatus (){
        return planStatus;
    }

    public void setPlanStatus (String planStatus){
        this.planStatus = planStatus;
    }

    public LocalDate getPlanStartDate (){
        return planStartDate;
    }

    public void setPlanStartDate (LocalDate planStartDate){
        this.planStartDate = planStartDate;
    }

    public LocalDate getPlanEndDate (){
        return planEndDate;
    }

    public void setPlanEndDate (LocalDate planEndDate){
        this.planEndDate = planEndDate;
    }

    public Double getBenfitAmt (){
        return benfitAmt;
    }

    public void setBenfitAmt (Double benfitAmt){
        this.benfitAmt = benfitAmt;
    }

    public String getDenialRsn (){
        return denialRsn;
    }

    public void setDenialRsn (String denialRsn){
        this.denialRsn = denialRsn;
    }
}
