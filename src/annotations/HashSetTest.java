//: annotations/HashSetTest.java
package annotations;

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

import java.util.HashSet;

public class HashSetTest {
    HashSet<String> testObject = new HashSet<String>();

    public static void main(String[] args) throws Exception {
        OSExecute.command(
                "java net.mindview.atunit.AtUnit HashSetTest");
    }

    @Test
    void initialization() {
        assert testObject.isEmpty();
    }

    @Test
    void _contains() {
        testObject.add("one");
        assert testObject.contains("one");
    }

    @Test
    void _remove() {
        testObject.add("one");
        testObject.remove("one");
        assert testObject.isEmpty();
    }
} /* Output:
annotations.HashSetTest
  . initialization
  . _remove
  . _contains
OK (3 tests)
*///:~
