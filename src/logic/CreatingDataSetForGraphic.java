package logic;

import math.MathFunction;
import math.PolynomialLangrage;
import dataSet.dataSetForCreatingGraphic;

public class CreatingDataSetForGraphic {

    MathFunction mathFunction = new MathFunction();
    PolynomialLangrage polynomialLangrage = new PolynomialLangrage();
    dataSetForCreatingGraphic dataSetForCreatingGraphic = dataSet.dataSetForCreatingGraphic.getInstance();

    public void create(){
        for (double i = -2 * Math.PI; i <= 2.25 * Math.PI; i += 0.1){
            double y = mathFunction.getY(i);
            double yPolynomial = polynomialLangrage.getY(i);
            dataSetForCreatingGraphic.addPoint(i, y, yPolynomial);
        }
    }
}
