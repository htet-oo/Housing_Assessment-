package springblog.web.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springblog.bl.dto.HouseDTO;
import springblog.persistence.entity.Owner;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseForm {

	private int id;
	
	@NotBlank(message = "Please Enter Housing Name")
	private String housingName;
	
	@NotBlank(message = "Please Enter Address")
	private String address;
	
	@NotNull(message = "Please Enter Number of Floors")
	private String numberOfFloor;
	
	@NotNull(message = "Please Enter Number of Master Rooms")
	private String numberOfMasterRoom;
	
	@NotNull(message = "Please Enter Number of Single Rooms")
	private String numberOfSingleRoom;
	
	@NotNull(message = "Please Enter Amount")
	private String amount;
	
	private String email;
	
	
	public HouseForm(HouseDTO houeDto) {
		this.id = houeDto.getId();
		this.housingName = houeDto.getHousingName();
		this.address = houeDto.getAddress();
		this.numberOfFloor = houeDto.getNumberOfFloor();
		this.numberOfMasterRoom = houeDto.getNumberOfMasterRoom();
		this.numberOfSingleRoom = houeDto.getNumberOfSingleRoom();
		this.amount = houeDto.getAmount();
	}
	
	

}
