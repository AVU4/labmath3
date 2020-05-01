package ActionListeners;

import math.PolynomialLangrage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventListener implements ActionListener {

    private JTextField input;
    private PolynomialLangrage polynomialLangrage = new PolynomialLangrage();

    public ButtonEventListener( JTextField input){
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Double x = Double.parseDouble(input.getText());
            double y = polynomialLangrage.getY(x);
            String message = "Приближённое значение функции : " + y;
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }catch (NumberFormatException e1){

        }
    }
}
