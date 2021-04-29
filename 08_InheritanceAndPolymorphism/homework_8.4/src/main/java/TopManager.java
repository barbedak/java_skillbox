public class TopManager extends Employee {
    private final int BASE_SALARY = 100000;
    private int salary;

    public TopManager(Company companyName) {
        super(companyName);
        if(companyName.getIncome() > 10000000) {
            setSalary((int)(BASE_SALARY + BASE_SALARY * 1.5));
        } else {
            setSalary(BASE_SALARY);
        }
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

}