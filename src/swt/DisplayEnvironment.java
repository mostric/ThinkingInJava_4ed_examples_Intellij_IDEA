//: swt/DisplayEnvironment.java
package swt; /* Added by Eclipse.py */

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import swt.util.SWTApplication;
import swt.util.SWTConsole;

import java.util.Map;

public class DisplayEnvironment implements SWTApplication {
    public static void main(String[] args) {
        SWTConsole.run(new DisplayEnvironment(), 800, 600);
    }

    public void createContents(Composite parent) {
        parent.setLayout(new FillLayout());
        Text text = new Text(parent, SWT.WRAP | SWT.V_SCROLL);
        for (Map.Entry entry : System.getenv().entrySet()) {
            text.append(entry.getKey() + ": " +
                    entry.getValue() + "\n");
        }
    }
} ///:~
