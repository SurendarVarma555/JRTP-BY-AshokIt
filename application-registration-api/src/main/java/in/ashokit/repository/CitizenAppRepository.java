package in.ashokit.repository;

import in.ashokit.entity.CitizenAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenAppRepository extends JpaRepository<CitizenAppEntity, Integer> {

    public CitizenAppEntity findByCitizenBySsn (Long citizenSsn);
}
