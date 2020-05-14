import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JTextField text=new JTextField(20);
    public ControlPanel(MainFrame frame){
        this.frame=frame;
        add(text);
        text.addActionListener(this::doit);
    }

    private void doit(ActionEvent e)  {
        String command1=text.getText();
       frame.design.mlt.add(new JButton("buton"));
       // frame.show();
        frame.revalidate();
       frame.repaint();
       frame.pack();

    }

}
