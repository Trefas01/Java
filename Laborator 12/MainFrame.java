import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel control;
    DesignPanel design;
    public MainFrame()
    {
        super("Lab12");
        init();
    }
    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        control=new ControlPanel(this);
        design=new DesignPanel(this);
        design.setLayout(null);


        add(control, BorderLayout.NORTH);
        add(design);
        pack();
    }
}
