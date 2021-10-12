package listApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;

public class ListApplication {
	/*
	 * 1.       Enter a new student.
	 * 2.       Print the student list.
	 * 3.       Read the list from disk.
	 * 4.       Save the current list to the disk.
	 * 5.       Exit the program.
	 */

	public static Student [] enter_student() {
		Student [] studentList = new Student[5];
		// Read the list from disk and convert to array
		studentList = read_list();
		
		// Enter student information up to a maximum of 5 students in the list.
		Scanner s = new Scanner(System.in);
		Address [] addressList = new Address[3];
		String street, city, state, zip;
		int count=0, stopSig;
		String fName, lName, GPA, quitSig;
		
		// Count the number of elements in studentList 
		// (studentList.length will always be 5)
		for (int i=0; i<5; i++) {
			if (studentList[i] != null) {
				count++;
			}
		}
		
		// Check count.
		if (count == 5) {
			System.out.println("The list is full.");
		} else {
			if (count == 0) {
				System.out.println("The list is empty. There is room for 5 students.");
			} else {
			System.out.printf("The list has "+count+" students already. There is room for "+(5-count)+" more.\n");
			}
		
			System.out.printf("Select:\n1.  Enter student information.\n2.  Return to menu.\n >>");
			stopSig = Integer.parseInt(s.nextLine());
			while (stopSig == 1) {
			    if (count > 4) {
			        System.out.println("You have entered the maximum number of students allowed.");
			        break;
			    }
			    System.out.print("First Name: ");
				fName = s.nextLine();
				System.out.print("Last Name: ");
				lName = s.nextLine();
				System.out.print("GPA: ");
				GPA = s.nextLine();
				
				// input addresses
				System.out.printf("Enter up to three addresses for this student.\nEnter \"Q\" to stop " +
				"entering address information.\n");
				for (int i=0; i<3; i++) {
					System.out.println("Street address: ");
					quitSig=s.nextLine();
					if (quitSig.toLowerCase().equals("q")) {
					    break;
					}
					street=quitSig;
					System.out.println("City: ");
					city=s.nextLine();
					System.out.println("State: ");
					state=s.nextLine();
					System.out.println("Zip: ");
					zip=s.nextLine();
					if (i == 2) {
						System.out.println("You entered the maximum number of addresses allowed.");
				    }
					addressList[i] = new Address(street, city, state, zip);
				}
				studentList[count] = new Student(fName, lName, GPA, addressList);
				count+=1;
				System.out.printf("Select:\n1.  Enter student information.\n2.  Return to menu.\n >");
				stopSig = Integer.parseInt(s.nextLine());
			} // end while
			// Save list to disk
		 	write_list(studentList);
		}
		// Close scanner
	 	s.close();
	 	return studentList;
	 	
    }// end Enter_Student
	
	// Read list and convert to array
	static Student[] read_list() {
		Student[] studentList = new Student[5];
		Address[] addressList = new Address[3];
		String fName="", lName="", GPA="";
		String street0="", city0="", state0="", zip0="";
		String street1="", city1="", state1="", zip1="";
		String street2="", city2="", state2="", zip2="";
		try {
			File f = new File("student_list.txt");
			Scanner reader = new Scanner(f);
			int i=0;
			while (reader.hasNextLine()) {
				StringTokenizer data = new StringTokenizer(reader.nextLine(),"|");
				if (data.hasMoreTokens()) {
					fName = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					lName = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					GPA = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					street0 = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					city0 = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					state0 = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					zip0 = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					street1 = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					city1 = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					state1 = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					zip1 = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					street2 = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					city2 = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					state2 = data.nextToken();
				}
				if (data.hasMoreTokens()) {
					zip2 = data.nextToken();
				}
				addressList[0] = new Address(street0, city0, state0, zip0);
				addressList[1] = new Address(street1, city1, state1, zip1);
				addressList[2] = new Address(street2, city2, state2, zip2);
				studentList[i] = new Student(fName, lName, GPA, addressList);
				i++;
			}
			reader.close();
	    } catch (FileNotFoundException e) {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    }
		return(studentList);
	}// end read_list
	
	// Write list to disk
	static void write_list(Student [] studentList) {
		String str = "";
		int count = 0;
		for (int i=0; i<5; i++) {
			if (studentList[i] != null) {
				count++;
			}
		}
		for (int i=0; i<studentList.length; i++) {
			if (studentList[i] != null) {
				str+=studentList[i].getFName()+"|"+studentList[i].getLName()+"|"+studentList[i].getGPA()+
						"|"+studentList[i].writeAddresses()+"\n";
			}
		}
		try {
			File f = new File("student_list.txt");
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			pw.printf(str);
			pw.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.printf("\nSaved list containing "+count+" student(s).\n");
	}
	 
	static void print_list() {
		Student [] studentList = new Student[5];
		String str = "";
		int count = 0;
		
		studentList = read_list();
		// Count the elements in studentList
		for (int i=0; i<5; i++) {
			if (studentList[i] != null) {
				count++;
			}
		}
		if (count == 0) {
			System.out.println("\nThe list is empty, nothing to print.\n");
			return;
		} else {
			for (int i=0; i<count; i++) {
				if (studentList[i] != null) {
					System.out.printf("\n"+studentList[i].getFName()+" "+studentList[i].getLName()+"\nGPA: "+
							studentList[i].getGPA()+"\n");
					str = studentList[i].printAddresses();
					str+="\n";
					System.out.printf(str);
				}
			}
		}
	}// end print_list
		
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		Student [] studentList = new Student[5];
		int selection;
		System.out.printf("Select: \n  1. Enter a student.\n  2. Print the student list.\n  3. Read the list from disc."+
				"\n  4. Save the current list to disk.\n  5. Exit this program.\n>>");
		selection = s.nextInt();
		while (selection != 5) {
			switch (selection) {
			case 1:
				studentList = enter_student();
				break;
			case 2:
				print_list();
				break;
			case 3:
				studentList = read_list();
				break;
			case 4:
				if (studentList[0] != null) {
					write_list(studentList);
				} else {
					studentList = read_list();
					write_list(studentList);
				}
				break;
			default:
				System.out.println("Please select a number between 1 and 5 inclusive.");
				break;
			}
			System.out.printf("Select: \n  1. Enter a student.\n  2. Print the student list.\n  3. Read the list from disc."+
					"\n  4. Save the current list to disk.\n  5. Exit this program.\n>>");
			selection = s.nextInt();
		}
		System.out.println("Good-bye");
		s.close();
		// student_list.txt.close();
		return;
	}// end main
	
}// end class
