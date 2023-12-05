package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "ELIG_DTLS")
public class EligibilityDetails {

    @Id
    private Integer eligId;
    private String name;
    private Long mobile;
    private String email;
    private Character gender;
    private Long ssn;
    private String planName;
    private String planStatus;
    private LocalDate planStartDate;
    private LocalDate planEndDate;
    private LocalDate createDate;
    private LocalDate updateDate;
    private String createdBy;
    private String updatedBy;

    public Integer getEligId (){
        return eligId;
    }

    public void setEligId (Integer eligId){
        this.eligId = eligId;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public Long getMobile (){
        return mobile;
    }

    public void setMobile (Long mobile){
        this.mobile = mobile;
    }

    public String getEmail (){
        return email;
    }

    public void setEmail (String email){
        this.email = email;
    }

    public Character getGender (){
        return gender;
    }

    public void setGender (Character gender){
        this.gender = gender;
    }

    public Long getSsn (){
        return ssn;
    }

    public void setSsn (Long ssn){
        this.ssn = ssn;
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

    public LocalDate getCreateDate (){
        return createDate;
    }

    public void setCreateDate (LocalDate createDate){
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate (){
        return updateDate;
    }

    public void setUpdateDate (LocalDate updateDate){
        this.updateDate = updateDate;
    }

    public String getCreatedBy (){
        return createdBy;
    }

    public void setCreatedBy (String createdBy){
        this.createdBy = createdBy;
    }

    public String getUpdatedBy (){
        return updatedBy;
    }

    public void setUpdatedBy (String updatedBy){
        this.updatedBy = updatedBy;
    }
}
