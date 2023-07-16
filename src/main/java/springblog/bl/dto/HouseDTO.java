package springblog.bl.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springblog.persistence.entity.House;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {
	private int id;
	private String housingName;
	private String address;
	private String numberOfFloor;
	private String numberOfMasterRoom;
	private String numberOfSingleRoom;
	private String amount;
	
	public HouseDTO(House house) {
		this.id = house.getId();
		this.housingName = house.getHousingName();
		this.address = house.getAddress();
		this.numberOfFloor = house.getNumberOfFloor();
		this.numberOfMasterRoom = house.getNumberOfMasterRoom();
		this.numberOfSingleRoom = house.getNumberOfSingleRoom();
		this.amount = house.getAmount();
	}
	
}
