import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.*;

public class Driver {

	public static void main(String[] args) throws IOException {

		// creating new File instance with patient information.txt
		File patientInfo = new File("patient information.txt");

		// using FileWriter, PrintWriter, and BufferedWriter to write to patient information.txt
		FileWriter fw = new FileWriter(patientInfo);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		// checks file to see if system already has users who previously registered and have their own Block
		 // use data to create new 

		// Scanner object to take in user input
		Scanner sc = new Scanner(System.in);

		System.out.println("Hello, welcome to MedBlock.");
		System.out.println("What would you like to do today? \nPress A if you would like to make a new account. "
				+ "\nPress B if you would like to login to an exisiting account."
				+ "\nPress any key if you would like to exit.");

		if ("A".equals(sc.next())) {
			createAccount(sc, pw);
		}

		else if ("B".equals(sc.next())) {
			// run something
		}

		else {
			exitProgram();
		}
	}
	
	public static Block createAccount(Scanner sc, PrintWriter pw) {
		
		// all data points are initialized to default values to avoid null/empty data
		// points

		// indicator for their general health
		GeneralHealth genHealth = GeneralHealth.DEFAULT;

		// what insurance plan they are on
		int healthPlan = -1;

		// if they smoked at least 100 cigarettes in a month
		boolean smoke100 = false;

		// height of patient in inches
		int height = -1;

		// weight of patient in lbs
		double weight = -1;

		// patient's desired weight
		double desiredWeight = -1;

		// how old patient is
		int age = -1;

		// name
		String name = "Default";
		
		
		// password
		String password = "Default";

		// gender of patient
		Gender gender = Gender.DEFAULT;

		
		System.out.println("What is your name?");
		name = sc.next();
		
		System.out.println("Which gender do you identify with? \nPress A for female. \nPress B for male. \nPress C for other.");
		
		if ("A".equals(sc.next())) {
			gender = Gender.FEMALE;
		}
		
		else if ("B".equals(sc.next())) {
			gender = Gender.MALE;
		}
		
		else if ("C".equals(sc.next())) {
			gender = Gender.OTHER;
		}
		
		else {
			System.out.println("Invalid input given. Exiting program.");
			exitProgram();
		}
		
		System.out.println("What is your age?");
		age = sc.nextInt();
		
		System.out.println("What is your height (in inches)");
		height = sc.nextInt();
		
		System.out.println("What is your weight (in lbs)");
		weight = sc.nextInt();
		
		System.out.println("What is your desired weight (in lbs)?");
		desiredWeight = sc.nextInt();
		
		System.out.println("How would you rate your overall general health? \nPress A for excellent. \nPress B for good. \nPress C for verage. \nPress D for poor.");
		
		if ("A".equals(sc.next())) {
			genHealth = GeneralHealth.EXCELLENT;
		}
		
		else if ("B".equals(sc.next())) {
			genHealth = GeneralHealth.GOOD;
		}
		
		else if ("C".equals(sc.next())) {
			genHealth = GeneralHealth.AVERAGE;
		}
		
		else if ("D".equals(sc.next())) {
			genHealth = GeneralHealth.POOR;
		}
		
		else {
			System.out.println("Invalid input given. Exiting program.");
			exitProgram();
		}
		
		System.out.println("What is your health plan? (0, 1, 2, 3, or 4)");
		healthPlan = sc.nextInt();
		
		
		System.out.println("Do you smoke 100 cigarettes or more in a month? Y/N");
		if ("Y".equals(sc.next())) {
			smoke100 = true;
		}
		
		else if ("N".equals(sc.next())) {
			smoke100 = false;
		}
		
		else  {
			System.out.println("Invalid input given. Exiting program.");
			exitProgram();
		}
		
		System.out.println("Create a password.");
		password = sc.next();
		
		//creates new Data object for new account
		Data newPatient = new Data(genHealth, healthPlan, smoke100, height, weight,
			desiredWeight, age, gender, name, password);
		
		writeToPatientInfoFile(genHealth, healthPlan, smoke100, height, weight,
			desiredWeight, age, gender, name, password, pw);
		
		
		// adds new Block to Blockchain
		
		// returns Block
		return null;
		
	}
	
	public static void exitProgram() {
		System.out.println("Thank you for using MedBlock.");
		System.exit(0);
	}
	
	public static void writeToPatientInfoFile(GeneralHealth genHealth, int healthPlan, boolean smoke100, int height, double weight,
			double desiredWeight, int age, Gender gender, String name, String password, PrintWriter pw) {
		
		//prints patient information to patient information.txt
		pw.println(genHealth + " " + healthPlan + " " + smoke100 + " " + height + " " + weight + " " + desiredWeight + " " + age + " " + gender + 
				" " + name + " " + password);
	}

}