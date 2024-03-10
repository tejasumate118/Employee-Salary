package main.java.project.employee_salary;

public class CalculateSalary {
    public float calSalary(float experience){
        //each 1year of experience is 3 LPA
        if (experience<1)return 3;
        return 3*experience;
    }
    public String salaryToLPA(float salary){
        return String.format("%.2f LPA",salary);
    }
}
