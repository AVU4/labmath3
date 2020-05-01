package Graphic;

import com.sun.deploy.panel.JreDialog;
import logic.CreatingDataSetForGraphic;
import logic.CreatingDataSetForPolynimial;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;

public class GraphicPanel {
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JCheckBox checkBox;
    private JCheckBox checkBox2;

    public GraphicPanel(JRadioButton radio1, JRadioButton radio2, JCheckBox checkBox, JCheckBox checkBox2){
        this.checkBox = checkBox;
        this.checkBox2 = checkBox2;
        this.radio1 = radio1;
        this.radio2 = radio2;
    }


    public JPanel createDemoPanel()
    {
        CreatingDataSetForPolynimial creatingDataSetForPolynimial = new CreatingDataSetForPolynimial();
        CreatingDataSetForGraphic creatingDataSetForGraphic = new CreatingDataSetForGraphic();
        if (radio1.isSelected()){
            creatingDataSetForPolynimial.create(1);
        }else if (radio2.isSelected()){
            creatingDataSetForPolynimial.create(2);
        }else
            creatingDataSetForPolynimial.create(3);

        creatingDataSetForGraphic.create();
        JFreeChart chart = createChart(creatingDataSetForGraphic.createDataset());
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

        if (checkBox.isSelected()) {
            renderer.setSeriesShapesVisible(0, false);
            renderer.setSeriesLinesVisible(0, true);
        }else{
            renderer.setSeriesShapesVisible(0, false);
            renderer.setSeriesLinesVisible(0, false);
        }

        if (checkBox2.isSelected()){
            renderer.setSeriesShapesVisible(1, false);
            renderer.setSeriesLinesVisible(1, true);
            renderer.setSeriesLinesVisible(2, false);
            renderer.setSeriesShapesVisible(2, true);
        }else{
            renderer.setSeriesShapesVisible(1, false);
            renderer.setSeriesLinesVisible(1, false);
            renderer.setSeriesLinesVisible(2, false);
            renderer.setSeriesShapesVisible(2, false);
        }


        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);


        return chart;
    }
}
