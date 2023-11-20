package in.ashokit.binding;

public class Income {

    private Integer caseNum;
    private Double salaryIncome;
    private Double rentIncome;
    private Double propertyIncome;

    private Integer userId;

    public Integer getCaseNum (){
        return caseNum;
    }

    public void setCaseNum (Integer caseNum){
        this.caseNum = caseNum;
    }

    public Double getSalaryIncome (){
        return salaryIncome;
    }

    public void setSalaryIncome (Double salaryIncome){
        this.salaryIncome = salaryIncome;
    }

    public Double getRentIncome (){
        return rentIncome;
    }

    public void setRentIncome (Double rentIncome){
        this.rentIncome = rentIncome;
    }

    public Double getPropertyIncome (){
        return propertyIncome;
    }

    public void setPropertyIncome (Double propertyIncome){
        this.propertyIncome = propertyIncome;
    }

    public Integer getUserId (){
        return userId;
    }

    public void setUserId (Integer userId){
        this.userId = userId;
    }
}
