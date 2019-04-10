import java.util.*;
import java.io.*;
/**
 * 
 * @author Qurrat-al-Ain Siddiqui
 * @version FINAL
 * @due-date March 23, 2018
 * 
 * Instructor: Ruben Yumol
 * Assumptions:
 * Known errors: None
 * 
 * This is the class that determines an employee's hourly pay rate if they
 * are an hourly type employee.
 * 
 */
public class Hourly extends Employee
{

    private char type = 'H';
    private double hrlyPay;
    private double hrsWorked;
    /**
     * Hourly pay constructor defaulting hours worked and hourly pay
     */
    public Hourly() {
        super();
        this.hrlyPay = 0;
        this.hrsWorked = 0;
    }

    /**
     * Hourly constructor
     * 
     * @param   name         employee name
     *          empNum       employee number
     *          dept         employee department
     *          hrlyPay      hourly pay of emloyee
     *          hrsWorked    hours worked so far 
     */
    public Hourly(String name, String empNum, String dept, double hrlyPay, double hrsWorked) {
        super(name, empNum, dept);
        this.hrlyPay = hrlyPay;
        this.hrsWorked = hrsWorked;
    }

    //Mutators
    /**
     * Mutator for hourly pay
     * 
     * @param hrlyPay   hourly pay of employee
     */
    public void setHrlyPay (double hrlyPay) {
        this.hrlyPay = hrlyPay;
    }

    /**
     * Muator for setHrsWorked
     * 
     * @param   hrsWorked   number of hours worked so far
     */
    public void setHrsWorked(double hrsWorked) {
        this.hrsWorked = hrsWorked;
    }
    
    //Accessors
    /**
     * Accessor for hourly pay
     * 
     * @return  hrlyPay     hourly pay
     */
    public double getHrlyPay() {
        return this.hrlyPay;
    }

    /**
     * Accessor for hours worked
     * 
     * @return  hrsWorked   amount of hours worked so far
     */
    public double getHrsWorked() {
        return this.hrsWorked;
    }

    /**
     * Method that calculates weekly salary
     * 
     * @return  weeklySalary    the salary for the week
     */
    public double calcWeeklySalary() {
        double weeklySalary = 0;
        if (this.hrsWorked <= 40) {
            weeklySalary = this.hrsWorked * this.hrlyPay;
        } else {
            weeklySalary = ((this.hrsWorked - 40) * hrlyPay * 1.5) + (40 * hrlyPay);
        }
        return weeklySalary;
    }

    /**
     * Method that prints the outputs in a readable way and formatted correctly
     */
    public String toString() {
        return super.toString() + "Type: " + this.type + "\n" + "Hourly Pay: " + this.hrlyPay + "\n" + "Hours Worked: " + this.hrsWorked + "\n";
    }

    /**
     * Method that writes the data to the file
     * 
     * @param   PrintWriter pw      the printer writer to the file
     */
    public void writeData(PrintWriter pw) throws IOException {
        pw.println("\n" + this.name + "\t" + this.empNum + "\t" + this.department + "\t" + this.type + "\t" + this.hrlyPay + "\t" + this.hrsWorked + "\n");
    }

}
