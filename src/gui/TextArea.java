//: gui/TextArea.java
package gui; /* Added by Eclipse.py */
// Using the JTextArea control.

import net.mindview.util.Countries;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.SwingConsole.run;

public class TextArea extends JFrame {
    private JButton
            b = new JButton("Add Data"),
            c = new JButton("Clear Data");
    private JTextArea t = new JTextArea(20, 40);
    private Map<String, String> m =
            new HashMap<String, String>();

    public TextArea() {
        // Use up all the data:
        m.putAll(Countries.capitals());
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Map.Entry me : m.entrySet())
                    t.append(me.getKey() + ": " + me.getValue() + "\n");
            }
        });
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText("");
            }
        });
        setLayout(new FlowLayout());
        add(new JScrollPane(t));
        add(b);
        add(c);
    }

    public static void main(String[] args) {
        run(new TextArea(), 475, 425);
    }
} ///:~
