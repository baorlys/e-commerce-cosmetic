package boot.entity;


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
@Table(name = "role",uniqueConstraints = {@UniqueConstraint(columnNames =  "role_name")})
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false)
	private long roleId;
	
	@Column(name = "role_name", length = 50, nullable = false)
	private String roleName;

	@ManyToMany(mappedBy = "roles")
    private List<User_info> users = new ArrayList<>();
    
	public List<User_info> getUsers() {
		return users;
	}

	public void setUsers(List<User_info> users) {
		this.users = users;
	}

	
	public Role(String roleName, List<User_info> users) {
		super();
		this.roleName = roleName;
		this.users = users;
	}

	public Role() {
		super();
		this.roleName = "";
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
