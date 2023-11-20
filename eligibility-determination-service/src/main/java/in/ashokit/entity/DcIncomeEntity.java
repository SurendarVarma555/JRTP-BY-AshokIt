package in.ashokit.entity;

import jakarta.persistence.*;

@Entity
public class DcIncomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer incomeId;
    private Double salaryIncome;
    private Double rentIncome;
    private Double propertyIncome;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfoEntity user;

    @OneToOne
    @JoinColumn(name = "case_num")
    private CitizenAppEntity app;

    public Integer getIncomeId (){
        return incomeId;
    }

    public void setIncomeId (Integer incomeId){
        this.incomeId = incomeId;
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

    public UserInfoEntity getUser (){
        return user;
    }

    public void setUser (UserInfoEntity user){
        this.user = user;
    }

    public CitizenAppEntity getApp (){
        return app;
    }

    public void setApp (CitizenAppEntity app){
        this.app = app;
    }
}
