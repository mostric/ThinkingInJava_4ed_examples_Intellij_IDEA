//: innerclasses/Parcel6.java
package innerclasses; /* Added by Eclipse.py */
// Nesting a class within a scope.

public class Parcel6 {
    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }

    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
        // Can't use it here! Out of scope:
        //! TrackingSlip ts = new TrackingSlip("x");
    }

    public void track() {
        internalTracking(true);
    }
} ///:~
