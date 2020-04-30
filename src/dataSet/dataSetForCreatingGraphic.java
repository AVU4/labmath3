package dataSet;

import lombok.Getter;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;

@Getter
public class dataSetForCreatingGraphic {

    private static dataSetForCreatingGraphic instance;
    private DataSetForCreatingPolynimial dataSetForCreatingPolynimial = DataSetForCreatingPolynimial.getInstance();
    private ArrayList<Double> coordinatesX = new ArrayList<>();
    private ArrayList<Double> coordinatesY = new ArrayList<>();
    private ArrayList<Double> coordinatesXPolynomial = new ArrayList<>();
    private ArrayList<Double> coordinatesYPolynomial = new ArrayList<>();

    public static dataSetForCreatingGraphic getInstance(){
        if (instance == null){
            instance = new dataSetForCreatingGraphic();
        }
        return instance;
    }

    public void addPoint(double x, double y, double yPolynomial){
        coordinatesX.add(x);
        coordinatesY.add(y);
        coordinatesXPolynomial.add(x);
        coordinatesYPolynomial.add(yPolynomial);
    }

    public XYDataset createDataset(){
        XYSeries series1 = new XYSeries("График функции");
        for (int i = 0; i < coordinatesX.size(); i ++){
            series1.add(coordinatesX.get(i), coordinatesY.get(i));
        }

        XYSeries series2 = new XYSeries("График полинома");
        for (int i = 0; i < coordinatesXPolynomial.size(); i ++){
            series2.add(coordinatesXPolynomial.get(i), coordinatesYPolynomial.get(i));
        }
        XYSeries series3 = new XYSeries("Точки интерполяции");
        for (int i = 0; i < dataSetForCreatingPolynimial.getCoordinatesX().size(); i ++ ){
            series3.add(dataSetForCreatingPolynimial.getCoordinatesX().get(i), dataSetForCreatingPolynimial.getCoordinatesY().get(i));
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        return dataset;
    }

}
