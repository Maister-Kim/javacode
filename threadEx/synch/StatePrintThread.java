package threadEx.synch;

public class StatePrintThread extends Thread{
    private Thread taegetThread;

    public StatePrintThread(Thread taegetThread)
    {
        this.taegetThread = taegetThread;
    }

    public void run()
    {
        while(true)
        {
            Thread.State state = taegetThread.getState();
            System.out.println("타켓 스레드 상태: " + state);

            if(state == State.NEW)
            {
                taegetThread.start();
            }

            if(state == State.TERMINATED)
            {
                break;
            }

            try{
                // 0.5초간 일시 정지
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
