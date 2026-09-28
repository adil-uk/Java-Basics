public class BankAccount {

    String accountName;
    double accountBalance;

    public BankAccount(String name, double balance) {
        accountName = name;
        accountBalance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
        } else if (amount > accountBalance) {
            System.out.println("Not enough balance");
        } else {
            accountBalance -= amount;
        }
    }

    public void addInterest() {
        accountBalance = accountBalance * 1.03;
    }

    public void displayAccount() {
        System.out.println(accountName + " - £" + accountBalance);
    }
}