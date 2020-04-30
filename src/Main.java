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
        CreatingDataSetForGraphic creatingDataSetForGraphic = new CreatingDataSetForGraphic();
        creatingDataSetForGraphic.create();
        GUI gui = new GUI();
        gui.setVisible(true);



    }
}
