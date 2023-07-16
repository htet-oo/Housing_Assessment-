package springblog.bl.services.owner;

import springblog.web.form.OwnerForm;

public interface OwnerService {
	void saveOwner(OwnerForm ownerForm);
	
	int findOwnerByEmail(String email);
}
