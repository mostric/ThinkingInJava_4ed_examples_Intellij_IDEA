//: gui/ButtonGroups.java
package gui; /* Added by Eclipse.py */
// Uses reflection to create groups
// of different types of AbstractButton.

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.lang.reflect.Constructor;

import static net.mindview.util.SwingConsole.run;

public class ButtonGroups extends JFrame {
    private static String[] ids = {
            "June", "Ward", "Beaver", "Wally", "Eddie", "Lumpy"
    };

    public ButtonGroups() {
        setLayout(new FlowLayout());
        add(makeBPanel(JButton.class, ids));
        add(makeBPanel(JToggleButton.class, ids));
        add(makeBPanel(JCheckBox.class, ids));
        add(makeBPanel(JRadioButton.class, ids));
    }

    static JPanel makeBPanel(
            Class<? extends AbstractButton> kind, String[] ids) {
        ButtonGroup bg = new ButtonGroup();
        JPanel jp = new JPanel();
        String title = kind.getName();
        title = title.substring(title.lastIndexOf('.') + 1);
        jp.setBorder(new TitledBorder(title));
        for (String id : ids) {
            AbstractButton ab = new JButton("failed");
            try {
                // Get the dynamic constructor method
                // that takes a String argument:
                Constructor ctor =
                        kind.getConstructor(String.class);
                // Create a new object:
                ab = (AbstractButton) ctor.newInstance(id);
            } catch (Exception ex) {
                System.err.println("can't create " + kind);
            }
            bg.add(ab);
            jp.add(ab);
        }
        return jp;
    }

    public static void main(String[] args) {
        run(new ButtonGroups(), 500, 350);
    }
} ///:~
