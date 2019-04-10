import java.util.*;
import java.io.*;
import java.util.ArrayList;
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
 * This is the processing class that processes the Payroll of the company.
 * 
 */
public class Payroll
{
    private ArrayList<Employee> employees;
    /**
     * This is the constructor for the Payroll class.
     */
    public Payroll() {
        employees = new ArrayList<Employee>();
    }

    /**
     * This method is the data read from the file to be 
     * loaded into the instance variables.
     * 
     * @param   String fileName     the name of the file the data is read from.
     */
    public void loadData(String filename) throws FileNotFoundException {
        Scanner fileIn = new Scanner(new File(filename));
        while (fileIn.hasNext()) {
            String name = fileIn.next();
            String empNum = fileIn.next();
            String department = fileIn.next();
            char type = fileIn.next().charAt(0);
            if (type == 'H') {
                processH(fileIn, name, empNum, department);
            } else {
                if (type == 'S') {
                    processS(fileIn, name, empNum, department);
                }  else {
                    if (type == 'C') {
                        processC(fileIn, name, empNum, department);
                    }
                }
            }
        }
        fileIn.close();
    }

    /**
     * The method that enters the employee number.
     * 
     * @param       Scanner in     The scanner that reads the input 
     */
    public String enter(Scanner in) {
        System.out.print("Enter the employee number: ");
        String newEmp2 = in.next();
        return newEmp2;
    }

    /**
     * The method that processes hourly employees.
     * 
     * @params  Scanner filein      the scanner that reads data from file
     *          name                employee name
     *          empNum              employee number 
     *          department          employee department
     */
    public void processH(Scanner filein, String name, String empNum, String department){
        Scanner in = new Scanner(System.in);
        double hrlyPay = filein.nextDouble();
        double hrsWorked = filein.nextDouble();
        System.out.print("Enter the number of hours worked this week for employee " + empNum + ": ");
        double hrsWorked2 = in.nextDouble();
        hrsWorked = hrsWorked2;
        Employee h = new Hourly(name, empNum, department, hrlyPay, hrsWorked);
        employees.add(h);
    }
   
    /**
     * Method that processes salaried employees.
     * 
     * @params  Scanner filein      the scanner that reads data from file
     *          name                employee name
     *          empNum      top        employee number 
     *          department          employee department
     */
    public void processS(Scanner filein, String name, String empNum, String department) {
        double yearly = filein.nextDouble();
        Employee s = new Salary(name, empNum, department, yearly); 
        employees.add(s);
    }

    /**
     * Method that processes commissioned employees.
     * 
     * @params  Scanner filein      the scanner that reads data from file
     *          name                employee name
     *          empNum              employee number 
     *          department          employee department
     */
    public void processC(Scanner filein, String name, String empNum, String department) {
        Scanner in = new Scanner(System.in);
        int weeks = filein.nextInt();
        double baseWeekly = filein.nextDouble();
        double weeklySales = filein.nextDouble();
        double yearlySales = filein.nextDouble();
        double commission = filein.nextDouble();
        System.out.print("Enter the weekly sales for employee: " + empNum + ":");
        weeklySales = in.nextDouble();
        Employee c = new Commission(name, empNum, department, weeks, baseWeekly, weeklySales, yearlySales, commission);
        employees.add(c);
    }

    /**
     * Method that prints the employee information.
     * 
     * @param Scanner in        the Scanner that reads data
     */
    public void printInfo(Scanner in) {
        String newEmp2 = enter(in);
        boolean there = false;
        for (int i = 0; i < employees.size(); i++) {
            if (newEmp2.equals(employees.get(i).getEmpNum())) {
                System.out.println(employees.get(i));
                there = true;
            }
        }
        if(there == false) {
            System.out.println("Invalid employee number.");
        }

    }

