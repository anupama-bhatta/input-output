
package AuxPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.Timer;


public class AuxDelayedStyler {
    
    private JComponent formControl;
    private int waitSeconds;

    public AuxDelayedStyler(int waitSeconds, JComponent formControl) {
        this.formControl = formControl;
        this.waitSeconds = waitSeconds;
    }

    public void hide() {
        
        Timer timer = new Timer(waitSeconds * 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                formControl.setVisible(false);
            }
        });
        timer.start();
    }
    
}
