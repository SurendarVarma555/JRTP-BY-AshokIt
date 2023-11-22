package in.ashokit.repository;

import in.ashokit.entity.CoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoRepo extends JpaRepository<CoEntity, Integer> {

    @Query("From CoEntity WHERE caseNum = :caseNum")
    public List<CoEntity> fetchByCaseNum (Integer caseNum);
}
