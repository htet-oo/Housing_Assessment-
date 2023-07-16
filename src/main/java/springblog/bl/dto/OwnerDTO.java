package springblog.bl.dto;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springblog.persistence.entity.Owner;;

@SuppressWarnings("serial")
@Getter
@Setter

public class OwnerDTO implements UserDetails {

	private int id;
	private String email;
	private String ownerName;
	private String ownerUserName;
	private Date created_at;
	private String password;
	private SimpleGrantedAuthority role;
	
	
	public OwnerDTO(Owner owner) {
		this.id = owner.getId();
		this.email = owner.getEmail();
		this.ownerName = owner.getOwnerName();
		this.ownerUserName = owner.getOwnerUserName();
		this.created_at = owner.getCreated_at();
		this.password = owner.getPassword();
		this.role = new SimpleGrantedAuthority("Owner");
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(role);
	}
	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}

}
