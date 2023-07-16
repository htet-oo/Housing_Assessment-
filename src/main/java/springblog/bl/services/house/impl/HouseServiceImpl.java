package springblog.bl.services.house.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springblog.bl.dto.HouseDTO;
import springblog.bl.services.house.HouseService;
import springblog.persistence.dao.house.HouseDao;
import springblog.persistence.dao.owner.OwnerDao;
import springblog.persistence.entity.House;
import springblog.persistence.entity.Owner;
import springblog.web.form.HouseForm;

@Service
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	private HouseDao houseDao;
	
	@Autowired
	private OwnerDao ownerDao;
	
	@Override
	public void saveHoust(HouseForm houseForm,String account) {
		House house = new House();
		house.setAddress(houseForm.getAddress());
		house.setAmount(houseForm.getAmount());
		house.setCreated_at(new Date());
		house.setHousingName(houseForm.getHousingName());
		house.setNumberOfFloor(houseForm.getNumberOfFloor());
		house.setNumberOfMasterRoom(houseForm.getNumberOfMasterRoom());
		house.setNumberOfSingleRoom(houseForm.getNumberOfSingleRoom());
		
		Owner owner = ownerDao.findByEmail(account);
		house.setOwner(owner);
		
		houseDao.saveHouse(house);
		
	}

	@Override
	public List<House> getAllHouses(int id) {
	    return houseDao.getAllHouses(id);
	}

	@Override
	public void deletePost(int deleteId) {
		houseDao.deleteHouse(houseDao.findById(deleteId));
		
	}

	@Override
	public HouseDTO findById(int id) {
		House house = houseDao.findById(id);
		return new HouseDTO(house);
	}

	@Override
	public void editUser(HouseForm houseForm) {
		House house = houseDao.findById(houseForm.getId());
		house.setHousingName(houseForm.getHousingName());
		house.setAddress(houseForm.getAddress());
		house.setNumberOfFloor(houseForm.getNumberOfFloor());
		house.setNumberOfMasterRoom(houseForm.getNumberOfMasterRoom());
		house.setNumberOfSingleRoom(houseForm.getNumberOfSingleRoom());
		house.setAmount(houseForm.getAmount());
		house.setUpdated_at(new Date());
		houseDao.edit(house);
		
	}

	@Override
	public List<House> searchHouse(String keyword) {
		List<House> houseList = houseDao.searchUser(keyword);
		return houseList;
	}

	@Override
	public List<House> getAllHouses() {
		List<House> houseList = houseDao.getAllHouses();
		return houseList;
	}



}
