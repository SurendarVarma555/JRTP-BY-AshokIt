package in.ashokit.response;
/*When the user login into app successfully , app will display the below details*/
public class DashboardResponse {

    private Long plansCount;

    private Long citizensApCnt;

    private Long citizensDnCnt;

    private Double benefitAmtTotal;

    public Long getPlansCount (){
        return plansCount;
    }

    public void setPlansCount (Long plansCount){
        this.plansCount = plansCount;
    }

    public Long getCitizensApCnt (){
        return citizensApCnt;
    }

    public void setCitizensApCnt (Long citizensApCnt){
        this.citizensApCnt = citizensApCnt;
    }

    public Long getCitizensDnCnt (){
        return citizensDnCnt;
    }

    public void setCitizensDnCnt (Long citizensDnCnt){
        this.citizensDnCnt = citizensDnCnt;
    }

    public Double getBenefitAmtTotal (){
        return benefitAmtTotal;
    }

    public void setBenefitAmtTotal (Double benefitAmtTotal){
        this.benefitAmtTotal = benefitAmtTotal;
    }
}
