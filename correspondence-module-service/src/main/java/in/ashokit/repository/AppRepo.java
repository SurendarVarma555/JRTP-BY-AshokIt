package in.ashokit.repository;

import in.ashokit.entity.AppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepo extends JpaRepository<AppEntity, Integer> {
}
