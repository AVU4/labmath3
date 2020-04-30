package logic;

import math.MathFunction;
import math.PolynomialLangrage;
import dataSet.dataSetForCreatingGraphic;

public class CreatingDataSetForGraphic {

    MathFunction mathFunction = new MathFunction();
    PolynomialLangrage polynomialLangrage = new PolynomialLangrage();
    dataSetForCreatingGraphic dataSetForCreatingGraphic = dataSet.dataSetForCreatingGraphic.getInstance();

    public void create(){
        for (double i = -1 * Math.PI; i <= Math.PI; i += 0.01){
            double y = mathFunction.getY(i);
            double yPolynomial = polynomialLangrage.getY(i);
            dataSetForCreatingGraphic.addPoint(i, y, yPolynomial);
        }
    }
}
