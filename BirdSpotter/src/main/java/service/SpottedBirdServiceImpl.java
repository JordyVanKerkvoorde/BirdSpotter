package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import domain.BirdSpecie;
import domain.BirdSpotLocation;

public class SpottedBirdServiceImpl implements SpottedBirdService {
	private static final List<BirdSpotLocation> birdSpotLocations = new ArrayList<>();
	
	private static void spotBirds(BirdSpotLocation birdSpotLocation, BirdSpecie birdSpecie, int count) {
		birdSpotLocation.newBirdSpot(birdSpecie);
		
		IntStream.range(0, count)
			.forEach(index -> birdSpotLocation.increaseBirdSpot(birdSpecie));
	}

	static {
		BirdSpotLocation birdSpotLocation = new BirdSpotLocation("Gent");

		spotBirds(birdSpotLocation, new BirdSpecie("Aquatic Warbler", 1788, "AW899"), 523);
		spotBirds(birdSpotLocation, new BirdSpecie("Arctic skua", 1655, "AS457"), 125);
		spotBirds(birdSpotLocation, new BirdSpecie("Bewick's swan", 1654, "BS333"), 587);
		birdSpotLocations.add(birdSpotLocation);

		birdSpotLocation = new BirdSpotLocation("Everglades_National_Park");
		spotBirds(birdSpotLocation, new BirdSpecie("Wood Duck", 1879, "WD503"), 2546);
		spotBirds(birdSpotLocation, new BirdSpecie("American Wigeon", 1676, "AW315"), 123);
		spotBirds(birdSpotLocation, new BirdSpecie("Mallard", 1756, "M896"), 45);
		spotBirds(birdSpotLocation, new BirdSpecie("Black Scoter", 1756, "BS578"), 78);
		birdSpotLocations.add(birdSpotLocation);

		birdSpotLocation = new BirdSpotLocation("Moskou");
		spotBirds(birdSpotLocation, new BirdSpecie("ChiffChaff", 1902, "CC145"), 852);
		spotBirds(birdSpotLocation, new BirdSpecie("Collard dove", 1789, "CD846"), 784);
		spotBirds(birdSpotLocation, new BirdSpecie("Coot", 1788, "C986"), 365);
		birdSpotLocations.add(birdSpotLocation);
		
		birdSpotLocation = new BirdSpotLocation("New_York");
		birdSpotLocations.add(birdSpotLocation);

		birdSpotLocation = new BirdSpotLocation("Sidney");
		spotBirds(birdSpotLocation, new BirdSpecie("Goldcrest", 1656, "G254"), 855);
		spotBirds(birdSpotLocation, new BirdSpecie("Glaucous gull", 1699, "GG364"), 237);
		spotBirds(birdSpotLocation, new BirdSpecie("Golden pheasant", 1725, "GP548"), 789);
		spotBirds(birdSpotLocation, new BirdSpecie("Goshawk", 1726, "G996"), 253);
		birdSpotLocations.add(birdSpotLocation);
	}

	@Override
	public List<BirdSpotLocation> findAll() {
		return birdSpotLocations;
	}

	@Override
	public Optional<BirdSpotLocation> findByName(String name) {

		return birdSpotLocations.stream().filter(i -> i.getName().equalsIgnoreCase(name)).findFirst();
	}
}