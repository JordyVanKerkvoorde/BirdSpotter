package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BirdSpotLocation {
	private String name;
	
	private final List<SpottedBird> spottedBirds;

	public BirdSpotLocation(String name) {
		setName(name);
		spottedBirds = new ArrayList<>();
	}

	public List<SpottedBird> getSpottedBirds() {
		return spottedBirds;
	}
	
	public void newBirdSpot(BirdSpecie birdSpecies) {
		spottedBirds.add(new SpottedBird(birdSpecies));
	}
	
	public void increaseBirdSpot(BirdSpecie birdSpecies) {
		Optional<SpottedBird> birdSpot = spottedBirds.stream()
			.filter(b -> b.getBirdSpecie().equals(birdSpecies))
			.findFirst();
		
		if (birdSpot.isPresent()) {
			birdSpot.get().increaseCount();
		} else {
			newBirdSpot(birdSpecies);
		}
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
