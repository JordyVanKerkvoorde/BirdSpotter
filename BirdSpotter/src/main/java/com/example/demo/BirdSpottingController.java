package com.example.demo;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.BirdSpecie;
import domain.BirdSpotLocation;
import service.SpottedBirdService;
import validator.NewSpotValidator;

@Controller	
@RequestMapping("/birdspotting")
public class BirdSpottingController {

	@Autowired
	private NewSpotValidator newSpotValidator;
	
	@Autowired
	private SpottedBirdService spottedBirdService;

	@GetMapping("")
	public String SpottingLocations(Model model) {
		model.addAttribute("locations", spottedBirdService.findAll());
		return "allLocationsView";
	}

	
	@GetMapping(value = "/{id}")
	public String SpotLocation(@PathVariable("id") String name, Model model) {
		Optional<BirdSpotLocation> spot = spottedBirdService.findByName(name);
		
		if(!spot.isPresent()) {
			return "redirect:/birdspotting";
		}
		
		model.addAttribute("location", spot.get());
		return "locationView";
	}
	
	
	@GetMapping(value = "/{id}/create-new-spotting")
	public String NewSpotting(@PathVariable(value="id") String name, Model model) {
		Optional<BirdSpotLocation> spot = spottedBirdService.findByName(name);
		
		if(!spot.isPresent()) {
			return "redirect:/birdspotting";
		}
		
		BirdSpecie specie = new BirdSpecie();
		model.addAttribute("birdSpecie", specie);
		model.addAttribute("location", spot.get());
		
		return "newSpottingView";
	}
	
	@PostMapping("/{id}/create-new-spotting")
	public String spotNewBird(@PathVariable(value="id") String name, @Valid BirdSpecie birdSpecie, BindingResult result, Model model) {
		newSpotValidator.validate(birdSpecie, result);
		
		
		if(result.hasErrors()) {
			return "newSpottingView";
		}
		
		Optional<BirdSpotLocation> spot = spottedBirdService.findByName(name);
		
		if(spot.isEmpty()) {
			return "redirect:/birdspotting";
		}
		
		spot.get().increaseBirdSpot(birdSpecie);
		
		return "redirect:/birdspotting";
	}
	
	
}
