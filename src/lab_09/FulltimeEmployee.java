package lab_09;

public class FulltimeEmployee extends Employee{
    public FulltimeEmployee(String name) {
        super(name);
    }
    private static final int FULL_TIME_EMPLOYEE = 50000;
    @Override
    public int getSalary() {
        return FULL_TIME_EMPLOYEE;
    }
}
