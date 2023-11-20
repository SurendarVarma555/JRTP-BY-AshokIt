package in.ashokit.service;

import in.ashokit.binding.*;

import java.util.Map;

public interface DcService {

    public Map<Integer, String> getPlanNames ();

    public boolean updatePlanSelection (PlanSelection planSelection);

    public boolean saveIncome (Income income);

    public boolean saveEducation (Education education);

    public boolean saveKids (Kids kids);

    public Summary getSummaryInfo (Integer caseNum);

}
