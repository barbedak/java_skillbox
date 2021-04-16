public class BankAccount {

  private double amount;

  public BankAccount() {
  }

  public BankAccount(double amount){
    this();
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }

  public void put(double amountToPut) {
    if (amountToPut > 0){
      amount += amountToPut;
    }
  }

  public boolean take(double amountToTake) {
    if (amount > amountToTake && amountToTake > 0){
      amount -= amountToTake;
      return true;
    }
    return false;
  }
  public boolean send(BankAccount receiver, double amount){
    if (take(amount)){
      receiver.put(amount);
      return true;
    }
    return false;
  }
}
