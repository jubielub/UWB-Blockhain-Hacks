
public class Data {

	public enum GeneralHealth {
		POOR, AVERAGE, GOOD, EXCELLENT, DEFAULT
	}

	public enum Gender {
		FEMALE, MALE, OTHER, DEFAULT
	}

	// all data points are initialized to default values to avoid null/empty data
	// points

	// indicator for their general health
	private GeneralHealth genHealth = GeneralHealth.DEFAULT;

	// what insurance plan they are on
	private int healthPlan = -1;

	// keeps track if the default smoke is the default value or not
	private boolean defaultSmoke100 = true;

	// if they smoked at least 100 cigarettes in a month
	private boolean smoke100 = false;

	// height of patient in inches
	private int height = -1;

	// weight of patient in lbs
	private double weight = -1;

	// patient's desired weight
	private double desiredWeight = -1;

	// how old patient is
	private int age = -1;

	// name
	private String name = "Default";

	// gender of patient
	private Gender gender = Gender.DEFAULT;

	public Data() {
		System.out.println("No data points exist for this patient. Please add data points.");
	}

	public Data(int healthPlan, int height, double weight, int age, Gender gender, String name) {
		setHealthPlan(healthPlan);
		setHeight(height);
		setWeight(weight);
		setAge(age);
		setGender(gender);
		setName(name);
	}

	public Data(GeneralHealth genHealth, int healthPlan, boolean smoke100, int height, double weight,
			double desiredWeight, int age, Gender gender, String name) {
		setGenHealth(genHealth);
		setHealthPlan(healthPlan);
		setSmoke100(smoke100);
		setHeight(height);
		setWeight(weight);
		setDesiredWeight(desiredWeight);
		setAge(age);
		setGender(gender);
		setName(name);
	}

	public Data(String name) {
		setName(name);
	}

	public GeneralHealth getGenHealth() {
		return genHealth;
	}

	public void setGenHealth(GeneralHealth genHealth) {
		if (genHealth != GeneralHealth.DEFAULT) {
			this.genHealth = genHealth;
		} else {
			System.out.println("Error: Invalid general health value given. Set to default, DEFAULT");
		}

	}

	public int getHealthPlan() {
		return healthPlan;
	}

	public void setHealthPlan(int healthPlan) {
		// checking for valid health plan input
		if (healthPlan >= 0 && healthPlan <= 4) {
			this.healthPlan = healthPlan;
		}

		// error message printed if invalid input is given
		else {
			System.out.println("Error: Invalid health plan information given. Setting to default, -1");

		}
	}

	public boolean getSmoke100() {
		return smoke100;
	}

	public void setSmoke100(boolean smoke100) {
		this.smoke100 = smoke100;
		this.defaultSmoke100 = false;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height > 0 && height < 108) {
			this.height = height;
		}

		else {
			System.out.println("Error: Invalid height information given. Setting to default, -1");
		}
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if (weight > 0 && weight < 1400) {
			this.weight = weight;
		}

		else {
			System.out.println("Error: Invalid weight information given. Setting to default, -1");
		}
	}

	public double getDesiredWeight() {
		return desiredWeight;
	}

	public void setDesiredWeight(double desiredWeight) {
		if (desiredWeight > 0 && desiredWeight < 1400) {
			this.desiredWeight = desiredWeight;
		}

		else {
			System.out.println("Error: Invalid desired weight information given. Setting to default, -1");
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0 && age < 122) {
			this.age = age;
		}

		else {
			System.out.println("Error: Invalid age information given. Setting to default, -1");
		}
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		if (gender != Gender.DEFAULT) {
			this.gender = gender;
		}

		else {
			System.out.println("Error: Invalid gender information given. Setting to default, DEFAULT");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!name.isBlank()) {
			this.name = name;
		}
		
		else {
			System.out.println("Error: Invalid gender information given. Setting to default, Default");
		}
	}
	
	public String toString() {
		return "General Health: " + this.genHealth + "\nHealth Plan: " + this.healthPlan + "\nSmoke 100: " + this.defaultSmoke100 +
				"\nHeight: " + this.height + "\nWeight: " + this.weight + "\nDesired weight: " + this.desiredWeight + "\nAge: " + this.age +
				"\nGender: " + this.gender + "\nName: " + this.name;
	}
}
