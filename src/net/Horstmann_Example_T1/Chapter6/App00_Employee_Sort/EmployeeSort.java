package net.Horstmann_Example_T1.Chapter6.App00_Employee_Sort;

/**
 * Created by root on 27.01.2015.
 */
public class EmployeeSort implements Comparable<EmployeeSort> {
    private String name;
    private double salary;
    private int id;

    public EmployeeSort(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    @Override
    public int compareTo(EmployeeSort otherEmployee) {
        return Double.compare(salary, otherEmployee.salary);
    }

    @Override
    public String toString() {
        return "name = " + name + ", salary = " + salary + ", id = " + id;
    }
}
