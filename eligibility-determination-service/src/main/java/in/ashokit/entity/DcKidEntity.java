package in.ashokit.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class DcKidEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kidId;

    private String kidName;

    private LocalDate kidDob;

    private Long kidSsn;

    @OneToOne
    @JoinColumn(name = "case_num")
    private CitizenAppEntity app;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfoEntity user;

    public Integer getKidId (){
        return kidId;
    }

    public void setKidId (Integer kidId){
        this.kidId = kidId;
    }

    public String getKidName (){
        return kidName;
    }

    public void setKidName (String kidName){
        this.kidName = kidName;
    }

    public LocalDate getKidDob (){
        return kidDob;
    }

    public void setKidDob (LocalDate kidDob){
        this.kidDob = kidDob;
    }

    public Long getKidSsn (){
        return kidSsn;
    }

    public void setKidSsn (Long kidSsn){
        this.kidSsn = kidSsn;
    }

    public CitizenAppEntity getApp (){
        return app;
    }

    public void setApp (CitizenAppEntity app){
        this.app = app;
    }

    public UserInfoEntity getUser (){
        return user;
    }

    public void setUser (UserInfoEntity user){
        this.user = user;
    }
}
