public class BankName implements src.main.java.Bank {

    private String name;

    public BankName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    @Override
    public void deposit(float amount) {

    }

    @Override
    public void withdraw(float amount) {

    }

    @Override
    public float account() {
        return 0;
    }

    @Override
    public int getAccountId() {
        return 0;
    }
}

