package threadEx.synch2;

public class Chef extends Thread {
    String chef;
    Food food;

    public Chef(String chef, Food food)
    {
        this.chef = chef;
        this.food = food;
    }

    public void run()
    {
        while(true)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            food.makeFood(chef);
        }

    }
}
