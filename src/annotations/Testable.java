//: annotations/Testable.java
package annotations;

import net.mindview.atunit.Test;

public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    @Test
    void testExecute() {
        execute();
    }
} ///:~
