//: enumerated/OverrideConstantSpecific.java
package enumerated; /* Added by Eclipse.py */

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public enum OverrideConstantSpecific {
    NUT, BOLT,
    WASHER {
        void f() {
            print("Overridden method");
        }
    };

    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs : values()) {
            printnb(ocs + ": ");
            ocs.f();
        }
    }

    void f() {
        print("default behavior");
    }
} /* Output:
NUT: default behavior
BOLT: default behavior
WASHER: Overridden method
*///:~
