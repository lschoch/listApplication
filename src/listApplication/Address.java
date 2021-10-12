package listApplication;

// Class to hold an address

public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Address(String street, String city, String state, String zip) {
	    setStreet(street);
	    setCity(city);
	    setState(state);
	    setZip(zip);
	}
	
	public void setStreet(String s) {
		street = s;
	}
	
	public void setCity(String c) {
		city = c;
	}
	
	public void setState(String st) {
		state = st;
	}
	
	public void setZip(String z) {
		zip = z;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public String toString() {
		return "\t"+street+"\n"+"\t"+city+", "+state+" "+zip+"\n";
	}
}
