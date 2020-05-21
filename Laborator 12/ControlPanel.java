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
    JComponent getNm(String clas) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class a=Class.forName(clas);
        JComponent jc=(JComponent) a.getConstructor().newInstance();
        return jc;

    }

    private void doit(ActionEvent e)  {
        String command1=text.getText();


        try{
            frame.design.addAtRandomLocation(getNm(command1));
        }catch(Exception a){
            a.printStackTrace();
        }

        frame.revalidate();
       frame.repaint();


    }

}
