package dataSet;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class dataSetForCreatingGraphic {

    private static dataSetForCreatingGraphic instance;
    private ArrayList<Double> coordinatesXPolynomial = new ArrayList<>();
    private ArrayList<Double> coordinatesYPolynomial = new ArrayList<>();

    private dataSetForCreatingGraphic(){

    }

    public static dataSetForCreatingGraphic getInstance(){
        if (instance == null){
            instance = new dataSetForCreatingGraphic();
        }
        return instance;
    }

    public void addPoint(double x, double yPolynomial){
        coordinatesXPolynomial.add(x);
        coordinatesYPolynomial.add(yPolynomial);
    }

    public  void clear(){
        coordinatesXPolynomial =new ArrayList<>();
        coordinatesYPolynomial = new ArrayList<>();
    }



}
