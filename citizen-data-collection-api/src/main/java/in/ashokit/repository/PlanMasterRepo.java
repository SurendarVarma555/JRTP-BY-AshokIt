package in.ashokit.repository;

import in.ashokit.entity.DcPlanMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlanMasterRepo extends JpaRepository<DcPlanMasterEntity, Integer> {


}
