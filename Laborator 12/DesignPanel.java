import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DesignPanel extends JPanel {
    final MainFrame frame;

    public DesignPanel(MainFrame frame)
    {
        this.frame=frame;
        setPreferredSize(new Dimension(400,200));




    }
    public void addAtRandomLocation(JComponent comp) {
        Random rd1=new Random();
        int x = rd1.nextInt(400);//create a random integer between 0 and W-1
        int y =rd1.nextInt(200);//create a random integer between 0 and H-1
        int w = comp.getPreferredSize().width;
        int h = comp.getPreferredSize().height;

        comp.setBounds(x,y,w,h);
        comp.setToolTipText(comp.getClass().getName());
        frame.design.add(comp);
        frame.repaint();
    }
}
