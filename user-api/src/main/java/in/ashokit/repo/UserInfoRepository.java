package in.ashokit.repo;

import in.ashokit.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity,Integer> {

}
