package bank;

public interface Bank {
    float deposit(int id, float amount);
    float withDraw(int id, float amount);
    float account(int id, float amount);
    int accountId();

}
