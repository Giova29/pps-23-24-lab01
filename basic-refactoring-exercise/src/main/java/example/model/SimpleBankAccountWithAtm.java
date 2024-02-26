package example.model;

public class SimpleBankAccountWithAtm implements BankAccount {
    private static final int FEE = 1;
    
    private double balance;
    private final AccountHolder holder;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if(this.checkUser(userID) && this.isDepositAllowed(amount)){
            this.balance += (amount - FEE);
        }
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (this.checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= (amount + FEE);
        }
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount + FEE;
    }

    private boolean isDepositAllowed(final double amount){
        return (this.balance + amount) >= FEE;
    }

    private boolean checkUser(final int id) {
        return this.getHolder().getId() == id;
    }
    
}
