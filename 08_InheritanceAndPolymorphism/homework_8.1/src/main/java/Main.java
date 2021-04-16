public class Main {
    public static void main(String[] args) {
        BankAccount clientDonor = new BankAccount();
        BankAccount clientReceiver = new BankAccount();

        clientDonor.put(1000);
        clientReceiver.put(100);

        System.out.println("Donor amount - " + clientDonor.getAmount());
        System.out.println("Receiver amount - " + clientReceiver.getAmount());
        System.out.println("Donor send 200 receiver");

        clientDonor.send(clientReceiver, 200);

        System.out.println("Donor amount - " + clientDonor.getAmount());
        System.out.println("Receiver amount - " + clientReceiver.getAmount() + "\n");

        BankAccount cardAccount = new CardAccount(500.0);
        BankAccount deposit = new DepositAccount(250.0);

        System.out.println("card amount - " + cardAccount.getAmount());
        System.out.println("put 1000 to card");
        cardAccount.put(1000);
        System.out.println("\tcard amount - " + cardAccount.getAmount());
        System.out.println("try take 100 from card");
        cardAccount.take(100);
        System.out.println("\tcard amount - " + cardAccount.getAmount() + "\n");

        System.out.println("deposit amount - " + deposit.getAmount());
        System.out.println("put 1000 to deposit");
        deposit.put(1000);
        System.out.println("\tdeposit amount - " + deposit.getAmount());
        System.out.println("try take 200 from deposit");
        deposit.take(200);
        System.out.println("\tdeposit amount - " + deposit.getAmount());
    }
}
