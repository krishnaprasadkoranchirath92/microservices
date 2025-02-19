package com.kp.user.service.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetails {
	@Id
	private String usrId;
	private String usrName;
	private String email;
	private String about;
	@Transient // field not saved in DB
	private List<Rating> ratingsList = new ArrayList<>();
}
