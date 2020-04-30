package Drawing;

import dataSet.dataSetForCreatingGraphic;
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
    private dataSetForCreatingGraphic dataSetForCreatingGraphic = dataSet.dataSetForCreatingGraphic.getInstance();

    private JButton button = new JButton("Посчитать");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Координата X : ");

    public GUI(){
        super("График функция");
        this.setBounds(100, 100, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        label.setPreferredSize(new Dimension(50, 25));
        input.setPreferredSize(new Dimension(50, 25));
        button.setPreferredSize(new Dimension(25, 25));
        container.add(label);
        container.add(input);
        button.addActionListener(new ButtonEventListener ());
        container.add(button);
        container.add(createDemoPanel());
        setLayout(new BoxLayout(container, 1));
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

    public JPanel createDemoPanel()
    {
        JFreeChart chart = createChart(dataSetForCreatingGraphic.createDataset());
        chart.setPadding(new RectangleInsets( 1, 1, 1, 1));
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(400, 400));
        return panel;
    }

    private JFreeChart createChart(XYDataset dataset)
    {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "График",
                "x",
                "y",
                dataset
        );
        XYPlot plot = chart.getXYPlot();

        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GRAY);

        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesLinesVisible(2, false);
        renderer.setSeriesShapesVisible(2, true);
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);


        return chart;
    }

}


