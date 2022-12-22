package boot.entity;

import lombok.Data;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
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
	
	@Column(name = "reset_password_token")
	private String resetPasswordToken;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
        inverseJoinColumns = @JoinColumn(
            name = "role_id", referencedColumnName = "role_id"))
    private Collection < Role > roles;

}
