//: innerclasses/Parcel11.java
package innerclasses; /* Added by Eclipse.py */
// Nested classes (static inner classes).

public class Parcel11 {
    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
    }

    private static class ParcelContents implements Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination
            implements Destination {
        static int x = 10;
        private String label;

        private ParcelDestination(String whereTo) {
            label = whereTo;
        }

        // Nested classes can contain other static elements:
        public static void f() {
        }

        public String readLabel() {
            return label;
        }

        static class AnotherLevel {
            static int x = 10;

            public static void f() {
            }
        }
    }
} ///:~
