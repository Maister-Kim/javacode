package threadEx.synch;

public class TreadStateEx {
    public static void main(String[] args) {
        StatePrintThread stateT = new StatePrintThread(new TargetThread());
        stateT.start();
    }
}
