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
 * This is the class that defines the Employees of a company.
 * 
 */
public class Employee
{

    protected String name;
    protected String empNum;
    protected String department;

    /**
     * This method sets the default values for Employee class.
     */
    public Employee() {
        this.name = "";
        this.empNum = "";
        this.department = "";
    }

    /**
     * This is the default constructor for the Employee class.
     */
    public Employee(String name, String empNum, String department) {
        this.name = name;
        this.empNum = empNum;
        this.department = department;
    }
    
    // The mutators
    /**
     * Mutator method for item number
     * 
     * @param       n       item number
     * 
     */
    public void setName(String n) {
        this.name = n;
    }

    /**
     * Mutator method for item number
     * 
     * @param       empNum      employee number
     * 
     */
    public void setEmpNum(String empNum) {
        this.empNum = empNum;
    }

    /**
     * Mutator method for item number
     * 
     * @param       dept        employee department
     * 
     */
    public void setDepartment(String dept) {
        this.department = dept;
    }

    //The accessors 
    /**
     * Accessor method for employee name
     * 
     * @return      name        employee name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor method for employee name
     * 
     * @return      empNum      employee name
     */
    public String getEmpNum() {
        return this.empNum;
    }

     /**
     * Accessor method for employee department
     * 
     * @return      dept     department
     */
    public String getDept() {
        return this.department;
    }

    /**
     * This method validates the employee number.
     * 
     * @param       Employee other       an employee
     *
     * @return       result              result
     */
    public boolean equals(Employee other) {
        boolean result;
        result = this.empNum == other.empNum;
        return result;
    }
    
    /**
     * This method is the toString method that prints the output in a 
     * readable format.
     */
    public String toString() {
        return "Name: " + this.name + "\n" + "Employee Number: " + this.empNum + "\n" + "Department: " + this.department + "\n";
    }

    public double calcWeeklySalary() {
        return 0;
    }

}