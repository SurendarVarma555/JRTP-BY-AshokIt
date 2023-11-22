package in.ashokit.repository;

import in.ashokit.entity.KidEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KidRepo extends JpaRepository<KidEntity, Integer> {
    public List<KidEntity> findByCaseNum (Integer caseNum);
}
