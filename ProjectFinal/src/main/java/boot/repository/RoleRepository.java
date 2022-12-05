package boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boot.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRoleName(String name);
}
