package in.ashokit.repository;

import in.ashokit.entity.CitizenAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.security.PublicKey;
import java.util.List;

public interface CitizenAppRepo extends JpaRepository<CitizenAppEntity, Integer> {

    public List<CitizenAppEntity> fetchUserApps ();

    @Query(value = "from CitizenAppEntity where userId=:userId ")
    public List<CitizenAppEntity> fetchCwApps (Integer userId);


}
