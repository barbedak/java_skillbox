public class TopManager extends Employee {
    private final static int BASE_SALARY = 100000;
    private final static double BONUS_COEFFICIENT = 1.5;
    private final static int INCOME_FOR_BONUS = 10000000;
    private int salary;

    public TopManager(Company companyName) {
        super(companyName);
        if(companyName.getIncome() > INCOME_FOR_BONUS) {
            setSalary((int) (BASE_SALARY + BASE_SALARY * BONUS_COEFFICIENT));
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