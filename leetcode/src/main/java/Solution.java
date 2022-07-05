import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            while (true) {
                lock.lock();
                System.out.println("A");

            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("B");
            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {
                System.out.println("C");
            }
        });
    }


}
