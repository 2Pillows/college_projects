
/*
------------------------------------------------------------------------
 Pseudocode: Two threads are created to count up to 20 and down to 20. Threads are managed using lock and reentrantlock to prevent parallel execution
------------------------------------------------------------------------
 Program Inputs: N/A
------------------------------------------------------------------------
*/
// Import required libraries
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Class for counter object
class CountObj {
    public int count;

    public CountObj() {
        count = 0;
    }
}

// Class for counting up
class CountUp implements Runnable {
    private CountObj countObj;
    private Lock lck;

    // Constructor to get counter object and lock
    public CountUp(CountObj countObj, Lock lck) {
        this.countObj = countObj;
        this.lck = lck;
    }

    // Function to be ran using thread
    @Override
    public void run() {
        lck.lock(); // Aquire lock
        System.out.println("\nStarting Thread1.");

        // While loop for counting up
        while (countObj.count <= 20) {
            System.out.println("Counter: " + countObj.count);
            if (countObj.count == 20)
                break;
            countObj.count++;
        }

        System.out.println("Ending Thread1.");
        lck.unlock(); // Release lock
    }
}

// Class for counting down
class CountDown implements Runnable {
    private CountObj countObj;
    private Lock lck;

    // Constructor to get counter object and lock
    public CountDown(CountObj countObj, Lock lck) {
        this.countObj = countObj;
        this.lck = lck;
    }

    // Function to be ran using thread
    @Override
    public void run() {
        lck.lock(); // Aquire lock
        System.out.println("\nStarting Thread2.");

        // While loop for counting down
        while (countObj.count >= 0) {
            System.out.println("Counter: " + countObj.count);
            if (countObj.count == 0)
                break;
            countObj.count--;
        }

        System.out.println("Ending Thread2.\n");
        lck.unlock(); // Release lock
    }
}

public class ThreadCounters {
    // Main method, throw InterruptedException to handle .join()
    public static void main(String[] args) throws InterruptedException {
        CountObj countObj = new CountObj(); // Counter object to hold counter variable
        Lock lck = new ReentrantLock(); // Lock to manage threads

        // Create threads using runnable classes
        System.out.println("Creating Threads 1 and 2.");
        Thread t1 = new Thread(new CountUp(countObj, lck));
        Thread t2 = new Thread(new CountDown(countObj, lck));

        // Start threads
        System.out.println("Starting Threads 1 and 2.");
        t1.start();
        t2.start();

        // Wait for threads to end
        t1.join();
        t2.join();
    }
}
