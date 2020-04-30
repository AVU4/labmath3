package logic;

import dataSet.DataSetForCreatingPolynimial;
import math.MathFunction;



public class CreatingDataSetForPolynimial {

    MathFunction mathFunction = new MathFunction();
    DataSetForCreatingPolynimial dataSetForCreatingPolynimial = DataSetForCreatingPolynimial.getInstance();

    public void create(int mode){
        dataSetForCreatingPolynimial.clear();
        if (mode == 1) {
            for (double i = -2 * Math.PI; i <= 2 * Math.PI; i += 1.5) {
                double y = mathFunction.getY(i);
                dataSetForCreatingPolynimial.addPoint(i, y);
            }
        }else if (mode == 2) {
            for (double i = -2 * Math.PI + 0.2; i <= 2 * Math.PI; i += 0.96) {
                double y = mathFunction.getY(i);
                dataSetForCreatingPolynimial.addPoint(i, y);
            }
        }else  if (mode == 3) {
            for (double i = -2 * Math.PI; i <= 5 * Math.PI; i += 4.6) {
                double y = mathFunction.getY(i);
                dataSetForCreatingPolynimial.addPoint(i, y);
            }
        }


    }
}
