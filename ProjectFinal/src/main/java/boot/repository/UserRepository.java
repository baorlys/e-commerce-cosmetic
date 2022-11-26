package boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boot.entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
	UserInfo findByEmail(String email);
}
