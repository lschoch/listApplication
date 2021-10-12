package listApplication;

public class Student {
	private String fName;
	private String lName;
	private String GPA;
	private Address [] addresses = new Address[3];
	
	public Student (String fName, String lName, String GPA, Address [] addresses) {
		setFName(fName);
		setLName(lName);
		setGPA(GPA);
		setAddresses(addresses);
	}
	
	public void setFName(String fn) {
		fName = fn;
	}
	
	public void setLName(String ln) {
		lName = ln;
	}
	
	public void setGPA(String g) {
		GPA = g;
	}
	
	public void setAddresses(Address [] addr) {
		// addresses = addr; // can't use alias here - addresses would get overwritten by new student
		addresses = addr.clone();
	}
	
	public String getFName() {
		return fName; 
	}
	
	public String getLName() {
		return lName;
	}
	
	public String getGPA() {
		return GPA;
	}
	
	public Address [] getAddresses() {
		return addresses;
	}
	
	// print addresses
	public String printAddresses() {
		String str = "";
		for (int i=0; i<3; i++) {
			// Check for empty addresses.
			if (this.getAddresses()[i] != null) {
				boolean isBlank = this.getAddresses()[i].getStreet().isBlank() && 
								  this.getAddresses()[i].getCity().isBlank() &&
								  this.getAddresses()[i].getState().isBlank() &&
								  this.getAddresses()[i].getZip().isBlank();
						
				if (!isBlank) {
					str=str+"Address "+(i+1)+":\n\t"+this.getAddresses()[i].getStreet()+"\n\t"+
							this.getAddresses()[i].getCity()+", "+this.getAddresses()[i].getState()+" "+
							this.getAddresses()[i].getZip()+"\n";
				}
			}
		}
	    return str;
	}	
	
	// write addresses
	public String writeAddresses() {
		String str = "";
		for (int i=0; i<3; i++) {
			if (this.getAddresses()[i] != null) {
				str=str+this.getAddresses()[i].getStreet()+"|"+this.getAddresses()[i].getCity()+"|"+
						this.getAddresses()[i].getState()+"|"+this.getAddresses()[i].getZip()+"|";
			}
		}
		return str;
	}
	
	
	
}// end class
