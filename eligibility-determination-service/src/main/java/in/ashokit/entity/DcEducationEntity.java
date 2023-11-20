package in.ashokit.entity;

import jakarta.persistence.*;

@Entity
public class DcEducationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eduId;

    private String highestDegree;

    private Integer graduationYear;

    private String uniName;

    @OneToOne
    @JoinColumn(name="case_num")
    private CitizenAppEntity app;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfoEntity user;

    public Integer getEduId (){
        return eduId;
    }

    public void setEduId (Integer eduId){
        this.eduId = eduId;
    }

    public String getHighestDegree (){
        return highestDegree;
    }

    public void setHighestDegree (String highestDegree){
        this.highestDegree = highestDegree;
    }

    public Integer getGraduationYear (){
        return graduationYear;
    }

    public void setGraduationYear (Integer graduationYear){
        this.graduationYear = graduationYear;
    }

    public String getUniName (){
        return uniName;
    }

    public void setUniName (String uniName){
        this.uniName = uniName;
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
