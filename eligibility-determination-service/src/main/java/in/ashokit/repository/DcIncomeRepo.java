package in.ashokit.repository;

import in.ashokit.entity.DcIncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DcIncomeRepo extends JpaRepository<DcIncomeEntity, Integer> {
    public DcIncomeEntity findByCaseNum (Integer caseNum);
}
