package dataSet;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Getter
public class DataSetForCreatingPolynimial {

    private static DataSetForCreatingPolynimial instance;

    private ArrayList<Double> coordinatesX = new ArrayList<>();
    private ArrayList<Double> coordinatesY = new ArrayList<>();

    private DataSetForCreatingPolynimial(){

    }


    public void setCoordinatesX(ArrayList<Double> coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public void setCoordinatesY(ArrayList<Double> coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public static DataSetForCreatingPolynimial getInstance(){
        if (instance == null)
            instance = new DataSetForCreatingPolynimial();
        return instance;
    }

    public void clear(){
        coordinatesY = new ArrayList<>();
        coordinatesX = new ArrayList<>();
    }

}
