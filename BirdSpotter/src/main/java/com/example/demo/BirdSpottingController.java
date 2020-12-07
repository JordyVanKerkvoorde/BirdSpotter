package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.BirdSpotLocation;
import service.SpottedBirdService;

@Controller	
@RequestMapping("/birdspotting")
public class BirdSpottingController {

	@Autowired
	private SpottedBirdService spottedBirdService;

	@GetMapping("")
	public String SpottingLocations(Model model) {
		model.addAttribute("locations", spottedBirdService.findAll());
		return "allLocationsView";
	}

	//@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@GetMapping(value = "/{id}")
	public String SpotLocation(@PathVariable("id") String name, Model model) {
		Optional<BirdSpotLocation> spot = spottedBirdService.findByName(name);
		
		if(spot.isPresent()) {
			return "redirect:/birdspotting";
		}
		
		model.addAttribute("location", spot.get());
		return "locationView";
	}
	
}
