import java.util.ArrayList;
import java.util.List;

public class Company{
    private int income;
    private List<Employee> employeesList = new ArrayList<>();

    public List<Employee> getTopSalaryStaff(int count){
        List<Employee> topSalaryStaff = new ArrayList<>();
        if (count < 1){
            return topSalaryStaff;
        }
        EmployeeComporator myEmployeeComparator = new EmployeeComporator();
        employeesList.sort(myEmployeeComparator);
        for (int i = 0; i < count; i++){
            topSalaryStaff.add(employeesList.get(i));
        }
        return topSalaryStaff;
    }

    public List<Employee> getLowestSalaryStaff(int count){
        List<Employee> lowestSalaryStaff = new ArrayList<>();
        if (count < 1 ) {
            return lowestSalaryStaff;
        }
        EmployeeComporator myEmployeeComparator = new EmployeeComporator();
        employeesList.sort(myEmployeeComparator.reversed());
        for (int i = 0; i < count; i++){
            lowestSalaryStaff.add(employeesList.get(i));
        }
        return lowestSalaryStaff;
    }

    public void hire(Employee employee){
        employeesList.add(employee);
    }

    public void hireAll(List<Employee> employees){
        for (Employee e : employees){
            hire(e);
        }
    }

    public void fire(Employee employee){
        employeesList.remove(employee);
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getIncome() {
        return income;
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public int getCompanySize(){
        return employeesList.size();
    }
}