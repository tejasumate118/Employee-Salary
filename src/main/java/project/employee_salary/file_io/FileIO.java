package main.java.project.employee_salary.file_io;
import main.java.project.employee_salary.*;

import java.io.*;
import java.util.*;

public class FileIO {
    private  static final EmployeeSalary employeeSalary=new EmployeeSalary();
    private static final CalculateSalary calculateSalary=new CalculateSalary();
    private List<Employee> employees=new ArrayList<>();

    public void testCSVInput() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the path of the CSV file:\n");
        String path=sc.nextLine();

        try {
            FileReader file=new FileReader(path);
            BufferedReader br=new BufferedReader(file);
            String line;
            while ((line=br.readLine())!=null){
                employees.add(processDataToEmployee(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        // Write data to CSV file
        writeToCSV(employees,path);
    }

    private void writeToCSV(List<Employee> employees,String path) {
        StringBuilder sb=new StringBuilder();
        for(Employee employee:employees){
            sb.append(formatObjToCSV(employee)+"\n");
        }
        try{
            FileWriter fileWriter=new FileWriter(path);
            fileWriter.write(sb.toString());
            fileWriter.flush();
            System.out.println("File Updated Successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String formatObjToCSV(Employee employee) {
        return employee.getName()+","+employee.getId()+","+employee.getExperience()+","+employee.getSalary();
    }

    public Employee processDataToEmployee(String s){
        String[] input=s.split(",");
        //creating object via parameterized constructor
        Employee employee=new Employee(input[0],Integer.parseInt(input[1].trim()),Float.parseFloat(input[2].trim()));
        //Set Salary
        employee.setSalary(calculateSalary.calSalary(employee.getExperience()));
        return employee;

    }
}
