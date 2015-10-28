//: innerclasses/DotThis.java
package innerclasses; /* Added by Eclipse.py */
// Qualifying access to the outer-class object.

public class DotThis {
    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }

    void f() {
        System.out.println("DotThis.f()");
    }

    public Inner inner() {
        return new Inner();
    }

    public class Inner {
        public DotThis outer() {
            return DotThis.this;
            // A plain "this" would be Inner's "this"
        }
    }
} /* Output:
DotThis.f()
*///:~
