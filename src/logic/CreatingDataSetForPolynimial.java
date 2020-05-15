package logic;

import Parser.MathParser;
import dataSet.DataSetForCreatingPolynimial;
import dataSet.DataSetInput;
import math.MathFunction;

import java.util.ArrayList;


public class CreatingDataSetForPolynimial {

    DataSetInput dataSetInput = DataSetInput.getInstance();
    MathParser mathParser = new MathParser();
    ArrayList<Double> Y1 = new ArrayList<>();
    ArrayList<Double> X = new ArrayList<>();
    ArrayList<Double> Y = new ArrayList<>();
    DataSetForCreatingPolynimial dataSetForCreatingPolynimial = DataSetForCreatingPolynimial.getInstance();

    public void create() throws Exception {
        Double x0 = dataSetInput.getX0();
        Double y0 = dataSetInput.getY0();
        Double xn = dataSetInput.getXn();
        X.add(x0);
        Y.add(y0);
        String function = dataSetInput.getFunction();
        Double accuracy = dataSetInput.getAccuracy();
        mathParser.setVariables("x", x0);
        mathParser.setVariables("y", y0);
        double y1 = mathParser.Parse(function);
        Y1.add(y1);
        Double h = dataSetInput.getH();
        for (int i = 1; i < 4; i ++){
            mathParser.setVariables("x", X.get(i - 1));
            mathParser.setVariables("y", Y.get(i - 1));
            double k0 = h*mathParser.Parse(function);
            mathParser.setVariables("x", X.get(i - 1) + h/2);
            mathParser.setVariables("y", Y.get(i - 1) + k0/2);
            double k1 = h*mathParser.Parse(function);
            mathParser.setVariables("x", X.get(i - 1) + h/2);
            mathParser.setVariables("y", Y.get(i - 1) + k1/2);
            double k2 = h * mathParser.Parse(function);
            mathParser.setVariables("x", X.get(i - 1) + h);
            mathParser.setVariables("y", Y.get(i - 1) + k2);
            double k3 = h * mathParser.Parse(function);
            X.add(X.get(i - 1) + h);
            Y.add(Y.get(i - 1) + (k0 + 2 * k1 + 2*k2 + k3)/6);
            mathParser.setVariables("x", X.get(i));
            mathParser.setVariables("y", Y.get(i));
            Y1.add(mathParser.Parse(function));
            System.out.println(X.get(i) + " " + Y.get(i));
        }
        int i = 3;
        int n = (int) Math.round((xn - x0)/h);
        while(i <= n){
            Y.add(Y.get(i - 3) + 4*h*(2 * Y1.get(i) - Y1.get(i - 1) + 2 * Y1.get(i - 2))/3);
            X.add(X.get(i) + h);
            double B = Y.get(i + 1);
            double A = 10000000;
            boolean flagFirst = true;
            while (Math.abs(A - B) > accuracy || flagFirst){
                A = B;
                mathParser.setVariables("x", X.get(i + 1));
                mathParser.setVariables("y", A);
                if (flagFirst)
                    Y1.add(mathParser.Parse(function));
                else
                    Y1.set(i + 1, mathParser.Parse(function));
                B = Y.get(i - 1) + h*(Y1.get(i+1) + 4*Y1.get(i) + Y1.get(i - 1))/3;
                flagFirst = false;
            }
            Y.set(i + 1, B);
            System.out.println(X.get(i) + " " + Y.get(i));
            i ++;
        }
        addDataSet();
    }

    public void addDataSet(){
        dataSetForCreatingPolynimial.setCoordinatesX(X);
        dataSetForCreatingPolynimial.setCoordinatesY(Y);

    }

}
