package ca.sheridan.controllers;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridan.beans.Mission;
import ca.sheridan.database.DatabaseAccess;

@Controller
public class HomeController {

	private DatabaseAccess database;

	/*
	 * Returns main-page.
	 */
	@GetMapping("/")
	public String homePage(Model model, Mission mission) {
		model.addAttribute("mission", mission);
		System.out.println(mission);
		return "index";
	}

	public HomeController(DatabaseAccess database) {
		this.database = database;
	}

	/*
	 * Returns Create-Mission Page
	 */
	@GetMapping("/createMission")
	public String createMission(Model model) {
		model.addAttribute("mission", new Mission());
		return "createMission";
	}

	@PostMapping("/addMission")
	public String processForm(@ModelAttribute Mission mission, Model model) {
		System.out.println(mission);
		int result = database.addMission(mission);
		System.out.println(result);
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
	public String viewMission(Mission mission, @RequestParam("hero") String hero) {
		database.viewMission(hero);
		int result = database.viewMission(hero);
		System.out.println(result);
		System.out.println(hero);
		return "index";

	}
}
