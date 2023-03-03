package com.validations.validation.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@NotEmpty(message="username should not be empty")
	private String username;
	@NotEmpty	@Pattern(regexp = "[0-9]{10}", 
			message = "Phone number doesnot match the pattern")
	private String contactno;
	@NotNull(message="gender should not be null")
	private String gender;

}
