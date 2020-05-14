import javax.swing.*;
import java.awt.*;

public class DesignPanel extends JPanel {
    final MainFrame frame;
    JPanel mlt;
    public DesignPanel(MainFrame frame)
    {
        this.frame=frame;
        mlt=new JPanel();
        add(mlt);


    }
}
