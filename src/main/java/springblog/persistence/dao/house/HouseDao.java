package springblog.persistence.dao.house;

import java.util.List;

import springblog.persistence.entity.House;

public interface HouseDao {
	void saveHouse(House house);
	
	List<House> getAllHouses(int id);
	
	List<House> getAllHouses();
	
	void deleteHouse(House house);
	
	House findById(int id);

	void edit(House house);

	List<House> searchUser(String keyword);
}
