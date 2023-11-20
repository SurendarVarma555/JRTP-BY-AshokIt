package in.ashokit.binding;

public class Summary {

    private Integer caseNum;
    private String planName;
    private Income income;
    private Education education;
    private Kids kids;

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

    public Income getIncome (){
        return income;
    }

    public void setIncome (Income income){
        this.income = income;
    }

    public Education getEducation (){
        return education;
    }

    public void setEducation (Education education){
        this.education = education;
    }

    public Kids getKids (){
        return kids;
    }

    public void setKids (Kids kids){
        this.kids = kids;
    }
}
