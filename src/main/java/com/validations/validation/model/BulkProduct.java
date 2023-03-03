package com.validations.validation.model;

import java.util.List;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulkProduct {
	  @NotEmpty(message="Product should not be empty")
	  List<@Valid Product> products;


}
