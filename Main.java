import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MultiThreadExample multiThreadExample1 = new MultiThreadExample("Thread 1");
        MultiThreadExample multiThreadExample2 = new MultiThreadExample("Thread 2");
        MultiThreadExample multiThreadExample3 = new MultiThreadExample("Thread 3");

        Thread thread1 = new Thread(multiThreadExample1);
        Thread thread2 = new Thread(multiThreadExample2);
        Thread thread3 = new Thread(multiThreadExample3);

        thread1.start();
        thread2.start();
        thread3.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main thread Valor atual do loop " + i);
        }

        thread1.join();
        thread2.join();
        thread3.join();
    }
}
