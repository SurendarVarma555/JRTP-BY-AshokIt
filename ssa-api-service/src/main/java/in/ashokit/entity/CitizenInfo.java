package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Citizen_Info")
public class CitizenInfo {

    @Id
    private String ssn;
    private String citizenName;
    private LocalDate citizenDob;
    private String citizenGender;

    public String getSsn (){
        return ssn;
    }

    public void setSsn (String ssn){
        this.ssn = ssn;
    }

    public String getCitizenName (){
        return citizenName;
    }

    public void setCitizenName (String citizenName){
        this.citizenName = citizenName;
    }

    public LocalDate getCitizenDob (){
        return citizenDob;
    }

    public void setCitizenDob (LocalDate citizenDob){
        this.citizenDob = citizenDob;
    }

    public String getCitizenGender (){
        return citizenGender;
    }

    public void setCitizenGender (String citizenGender){
        this.citizenGender = citizenGender;
    }
}
