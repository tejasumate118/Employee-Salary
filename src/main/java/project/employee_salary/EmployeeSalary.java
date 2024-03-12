package main.java.project.employee_salary;

import main.java.project.employee_salary.file_io.*;


import java.util.*;

public class EmployeeSalary {
    private static final CalculateSalary calculateSalary=new CalculateSalary();
    private static final Scanner sc=new Scanner(System.in);
    private static final FileIO fileIO=new FileIO();
    public static void main(String[] args) {
         //testSingleSalary();
        //testMultipleSalary();
         //testMultipleObject();
         fileIO.testCSVInput();
    }

    private static void testMultipleObject() {
        System.out.println("Enter number of employees:");
        //Store Objects of Employee
        ArrayList<Employee> employees=new ArrayList<>();
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("Enter Employee name, id, experience");
            String s=sc.nextLine();
            String[] input=s.split(",");
            //creating object via parameterized constructor
            Employee employee=new Employee(input[0],Integer.parseInt(input[1].trim()),Float.parseFloat(input[2].trim()));
            employees.add(employee);
            //Set salary
            employee.setSalary(calculateSalary.calSalary(employee.getExperience()));
        }
        //print data
        System.out.println("+-------+------------------+------------+------------+");
        System.out.println("| ID    | Name             | Experience | Salary     |");


        for(Employee employee:employees){
            employee.printData();
        }
        System.out.println("+-------+------------------+------------+------------+");

    }

    private static void testMultipleSalary() {
        System.out.println("Enter experience comma separated ");
        String s=sc.nextLine();
        String[] inputs=s.split(",");
        ArrayList<Float> experiences=new ArrayList<>();
        for(String experience: inputs){
            experiences.add(Float.parseFloat(experience.trim()));
        }

        for(Float exp:experiences){
            System.out.print(calculateSalary.salaryToLPA(calculateSalary.calSalary(exp))+" ");
        }
    }

    private static void testSingleSalary() {
        System.out.println("Enter the experience: ");
        float salary=calculateSalary.calSalary(sc.nextFloat());
        System.out.println("Salary in LPA is: "+calculateSalary.salaryToLPA(salary));
    }
}
