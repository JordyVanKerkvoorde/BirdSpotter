package validator;

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
		
//		ValidationUtils.rejectIfEmpty(errors, "name", "required.name", "may not be empty");
//		
//		
//		String name = bird.getName();
//		if(name.isBlank() || name == null) {
//			errors.rejectValue("name",  "");
//		}
	}

}
