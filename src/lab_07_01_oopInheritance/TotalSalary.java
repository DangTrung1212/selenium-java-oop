package lab_07_01_oopInheritance;

import java.util.Arrays;
import java.util.List;

public class TotalSalary {

    public static void main(String[] args) {
        Employee a = new FullTimeEmployee();
        Employee b = new PartTimeEmployee();
        List<Employee> employeeList = Arrays.asList(a, b);
        System.out.println(getTotalSalary(employeeList));
    }

    public static double getTotalSalary(List<Employee> employeeList) {
        double total = 0;
        for (Employee employee : employeeList) {
            total = total + employee.getSalary();
        }
        return total;
    }
}
