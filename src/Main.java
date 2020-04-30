import Drawing.GUI;
import dataSet.DataSetForCreatingPolynimial;
import dataSet.dataSetForCreatingGraphic;
import logic.CreatingDataSetForGraphic;
import logic.CreatingDataSetForPolynimial;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CreatingDataSetForPolynimial creatingDataSetForPolynimial = new CreatingDataSetForPolynimial();
        creatingDataSetForPolynimial.create();
//        CreatingDataSetForGraphic creatingDataSetForGraphic = new CreatingDataSetForGraphic();
//        creatingDataSetForGraphic.create();
//        dataSetForCreatingGraphic dataSetForCreatingGraphic = dataSet.dataSetForCreatingGraphic.getInstance();
//        DataSetForCreatingPolynimial dataSetForCreatingPolynimial = DataSetForCreatingPolynimial.getInstance();
//        ArrayList<Double> arrayListPX = dataSetForCreatingPolynimial.getCoordinatesX();
//        ArrayList<Double> arrayListPY = dataSetForCreatingPolynimial.getCoordinatesY();
//        ArrayList<Double> arrayList = dataSetForCreatingGraphic.getCoordinatesXPolynomial();
//        ArrayList<Double> arrayList1 = dataSetForCreatingGraphic.getCoordinatesYPolynomial();
//        ArrayList<Double> arrayList2 = dataSetForCreatingGraphic.getCoordinatesX();
//        ArrayList<Double> arrayList3 = dataSetForCreatingGraphic.getCoordinatesY();
        GUI gui = new GUI();
        gui.setVisible(true);



    }
}
