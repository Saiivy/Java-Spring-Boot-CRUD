package ca.sheridan.beans;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
/*
 * This class is a mission object, that will be used to create a mission as a
 * whole
 * 
 */
public class Mission {
	private String id;
	private String title;
	private String hero;
	private String primaryWeapon;
	private String secondaryWeapon;
	private final String[] heroes = {"Trevor","Franklin","Santos"};
}
	


