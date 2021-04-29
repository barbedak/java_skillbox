import java.util.Comparator;

public class EmployeeComporator  implements Comparator<Employee>{
    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e2.getMonthSalary(), e1.getMonthSalary());
    }
}
