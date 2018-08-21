public abstract class Person {
	private String firstName;
	private String lastName;
	private String birthDate;
	private String gender;
	private String email;
	private String phone;	
	
	Person(String fn, String ln, String bday, String gen, String phn, String em){
		firstName = fn;
		lastName = ln;
		birthDate = bday;
		gender = gen;
		phone = phn;
		email = em;
	}
	public abstract String staffType();
	
	public void setfirstName(String fn) {
		firstName = fn;
	}
	public void setLastName(String ln) {
		lastName = ln;
	}
/*	public void setPersonalInfo(String bday, String gen) {
		birthDate= bday;
		gender = gen;
	}
	public void setContactInfo(String em, String number) {
		email = em;
		phone = number;
	}*/
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPersonalInfo() {
		return String.format("%s%s%s", firstName, " ",lastName);
	}
	public String getContactInfo() {
		return String.format("%s%s%s", email, " ", phone);
	}
	public String toString() {
		return String.format("%s%s\t%-10s%-15s%-5s%-5s%s%-15s", firstName," ", lastName, birthDate, gender, email,
				" ",phone);
	}
/*	public String staffToString() {
		return String.format("%S%S%S%S%S", toString(), " ", email, " ", phone);
	}
	public String patientToString() {
		return String.format("%S%S%S%S%S", toString(), " ", birthDate, " ", gender);
	}*/
}