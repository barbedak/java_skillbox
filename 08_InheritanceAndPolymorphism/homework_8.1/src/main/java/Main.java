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
        System.out.println("Receiver amount - " + clientReceiver.getAmount());
    }
}
