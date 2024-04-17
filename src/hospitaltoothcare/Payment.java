package hospitaltoothcare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Class representing different treatments with fixed prices
class Treatment {

    String treatmentName;
    float price;

    // Constructor 
    public Treatment(String treatmentName, float price) {
        this.treatmentName = treatmentName;
        this.price = price;
    }

    // Getter and Setter methods
    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    //  treatments with fixed prices as constants
    static final Treatment CLEANINGS = new Treatment("Cleanings", 2000.0f);
    static final Treatment WHITENING = new Treatment("Whitening", 2000.0f);
    static final Treatment FILLING = new Treatment("Filling", 2000.0f);
    static final Treatment NERVE_FILLING = new Treatment("Nerve Filling", 2000.0f);
    static final Treatment ROOT_CANAL_THERAPY = new Treatment("Root Canal Therapy", 2000.0f);
}

// Class payment
public class Payment {

    // Static ArrayList to store Payment objects
    static ArrayList<Payment> arraypay = new ArrayList<Payment>();
    HospitalToothCare htc = new HospitalToothCare();
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    int pay_id;
    Appointment appointment;
    Treatment treatment;
    Double amount;
    String paydate, cashier;

    // Constructors
    public Payment() {
    }

    public Payment(int pay_id, Appointment appointment, Treatment treatment, Double amount, String paydate, String cashier) {
        this.pay_id = pay_id;
        this.appointment = appointment;
        this.treatment = treatment;
        this.amount = amount;
        this.paydate = paydate;
        this.cashier = cashier;
    }

    public static ArrayList<Payment> getArraypay() {
        return arraypay;
    }

    public static void setArraypay(ArrayList<Payment> arraypay) {
        Payment.arraypay = arraypay;
    }

    public HospitalToothCare getHtc() {
        return htc;
    }

    public void setHtc(HospitalToothCare htc) {
        this.htc = htc;
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    // Method to calculate the amount of a payment
    void calculateAmount() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Display available treatment types
    System.out.println("Available Treatment Types:");
    System.out.println("1. Cleanings");
    System.out.println("2. Whitening");
    System.out.println("3. Filling");
    System.out.println("4. Nerve Filling");
    System.out.println("5. Root Canal Therapy");

    // Continue adding payments until the user chooses to exit
    while (true) {
        // Get user input for treatment type selection
        System.out.println("Enter the Number Corresponding to the Selected Treatment or type '0' to Print Bill: ");
        String userInput = br.readLine();

        if (userInput.equals("0")) {
            // Exit the loop if the user types '0'
            break;
        }

        int treatmentChoice = Integer.parseInt(userInput);
        hospitaltoothcare.Treatment selectedTreatment;

        // Switch statement to map user input to Treatment enum
        switch (treatmentChoice) {
            case 1:
                selectedTreatment = hospitaltoothcare.Treatment.CLEANINGS;
                break;
            case 2:
                selectedTreatment = hospitaltoothcare.Treatment.WHITENING;
                break;
            case 3:
                selectedTreatment = hospitaltoothcare.Treatment.FILLING;
                break;
            case 4:
                selectedTreatment = hospitaltoothcare.Treatment.NERVE_FILLING;
                break;
            case 5:
                selectedTreatment = hospitaltoothcare.Treatment.ROOT_CANAL_THERAPY;
                break;
            default:
                System.out.println("Invalid treatment choice. Please enter a valid number or type '0' to finish.");
                continue; // Skip the rest of the loop and start a new iteration
        }

        // Calculate the full bill amount based on the fixed price associated with the selected treatment type
        double fullBillAmount = selectedTreatment.getPrice();

        // Decrease the last amount by 0.0
        if (!arraypay.isEmpty()) {
            hospitaltoothcare.Payment lastPayment = arraypay.get(arraypay.size() - 1);
            lastPayment.setAmount(lastPayment.getAmount() - 0.0);

            // Update the full bill amount after decreasing the last amount
            fullBillAmount += lastPayment.getAmount();
        }

        // Create a new Payment instance with the calculated amount and other relevant parameters
        hospitaltoothcare.Payment newPayment = new hospitaltoothcare.Payment(/* pass relevant parameters */);
        newPayment.setAmount(fullBillAmount);

        // Add the new payment to the list
        arraypay.add(newPayment);

        System.out.println("Payment details:");
        // Display other payment details...
        System.out.println("Treatment Name: " + selectedTreatment.getTreatmentName());
        System.out.println("Full Bill Amount: " + fullBillAmount);
    }

    // Confirm whether the user wants to proceed with the payment
    System.out.print("Do you want to proceed with the payment? (yes/no): ");
    String proceedChoice = br.readLine().toUpperCase();

    if ("yes".equals(proceedChoice)) {
        // Print the bill
        System.out.println("Bill printed successfully!");
    } else {
        // Inform the user to collect money
        System.out.println("Please collect the money.");
    }
}

}
