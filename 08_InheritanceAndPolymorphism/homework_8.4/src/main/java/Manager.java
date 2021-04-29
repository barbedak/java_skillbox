public class Manager extends Employee {
    private final int BASE_SALARY = 30000;
    private int companyProfit;
    private int salary;

    Manager(Company companyName){
        super(companyName);
        setCompanyProfit((int)(Math.random() * 115000 + 25000));
        setSalary((int)(BASE_SALARY + companyProfit * 0.05));
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setCompanyProfit(int companyProfit) {
        this.companyProfit = companyProfit;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }
}