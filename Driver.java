import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.*;

public class Driver {

    public static void main(String[] args) throws IOException{
    	
    	// creating new File instance with patient information.txt
    	File patientInfo = new File("patient information.txt");
    	
    	// using FileWriter and PrintWriter to write to patient information.txt
    	FileWriter fw = new FileWriter(patientInfo);
    	PrintWriter pw = new PrintWriter(fw);
    	
    	// Scanner object to take in user input
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Hello, welcome to MedBlock.");
    	System.out.println("What would you like to do today? \nPress A if you would like to make a new account. "
    			+ "\nPress B if you would like to login to an exisiting account." + "\nPress any key if you would like to exit.");
    	
    	if ("A".equals(sc.next())) {
    		// run something
    	}
    	
    	else if ("B".equals(sc.next())) {
    		// run something
    	}
    	
    	else {
    		System.exit(0);
    	}
    }
    
    
}