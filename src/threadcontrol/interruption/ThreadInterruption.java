package threadcontrol.interruption;

public class ThreadInterruption {
    public static void main(String[] args) {
        InterruptibleThread thread = new InterruptibleThread();
        thread.start();

        try {
            Thread.sleep(2000); // Main thread sleeps for 2 seconds
            thread.interrupt();  // Interrupt the child thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class InterruptibleThread extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Thread is running...");
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
                Thread.currentThread().interrupt(); // Re-interrupt to exit the loop
            }
        }
        System.out.println("Thread is exiting...");
    }
}
