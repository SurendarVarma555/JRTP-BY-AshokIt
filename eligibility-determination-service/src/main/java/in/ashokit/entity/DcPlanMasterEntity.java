package in.ashokit.entity;

import jakarta.persistence.*;

@Entity
public class DcPlanMasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    private String planName;

    @OneToOne
    @JoinColumn(name = "case_num")
    private CitizenAppEntity app;

    public CitizenAppEntity getApp (){
        return app;
    }

    public void setApp (CitizenAppEntity app){
        this.app = app;
    }

    public Integer getPlanId (){
        return planId;
    }

    public void setPlanId (Integer planId){
        this.planId = planId;
    }

    public String getPlanName (){
        return planName;
    }

    public void setPlanName (String planName){
        this.planName = planName;
    }
}
