//: reusing/Beetle.java
package reusing; /* Added by Eclipse.py */
// The full process of initialization.

import static net.mindview.util.Print.print;

class Insect {
    private static int x1 =
            printInit("static Insect.x1 initialized");
    protected int j;
    private int i = 9;

    Insect() {
        print("i = " + i + ", j = " + j);
        j = 39;
    }

    static int printInit(String s) {
        print(s);
        return 47;
    }
}

public class Beetle extends Insect {
    private static int x2 =
            printInit("static Beetle.x2 initialized");
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }

    public static void main(String[] args) {
        print("Beetle constructor");
        Beetle b = new Beetle();
    }
} /* Output:
static Insect.x1 initialized
static Beetle.x2 initialized
Beetle constructor
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
*///:~
