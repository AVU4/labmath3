package dataSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataSetInput {

    private static DataSetInput instance;
    private double x0;
    private double xn;
    private double y0;
    private String function;
    private double accuracy;
    private double h;

    private DataSetInput(){

    }

    public synchronized static DataSetInput getInstance(){
        if (instance == null) instance = new DataSetInput();
        return instance;
    }

}
