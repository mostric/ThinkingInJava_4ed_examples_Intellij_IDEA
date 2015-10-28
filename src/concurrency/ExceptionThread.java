//: concurrency/ExceptionThread.java
package concurrency; /* Added by Eclipse.py */
// {ThrowsException}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }

    public void run() {
        throw new RuntimeException();
    }
} ///:~
