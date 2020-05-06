package logic;

import dataSet.DataSetForCreatingPolynimial;
import dataSet.DataSetInput;
import math.MathFunction;
import math.PolynomialLangrage;
import dataSet.dataSetForCreatingGraphic;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;

public class CreatingDataSetForGraphic {

    PolynomialLangrage polynomialLangrage = new PolynomialLangrage();
    dataSetForCreatingGraphic dataSetForCreatingGraphic = dataSet.dataSetForCreatingGraphic.getInstance();
    DataSetForCreatingPolynimial dataSetForCreatingPolynimial = DataSetForCreatingPolynimial.getInstance();
    DataSetInput dataSetInput = DataSetInput.getInstance();

    public void create(){
        dataSetForCreatingGraphic.clear();
        for (double i = dataSetInput.getX0(); i <= dataSetInput.getXn(); i += dataSetInput.getH()){
            double yPolynomial = polynomialLangrage.getY(i);
            dataSetForCreatingGraphic.addPoint(i, yPolynomial);
        }
    }

    public XYDataset createDataset(){

        ArrayList<Double> coordinatesXPolynomial = dataSetForCreatingGraphic.getCoordinatesXPolynomial();
        ArrayList<Double> coordinatesYPolynomial = dataSetForCreatingGraphic.getCoordinatesYPolynomial();

        XYSeries series2 = new XYSeries("График полинома");
        for (int i = 0; i < coordinatesXPolynomial.size(); i ++){
            series2.add(coordinatesXPolynomial.get(i), coordinatesYPolynomial.get(i));
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series2);
        return dataset;
    }

    public boolean test(){
        if (dataSetInput.getXn() == 0 && dataSetInput.getX0() == 0 && dataSetInput.getAccuracy() == 0 && dataSetInput.getFunction() == null && dataSetInput.getY0() == 0){
            return false;
        }else
            return true;
    }
}
