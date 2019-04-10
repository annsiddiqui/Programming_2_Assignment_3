import java.io.*;
import java.util.*;
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
 * This is the class that determines an employee's commission pay rate if they
 * are a commission type employee.
 * 
 */
public class Commission extends Employee
{
    //Instance variables
    private char type = 'C';
    private int numWeeks;
    private double baseWeeklySalary;
    private double weeklySales;
    private double yearlySales;
    private double commissionRate; 

    /**
     * Default constructor. All instance variables are set to 0.
     * 
     */
    public Commission() {
        super();
        this.numWeeks = 0;
        this.baseWeeklySalary = 0;
        this.weeklySales = 0;
        this.yearlySales = 0;
        this.commissionRate = 0;
    }

    /**
     * Constructor that accepts parameters
     * 
     * @params      name            employee name
     *              empNum          employee number
     *              department      employee department
     *              numWeeks        number of weeks worked
     *              baseSalary      base salary of the employee
     *              weeklySales     amount of weekly sales for that employee
     *              yearSales       amount of sales that year for that employee
     *              commission      commission rate for the employee
     */
    public Commission (String name, String empNum, String department, int numWeeks, 
    double baseSalary, double weeklySales, double yearSales, double commission) {
        super(name, empNum, department);
        this.numWeeks = numWeeks;
        this.baseWeeklySalary = baseSalary;
        this.weeklySales = weeklySales;
        this.yearlySales = yearSales;
        this.commissionRate = commission;
    }

    //Mutators
     /**
     * Mutator method for number of weeks worked
     * 
     * @param       numWeeks        number of weeks worked
     * 
     */
    public void setNumWeeks(int numWeeks) {
        this.numWeeks = numWeeks;
    }

    /**
     * Mutator method for base weekly salary
     * 
     * @param       baseSalary      the base salary for commission workers
     */
    public void setBaseWeeklySalary(double baseSalary) {
        this.baseWeeklySalary = baseSalary;
    }

    /**
     * Mutator method for base weekly salary
     * 
     * @param       weeklySales     the amount of weekly sales
     */
    public void setWeeklySales(int weeklySales) {
        this.weeklySales = weeklySales;
    }

     /**
     * Mutator method for base weekly salary
     * 
     * @param       baseSalary      the base salary for commission workers
     */
    public void setCommissionRate (double commission) {
        this.commissionRate = commission;
    }

    //The accessors
    /**
     * The accessor for number of weeks worked
     * 
     * @return  numWeeks    number of weeks worked
     */
    public int getNumWeeks() {
        return this.numWeeks;
    }

    /**
     * The accessor for base weekly salary
     * 
     * @return  BaseWeeklySalary   weekly saalary base
     */
    public double getBaseWeeklySalary() {
        return this.baseWeeklySalary;
    }

    /**
     * The accessor for weekly sales
     * 
     * @return  weeklySales         weekly sales
     */
    public double getWeeklySales() {
        return this.weeklySales;
    }

     /**
     * The accessor for yearly sales
     * 
     * @return  yearlySales         yearly sales
     */
    public double getYearlySales() {
        return this.yearlySales;
    }

    /**
     * The accessor for commission rate
     * 
     * @return  commissionRate      the commission rate for employees   
     */
    public double getCommissionRate() {
        return this.commissionRate;
    }

    /**
     *Method to calculate weekly salary of employees
     *
     * @return  weeklySales           weekly sales
     *          commissionRate        commission rate for employees
     *          baseWeeklySalary      the weekly salary base for employees  
     */
    public double calcWeeklySalary() {
        return (this.weeklySales * this.commissionRate) + this.baseWeeklySalary;
    }

    /**
     * Method to determine top seller
     * 
     * @return  top     top seller
     */
    public boolean topSeller() {
        boolean top;
        top =  (this.yearlySales / this.numWeeks) > 1500 && this.weeklySales > 1500;
        return top;
    }

    /**
     * Method that prints output in a readable format
     */
    @Override
    public String toString() {
        return super.toString() + "Type: " + this.type + "\n" + "Number of Weeks since Beginning of year: " + this.numWeeks + "\n" 
        + "Base Weekly Salary: " + this.baseWeeklySalary + "\n" + "Weekly Sales: " + this.weeklySales + "\n" + "Yearly Sales: " + this.yearlySales + "\n"
        + "Commission Rate: " + this.commissionRate + "\n" + "TopSellers: " + this.topSeller();
    }

    /**
     * Method that writes data to file.
     */
    public void writeData(PrintWriter pw)  throws IOException{    
        pw.println("\n" + this.name + "\t" + this.empNum + "\t" + this.department + "\t" + this.type + "\t" + this.numWeeks + "\t" + this.baseWeeklySalary + "\t" + this.weeklySales
            + "\t" + this.yearlySales + "\t" + this.commissionRate);
    }

}
