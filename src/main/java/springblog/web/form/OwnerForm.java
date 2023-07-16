package springblog.web.form;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerForm {
	

	private int id;
	
	@NotBlank(message = "Please Enter UserName")
	private String ownerUserName;
	
	@NotBlank(message = "Please Enter OwnerName")
	private String ownerName;
	
	@NotBlank(message = "Please Enter Email")
	private String email;
	
	@NotBlank(message = "Please Enter Password")
	private String password;
	

}
