import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class StaffMenu {
	public static StaffMember staffList[] = new StaffMember[6];
	public static int count = 0;
	private static Scanner input;

	public static void listAll() {
		System.out.printf("%-18s%-13s%-15s%-35s%-15s%-15s%s%n-----------------------------------------------------------"
				+ "------------------------------------------------------------"
				+ "-------------------------%n", "Staff Name",
				"Birthdate", "Gender", "Contact Info", "Staff ID", "Staff Type", "Department ID");
		for (int i = 0; i < count; i++) {

			System.out.printf("%-20s\n", staffList[i].toString());
		}
	}

	public static void addOne(String fn, String ln, String bday, String gen, String phn, String em, int id, String type, int dep) {
		// adds a new StaffMember entry to the array of staffList
		staffList[count++] = new StaffMember(fn, ln,  bday, gen, phn, em, id, type, dep);
		try(FileWriter fw = new FileWriter("s.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.printf("\n%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s",type, ",",
			    		fn,",",ln,",",id,",",dep,",",bday,",",gen,",",phn,",",em);
			    
			} catch (IOException e) {
			    //exception handling
			}
	}

	public static void searchOne(int id) {
		int whenfound = 0;
		int found = 0;
		for (int i = 0; i < count; i++) {
			if (staffList[i].getStaffID() == id) {
				whenfound = i;
				found = 1;
			}
		}
		if (found == 1) {
			System.out.println("Entry Found: ");
			System.out.printf("%-18s%-13s%-15s%-35s%-15s%-15s%s%n-----------------------------------------------------------"
					+ "------------------------------------------------------------"
					+ "-------------------------%n", "Staff Name",
					"Birthdate", "Gender", "Contact Info", "Staff ID", "Staff Type", "Department ID");
			System.out.printf("%-20s\n", staffList[whenfound].toString());
		} else {
			System.out.println("not found");
		}
	}

	public static void openFile() {
		try {
			input = new Scanner(Paths.get("s.txt"));
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

				String type = fields[0];
				String firstName = fields[1];
				String lastName = fields[2];
				int staffID = Integer.parseInt(fields[3]);
				int departmentID = Integer.parseInt(fields[4]);
				String bday = fields[5];
				String gen = fields[6];
				String phone = fields[7];
				String em = fields[8];
								
				staffList[count++] = new StaffMember(firstName, lastName, bday, gen, phone, em, staffID, type, departmentID);
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
		addOne("Kenneth", "Ickstadt", "09/16/1996","m","516-450-1784", "email@email.com", 420,"D", 4);
		listAll();
		searchOne(420); // not found
		searchOne(5); // found	
		System.out.println("1. List all\n");
		System.out.println("2. Add one\n");
		System.out.println("3. Seach one\n");
		System.out.println("4. Return to main menu");
		
		Scanner choiceinput = new Scanner(System.in);
		
		int choice = choiceinput.nextInt();
		
		switch (choice) {
		case 1:	listAll();
				break;
				
		case 2: System.out.println("Enter First name: ");
				String firstName = choiceinput.next();
				System.out.println("Enter Last name: ");
				String lastName = choiceinput.next();
				System.out.println("Enter Birthdate as a string: ");
				String bday = choiceinput.next();
				System.out.println("Enter Gender: ('M' or 'F'): ");
				String gen = choiceinput.next();
				System.out.println("Enter phone number: ");
				String phn = choiceinput.next();
				System.out.println("Enter Email: ");
				String em = choiceinput.next();
				System.out.println("Enter ID: ");
				int id = choiceinput.nextInt();
				System.out.println("Enter Staff Type ('D' or 'N' or 'A'): ");
				String type = choiceinput.next();
				System.out.println("Enter Department ID: ");
				int dep = choiceinput.nextInt();
				addOne(firstName, lastName,  bday, gen, phn, em, id, type, dep);
				break;
				
		case 3: System.out.println("Enter the ID to search");
				int ID = choiceinput.nextInt();
				searchOne(ID);
				break;
				
		case 4: System.out.println("main menu");
				break;
				
		default: System.out.println("Invalid choice");
				break;
				
		}
		choiceinput.close();

	}*/
}