package in.ashokit.repository;

import in.ashokit.entity.CitizenAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenAppRepository extends JpaRepository<CitizenAppEntity, Integer> {

    public CitizenAppEntity findByCitizenBySsn (Long citizenSsn);

    public List<CitizenAppEntity> findByCreatedBy (Integer userId);
}
