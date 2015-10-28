//: enumerated/TrafficLight.java
package enumerated; /* Added by Eclipse.py */
// Enums in switch statements.

import static net.mindview.util.Print.print;

// Define an enum type:
enum Signal {
    GREEN, YELLOW, RED,
}

public class TrafficLight {
    Signal color = Signal.RED;

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            print(t);
            t.change();
        }
    }

    public void change() {
        switch (color) {
            // Note that you don't have to say Signal.RED
            // in the case statement:
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    public String toString() {
        return "The traffic light is " + color;
    }
} /* Output:
The traffic light is RED
The traffic light is GREEN
The traffic light is YELLOW
The traffic light is RED
The traffic light is GREEN
The traffic light is YELLOW
The traffic light is RED
*///:~
