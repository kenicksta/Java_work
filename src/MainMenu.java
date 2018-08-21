import java.util.Scanner;

public class MainMenu {

	public static void main(String args[]) {
		DepartmentMenu.openFile();
		DepartmentMenu.readRecords();
		StaffMenu.openFile();
		StaffMenu.readRecords();
		PatientMenu.openFile();
		PatientMenu.readRecords();
		
		boolean mainLoop = true;
		while (mainLoop) {
		Scanner input = new Scanner(System.in);


			System.out.println("1. Department Menu");
			System.out.println("2. Staff Menu");
			System.out.println("3. Patient Menu");
			System.out.println("4. Exit");

			int menuChoice = input.nextInt();
			switch (menuChoice) {
			case 1:
				boolean departmentLoop = true;
				while(departmentLoop) {
				System.out.println("\nDepartment Menu");
				System.out.println("1. List all");
				System.out.println("2. Add one");
				System.out.println("3. Seach one");
				System.out.println("4. Return to main menu");

				Scanner userChoice = new Scanner(System.in);
				int departmentChoice = userChoice.nextInt();
				switch (departmentChoice) {
				case 1:
					DepartmentMenu.listAll();
					break;
				case 2:				
					System.out.println("Enter new Department name: ");
					String s = userChoice.next();
					System.out.println("Enter new Department ID: ");
					int id = userChoice.nextInt();
					DepartmentMenu.addOne(s, id);
					break;
				case 3:
					System.out.println("Enter the ID to search");
					int ID = userChoice.nextInt();
					DepartmentMenu.searchOne(ID);
					break;

				case 4:
					departmentLoop = false;
					break;
					}
				}
				break;
			case 2:
				boolean staffLoop = true;
				while(staffLoop) {
				System.out.println("Staff Menu");
				System.out.println("1. List all");
				System.out.println("2. Add one");
				System.out.println("3. Seach one");
				System.out.println("4. Return to main menu");

				Scanner choiceinput = new Scanner(System.in);

				int choice1 = choiceinput.nextInt();
				switch (choice1) {
				case 1:
					StaffMenu.listAll();
					break;

				case 2:
					System.out.println("Enter First name: ");
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
					StaffMenu.addOne(firstName, lastName, bday, gen, phn, em, id, type, dep);
					break;

				case 3:
					System.out.println("Enter the ID to search");
					int ID = choiceinput.nextInt();
					StaffMenu.searchOne(ID);
					break;

				case 4:
					staffLoop = false;
					break;

				default:
					System.out.println("Invalid choice");
					break;
				}
				}
				break;
			case 3:
				boolean patientLoop = true;
				while(patientLoop) {
				System.out.println("Patient Menu");
				System.out.println("1. List all");
				System.out.println("2. Add one");
				System.out.println("3. Seach one");
				System.out.println("4. Return to main menu");

				Scanner choice = new Scanner(System.in);

				int patientChoice = choice.nextInt();
				switch (patientChoice) {
				case 1:
					PatientMenu.listAll();
					break;

				case 2:
					System.out.println("Enter First name: ");
					String fn = choice.next();
					System.out.println("Enter Last name: ");
					String ln = choice.next();
					System.out.println("Enter Birthdate as a string: ");
					String bday = choice.next();
					System.out.println("Enter Gender: ('M' or 'F'): ");
					String gen = choice.next();
					System.out.println("Enter phone number: ");
					String phn = choice.next();
					System.out.println("Enter Email: ");
					String em = choice.next();
					System.out.println("Enter Pateint ID: ");
					int patID = choice.nextInt();
					System.out.println("Enter Doctor's ID: ");
					int doc = choice.nextInt();
					System.out.println("Enter House Number: ");
					int house = choice.nextInt();
					System.out.println("Enter Street Name: ");
					String strt = choice.next();
					System.out.println("Enter City Name: ");
					String cty = choice.next();
					System.out.println("Enter State: ");
					String st = choice.next();
					System.out.println("Enter Zip Code: ");
					int zp = choice.nextInt();

					PatientMenu.addOnePatient(fn, ln, patID, doc, bday, gen, house, strt, cty, st, zp, phn, em);
					break;

				case 3:
					System.out.println("Enter the ID to search");
					int ID = choice.nextInt();
					PatientMenu.searchOne(ID);
					break;

				case 4:
					patientLoop = false;
					break;

				default:
					System.out.println("Invalid choice");
					break;
				}
				}

				break;
			case 4:
				mainLoop = false;
				DepartmentMenu.closeFile();
				StaffMenu.closeFile();
				PatientMenu.closeFile();
				System.exit(0);
			}
		}
	}
}