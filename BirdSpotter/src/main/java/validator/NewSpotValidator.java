package validator;

import java.time.Year;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import domain.BirdSpecie;

public class NewSpotValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BirdSpecie.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BirdSpecie bird = (BirdSpecie) target;
		if(bird.getYearOfDiscovery() != null) {
			if(bird.getYearOfDiscovery() > Year.now().getValue()) {
				errors.rejectValue("yearOfDiscovery", "yearOfDiscovery.future","You cannot discover birds in the future!");
			}
		}
	}

}
