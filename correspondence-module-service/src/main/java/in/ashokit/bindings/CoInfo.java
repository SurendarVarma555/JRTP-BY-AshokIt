package in.ashokit.bindings;

import java.time.LocalDate;

public class CoInfo {

    private String planName;
    private String planStatus;
    private LocalDate planStartDate;
    private LocalDate planEndDate;
    private Double benefitAmt;
    private String noticeDenialRsn;
    private LocalDate noticeGenDate;

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

    public Double getBenefitAmt (){
        return benefitAmt;
    }

    public void setBenefitAmt (Double benefitAmt){
        this.benefitAmt = benefitAmt;
    }

    public String getNoticeDenialRsn (){
        return noticeDenialRsn;
    }

    public void setNoticeDenialRsn (String noticeDenialRsn){
        this.noticeDenialRsn = noticeDenialRsn;
    }

    public LocalDate getNoticeGenDate (){
        return noticeGenDate;
    }

    public void setNoticeGenDate (LocalDate noticeGenDate){
        this.noticeGenDate = noticeGenDate;
    }
}
