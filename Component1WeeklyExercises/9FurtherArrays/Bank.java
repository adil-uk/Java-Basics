public class Bank {
    public static void main(String[] args) {

        BankAccount[] bankAccounts = new BankAccount[30];
        int totalAccounts = 0;

        bankAccounts[totalAccounts++] = new BankAccount("Ali", 100);
        bankAccounts[totalAccounts++] = new BankAccount("John", 200);

        bankAccounts[0].deposit(50);

        bankAccounts[1].withdraw(30);

        bankAccounts[0].addInterest();

        bankAccounts[0].displayAccount();
        bankAccounts[1].displayAccount();

    }
}