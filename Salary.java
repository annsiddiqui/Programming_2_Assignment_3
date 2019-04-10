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
 * This is the class that determines an employee's salary if they
 * are a salary type employee.
 * 
 */
public class Salary extends Employee
{

    private char type = 'S';
    private double yearlySalary;

    /**
     * Default constructor for Salary
     */
    public Salary() {
        super();
        this.yearlySalary = 0;
    }

    /**
     * Constructor that takes in all the instnace variables of super class
     * and the yearly salary.
     * 
     * @param   name            employee name
     *          empNum          employee number
     *          department      employee department
     *          yearlySalary    yearly salary of employee  
     */
    public Salary(String name, String empNum, String department, double yearlySalary) {
        super(name, empNum, department);
        this.yearlySalary = yearlySalary;
    }

    //Mutator
    /**
     * Muator for setting the yearly salary
     * 
     * @param   yearlySalary    yearly salary
     */
    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }
    
    //Accessor
    /**
     * Accessor for yearly salary
     * 
     * @return  yearlySalary       yearly salary
     */
    public double getYearlySalary() {
        return this.yearlySalary;
    }

    /**
     * Method that calculates weekly salary.
     * 
     * @return  weeklySalary    weekly salary
     */
    public double calcWeeklySalary() {
        return this.yearlySalary/52;
    }

    /**
     * Method that prints out the outputs the information in a formatted table.
     */
    public String toString() {
        return super.toString() + "Type: " + this.type + "\n" + "Yearly Salary: " + this.yearlySalary;
    }

    /**
     * Method that writes the data out to the file.
     * 
     * @param   PrintWriter pw      the printer writer that sends the info to the file
     */
    public void writeData(PrintWriter pw) throws IOException {
        pw.print(this.name + "\t" + this.empNum + "\t" + this.department + "\t"+ this.type + "\t" + this.yearlySalary + "\n");
    }
}