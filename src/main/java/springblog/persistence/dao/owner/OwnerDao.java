package springblog.persistence.dao.owner;

import springblog.persistence.entity.Owner;

public interface OwnerDao {
	void saveOwner(Owner owner);
	
	Owner findByEmail(String email);
}
