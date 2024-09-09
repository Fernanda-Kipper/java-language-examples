public class MultiThreadExample implements Runnable {

    String threadName;

    public MultiThreadExample(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.threadName + " Valor atual do loop " + i);
        }
    }
}
