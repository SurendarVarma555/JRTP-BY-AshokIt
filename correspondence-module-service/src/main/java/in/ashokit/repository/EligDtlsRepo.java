package in.ashokit.repository;

import in.ashokit.entity.EligDtlsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EligDtlsRepo extends JpaRepository<EligDtlsEntity, Integer> {
    @Query("From EligDtlsEntity WHERE caseNum = :caseNum")
    public EligDtlsEntity fetchByCaseNum (Integer caseNum);
}
