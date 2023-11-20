package in.ashokit.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CITIZEN_APPS_REG")
public class CitizenAppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer caseNum;
    private String citizenName;
    private String citizenEmail;
    private Long citizenPhno;
    private String citizenGender;
    private LocalDate citizenDob;
    private Long citizenSsn;

    private Integer planId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfoEntity user;


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

    public Integer getPlanId (){
        return planId;
    }

    public void setPlanId (Integer planId){
        this.planId = planId;
    }

    public UserInfoEntity getUser (){
        return user;
    }

    public void setUser (UserInfoEntity user){
        this.user = user;
    }
}
