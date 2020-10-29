package ca.sheridan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridan.beans.Mission;
import ca.sheridan.database.DatabaseAccess;

@Controller
public class HomeController {

	private DatabaseAccess database;

	/**
	 * Using this we will redirect users to index page
	 * @param model
	 * @param mission
	 * @return index
	 */
	@GetMapping("/")
	public String homePage(Model model, Mission mission) {
		model.addAttribute("mission", mission);
		return "index";
	}
    
	/*
	 * A constructor for the database access
	 * to be used here for making CRUD operations using 
	 * user's data
	 */
	public HomeController(DatabaseAccess database) {
		this.database = database;
	}

    /**
     * Whenever user clicks on the link, he will be redirected to Createmission page,
     * where he can add data to be added to database
     * @param model
     * @return create mision
     */
	@GetMapping("/createMission")
	public String createMission(Model model) {
		model.addAttribute("mission", new Mission());
		return "createMission";
	}
    
	/**
	 * This method allows us to add mission to database 
	 * calling the mission method using database constructor 
	 * @param mission
	 * @param model
	 * @return index page.
	 */
	@PostMapping("/addMission")
	public String processForm(@ModelAttribute Mission mission, Model model) {
		database.addMission(mission);
		String message = "Mission Created Successfully";
		model.addAttribute("message",message);
		return "index";

	}

	/**
	 * Created to get the name of the hero user wish to see missions for query the
	 * database, if name matches missions are listed else user sees an error.
	 * 
	 * @param mission
	 * @param hero
	 * @return viewMission page.
	 */
	@GetMapping("/viewMissions/")
	public String viewMission(@RequestParam("hero") String hero,Model model) {   
		System.out.println(database.viewMission(hero));
		model.addAttribute("missionList",database.viewMission(hero));
		model.addAttribute("hero",hero);
		return "viewMissions";

	}
	
	/**
	 * Invoking the deleteMission method using database constructor
	 * which will delete the mission user desires using an unique ID.
	 * @param id
	 * @return index
	 */
	@GetMapping("/delete/{id}")
	public String deleteMission(@PathVariable Long id) {
		database.deleteMission(id);
			return "redirect:/";
		        
		
	}
}
