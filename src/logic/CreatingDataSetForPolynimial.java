package logic;

import dataSet.DataSetForCreatingPolynimial;
import math.MathFunction;



public class CreatingDataSetForPolynimial {

    MathFunction mathFunction = new MathFunction();
    DataSetForCreatingPolynimial dataSetForCreatingPolynimial = DataSetForCreatingPolynimial.getInstance();

    public void create(){

        for (double i = - Math.PI; i <= Math.PI; i += 1.5){
            double y = mathFunction.getY(i);
            dataSetForCreatingPolynimial.addPoint(i, y);
        }

        for (double i = -Math.PI + 0.1; i <= Math.PI; i += 0.6 ){
            double y = mathFunction.getY(i);
            dataSetForCreatingPolynimial.addPoint(i, y);
        }

        for (double i = -2 * Math.PI; i <= 2 * Math.PI; i += 0.4){
            double y = mathFunction.getY(i);
            dataSetForCreatingPolynimial.addPoint(i, y);
        }


    }
}
