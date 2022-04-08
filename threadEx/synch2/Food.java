package threadEx.synch2;

public class Food {
    public synchronized void receiveOrder(String waiter)
    {
        for(int i=0;i<5;i++)
        {
            System.out.println(waiter + "가 주문을 받습니다.");
        }
        System.out.println(waiter + "가 주문을 주방에 전달합니다.");
        System.out.println();
    }

    public synchronized void makeFood(String chef)
    {
        for(int i=0;i<5;i++)
        {
            System.out.println(chef + "이 음식을 만듭니다.");
        }
        System.out.println(chef + "이 음식을 다 만들었습니다.");
        System.out.println();
    }
}
