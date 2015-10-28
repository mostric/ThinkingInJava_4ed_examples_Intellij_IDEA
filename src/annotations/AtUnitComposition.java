//: annotations/AtUnitComposition.java
// Creating non-embedded tests.
package annotations;

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

public class AtUnitComposition {
    AtUnitExample1 testObject = new AtUnitExample1();

    public static void main(String[] args) throws Exception {
        OSExecute.command(
                "java net.mindview.atunit.AtUnit AtUnitComposition");
    }

    @Test
    boolean _methodOne() {
        return
                testObject.methodOne().equals("This is methodOne");
    }

    @Test
    boolean _methodTwo() {
        return testObject.methodTwo() == 2;
    }
} /* Output:
annotations.AtUnitComposition
  . _methodOne
  . _methodTwo This is methodTwo

OK (2 tests)
*///:~
