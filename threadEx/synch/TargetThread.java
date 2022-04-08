package threadEx.synch;

public class TargetThread extends Thread{
    public void run()
    {
        for(long i = 0; i < 1000000000; i++) {}

        //1.5초간 일시 정지
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(long i = 0; i < 1000000000; i++) {}
    }
}
