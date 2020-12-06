package domain;

public class SpottedBird {
	private BirdSpecie birdSpecie;
	private Integer count;
	
	public SpottedBird(BirdSpecie birdSpecie) {
		super();
		this.birdSpecie = birdSpecie;
		count = 1;
	}
	
	public void increaseCount() {
		count++;
	}
	
	public BirdSpecie getBirdSpecie() {
		return birdSpecie;
	}
	
	public Integer getCount() {
		return count;
	}
	
	@Override
	public String toString() {
		return String.format("%s (%d)", birdSpecie.getName(), getCount());
	}
}
