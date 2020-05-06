package Drawing;

import ActionListeners.ButtonEventListener;
import ActionListeners.UpdateGraphic;
import Graphic.GraphicPanel;
import lombok.Getter;
import lombok.Setter;
import math.PolynomialLangrage;
import java.awt.*;
import javax.swing.*;


public class GUI extends JFrame {

    private JButton button = new JButton("Нарисовать");

    private JLabel labelX0 = new JLabel("Координата X0 : ");
    private JLabel labelXn = new JLabel("Координата Xn : ");
    private JLabel labelY0 = new JLabel("Координата Y0 : ");
    private JLabel labelFunction = new JLabel("Функция f(x, y) : ");
    private JLabel labelAccuracy = new JLabel("Точность : ");

    private JTextField inputX0 = new JTextField("", 5);
    private JTextField inputXn = new JTextField("", 5);
    private JTextField inputY0 = new JTextField("", 5);
    private JTextField inputFunction = new JTextField("", 5);
    private JTextField inputAccuracy = new JTextField("", 5);




    public GUI(){
        super("График функция");
        this.setBounds(100, 100, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();



        labelX0.setPreferredSize(new Dimension(50, 25));
        inputX0.setPreferredSize(new Dimension(50, 25));
        labelXn.setPreferredSize(new Dimension(50, 25));
        inputXn.setPreferredSize(new Dimension(50, 25));
        labelY0.setPreferredSize(new Dimension(50, 25));
        inputY0.setPreferredSize(new Dimension(50, 25));
        labelFunction.setPreferredSize(new Dimension(50, 25));
        inputFunction.setPreferredSize(new Dimension(50, 25));
        labelAccuracy.setPreferredSize(new Dimension(50, 25));
        inputAccuracy.setPreferredSize(new Dimension(50, 25));
        button.setPreferredSize(new Dimension(25, 25));
        container.add(labelX0);
        container.add(inputX0);
        container.add(labelXn);
        container.add(inputXn);
        container.add(labelY0);
        container.add(inputY0);
        container.add(labelFunction);
        container.add(inputFunction);
        container.add(labelAccuracy);
        container.add(inputAccuracy);
        GraphicPanel graphicPanel = new GraphicPanel();
        button.addActionListener(new ButtonEventListener(inputX0, inputY0, inputFunction, inputAccuracy, inputXn, graphicPanel, container));
        container.add(button);
        container.add(graphicPanel.createDemoPanel());

        setLayout(new BoxLayout(container, 1));
    }
}


