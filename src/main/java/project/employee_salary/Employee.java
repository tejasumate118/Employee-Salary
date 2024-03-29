package main.java.project.employee_salary;

public class Employee {
    private String name;
    private int id;

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    private float experience;
    private float salary;

    public Employee(String name, int id, float experience) {
        this.name = name;
        this.id = id;
        this.experience=experience;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    public void printData() {
        System.out.println("+-------+------------------+------------+------------+");
        System.out.printf("| %-5s | %-16s | %-10s | %-10s |\n", getId(), getName(), String.format(getExperience()+" Years"), String.format(getSalary()+" LPA"));

    }

}

