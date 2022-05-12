public class Account {

    private long money;
    private String accNumber;
    private Boolean isBlocked = false;

    public Account() {
    }

    public Account( String accNumber, long money, Boolean isBlocked) {
        this();
        this.money = money;
        this.accNumber = accNumber;
        this.isBlocked = isBlocked;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void block() {
        isBlocked = true;
    }

    public void unBlock() {
        isBlocked = false;
    }
}
