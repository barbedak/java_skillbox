public class Main {
    private static final String PATH_MOVEMENTS_CSV = "../files/movementList.csv";

    public static void main(String[] args) {
        Movements movements = new Movements(PATH_MOVEMENTS_CSV);
        System.out.println("Общие расходы : " + String.format("%.0f", movements.getExpenseSum() / 1000) + " " +
                String.format("%.2f", movements.getExpenseSum() % 1000) + " руб.");
        System.out.println("Общие доходы  : " + String.format("%.0f", movements.getIncomeSum() / 1000) + " " +
                String.format("%.2f", movements.getIncomeSum() % 1000) + " руб.");
        System.out.println("Общие расходы по организациям : ");
        for (String key : movements.getExpenseByOrganizations().keySet()) {
            System.out.println("\t" + key);
            System.out.println("\t\t\t\t\t\t\t\t\t" + movements.getExpenseByOrganizations().get(key) + " руб.");
        }
    }
}
