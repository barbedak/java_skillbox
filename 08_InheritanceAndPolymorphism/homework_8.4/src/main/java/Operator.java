public class Operator extends Employee {
    private final int BASE_SALARY = 10000;
    private int salary;

    public Operator(Company companyName) {
        super(companyName);
        setSalary(BASE_SALARY);
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }
}