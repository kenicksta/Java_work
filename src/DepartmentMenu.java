import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DepartmentMenu {
	public static Department departmentList[] = new Department[6];
	public static int count = 0;
	private static Scanner input;

	public static void listAll() {
		System.out.printf("%-20s%-30s%n-----------------------------------------------------%n", "Department Name",
				"Department ID");
		for (int i = 0; i < count; i++) {

			System.out.printf("%-20s", departmentList[i].toString());
		}
	}

	public static void addOne(String s, int id) {
		// adds a new Department entry to the array of Department
		departmentList[count++] = new Department(s, id);
		try(FileWriter fw = new FileWriter("d.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.printf("\n%s%s%s",s, ",",id);
			    
			} catch (IOException e) {
			    //exception handling
			}
	}

	public static void searchOne(int id) {
		int whenfound = 0;
		int found = 0;
		for (int i = 0; i < count; i++) {
			if (departmentList[i].getDepartmentID() == id) {
				whenfound = i;
				found = 1;
			}
		}
		if (found == 1) {
			System.out.println("Entry Found: ");
			System.out.printf("%-20s%-30s%n-----------------------------------------------------%n", "Department Name",
					"Department ID");
			System.out.printf("%-20s", departmentList[whenfound].toString());
		} else {
			System.out.println("not found");
		}
	}

	public static void openFile() {
		try {
			input = new Scanner(Paths.get("d.txt"));
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

				String departmentName = fields[0];
				int departmentID = Integer.parseInt(fields[1]);
				departmentList[count++] = new Department(departmentName, departmentID);
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
		addOne("Emergency", 12);
		listAll();
		searchOne(6); // not found
		searchOne(5); // found
	}*/
}
