package springblog.bl.services.house;

import java.util.List;
import springblog.bl.dto.HouseDTO;
import springblog.persistence.entity.House;
import springblog.web.form.HouseForm;

public interface HouseService {
	void saveHoust(HouseForm houseForm,String account);
	
	List<House> getAllHouses(int id);
	
	List<House> getAllHouses();

	void deletePost(int deleteId);
	
	HouseDTO findById(int id);

	void editUser(HouseForm houseForm);

	List<House> searchHouse(String keyword);
}
