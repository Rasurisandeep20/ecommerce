package com.dnb.ecommerce.dto;

import java.time.LocalDate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.dnb.ecommerce.utils.CustomProductIdGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode 
@Entity
public class Product {
	/*
	 product fields: productId
	                 productName
	                 price
	                 description
	                 expirationDate
	                 category
	 */
	
	/*
	 * validation conditions for all fields:
	 * productName,description,category should not blank price must be
	 * positive value and notnull 
	 */
		
	// productId must be Generated value

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@GenericGenerator(name = "product_seq", type = CustomProductIdGenerator.class, parameters = {
			@Parameter(name = CustomProductIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = CustomProductIdGenerator.VALUE_PREFIX_PARAMETER, value = "PR_"),
			@Parameter(name = CustomProductIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String productId;
	@NotBlank(message = "Product Cannot be blank")
	private String productName;
	@NotNull(message = "Price cannot be Null")
	@Min(value = 0, message = "Price cannot be negative")
	private float price;
	@NotBlank(message = "Description cannot be null")
	private String description;
	private LocalDate expirationDate;
	private String category;

}
