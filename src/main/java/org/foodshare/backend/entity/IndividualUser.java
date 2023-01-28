package org.foodshare.backend.entity;

import org.foodshare.backend.validator.NoFunnyNames;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true) //include attributes from superclass in the equals and hashcode methods
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class IndividualUser extends BaseUserModel{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Setter(AccessLevel.NONE) // prevent manually setting of Id using lombok, all Id must be generated by the database to maintain integrity
	 @Column(unique=true)
	 private Long id;
	 
	 @NoFunnyNames
	 @NotBlank
	 @Size(min = 6, max=50)
	 @Pattern(regexp="^\\D*$") //no digits
	 @Column(nullable=false)
	 private String name; 
	 
	 @Nullable
	 @Pattern(regexp="^\\+[0-9]+[0-9]+") //country code and phone number
	 @Column(nullable=true)
	 private String mobileNo;
	 
	 @NotNull
	 @Column(nullable=false)
	 private Integer postcode;
	 
	 @Min(value=0)
	 @Column(nullable=false)
	 private Integer rewardPts = 0;

}
