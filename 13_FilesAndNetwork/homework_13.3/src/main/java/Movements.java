import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {
    private ArrayList<Movement> listMovements = new ArrayList<>();

    private ArrayList<String> splitLine(String line) {
        ArrayList<String> fragments = new ArrayList<>();
        Pattern pattern = Pattern.compile("\".+\"|[^,]+");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            fragments.add(matcher.group().replaceAll("\"", "").replace(",", "."));
        }
        return fragments;
    }

    public Movements(String pathMovementsCsv) {
        try {
            ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(pathMovementsCsv));
            for (String line : lines) {
                ArrayList<String> fragments = splitLine(line);
                if (fragments.get(1).matches("\\d+")) {
                    Movement movement = new Movement();
                    movement.setAccountType(fragments.get(0));
                    movement.setAccount(fragments.get(1));
                    movement.setCurrency(fragments.get(2));
                    movement.setDate(new SimpleDateFormat("dd.MM.yyyy").parse(fragments.get(3)));
                    movement.setReference(fragments.get(4));
                    movement.setDescription(fragments.get(5));
                    movement.setIncome(Double.parseDouble(fragments.get(6)));
                    movement.setExpense(Double.parseDouble(fragments.get(7)));
                    listMovements.add(movement);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Movement> getListMovements() {
        return listMovements;
    }

    public double getExpenseSum() {
        double expenseSum = 0.0;
        for (Movement movement : listMovements) {
            expenseSum += movement.getExpense();
        }
        return expenseSum;
    }

    public double getIncomeSum() {
        double incomeSum = 0.0;
        for (Movement movement : listMovements) {
            incomeSum += movement.getIncome();
        }
        return incomeSum;
    }

    public TreeMap<String, Double> getExpenseByOrganizations() {
        TreeMap<String, Double> expense = new TreeMap<>();
        for (Movement movement : listMovements) {
            if (movement.getExpense() > 0) {
                try {
                    String organizationName = movement.getOrganization().toUpperCase(Locale.US);
                    if (expense.containsKey(organizationName)) {
                        expense.put(organizationName, expense.get(organizationName) + movement.getExpense());
                    } else {
                        expense.put(organizationName, movement.getExpense());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return expense;
    }
}
