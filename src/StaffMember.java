import java.util.Objects;

public class StaffMember extends Person {
	private int staffID;
	private String staffType;
	private int departmentInt;
	private String staffTypeWritten;
	
	StaffMember(String fn, String ln, String bday, String gen, String phn, String em, int id, String type, int dep){
		super(fn, ln, bday, gen, phn, em);
		staffID = id;
		staffType = type;
		departmentInt = dep;
	}
	
	@Override
	public String staffType() {
		if (Objects.equals(staffType, "D")) {
			//is a doctor
			staffTypeWritten = "Doctor";
			return staffTypeWritten;
		}
		else if (Objects.equals(staffType, "N")) {
			// is a nurse
			staffTypeWritten = "Nurse";
			return staffTypeWritten;
		}
		else if (Objects.equals(staffType, "A")){
			//is administrator in hospital
			staffTypeWritten = "Administrator";
			return staffTypeWritten;
		}
		else {
			//doesn't match 'D' 'N' or 'A'
			return "Not a valid StaffMember Type";
		}
	}
	public void setStaffID(int id) {
		staffID = id;
	}
	public void setStaffType(String type) {
		staffType = type;
	}
	public void setDepartmentInt(int id) {
		departmentInt = id;
	}
	public int getStaffID() {
		return staffID;
	}
	public String getStaffType() {
		return staffType;
	}
	public int getDepartmentInt() {
		return departmentInt;
	}
	public String toString() {
		return String.format("%s%s%s%-10s%-8s\t%-4s%s", super.toString()," ", staffID," ", staffType(), " ", departmentInt);
	}
}
