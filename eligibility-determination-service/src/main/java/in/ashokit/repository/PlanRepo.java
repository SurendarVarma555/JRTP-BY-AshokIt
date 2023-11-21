package in.ashokit.repository;

import in.ashokit.entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepo extends JpaRepository<PlanEntity, Integer> {
}
