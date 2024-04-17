package hospitaltoothcare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Doctor {

    // Static ArrayList to store Doctor objects
    static ArrayList<Doctor> arraydoc = new ArrayList<Doctor>();
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); // Buffered Reader for user input
    HospitalToothCare htc = new HospitalToothCare(); // Reference to the main HospitalToothCare class

    int doc_id; // Instance variables for Doctor details
    String dname, contact, email, visit_date, visit_time;

    // Constructors
    public Doctor() {
    }

    public Doctor(int doc_id, String dname, String contact, String email, String visit_date, String visit_time) {
        this.doc_id = doc_id;
        this.dname = dname;
        this.contact = contact;
        this.email = email;
        this.visit_date = visit_date;
        this.visit_time = visit_time;
    }

    // Getter and Setter
    public static ArrayList<Doctor> getArraydoc() {
        return arraydoc;
    }

    public static void setArraydoc(ArrayList<Doctor> arraydoc) {
        Doctor.arraydoc = arraydoc;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(String visit_date) {
        this.visit_date = visit_date;
    }

    public String getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(String visit_time) {
        this.visit_time = visit_time;
    }

    public HospitalToothCare getHtc() {
        return htc;
    }

    public void setHtc(HospitalToothCare htc) {
        this.htc = htc;
    }

    // Method to add a new Doctor
    void addDoctor() throws IOException //function to insert new doctor records 
    {
        Doctor doc = new Doctor();
        System.out.println("-------------------------------------");
        System.out.println("Doctor Registration Form");
        System.out.println("-------------------------------------");
        System.out.println("Enter Doctor ID:");
        doc.doc_id = Integer.parseInt(buffer.readLine());

        // Getting user input for Doctor details
        System.out.println("Enter Doctor name:");
        doc.dname = buffer.readLine();

        System.out.println("Enter Contact Number:");
        doc.contact = buffer.readLine();

        System.out.println("Doctor Email Address:");
        doc.email = buffer.readLine();

        System.out.println("Enter Visiting Date:");
        doc.visit_date = buffer.readLine();

        System.out.println("Enter Visiting Times:");
        doc.visit_time = buffer.readLine();

        // Adding the new Doctor object to the list
        htc.arraydoc.add(doc);
    }

    // Method to display the list of Doctors
    public void showDoctorList() {

        for (int i = 0; i < htc.arraydoc.size(); i++) {
            System.out.println(htc.arraydoc.get(i).doc_id + " \t\t " + htc.arraydoc.get(i).dname + " \t\t " + htc.arraydoc.get(i).contact + " \t\t " + htc.arraydoc.get(i).email + " \t\t " + htc.arraydoc.get(i).visit_date + " \t\t " + htc.arraydoc.get(i).visit_time);
        }
    }

}
