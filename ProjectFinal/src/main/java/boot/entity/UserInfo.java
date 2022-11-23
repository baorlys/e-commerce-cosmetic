package boot.entity;

import lombok.Data;

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
@Data
@Table(name = "user_info",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id",nullable = false)
	private long userId;
	
	@Column(name = "full_name",length = 50)
	private String fullName;
	
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

	

	public UserInfo(String full_name, String email, String password, String address, String phone,
			int point, Collection<Role> roles) {
		super();
		
		this.fullName = full_name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.point = point;
		this.roles = roles;
	}

	public UserInfo() {
		super();
		this.fullName = "";
		this.email = "";
		this.password = "";
		this.address = "";
		this.phone = "";
		this.point = 0;
		this.roles = null;
	}


	
}
