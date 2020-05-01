package logic;

import dataSet.DataSetForCreatingPolynimial;
import math.MathFunction;
import math.PolynomialLangrage;
import dataSet.dataSetForCreatingGraphic;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;

public class CreatingDataSetForGraphic {

    MathFunction mathFunction = new MathFunction();
    PolynomialLangrage polynomialLangrage = new PolynomialLangrage();
    dataSetForCreatingGraphic dataSetForCreatingGraphic = dataSet.dataSetForCreatingGraphic.getInstance();
    DataSetForCreatingPolynimial dataSetForCreatingPolynimial = DataSetForCreatingPolynimial.getInstance();

    public void create(){
        dataSetForCreatingGraphic.clear();
        for (double i = -2 * Math.PI; i <= 2.25 * Math.PI; i += 0.1){
            double y = mathFunction.getY(i);
            double yPolynomial = polynomialLangrage.getY(i);
            dataSetForCreatingGraphic.addPoint(i, y, yPolynomial);
        }
    }

    public XYDataset createDataset(){

        ArrayList<Double> coordinatesX = dataSetForCreatingGraphic.getCoordinatesX();
        ArrayList<Double> coordinatesY = dataSetForCreatingGraphic.getCoordinatesY();
        ArrayList<Double> coordinatesXPolynomial = dataSetForCreatingGraphic.getCoordinatesXPolynomial();
        ArrayList<Double> coordinatesYPolynomial = dataSetForCreatingGraphic.getCoordinatesYPolynomial();
        XYSeries series1 = new XYSeries("График функции sin(x) * sqrt(x + PI*2)");
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
