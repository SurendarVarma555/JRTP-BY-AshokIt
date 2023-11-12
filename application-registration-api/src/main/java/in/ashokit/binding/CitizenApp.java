package in.ashokit.binding;

import java.time.LocalDate;

/*
1. CitizenApp class is a binding class
2. It is used for request and response
3. From form whatever data coming as request we saved at server and gives response to client

* */
public class CitizenApp {
    private Integer caseNum;
    private String citizenName;
    private String citizenEmail;
    private Long citizenPhno;
    private String citizenGender;
    private LocalDate citizenDob;
    private Long citizenSsn;
    private LocalDate createDate;
    private LocalDate updateDate;
    private Integer createdBy;

    public Integer getCaseNum (){
        return caseNum;
    }

    public void setCaseNum (Integer caseNum){
        this.caseNum = caseNum;
    }

    public String getCitizenName (){
        return citizenName;
    }

    public void setCitizenName (String citizenName){
        this.citizenName = citizenName;
    }

    public String getCitizenEmail (){
        return citizenEmail;
    }

    public void setCitizenEmail (String citizenEmail){
        this.citizenEmail = citizenEmail;
    }

    public Long getCitizenPhno (){
        return citizenPhno;
    }

    public void setCitizenPhno (Long citizenPhno){
        this.citizenPhno = citizenPhno;
    }

    public String getCitizenGender (){
        return citizenGender;
    }

    public void setCitizenGender (String citizenGender){
        this.citizenGender = citizenGender;
    }

    public LocalDate getCitizenDob (){
        return citizenDob;
    }

    public void setCitizenDob (LocalDate citizenDob){
        this.citizenDob = citizenDob;
    }

    public Long getCitizenSsn (){
        return citizenSsn;
    }

    public void setCitizenSsn (Long citizenSsn){
        this.citizenSsn = citizenSsn;
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

    public Integer getCreatedBy (){
        return createdBy;
    }

    public void setCreatedBy (Integer createdBy){
        this.createdBy = createdBy;
    }
}
