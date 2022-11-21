package boot.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_info",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User_info {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id",nullable = false)
	private long user_id;
	
	@Column(name = "full_name",length = 50)
	private String full_name;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
    private String password;
    
	@Column(name = "address",  length = 250)
	private String address;
	
	@Column(name = "phone", length = 50)
	private String phone;
	
	@Column(name = "point")
	private int point;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "users",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
        inverseJoinColumns = @JoinColumn(
            name = "role_id", referencedColumnName = "role_id"))
    private Collection < Role > roles;

	

	public User_info(String full_name, String email, String password, String address, String phone,
			int point, Collection<Role> roles) {
		super();
		
		this.full_name = full_name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.point = point;
		this.roles = roles;
	}

	public User_info() {
		super();
		this.full_name = "";
		this.email = "";
		this.password = "";
		this.address = "";
		this.phone = "";
		this.point = 0;
		this.roles = null;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	
}
