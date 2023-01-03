package lab_09;

public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name) {
        super(name);
    }

    private final static int PART_TIME_EMPLOYEE = 40_000;

    @Override
    public int getSalary() {
        return PART_TIME_EMPLOYEE;
    }
}
