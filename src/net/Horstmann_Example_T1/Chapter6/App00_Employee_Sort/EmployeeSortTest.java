package net.Horstmann_Example_T1.Chapter6.App00_Employee_Sort;

import java.util.Arrays;

/**
 * Created by root on 27.01.2015.
 */
public class EmployeeSortTest {
    public static void main(String[] args) {
        EmployeeSort[] staff = new EmployeeSort[3];

        staff[0] = new EmployeeSort("Dima", 25000, 68);
        staff[1] = new EmployeeSort("Sveta", 36000, 75);
        staff[2] = new EmployeeSort("Kate", 19000, 41);

        System.out.println("Список до сортировки:");
        System.out.println(staff[0] + "\n" + staff[1] + "\n" + staff[2]);

        System.out.println("\nСписок после сортировки по salary");
        Arrays.sort(staff);
        System.out.println(staff[0] + "\n" + staff[1] + "\n" + staff[2]);
    }
}
