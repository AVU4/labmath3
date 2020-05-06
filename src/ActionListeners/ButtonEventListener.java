package ActionListeners;

import Graphic.GraphicPanel;
import dataSet.DataSetInput;
import logic.CreatingDataSetForPolynimial;
import lombok.AllArgsConstructor;
import math.PolynomialLangrage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonEventListener implements ActionListener {

    private JTextField inputX0;
    private JTextField inputY0;
    private JTextField inputFunction;
    private JTextField inputAccuracy;
    private JTextField inputXn;
    private GraphicPanel graphicPanel;
    private Container container;

    private DataSetInput dataSetInput = DataSetInput.getInstance();
    CreatingDataSetForPolynimial creatingDataSetForPolynimial = new CreatingDataSetForPolynimial();

    public ButtonEventListener(JTextField inputX0, JTextField inputY0, JTextField inputFunction, JTextField inputAccuracy,
                               JTextField inputXn, GraphicPanel graphicPanel, Container container) {
        this.inputX0 = inputX0;
        this.inputY0 = inputY0;
        this.inputFunction = inputFunction;
        this.inputAccuracy = inputAccuracy;
        this.inputXn = inputXn;
        this.graphicPanel = graphicPanel;
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Double x0 = Double.parseDouble(inputX0.getText());
            Double xn = Double.parseDouble(inputXn.getText());
            Double y0 = Double.parseDouble(inputY0.getText());
            String function = inputFunction.getText();
            if (function.equals(""))
                throw new NumberFormatException();
            Double accuracy = Double.parseDouble(inputAccuracy.getText());
            double h = Math.pow(accuracy, 1/4);
            dataSetInput.setH(h);
            dataSetInput.setAccuracy(accuracy);
            dataSetInput.setFunction(function);
            dataSetInput.setX0(x0);
            dataSetInput.setY0(y0);
            dataSetInput.setXn(xn);
            container.remove(11);
            container.add(graphicPanel.createDemoPanel());
            container.revalidate();
            container.repaint();

            //Обновление GUI

        }catch (NumberFormatException e1){
            System.out.println("Кто-то накосячил");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
