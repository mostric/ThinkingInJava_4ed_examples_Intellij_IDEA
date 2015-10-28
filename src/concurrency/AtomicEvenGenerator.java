//: concurrency/AtomicEvenGenerator.java
package concurrency; /* Added by Eclipse.py */
// Atomic classes are occasionally useful in regular code.
// {RunByHand}

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue =
            new AtomicInteger(0);

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }

    public int next() {
        return currentEvenValue.addAndGet(2);
    }
} ///:~
