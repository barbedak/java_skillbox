abstract class Employee implements Employees {
    private Company company;

    public abstract int getMonthSalary();

    public Employee(Company company) {
        this.company = company;
    }

}
