public class Main {
    public static void main(String[] args) {
        Company myCompany = new Company();

        for (int i = 0; i < 180; i++) {
            Employee operator = new Operator(myCompany);
            myCompany.hire(operator);
        }
        for (int i = 0; i < 80; i++) {
            Employee manager = new Manager(myCompany);
            myCompany.hire(manager);
        }
        for (int i = 0; i < 10; i++) {
            myCompany.setIncome((int)(Math.random() * 9999999 + 2000000));
            Employee topManager = new TopManager(myCompany);
            myCompany.hire(topManager);
        }

        System.out.println("Top salary :");
        for(Employee e : myCompany.getTopSalaryStaff(15)) {
            System.out.println(e.getMonthSalary() + " руб.");
        }

        System.out.println("\nLowest salary :");
        for(Employee e : myCompany.getLowestSalaryStaff(30)) {
            System.out.println(e.getMonthSalary() + " руб.");
        }

        int countFireEmployee = myCompany.getCompanySize() / 2;
        for(int i = 0; i <= countFireEmployee; i++){
            int indexFireEmployee = (int)(myCompany.getCompanySize() - Math.random() * myCompany.getCompanySize());
            myCompany.fire(myCompany.getEmployeeList().get(indexFireEmployee));
        }
        System.out.println("\nFire " + countFireEmployee + " employees");
        System.out.println("\nTop salary :");
        for(Employee e : myCompany.getTopSalaryStaff(15)) {
            System.out.println(e.getMonthSalary() + " руб.");
        }

        System.out.println("\nLowest salary :");
        for(Employee e : myCompany.getLowestSalaryStaff(30)) {
            System.out.println(e.getMonthSalary() + " руб.");
        }
    }
}