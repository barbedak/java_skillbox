import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        staff.sort((employee1, employee2) -> {
            if (employee1.getSalary().compareTo(employee2.getSalary()) == 0) {
                return employee1.getName().compareTo(employee2.getName());
            } else {
                return employee1.getSalary().compareTo(employee2.getSalary());
            }
        });
    }
}