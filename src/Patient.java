
public class Patient extends Person {
	private int patientID;
	private int doctorID;
	private int houseNumber;
	private String street;
	private String city;
	private String state;
	private int zip;
	
	Patient(String fn, String ln, int patID, int doc, String bday, String gen, int house, String strt,
			String cty, String st, int zp, String phn, String em){
		super(fn, ln, bday, gen, phn, em);
		patientID = patID;
		doctorID = doc;
		houseNumber = house;
		street = strt;
		city = cty;
		state = st;
		zip = zp;
	}
	
	@Override
	public String staffType() {
		// part of abstract class Person
		return "Not implemented yet";
	}
	
	public void setAddressInfo(int num, String strt, String cty, String st, int z) {
		houseNumber = num;
		street = strt;
		city = cty;
		state = st;
		zip = z;
	}
	public String getAddressInfo() {
		return String.format("%s%s%s%s%s%s%s%s%s",houseNumber, " ",street, " ", city, " ",state, " ",zip);
	}

	public void setPatientID(int id) {
		patientID = id;
	}
	public void setDoctor(int doc) {
		doctorID = doc;
	}
	public int getPatientID() {
		return patientID;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public String toString() {
		return String.format("%-75s%-12s%-15s%-1s%-1s%-11s%-14s%-3s%s", super.toString(),patientID, doctorID, 
				houseNumber, " ", street, city, state, zip);
	}
}
