class MyThread implements Runnable {

    public void run() {
        try {
            for (int i = 0; i <= 5; i++) {
                System.out.println("Child Thread");
                Thread.sleep(500);

            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Child Thread Exiting");
    }
}

public class SimpleThread {
    public static void main(String[] argv) {

        MyThread mt = new MyThread();
        Thread t = new Thread(mt);
        t.start();
        System.out.println(t.getPriority());

        try {
            for (int i = 0; i <= 5; i++) {
                System.out.println("Main Thread");
                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Main Thread Exiting");
    }

}
