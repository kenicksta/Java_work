//class Person should be abstract
public class Department {
	private String departmentName;
	private int departmentID;
	
	Department(String depName, int depID){
		departmentName = depName;
		departmentID = depID;
	}
	public void setDepartmentName(String depName){
		departmentName = depName;
	}
	public void setDepartmentID(int depID) {
		departmentID = depID;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public String toString() {
		return String.format("%-20s%-30d%n", departmentName, departmentID);
	}
}
