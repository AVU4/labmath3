package Drawing;

import ActionListeners.ButtonEventListener;
import ActionListeners.UpdateGraphic;
import Graphic.GraphicPanel;
import math.PolynomialLangrage;
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {

    private PolynomialLangrage polynomialLangrage = new PolynomialLangrage();


    private JButton button = new JButton("Посчитать");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Координата X : ");
    private  JRadioButton radio1 = new JRadioButton("Первая выборка", true);
    private JRadioButton radio2 = new JRadioButton("Вторая выборка");
    private JRadioButton radio3 = new JRadioButton("Третья выборка");
    private JCheckBox checkBox = new JCheckBox("Показывать график функции", true);
    private JCheckBox checkBox2 = new JCheckBox("Показывать график полинома", true);


    public GUI(){
        super("График функция");
        this.setBounds(100, 100, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);

        GraphicPanel graphicPanel = new GraphicPanel(radio1, radio2, checkBox, checkBox2);
        Container container = this.getContentPane();



        label.setPreferredSize(new Dimension(50, 25));
        input.setPreferredSize(new Dimension(50, 25));
        button.setPreferredSize(new Dimension(25, 25));

        container.add(radio1);
        container.add(radio2);
        container.add(radio3);
        container.add(label);
        container.add(input);


        button.addActionListener(new ButtonEventListener(input));


        container.add(button);

        JPanel myPanel = graphicPanel.createDemoPanel();
        container.add(myPanel);

        container.add(checkBox);
        container.add(checkBox2);


        UpdateGraphic updateGraphic = new UpdateGraphic(container, checkBox, checkBox2, graphicPanel);

        radio1.addActionListener(updateGraphic);
        radio2.addActionListener(updateGraphic);
        radio3.addActionListener(updateGraphic);
        checkBox.addActionListener(updateGraphic);
        checkBox2.addActionListener(updateGraphic);


        setLayout(new BoxLayout(container, 1));
    }
}


