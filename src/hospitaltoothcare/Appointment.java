package hospitaltoothcare;

import java.util.*;

// Class representing an Appointment 
public class Appointment {

    // Fields to store appointment information
    int appid;
    String dname, pname, time, address, contact;
    double date;
    int appfee;

    // Default constructor
    public Appointment() {
    }

    // Parameterized constructor to initialize the Appointment object
    Appointment(int appid, String dname, String pname, double date, String time, String address, String contact, int appfee) {
        this.appid = appid;
        this.dname = dname;
        this.pname = pname;
        this.time = time;
        this.address = address;
        this.contact = contact;
        this.date = date;
        this.appfee = appfee;
    }

    // Getter and setter methods
    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public int getAppfee() {
        return appfee;
    }

    public void setAppfee(int appfee) {
        this.appfee = appfee;
    }

    // Override toString method for better representation
    @Override
    public String toString() {
        return "Appointment{" + "    " + appid + "    "  + dname  + "    " + pname  + "    " + time  + "    " + address  + "    " + contact  + "   Date :" + date  + "    " + appfee + '}';
    }
    

}
