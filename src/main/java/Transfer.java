import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Transfer {
    List<Account>  accountList = new ArrayList<>();
    private static Transfer  transfer = null;
    private Transfer() {
    }
    public static Transfer getInstance(){
        if (transfer == null)
        {
            transfer = new Transfer();
        }
        return transfer;
    }

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

    public void transfer(int accountIdFrom , int accountIdTo, double transferAmount) {

        List<Account> filterList = accountList.stream()
                .filter(e -> e.getId() == accountIdFrom)
                .collect(Collectors.toList());
        List<Account> filterList1 = accountList.stream()
                .filter(e -> e.getId() == accountIdTo)
                .collect(Collectors.toList());

        if (filterList.size()>=1 || filterList1.size() >= 1) {
            if (transferAmount <= filterList.get(0).getAmount()) {
                int index = accountList.indexOf(filterList.get(0));
                double amount = accountList.get(index).getAmount();
                accountList.get(index).setAmount(amount-transferAmount);
                int index1 = accountList.indexOf(filterList1.get(0));
                double amount1 = accountList.get(index).getAmount();
                accountList.get(index1).setAmount(amount1+transferAmount);

                //System.out.println("Current balance of sending account: " + Account.getInstance().getAmount());
                //System.out.println("Current balance of receiving account: " + Account.getInstance().getAmount());
            }
        }
    }
}
