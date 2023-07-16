package springblog.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "house")
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String housingName;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String numberOfFloor;
	
	@Column(nullable = false)
	private String numberOfMasterRoom;
	
	@Column(nullable = false)
	private String numberOfSingleRoom;
	
	@Column(nullable = false)
	private String amount;
	
	@CreationTimestamp
	private Date created_at;

	@UpdateTimestamp
	private Date updated_at;
	
	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false)
	private Owner owner;

	
}
