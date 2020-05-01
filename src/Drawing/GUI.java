package Drawing;

import Graphic.GraphicPanel;
import dataSet.dataSetForCreatingGraphic;
import logic.CreatingDataSetForGraphic;
import logic.CreatingDataSetForPolynimial;
import math.PolynomialLangrage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.xy.XYDataset;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
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


        button.addActionListener(new ButtonEventListener ());


        container.add(button);

        JPanel myPanel = graphicPanel.createDemoPanel();
        container.add(myPanel);

        container.add(checkBox);
        container.add(checkBox2);



        class updateGraphic implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                container.remove(6);
                container.add(graphicPanel.createDemoPanel());
                container.add(checkBox);
                container.add(checkBox2);
                container.revalidate();
                container.repaint();
            }
        }

        radio1.addActionListener(new updateGraphic());
        radio2.addActionListener(new updateGraphic());
        radio3.addActionListener(new updateGraphic());
        checkBox.addActionListener(new updateGraphic());
        checkBox2.addActionListener(new updateGraphic());


        setLayout(new BoxLayout(container, 1));
    }
    class ButtonEventListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Double x = Double.parseDouble(input.getText());
            double y =  polynomialLangrage.getY(x);
            String message = "Приближённое значение функции : " + y;
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }
}


