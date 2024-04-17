package hospitaltoothcare;

import java.io.*;
import java.util.*;

public class Patient {

    // Static ArrayList to store Patient objects
    static ArrayList<Patient> arrayPat = new ArrayList<Patient>();
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); // Buffered Reader for user input
    HospitalToothCare htc = new HospitalToothCare(); // Reference to the main HospitalToothCare class

    // Instance variables for Patient details
    int pid;
    String Name, Address, age, contact, gender;

    // Constructors
    public Patient() {
    }

    public Patient(int pid, String Name, String Address, String age, String contact, String gender) {
        this.pid = pid;
        this.Name = Name;
        this.Address = Address;
        this.age = age;
        this.contact = contact;
        this.gender = gender;
    }

    // Getter and Setters
    public static ArrayList<Patient> getArrayPat() {
        return arrayPat;
    }

    public static void setArrayPat(ArrayList<Patient> arrayPat) {
        Patient.arrayPat = arrayPat;
    }

    public HospitalToothCare getHtc() {
        return htc;
    }

    public void setHtc(HospitalToothCare htc) {
        this.htc = htc;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Method to add a new Patient
    void addPatient() throws IOException //function to insert new doctor records 
    {
        Patient patient = new Patient();

        System.out.println("-------------------------------------");
        System.out.println("Patient Registration Form");
        System.out.println("-------------------------------------");
        System.out.println("Enter Patient ID:");
        patient.pid = Integer.parseInt(buffer.readLine());

        // Getting user input for Patient details
        System.out.println("Enter Patient name:");
        patient.Name = buffer.readLine();

        System.out.println("Enter Address:");
        patient.Address = buffer.readLine();

        System.out.println("Enter Age:");
        patient.age = buffer.readLine();

        System.out.println("Enter Contact Number:");
        patient.contact = buffer.readLine();

        System.out.println("Enter Male / Female:");
        patient.gender = buffer.readLine();

        // Adding the new Doctor object to the list
        htc.arrayPat.add(patient);
    }

    public void showPatientList() {

        for (int i = 0; i < htc.arrayPat.size(); i++) {
            System.out.println(htc.arrayPat.get(i).pid + " \t\t " + htc.arrayPat.get(i).Name + " \t\t " + htc.arrayPat.get(i).Address + " \t\t " + htc.arrayPat.get(i).age + " \t\t " + htc.arrayPat.get(i).contact + " \t\t " + htc.arrayPat.get(i).gender);
        }
    }

}
