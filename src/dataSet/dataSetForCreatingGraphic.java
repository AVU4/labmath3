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

    public  void clear(){
        coordinatesXPolynomial =new ArrayList<>();
        coordinatesX = new ArrayList<>();
        coordinatesYPolynomial = new ArrayList<>();
        coordinatesY = new ArrayList<>();
    }



}
