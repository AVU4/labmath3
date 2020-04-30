package Drawing;

import math.PolynomialLangrage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {

    private PolynomialLangrage polynomialLangrage = new PolynomialLangrage();

    private JButton button = new JButton("Посчитать");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Координата X : ");

    public GUI(){
        super("График функция");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2 , 2, 2));
        container.add(label);
        container.add(input);
        button.addActionListener(new ButtonEventListener ());
        container.add(button);
    }
    class ButtonEventListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Double x = Double.parseDouble(input.getText());
            double y =  polynomialLangrage.getY(x);
            System.out.println(x + " " + y);
            String message = "Приближённое значение функции : " + y;
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }
}


