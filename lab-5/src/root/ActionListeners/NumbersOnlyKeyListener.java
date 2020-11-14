package root.ActionListeners;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.sun.webkit.event.WCKeyEvent.VK_BACK;

public class NumbersOnlyKeyListener extends KeyAdapter {
    JTextField tf;
    public NumbersOnlyKeyListener(JTextField tf){
        this.tf=tf;
    }
    @Override
    public void keyPressed(KeyEvent ke) {
        //super.keyPressed(e);
        String value = tf.getText();
        int l = value.length();
        if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')||ke.getKeyChar()==VK_BACK) {
            tf.setEditable(true);
            //label.setText("");
        } else {
            tf.setEditable(false);
            //label.setText("* Enter only numeric digits(0-9)");
        }
    }
}
