package springblog.persistence.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "owner")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String ownerUserName;
	
	@Column(nullable = false, length = 100)
	private String ownerName;
	
	@Column(nullable = false, length = 30)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@CreationTimestamp
	private Date created_at;

	@UpdateTimestamp
	private Date updated_at;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<House> houses;
	
}
