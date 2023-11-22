package in.ashokit.repository;

import in.ashokit.entity.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepo extends JpaRepository<IncomeEntity, Integer> {
    public IncomeEntity findByCaseNum (Integer caseNum);

}
