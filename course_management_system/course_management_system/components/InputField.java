package course_management_system.components;

import javax.swing.*;

public class InputField {
    public JTextField makeInputField(int x, int y) {
        JTextField input = new JTextField();
        input.setBounds(x,y,300,40);
        return input;
    }
}
