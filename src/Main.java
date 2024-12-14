import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("Kapital Bank");

        while (true) {
            System.out.println("\n----Bank İdarəetmə Sistemi----");
            System.out.println("\n1. Müştəri əlavə et");
            System.out.println("2. Yeni hesab yaradın");
            System.out.println("3. Depozit et");
            System.out.println("4. Pul köçür");
            System.out.println("5. Ümumi depozit məbləğini göstər");
            System.out.println("6. Çıxış");
            System.out.print("Seçiminizi edin: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Müştərinin adını daxil edin: ");
                    String name = scanner.next();
                    System.out.print("Müştərinin ID-sini daxil edin: ");
                    int id = scanner.nextInt();
                    bank.addCustomer(new Customer(name, id));
                    break;

                case 2:
                    System.out.print("Müştərinin ID-sini daxil edin: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Hesab nömrəsini daxil edin: ");
                    int accountNumber = scanner.nextInt();
                    System.out.print("Başlanğıc depozit məbləğini daxil edin: ");
                    double initialDeposit = scanner.nextDouble();
                    bank.createAccountForCustomer(customerId, accountNumber, initialDeposit);
                    break;

                case 3:
                    System.out.print("Müştərinin ID-sini daxil edin: ");
                    int depositCustomerId = scanner.nextInt();
                    System.out.print("Hesab nömrəsini daxil edin: ");
                    int depositAccountNumber = scanner.nextInt();
                    System.out.print("Depozit məbləğini daxil edin: ");
                    double depositAmount = scanner.nextDouble();
                    bank.depositToAccount(depositCustomerId, depositAccountNumber, depositAmount);
                    break;

                case 4:
                    System.out.print("Göndərən müştərinin ID-sini daxil edin: ");
                    int fromCustomerId = scanner.nextInt();
                    System.out.print("Göndərən hesab nömrəsini daxil edin: ");
                    int fromAccountNumber = scanner.nextInt();
                    System.out.print("Qəbul edən müştərinin ID-sini daxil edin: ");
                    int toCustomerId = scanner.nextInt();
                    System.out.print("Qəbul edən hesab nömrəsini daxil edin: ");
                    int toAccountNumber = scanner.nextInt();
                    System.out.print("Köçürmə məbləğini daxil edin: ");
                    double transferAmount = scanner.nextDouble();
                    bank.transferFunds(fromCustomerId, fromAccountNumber, toCustomerId, toAccountNumber, transferAmount);
                    break;

                case 5:
                    System.out.println("Bankın ümumi depozit məbləği: " + bank.getTotalDeposits());
                    break;

                case 6:
                    System.out.println("Proqram bitir.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Yanlış seçim etdiniz. Yenidən cəhd edin.");
            }
        }
    }
}