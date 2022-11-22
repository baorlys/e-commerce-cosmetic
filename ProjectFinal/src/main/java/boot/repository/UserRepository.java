package boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boot.entity.User_info;

@Repository
public interface UserRepository extends JpaRepository<User_info, Long> {
	User_info findByEmail(String email);
}
