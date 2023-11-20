package in.ashokit.repository;

import in.ashokit.entity.CitizenInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenInfoRepository extends JpaRepository<CitizenInfo,String> {
}
