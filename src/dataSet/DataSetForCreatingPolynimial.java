package dataSet;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@NoArgsConstructor
@Getter
public class DataSetForCreatingPolynimial {

    private static DataSetForCreatingPolynimial instance;

    private ArrayList<Double> coordinatesX = new ArrayList<>();
    private ArrayList<Double> coordinatesY = new ArrayList<>();

    public void addPoint(double x, double y){
        coordinatesX.add(x);
        coordinatesY.add(y);
    }

    public static DataSetForCreatingPolynimial getInstance(){
        if (instance == null)
            instance = new DataSetForCreatingPolynimial();
        return instance;
    }

}
