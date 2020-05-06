package Graphic;

import com.sun.deploy.panel.JreDialog;
import logic.CreatingDataSetForGraphic;
import logic.CreatingDataSetForPolynimial;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;

public class GraphicPanel {

    int i = 0;

    public JPanel createDemoPanel()
    {
        try {
            CreatingDataSetForGraphic creatingDataSetForGraphic = new CreatingDataSetForGraphic();
            CreatingDataSetForPolynimial creatingDataSetForPolynimial = new CreatingDataSetForPolynimial();

            if (creatingDataSetForGraphic.test()) {
                creatingDataSetForPolynimial.create();
                creatingDataSetForGraphic.create();
                JFreeChart chart = createChart(creatingDataSetForGraphic.createDataset());
                chart.setPadding(new RectangleInsets(1, 1, 1, 1));
                ChartPanel panel = new ChartPanel(chart);
                panel.setPreferredSize(new Dimension(400, 400));
                return panel;
            } else {
                ChartPanel panel = new ChartPanel(null);
                panel.setPreferredSize(new Dimension(400, 400));
                return panel;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
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


        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);


        return chart;
    }
}
