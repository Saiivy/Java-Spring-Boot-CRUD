package ca.sheridan.beans;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
/*
 * This class is a mission object, that will be used to create a mission as
 * whole
 * 
 */
public class Mission {
	private String title;
	private ArrayList weapons;
	private String hero;
	private final String[] heroes = {"Trevor","Franklin","Santos"};
}
	


