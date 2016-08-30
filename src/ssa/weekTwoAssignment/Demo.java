package ssa.weekTwoAssignment;

public class Demo {

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	private int counter;
	private String description;
	private String name; 
	private int step;
	
	public int getStep() {
		return step;
	}
	
	public void setStep(int step) {
		if (step >=1 && step <= 10) {
			this.step = step;
		}
	}
	public String getDescription() {
		return description;	
	}
	public void setDescription(String adescription) {
		this.description = adescription;
	}
	
	
	public Demo () {
		step = 5;	
		}
	public Demo (int aStep) {
		// step = aStep;
		this.setStep(aStep);
	}
	}
