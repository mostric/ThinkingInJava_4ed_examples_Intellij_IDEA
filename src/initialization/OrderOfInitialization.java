//: initialization/OrderOfInitialization.java
package initialization; /* Added by Eclipse.py */
// Demonstrates initialization order.

import static net.mindview.util.Print.print;

// When the constructor is called to create a
// Window object, you'll see a message:
class Window {
    Window(int marker) {
        print("Window(" + marker + ")");
    }
}

class House {
    Window w1 = new Window(1); // Before constructor
    Window w2 = new Window(2); // After constructor
    Window w3 = new Window(3); // At end

    House() {
        // Show that we're in the constructor:
        print("House()");
        w3 = new Window(33); // Reinitialize w3
    }

    void f() {
        print("f()");
    }
}

public class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();
        h.f(); // Shows that construction is done
    }
} /* Output:
Window(1)
Window(2)
Window(3)
House()
Window(33)
f()
*///:~
