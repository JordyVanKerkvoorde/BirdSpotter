package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import service.SpottedBirdService;

@Controller	
public class BirdSpottingController {

	@Autowired
	private SpottedBirdService spottedBirdService;

	@GetMapping("/locationsall")
	public String SpottingLocations(Model model) {
		model.addAttribute("locations", spottedBirdService.findAll());
		return "allLocationsView";
	}

	@GetMapping("/location")
	public String SpotLocation(@ModelAttribute String name, Model model) {
		model.addAttribute("location", spottedBirdService.findByName(name));
		return "locationView";
	}
	
}
