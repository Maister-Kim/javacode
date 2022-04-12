package threadEx.synch3;


public class Atm implements Runnable {
	DataBuffer dataBuffer;
    private int depositMoney = 10000;
    boolean bool = false;

    @Override
    public void run() {
        synchronized (this)
        {
        	if(getDepositMoney() <=0) {
        		return;
        	}
            withdraw(1000);
        }
    }
    public void withdraw(int amount)
    {
    	
        while(!(getDepositMoney() < amount)) {
        	if(this.))
        	{
        		try {
	            	System.out.println("this.wait() 호출");
	            	this.wait();
	            } catch (InterruptedException e) {
	            	e.printStackTrace();
	            }
	            if (getDepositMoney() > 0) {
	            	System.out.println(Thread.currentThread().getName());
	            	System.out.println("this.notify() 호출");
	                this.notify();
	                depositMoney -= amount;
	                System.out.println("잔액: " + depositMoney);
	                //            System.out.println("잔액: " + getDepositMoney);
		            
				}
//	            this.bool = true;
        	}
        	else if(bool == true)
        	{
        		bool = false;
        		try {
	            	System.out.println("this.wait() 호출");
	            	this.wait();
	            } catch (InterruptedException e) {
	            	e.printStackTrace();
	            }
	            if (getDepositMoney() > 0) {
	            	System.out.println(Thread.currentThread().getName());
	            	System.out.println("this.notify() 호출");
	                this.notify();
	                depositMoney -= amount;
	                System.out.println("잔액: " + depositMoney);
	                //            System.out.println("잔액: " + getDepositMoney);
		            
				}
//	            bool = false;
        	}
        }
        System.out.println("잔액부족");   
    }
    public int getDepositMoney() {
        return depositMoney;
    }
}
