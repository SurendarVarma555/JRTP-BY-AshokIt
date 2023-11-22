package in.ashokit.repository;

import in.ashokit.entity.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepo extends JpaRepository<EducationEntity, Integer> {
    EducationEntity findByCaseNum (Integer caseNum);
}
