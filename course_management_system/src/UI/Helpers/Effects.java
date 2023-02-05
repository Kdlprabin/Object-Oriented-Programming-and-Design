package UI.Helpers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Effects {
    public void activateEffect(JButton[] buttons){
        MyColor myColor = new MyColor();
        for(JButton b:buttons){
            b.addActionListener(e->{
                for(JButton button:buttons){
                    button.setBackground(Color.white);
                    button.setForeground(Color.getColor("525252"));
                }
                b.setForeground(Color.white);
                b.setBackground(myColor.myGreen);
            });
        }
    }

public void addPlaceholder(JTextField textField,String message){
    textField.addFocusListener(new FocusListener() {
        public void focusGained(FocusEvent e) {
            if (textField.getText().equals(message)) {
                textField.setText("");
            }
        }
        public void focusLost(FocusEvent e) {
            if (textField.getText().isEmpty()) {
                textField.setText(message);
            }
        }
    });
}
}
