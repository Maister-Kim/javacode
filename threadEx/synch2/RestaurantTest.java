package threadEx.synch2;

public class RestaurantTest {
    public static void main(String[] args) {
        Food food = new Food();
        Chef chef = new Chef("주방장", food); // 생성자 메소드로 전달
        Waiter waiter = new Waiter("웨이터", food); // 생성자 메소드로 전달

        waiter.start();
        chef.start();
    }
}
