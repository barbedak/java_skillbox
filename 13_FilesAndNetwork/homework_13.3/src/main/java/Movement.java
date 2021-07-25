import java.util.Date;

public class Movement {
    private String accountType;
    private String account;
    private String currency;
    private Date date;
    private String reference;
    private String description;
    private Double income;
    private Double expense;

    public String getOrganization() {
        String result = "";
        if (reference.matches("OP.+")) {
            String[] fragments = description.replaceAll("\\s{2,}", "|").split("\\|");
            result = fragments[2].replaceAll("/", " ").trim();
        } else {
            String[] fragments = description.split("\\\\");
            for (int i = 1; i < fragments.length - 1; i++) {
                fragments[i] = fragments[i].replaceAll("\\s+", " ").trim();
                result = result.concat(fragments[i] + " ");
            }
            fragments = fragments[fragments.length - 1].replaceAll("\\s{2,}", "|").split("\\|");
            result = result.concat(fragments[0].trim()).trim();
        }
        return result.trim();
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }
}
