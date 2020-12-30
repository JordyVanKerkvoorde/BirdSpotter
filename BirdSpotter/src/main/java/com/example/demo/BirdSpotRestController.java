package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.SpottedBird;
import service.SpottedBirdService;

@RestController
@RequestMapping(value = "/birds-spotted")
public class BirdSpotRestController {

	@Autowired
	private SpottedBirdService spottedBirdService;
	
	@GetMapping(value = "/{id}")
	public List<SpottedBird> getBirdSpecie(@PathVariable("id") String name) {
		return spottedBirdService.findByName(name).get().getSpottedBirds();
	}
}
