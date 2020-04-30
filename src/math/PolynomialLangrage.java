package math;

import dataSet.DataSetForCreatingPolynimial;

import java.util.ArrayList;

public class PolynomialLangrage {

    private DataSetForCreatingPolynimial  dataSetForCreatingPolynimial = DataSetForCreatingPolynimial.getInstance();

    public double getY(double x){
        ArrayList<Double> X = dataSetForCreatingPolynimial.getCoordinatesX();
        ArrayList<Double> Y = dataSetForCreatingPolynimial.getCoordinatesY();
        int n = X.size();
        double result = 0;
        for (int i = 0; i < n; i ++){
            double composition = 1;
            for (int j = 0; j < n; j ++){
                if (!X.get(i).equals(X.get(j)))
                    composition *= (x - X.get(j))/(X.get(i) - X.get(j));
            }
            result += Y.get(i) * composition;
        }
        return result;
    }
}
