package in.ashokit.repository;

import in.ashokit.entity.DcPlanMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanMasterRepo extends JpaRepository<DcPlanMasterEntity, Integer> {


}
