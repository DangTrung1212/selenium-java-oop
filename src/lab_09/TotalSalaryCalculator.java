package lab_09;

import java.util.Arrays;
import java.util.List;

public class TotalSalaryCalculator {
    public static void main(String[] args) {
        Employee a = new FulltimeEmployee("Mr. A");
        Employee b = new PartTimeEmployee("Mrs. B");
        getTotalSalary(Arrays.asList(a,b));
    }
    public static int getTotalSalary(List<Employee> employeeList) {
        int totalSalary = 0;
        for (Employee employee : employeeList) {
            totalSalary += employee.getSalary();
        }
        System.out.println("Total salary is: "+ totalSalary);
        return totalSalary;
    }
}
