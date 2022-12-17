package boot.entity;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Data
@Table(name = "role",uniqueConstraints = {@UniqueConstraint(columnNames =  "role_name")})
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false)
	private long roleId;
	
	@Column(name = "role_name", length = 50, nullable = false)
	private String roleName;

	@ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

	
	
}
