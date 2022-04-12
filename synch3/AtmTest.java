package threadEx.synch3;

public class AtmTest {
	public static void main(String[] args) {

        Atm atm = new Atm();
        Thread hong = new Thread(atm, "홍길동"); // Runable 상속시 new Thread(사용할 클래스 객체명);
        Thread lee = new Thread(atm, "이순신");
//        hong.setName("홍길동");
//        lee.setName("이순신");
        hong.start();
        lee.start();
	}
}
