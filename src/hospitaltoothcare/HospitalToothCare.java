package hospitaltoothcare;

import java.io.IOException;
import java.util.*;

// Import necessary classes
public class HospitalToothCare {

    //  static lists to store data
    static List<Appointment> app = new ArrayList<>();
    static ArrayList<Doctor> arraydoc = new ArrayList<Doctor>();
    static ArrayList<Patient> arrayPat = new ArrayList<Patient>();
    static ArrayList<Payment> arraypay = new ArrayList<Payment>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // Login credentials
        String username = "Gayathra";
        String password = "123";

        boolean isLoggedIn = false;
        int attempts = 0;

        while (true) {
            if (attempts >= 2) {
                System.out.println("Exceeded maximum login attempts. Exiting the tch system.");
                break;
            }

            // Check login status
            if (!isLoggedIn) {
                // Request username and password for login
                System.out.println("-------------------------------------");
                System.out.println("            Login Form");
                System.out.println("-------------------------------------");
                System.out.print("Enter Username: ");
                String enteredUsername = scanner.nextLine();

                System.out.print("Enter Password: ");
                String enteredPassword = scanner.nextLine();

                // Validate credentials
                if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
                    System.out.println("-------------------------------------");
                    System.out.println("\n         Login Successfully");
                    System.out.println("\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
                    System.out.println("|                Welcome to Tooth Care Dental Hospital                              |");
                    System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
                    isLoggedIn = true;
                    attempts = 0; // Reset attempts on successful login
                } else {
                    System.out.println(" ");
                    System.out.println("Username or password is incorrect. Login failed.");
                     System.out.println(" ");
                    attempts++;
                }
            } else {
                // Display menu options for the logged-in user(Main Menu)

                System.out.println("\nSelect an option:");
                System.out.println("1. Appointment Section");
                System.out.println("2. Doctor Section");
                System.out.println("3. Patient Section");
                System.out.println("4. Payment Section");
                System.out.println("5. Logout");
                System.out.println("-------------------------------------");

                System.out.print("\n\nEnter Your Choice : ");

                int choice, j, c1;

                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after reading the int
                } catch (Exception e) {
                    // Handle invalid input
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the newline character to avoid infinite loop
                    continue;
                }
                // Process user's choice using switch statement
                switch (choice) {
                    // Handle Appointment Section
                    case 1: {

                        Appointment appoin = new Appointment();
                        Scanner s = new Scanner(System.in);
                        Scanner s1 = new Scanner(System.in);
                        Scanner s2 = new Scanner(System.in);
                        int ch;
                        do {
                            System.out.println("-------------------------------------");
                            System.out.println("\n1.Appointment Create");
                            System.out.println("2.View Appointments List");
                            System.out.println("3.Delete Appointment");
                            System.out.println("4.Update Appointment");
                            System.out.println("5.Serach Appointments");
                            System.out.println("6.Appointment Search Using Date");
                            System.out.println("7.Serach Name");
                            System.out.println("0.Main Menu");
                            System.out.println("-------------------------------------");
                            System.out.print("\n\nEnter Your Choice : ");
                            ch = s.nextInt();

                            switch (ch) {
                                case 1:
                                    System.out.println("-------------------------------------");
                                    System.out.println("Appointment Create Form");
                                    System.out.println("-------------------------------------");
                                    System.out.print("\nEnter Appointment ID: ");
                                    int appid = s.nextInt();
                                    System.out.print("Enter Doctor Name: ");
                                    String dname = s1.nextLine();
                                    System.out.print("Enter Patient Name: ");
                                    String pname = s1.nextLine();

                                    double date = 0;
                                    boolean validDate = false;

                                    // Keep prompting until a valid date is entered
                                    while (!validDate) {
                                        try {
                                            System.out.print("Enter Date (DD.MM): ");
                                            date = s2.nextDouble();
                                            validDate = true; // If no exception occurred, mark the date as valid
                                        } catch (InputMismatchException e) {
                                            System.out.println("Invalid Input for Date. Please Enter a This Type (DD.MM) eg.(25.12)");
                                            s2.next(); // Consume the invalid input to prevent an infinite loop
                                        }
                                    }

                                    System.out.print("Enter Time: ");
                                    String time = s1.nextLine();
                                    System.out.print("Enter Address: ");
                                    String address = s1.nextLine();
                                    System.out.print("Enter Contact: ");
                                    String contact = s1.nextLine();

                                    int appfee = 0;
                                    boolean validAppFee = false;

                                    // Keep prompting until a valid appointment fee is entered
                                    while (!validAppFee) {
                                        try {
                                            System.out.print("Enter Appointment Fee: ");
                                            appfee = s.nextInt();
                                            validAppFee = true; // If no exception occurred, mark the appointment fee as valid
                                        } catch (InputMismatchException e) {
                                            System.out.println("Invalid Input for Appointment Fee. Please Enter a numeric Value.");
                                            s.next(); // Consume the invalid input to prevent an infinite loop
                                        }
                                    }

                                    app.add(new Appointment(appid, dname, pname, date, time, address, contact, appfee));
                                    break;
                                case 2:

                                    System.out.println("-------------------------------------");
                                    Iterator<Appointment> i = app.iterator();
                                    while (i.hasNext()) {
                                        Appointment e = i.next();
                                        System.out.println(e);
                                    }
                                    System.out.println("-------------------------------------");
                                    break;

                                case 3:

                                    boolean found = false;
                                    System.out.println("-------------------------------------");
                                    System.out.print("Enter Appointment ID to Delete : ");
                                    appid = s.nextInt();
                                    System.out.println("-------------------------------------");
                                    i = app.iterator();
                                    while (i.hasNext()) {
                                        Appointment e = i.next();
                                        if (e.getAppid() == appid) {
                                            i.remove();
                                            found = true;

                                        }
                                    }

                                    if (!found) {
                                        System.out.println("Record Not Found");
                                    } else {
                                        System.out.println("Record is Deleted Successfully");
                                    }
                                    System.out.println("-------------------------------------");
                                    break;

                                case 4:

                                    found = false;
                                    System.out.println("-------------------------------------");
                                    System.out.print("Enter Appointment Number to Update : ");
                                    appid = s.nextInt();
                                    System.out.println("-------------------------------------");
                                    ListIterator<Appointment> li = app.listIterator();
                                    while (li.hasNext()) {
                                        Appointment e = li.next();
                                        if (e.getAppid() == appid) {
                                            System.out.print("Enter Doctor Name : ");
                                            dname = s1.nextLine();
                                            System.out.print("Enter Patient Name : ");
                                            pname = s1.nextLine();
                                            System.out.print("Enter Date : ");
                                            date = s2.nextDouble();
                                            System.out.print("Enter Time : ");
                                            time = s1.nextLine();
                                            System.out.print("Enter Address : ");
                                            address = s1.nextLine();
                                            System.out.print("Enter Contact : ");
                                            contact = s1.nextLine();

                                            System.out.print("Update New Fee : ");
                                            appfee = s.nextInt();

                                            li.set(new Appointment(appid, dname, pname, date, time, address, contact, appfee));

                                            found = true;

                                        }
                                    }

                                    if (!found) {
                                        System.out.println("Record Not Found");
                                    } else {
                                        System.out.println("Record is Updated Successfully");
                                    }
                                    System.out.println("-------------------------------------");
                                    break;

                                case 5:

                                    found = false;
                                    System.out.println("-------------------------------------");
                                    System.out.print("Enter Appointment ID to Search : ");
                                    appid = s.nextInt();
                                    System.out.println("-------------------------------------");
                                    i = app.iterator();
                                    while (i.hasNext()) {
                                        Appointment e = i.next();
                                        if (e.getAppid() == appid) {
                                            System.out.println(e);
                                            found = true;

                                        }
                                    }

                                    if (!found) {
                                        System.out.println("Record Not Found");
                                    }
                                    System.out.println("-------------------------------------");
                                    break;

                                case 6:

                                    found = false;
                                    System.out.println("-------------------------------------");
                                    System.out.print("Enter Appointment Date to Search : ");
                                    date = s2.nextDouble();
                                    System.out.println("-------------------------------------");
                                    i = app.iterator();
                                    while (i.hasNext()) {
                                        Appointment e = i.next();
                                        if (e.getDate() == date) {
                                            System.out.println(e);
                                            found = true;

                                        }
                                    }

                                    if (!found) {
                                        System.out.println("Record Not Found");
                                    }
                                    System.out.println("-------------------------------------");
                                    break;

                                case 7:

                                    found = false;
                                    System.out.println("-------------------------------------");
                                    System.out.print("Enter Patient Name to Search : ");
                                    pname = s1.nextLine();
                                    System.out.println("-------------------------------------");
                                    i = app.iterator();
                                    while (i.hasNext()) {
                                        Appointment e = i.next();
                                        if (e.getPname() == null ? pname == null : e.getPname().equals(pname)) {
                                            System.out.println(e);
                                            found = true;

                                        }
                                    }

                                    if (!found) {
                                        System.out.println("Record Not Found");
                                    }
                                    System.out.println("-------------------------------------");
                                    break;

                            }
                        } while (ch != 0);
                    }
                    break;

                    // Handle Doctor Section
                    case 2: {
                        char l = 'i';
                        do {
                            Doctor doc = new Doctor();
                            System.out.println("-------------------------------------");
                            System.out.println("Enter\n 1 : Add a Doctor \n 2 : Doctor List \n 0 : Main Menu");
                            System.out.println("-------------------------------------");
                            System.out.print("\n\nEnter Your Choice : ");
                            Scanner input = new Scanner(System.in);

                            c1 = input.nextInt();
                            switch (c1) {

                                case 1:
                                    doc.addDoctor();
                                    System.out.println("-------------------------------------");
                                    System.out.println("\nDoctor Added Successfully !!!");
                                    System.out.println("-------------------------------------");
                                    doc.showDoctorList();
                                    break;
                                case 2:
                                    System.out.println("-------------------------------------");
                                    System.out.println("\nDoctor List Loaded !!!");
                                    System.out.println("-------------------------------------");
                                    doc.showDoctorList();
                                    break;

                                default:
                                    System.out.println("-------------------------------------");
                                    System.out.println("Doctor ID Does Not Exist With The Entered Correct ID");
                                    System.out.println("Try Again");
                                    System.out.println("-------------------------------------");
                                    break;
                            }

                        } while (l == 'n');
                    }
                    break;

                    // Handle Patient Section
                    case 3: {
                        char l = 'i';
                        do {
                            Patient Pt = new Patient();
                            System.out.println("-------------------------------------");
                            System.out.println("Enter\n 1 : Add a Patient \n 2 : Patient List \n 0 : Main Menu");
                            System.out.println("-------------------------------------");
                            System.out.print("\n\nEnter Your Choice : ");
                            Scanner input = new Scanner(System.in);

                            c1 = input.nextInt();
                            switch (c1) {

                                case 1:
                                    Pt.addPatient();
                                    System.out.println("-------------------------------------");
                                    System.out.println("\nPatient Added Successfully !!!");
                                    System.out.println("-------------------------------------");
                                    Pt.showPatientList();
                                    break;
                                case 2:
                                    System.out.println("-------------------------------------");
                                    System.out.println("\nPatient List Loaded !!!");
                                    System.out.println("-------------------------------------");
                                    Pt.showPatientList();
                                    break;

                                default:
                                    System.out.println("-------------------------------------");
                                    System.out.println("Patient ID Does Not Exist With The Entered Correct ID");
                                    System.out.println("Try Again");
                                    System.out.println("-------------------------------------");
                                    break;
                            }

                        } while (l == 'n');
                    }
                    break;

                    // Handle Payment Section
                    case 4: {
                        char l = 'i';
                        do {
                            Payment pay = new Payment();
                            System.out.println("-------------------------------------");
                            System.out.println("Enter\n 1 : Create a Bill \n 0 : Main Menu");
                            System.out.println("-------------------------------------");
                            System.out.print("\n\nEnter Your Choice : ");
                            Scanner input = new Scanner(System.in);
                            c1 = input.nextInt();
                            switch (c1) {

                                case 1:
                                    pay.calculateAmount();
                                    System.out.println("-------------------------------------");
                                    System.out.println("Bill Created Successfully Print It!!!");
                                    System.out.println("-------------------------------------");

                                    break;

                                default:
                                    System.out.println("Payment ID Does Not Exist With The Entered Correct ID");
                                    System.out.println("Try Again");
                                    break;
                            }

                        } while (l == 'y');
                    }
                    break;

                    // Exit the program
                    case 5: {
                        System.out.println("-------------------------------------");
                        System.out.println("You Are Log Out");
                        System.out.println("-------------------------------------");
                        System.exit(0);
                    }

                }

            }

        }

    }
}


