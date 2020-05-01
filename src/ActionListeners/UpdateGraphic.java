package ActionListeners;

import Graphic.GraphicPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateGraphic implements ActionListener {
    private Container container;
    private JCheckBox checkBox;
    private JCheckBox checkBox2;
    private GraphicPanel graphicPanel;

    public  UpdateGraphic(Container container, JCheckBox checkBox, JCheckBox checkBox2, GraphicPanel graphicPanel){
        this.checkBox = checkBox;
        this.checkBox2 = checkBox2;
        this.container = container;
        this.graphicPanel = graphicPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        container.remove(6);
        container.add(graphicPanel.createDemoPanel());
        container.add(checkBox);
        container.add(checkBox2);
        container.revalidate();
        container.repaint();
    }
}
