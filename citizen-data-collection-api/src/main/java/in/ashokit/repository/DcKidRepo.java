package in.ashokit.repository;

import in.ashokit.entity.DcKidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DcKidRepo extends JpaRepository<DcKidEntity, Integer> {

    public List<DcKidEntity> findByCaseNum (Integer caseNum);

}
