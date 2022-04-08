package threadEx.synch2;

public class Waiter extends Thread{
    String waiter;
    Food food;

    public Waiter(String waiter, Food food)
    {
        this.waiter = waiter;
        this.food = food;
    }

    public void run()
    {
        for(int i=0;i<5;i++)
        {
            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                food.receiveOrder(waiter);
            }
        }
    }
}
