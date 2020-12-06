package service;

import java.util.List;
import java.util.Optional;

import domain.BirdSpotLocation;

public interface SpottedBirdService {

    public List<BirdSpotLocation> findAll();

    public Optional<BirdSpotLocation> findByName(String name);
}