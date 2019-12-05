public class Transfer {

    public void withdraw(Account a, int withdrawAmount) {
        double currentAmount = a.getAmount();
        if (currentAmount >= withdrawAmount) {
            a.removeAmount(withdrawAmount);
        } else if (currentAmount < withdrawAmount) {
            System.out.println("Amount to withdraw exceeds amount on the account");
        }
    }

    public void deposit(Account a, int depositAmount) {
        if (depositAmount > 0) {
            a.addAmount(depositAmount);
        }
    }

    public void transfer(Account from, Account to, int transferAmount) {
        if (transferAmount <= from.getAmount()) {
            from.removeAmount(transferAmount);
            to.addAmount(transferAmount);
        }
    }
}
