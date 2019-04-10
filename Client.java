import java.util.Scanner;
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
 * This is the class that is the User Interface for the users of this program.
 * 
 */
public class Client
{
    /**
     * Based on the user's choice, employees are processed.
     */
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(System.in);
        Payroll p = new Payroll();
        p.loadData(askFile(in));
        showMenu();
        char choice2 = in.next().charAt(0);
        char choice = Character.toUpperCase(choice2);

        while(choice!= 'Q') {

            switch(choice) {
                case 'A': 
                p.addEmployee(in);
                showMenu();
                choice2 = in.next().charAt(0);
                choice = Character.toUpperCase(choice2);
                break;
                case 'I': 
                p.printInfo(in);
                showMenu();
                choice2 = in.next().charAt(0);
                choice = Character.toUpperCase(choice2);
                break;
                case 'D': 
                p.deleteEmp(in);
                showMenu();
                choice2 = in.next().charAt(0);
                choice = Character.toUpperCase(choice2);
                break;
                case 'S': 
                p.calculateWeeklySalary(in);
                showMenu();
                choice2 = in.next().charAt(0);
                choice = Character.toUpperCase(choice2);
                break;
                case 'T':
                p.printTopSellers();
                showMenu();
                choice2 = in.next().charAt(0);
                choice = Character.toUpperCase(choice2);
                break;
                case 'P':
                p.printSalaryReport();
                showMenu();
                choice2 = in.next().charAt(0);
                choice = Character.toUpperCase(choice2);
                break;
                case 'W':
                p.writeData();
                showMenu();
                choice2 = in.next().charAt(0);
                choice = Character.toUpperCase(choice2);
                break;
                default:
                System.out.print("Invalid character entered. Please try again");
                showMenu();
                choice2 = in.next().charAt(0);
                choice = Character.toUpperCase(choice2);
                break;
            }
        }
        System.out.println ("Thank you for using the Payroll Processing System");
    }

    /**
     * The method that reads in data from the file to be loaded.
     * 
     * @param   Scanner     a scanner that allows input file to be read.
     * 
     * @return  filename    name of the file 
     */
    public static String askFile(Scanner in) {
        System.out.print("Enter file name to be loaded: ");
        String filename = in.next();
        return filename;
    }
    
    //   The Payroll processing menu

    /**
     * The Payroll processing menu.
     */
    public static void showMenu()
    {
        System.out.println("\nMENU:");
        System.out.println("A - Add a new employee");
        System.out.println("I - Print information of an individual employee");
        System.out.println("D - Remove an employee from payroll");
        System.out.println("S - Calculate and print the weekly pay of an employee");
        System.out.println("T - This prints the list of Commission employees who are topSellers");
        System.out.println("P - prints salary report");
        System.out.println("W - End of week processing");
        System.out.println();
        System.out.println("Q - Quit the system");
    }

}
