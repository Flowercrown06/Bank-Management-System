import java.util.Scanner;

// Bank sinifi
class Bank {
    private String name;
    private Customer[] customers;
    private double totalDeposits;

    public Bank(String name) {
        this.name = name;
        this.customers = new Customer[10]; // Maksimum 10 müştəri üçün yer ayrılır
        this.totalDeposits = 0;
    }

    public void addCustomer(Customer customer) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = customer;
                System.out.println("Müştəri əlavə edildi: " + customer.getName());
                return;
            }
        }
        System.out.println("Yeni müştəri əlavə etmək üçün yer yoxdur.");
    }

    public Customer findCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer != null && customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public void createAccountForCustomer(int customerId, int accountNumber, double initialDeposit) {
        Customer customer = findCustomerById(customerId);
        if (customer != null) {
            Account newAccount = new Account(accountNumber, initialDeposit);
            customer.addAccount(newAccount);
            totalDeposits += initialDeposit;
            System.out.println("Yeni hesab yaradıldı: Hesab Nömrəsi " + accountNumber);
        } else {
            System.out.println("Müştəri tapılmadı.");
        }
    }

    public void depositToAccount(int customerId, int accountNumber, double amount) {
        Customer customer = findCustomerById(customerId);
        if (customer != null) {
            Account account = customer.findAccountByNumber(accountNumber);
            if (account != null) {
                account.deposit(amount);
                totalDeposits += amount;
                System.out.println("Depozit uğurla edildi: " + amount + " AZN");
            } else {
                System.out.println("Hesab tapılmadı.");
            }
        } else {
            System.out.println("Müştəri tapılmadı.");
        }
    }

    public void transferFunds(int fromCustomerId, int fromAccountNumber, int toCustomerId, int toAccountNumber, double amount) {
        Customer fromCustomer = findCustomerById(fromCustomerId);
        Customer toCustomer = findCustomerById(toCustomerId);

        if (fromCustomer != null && toCustomer != null) {
            Account fromAccount = fromCustomer.findAccountByNumber(fromAccountNumber);
            Account toAccount = toCustomer.findAccountByNumber(toAccountNumber);

            if (fromAccount != null && toAccount != null) {
                if (fromAccount.getBalance() >= amount) {
                    fromAccount.withdraw(amount);
                    toAccount.deposit(amount);
                    System.out.println("Pul köçürməsi uğurla həyata keçirildi.");
                } else {
                    System.out.println("Balans kifayət etmir.");
                }
            } else {
                System.out.println("Hesab tapılmadı.");
            }
        } else {
            System.out.println("Müştəri tapılmadı.");
        }
    }

    public double getTotalDeposits() {
        return totalDeposits;
    }
}