package domain;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BirdSpecie {
	@NotEmpty
	private String name;

	@NotNull
	@DecimalMin(value = "1250", message = "The earliest year of discovery allowed is 1250")
    private Integer yearOfDiscovery;

	@NotEmpty
	@Pattern(regexp = "^[A-Z]{1,2}[0-9]{3}", message = "Code should start with one or two capital letters [A-Z] followed by 3 digits.")
    private String code;
	
    public BirdSpecie() {
    	
    }
    
	public BirdSpecie(String name, Integer yearOfDiscovery, String code) {
		super();
		this.name = name;
		this.yearOfDiscovery = yearOfDiscovery;
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYearOfDiscovery() {
		return yearOfDiscovery;
	}

	public void setYearOfDiscovery(Integer yearOfDiscovery) {
		this.yearOfDiscovery = yearOfDiscovery;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return String.format("%s - %d (%s)", getName(), getYearOfDiscovery(), getCode());
	}
	
	
}
