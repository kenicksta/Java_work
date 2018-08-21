import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PatientMenu {

	public static Patient patientList[] = new Patient[6];
	public static int count = 0;
	private static Scanner input;

	public static void listAll() {
		System.out.printf("%-18s%-13s%-15s%-29s%-15s%-27s%s%n-----------------------------------------------------------"
				+ "------------------------------------------------------------"
				+ "-------------------------%n", "Patient Name",
				"Birthdate", "Gender", "Contact Info", "Patient ID", "Doctor ID", "Address");
		for (int i = 0; i < count; i++) {

			System.out.printf("%-20s\n", patientList[i].toString());
		}
	}

	public static void addOnePatient(String fn, String ln, int patID, int doc, String bday, String gen, int house, String strt,
			String cty, String st, int zp, String phn, String em) {
		// adds a new StaffMember entry to the array of staffList
		patientList[count++] = new Patient(fn, ln, patID, doc, bday, gen, house, strt,
				cty, st, zp, phn, em);
		try(FileWriter fw = new FileWriter("p.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.printf("\n%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s", fn,",",ln,",",patID,
			    		",",doc,",",bday,",",gen,",", house, ",",strt, ",", cty,",",  st, ",", zp, ",", phn,",",em);
			    
			} catch (IOException e) {
			    //exception handling
			}
	}

	public static void searchOne(int id) {
		int whenfound = 0;
		int found = 0;
		for (int i = 0; i < count; i++) {
			if (patientList[i].getPatientID() == id) {
				whenfound = i;
				found = 1;
			}
		}
		if (found == 1) {
			System.out.println("Entry Found: ");
			System.out.printf("%-18s%-13s%-15s%-29s%-15s%-27s%s%n-----------------------------------------------------------"
					+ "------------------------------------------------------------"
					+ "-------------------------%n", "Patient Name",
					"Birthdate", "Gender", "Contact Info", "Patient ID", "Doctor ID", "Address");
			System.out.printf("%-20s\n", patientList[whenfound].toString());
		} else {
			System.out.println("not found");
		}
	}

	public static void openFile() {
		try {
			input = new Scanner(Paths.get("p.txt"));
		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		}
	}

	public static void readRecords() {
		try {
			while (input.hasNextLine()) // while there is more to read
			{
				String theLine = input.nextLine(); // read the current line

				String[] fields = theLine.split(","); // split the line into fields

				
				String firstName = fields[0];
				String lastName = fields[1];
				int patientID = Integer.parseInt(fields[2]);
				int doctorID = Integer.parseInt(fields[3]);
				String bday = fields[4];
				String gen = fields[5];
				int houseNumber = Integer.parseInt(fields[6]);
				String street = fields[7];
				String city = fields[8];
				String state = fields[9];
				int zip = Integer.parseInt(fields[10]);
				String phone = fields[11];
				String em = fields[12];
								
				patientList[count++] = new Patient(firstName, lastName, patientID, doctorID, bday, gen, houseNumber,
						street, city, state, zip, phone, em);
			}
		} catch (NoSuchElementException elementException) {
			System.err.println("File improperly formed. Terminating.");
		} catch (IllegalStateException stateException) {
			System.err.println("Error reading from file. Terminating.");
		}
	}

	public static void closeFile() {
		if (input != null)
			input.close();
	}

/*	public static void main(String[] args) {
		openFile();
		readRecords(); // this method can read a line with fields seperated with commas
		closeFile();

		// troubleshooting purposes
		addOnePatient("Jon", "Smith", 420, 9910, "09/16/1996", "M", 33, "Market St.",
				"New York City", "NY", 17345, "631-999-777", "email@email.com");
		listAll();
		searchOne(580); // not found
		searchOne(333); // found
	}*/
}
