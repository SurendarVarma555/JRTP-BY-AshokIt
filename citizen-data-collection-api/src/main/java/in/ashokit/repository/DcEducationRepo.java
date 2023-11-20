package in.ashokit.repository;

import in.ashokit.entity.DcEducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DcEducationRepo extends JpaRepository<DcEducationEntity, Integer> {

    public DcEducationEntity findByCaseNum (Integer caseNum);

}
