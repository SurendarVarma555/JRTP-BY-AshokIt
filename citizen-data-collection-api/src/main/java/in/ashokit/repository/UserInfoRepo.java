package in.ashokit.repository;

import in.ashokit.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<UserInfoEntity, Integer> {
}
