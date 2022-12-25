package lab_09;

public abstract class Employee {
    private String name;
    private int salary;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getSalary();
}
