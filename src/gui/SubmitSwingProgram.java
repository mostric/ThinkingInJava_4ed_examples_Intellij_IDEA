//: gui/SubmitSwingProgram.java
package gui; /* Added by Eclipse.py */

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class SubmitSwingProgram extends JFrame {
    static SubmitSwingProgram ssp;
    JLabel label;

    public SubmitSwingProgram() {
        super("Hello Swing");
        label = new JLabel("A Label");
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ssp = new SubmitSwingProgram();
            }
        });
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ssp.label.setText("Hey! This is Different!");
            }
        });
    }
} ///:~
