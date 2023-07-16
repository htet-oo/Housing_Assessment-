package springblog.bl.services.owner.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springblog.bl.services.owner.OwnerService;
import springblog.persistence.dao.owner.OwnerDao;
import springblog.persistence.entity.Owner;
import springblog.web.form.OwnerForm;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void saveOwner(OwnerForm ownerForm) {
		Owner owner = new Owner();
		owner.setOwnerUserName(ownerForm.getOwnerUserName());
		owner.setOwnerName(ownerForm.getOwnerName());
		owner.setEmail(ownerForm.getEmail());
		owner.setPassword(passwordEncoder.encode(ownerForm.getPassword()));
		owner.setCreated_at(new Date());
		ownerDao.saveOwner(owner);
	}

	@Override
	public int findOwnerByEmail(String email) {
		Owner owner = ownerDao.findByEmail(email);
		return owner.getId();
	}



}