    /**
     * Method that validates employee number
     * 
     * @param       empNum        employee number
     * 
     * @return      index         employee number at the specified index
     */
    public int checkNum(String empNum) {
        int index = -1;
        for (int i = 0; i < employees.size(); i++) {
            if(empNum.equals(employees.get(i).getEmpNum())) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Method that deletes an employee.
     * 
     * @param       Scanner in      the Scanner that reads in the data
     */
    public void deleteEmp(Scanner in) {
        String empNum = enter(in);
        int i = checkNum(empNum);
        if (i != -1) {
            System.out.print(employees.get(i).getName() + "\t" + employees.get(i).getEmpNum() + "\nAre you sure you would like to delete this employee? ");
            char answer = in.next().charAt(0);
            if(answer == 'Y') {
                employees.remove(i);
                System.out.println("Employee has succesfully been removed.");
            } else {
                System.out.println("Employee removal unsucessfull.");
            }
        } else {
            System.out.println("Invalid employee number entered.");
        }
    }

    /**
     * Method that adds an employee.
     * 
     * @param   Scanner in      the Scanner that reads in the data 
     */
    public void addEmployee(Scanner in) {
        String newEmp = enter(in);
        int i = checkNum(newEmp);
        if (i != -1) {
            System.out.println("Employee with number " + newEmp + " already exists.");
        } else {
            System.out.print("Enter the type of employee: ");
            char type1 = in.next().charAt(0);
            char type = Character.toUpperCase(type1);
            if (type == 'H') {
                readH2(in, newEmp);
            } else {
                if (type == 'S') {
                    readS2(in, newEmp);
                } else {
                    if (type == 'C') {
                        readC2(in, newEmp);
                    } else {
                        System.out.println("Invalid character entered.");
                    }
                }
            }
        }
    }

    /**
     * Method that calculates the weekly salary of an employee.
     * 
     * @param   Scanner in      the scanner that reads in the data
     */
    public void calculateWeeklySalary(Scanner in) {
        String empNum = enter(in);
        int i = checkNum(empNum);
        if (i != -1) {
            System.out.println("Weekly Salary: " + employees.get(i).calcWeeklySalary());
        } else {
            System.out.println("Invalid employee number enetered.");
        }
    }

    /**
     * Method that prints out the salary report in a readable format
     * 
     */
    public void printSalaryReport() {
        double weekly = 0;
        String empNum = "";
        String name = "Jimmy"; 
        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i) instanceof Hourly) {
                System.out.printf("%-25s%-27s%-20s$%-25.2f%n", employees.get(i).getName(), employees.get(i).getEmpNum(),"Hourly", employees.get(i).calcWeeklySalary());
            } else {
                if (employees.get(i) instanceof Salary) {
                    System.out.printf("%-25s%-27s%-20s$%-25.2f%n", employees.get(i).getName(), employees.get(i).getEmpNum(),"Salary", employees.get(i).calcWeeklySalary());
                } else {
                    if (employees.get(i) instanceof Commission) {
                        System.out.printf("%-25s%-27s%-20s$%-25.2f%nn", employees.get(i).getName(), employees.get(i).getEmpNum(),"Commission", employees.get(i).calcWeeklySalary());
                    }
                }
            }
        }
    }

    /**
     * The method that writes the data to the file.
     */
    public void writeData() throws IOException{
        PrintWriter pw = new PrintWriter(new File("in2.txt"));
        for(int i = 0; i < employees.size(); i++) {

            if(employees.get(i) instanceof Hourly) {
                Hourly h = (Hourly) employees.get(i);
                h.setHrsWorked(0);
                h.writeData(pw);
            } else {

                if (employees.get(i) instanceof Commission) {
                    Commission c = (Commission) employees.get(i);
                    c.setWeeklySales(0);
                    c.setNumWeeks(c.getNumWeeks() + 1);
                    c.writeData(pw);
                } else {
                    if (employees.get(i) instanceof Salary) {
                        Salary s = (Salary) employees.get(i);
                        s.writeData(pw);
                    }
                }
            }

        }
        pw.close();
        System.out.println("Data successfully written to the file.");
    }

    /**
     * The method that prints the top seller employees.
     */
    public void printTopSellers() {
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i) instanceof Commission) {
                Commission newC = (Commission) employees.get(i);
                if (newC.topSeller() == true) {
                    System.out.println("Top Seller: " + newC.getName() + "\t" + newC.getEmpNum());
                }
            }
        }
    }

    /**
     * The method that reads the employee name
     * 
     * @return      name2       name of emplyee
     */
    public String readsEmp() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of new employee: ");
        String name2 = in.next();
        return name2;
    }

    /**
     * The method that reads the employee's department 
     * 
     * @return      dept        department of employee
     */
    public String readsDept() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the department: ");
        String dept = in.next();
        return dept;
    }

    /**
     * Method that reads in hourly employee data
     * 
     * @param       Scanner in      reads in data 
     *              newEmp          new employee that's been added
     */
    public void readH2(Scanner in, String newEmp) {
        String name2 = readsEmp();
        String dept = readsDept();
        System.out.print("Enter hourly pay rate: ");
        double hourlyPay = in.nextDouble();
        System.out.print("Enter hours worked this week: ");
        double hrsWorkedWeek = in.nextDouble();
        Employee h2 = new Hourly(name2, newEmp, dept, hourlyPay, hrsWorkedWeek);
        employees.add(h2);
        System.out.println("Employee successfully added.");
    }

    /**
     * The method that reads in salaried employee data
     * 
     * @param   Scanner in      the Scanner that reads in data
     *          newEmp          new employee that's been added
     */
    public void readS2(Scanner in, String newEmp) {
        String name2 = readsEmp();
        String dept = readsDept();
        System.out.print("Enter the yearly salary: ");
        double yearly = in.nextDouble();
        Employee s2 = new Salary(name2, newEmp, dept, yearly);
        employees.add(s2);
        System.out.println("Employee successfully added.");
    }

    /**
     * The method that reads in commission employee data.
     * 
     * @param   Scanner in      the Scanner that reads in data
     *          newEmp          new employee thats been added
     */
    public void readC2(Scanner in, String newEmp) {
        String name2 = readsEmp();
        String dept = readsDept();
        System.out.print("Enter the number of weeks since start of year or employment: ");
        int numWeeksSinceStart = in.nextInt();
        System.out.print("Enter the base weekly salary: ");
        double baseWeekly = in.nextDouble();
        System.out.print("Enter this week's sales: ");
        double weeklySales = in.nextDouble();
        System.out.print("Enter sales this year, discluding this week: ");
        double yearlySales = in.nextDouble();
        System.out.print("Enter the commission rate: ");
        double commissionRate = in.nextDouble();
        Employee c2 = new Commission(name2, newEmp, dept, numWeeksSinceStart, baseWeekly, weeklySales, yearlySales, commissionRate);
        employees.add(c2);
        System.out.println("Employee successfully added.");
    }
}