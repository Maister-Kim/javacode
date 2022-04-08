package threadEx.synch3;

public class Atm implements Runnable {
    private int depositMoney = 10000;

    @Override
    public void run() {
        synchronized (this)
        {
            withdraw(1000);
        }
    }
    public void withdraw(int amount)
    {
        while(!(getDepositMoney() < amount)) {
            if (getDepositMoney() > 0) {
                depositMoney -= amount;
                System.out.println(Thread.currentThread().getName());
                System.out.println("잔액: " + depositMoney);
                //            System.out.println("잔액: " + getDepositMoney);
            }
            /* else if (getDepositMoney() < amount) {

            }*/
        }
        System.out.println("잔액부족");
    }
    public int getDepositMoney() {
        return depositMoney;
    }
}
