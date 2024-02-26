package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {
    private static final int FEE = 1;
    
    private double balance;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
        this.balance = balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if(this.isDepositAllowed(amount)){
            super.deposit(userID, amount);
            this.balance -= FEE;
        }
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public AccountHolder getHolder() {
        return super.getHolder();
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
