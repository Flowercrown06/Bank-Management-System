class Customer {
    private String name;
    private int id;
    private Account[] accounts;
    private int accountCount;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
        this.accounts = new Account[10];
        this.accountCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addAccount(Account account) {
        if (accountCount < accounts.length) {
            accounts[accountCount++] = account;
        } else {
            System.out.println("Hesab əlavə etmək üçün yer yoxdur.");
        }
    }

    public Account findAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account != null && account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}
