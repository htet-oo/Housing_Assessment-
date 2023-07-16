package springblog.bl.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springblog.bl.dto.OwnerDTO;
import springblog.persistence.dao.owner.OwnerDao;
import springblog.persistence.entity.Owner;

@Service
public class RoleDetailsService implements UserDetailsService {
	
	@Autowired
	private OwnerDao ownerDao;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("before find");
		System.out.println(username);
		ownerDao.findByEmail(username);
		System.out.println("after find");
		OwnerDTO ownerDto = new OwnerDTO(ownerDao.findByEmail(username));
		return ownerDto;
	}

}
