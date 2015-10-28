//: swt/SineWave.java
package swt; /* Added by Eclipse.py */
// SWT translation of Swing SineWave.java.

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Slider;
import swt.util.SWTApplication;
import swt.util.SWTConsole;

class SineDraw extends Canvas {
    private static final int SCALEFACTOR = 200;
    private int cycles;
    private int points;
    private double[] sines;
    private int[] pts;

    public SineDraw(Composite parent, int style) {
        super(parent, style);
        addPaintListener(new PaintListener() {
            public void paintControl(PaintEvent e) {
                int maxWidth = getSize().x;
                double hstep = (double) maxWidth / (double) points;
                int maxHeight = getSize().y;
                pts = new int[points];
                for (int i = 0; i < points; i++)
                    pts[i] = (int) ((sines[i] * maxHeight / 2 * .95)
                            + (maxHeight / 2));
                e.gc.setForeground(
                        e.display.getSystemColor(SWT.COLOR_RED));
                for (int i = 1; i < points; i++) {
                    int x1 = (int) ((i - 1) * hstep);
                    int x2 = (int) (i * hstep);
                    int y1 = pts[i - 1];
                    int y2 = pts[i];
                    e.gc.drawLine(x1, y1, x2, y2);
                }
            }
        });
        setCycles(5);
    }

    public void setCycles(int newCycles) {
        cycles = newCycles;
        points = SCALEFACTOR * cycles * 2;
        sines = new double[points];
        for (int i = 0; i < points; i++) {
            double radians = (Math.PI / SCALEFACTOR) * i;
            sines[i] = Math.sin(radians);
        }
        redraw();
    }
}

public class SineWave implements SWTApplication {
    private SineDraw sines;
    private Slider slider;

    public static void main(String[] args) {
        SWTConsole.run(new SineWave(), 700, 400);
    }

    public void createContents(Composite parent) {
        parent.setLayout(new GridLayout(1, true));
        sines = new SineDraw(parent, SWT.NONE);
        sines.setLayoutData(
                new GridData(SWT.FILL, SWT.FILL, true, true));
        sines.setFocus();
        slider = new Slider(parent, SWT.HORIZONTAL);
        slider.setValues(5, 1, 30, 1, 1, 1);
        slider.setLayoutData(
                new GridData(SWT.FILL, SWT.DEFAULT, true, false));
        slider.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                sines.setCycles(slider.getSelection());
            }
        });
    }
} ///:~
