import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Reset, Exit)
    JButton loadBtn =new JButton("Load");
    JButton resetBtn=new JButton("Reset");
    JButton exitBtn=new JButton("Exit");


    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //add all buttons
        add(saveBtn);
        add(exitBtn);
        add(resetBtn);
        add(loadBtn);

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load) ;
        exitBtn.addActionListener(this::exit);
        resetBtn.addActionListener(this::reset);

    }

    private void reset(ActionEvent e)//buton reset
    {
       frame.canvas.graphics.setColor(Color.WHITE);
       frame.canvas.graphics.fill(new Rectangle(800,600));
       frame.canvas.repaint();



    }
    private void exit(ActionEvent e) {//exit
            System.exit(0);
    }

    private void load(ActionEvent e) {//load ...urmeaza in optional sa introduc optiunea de introducere a oricarui path

        try { BufferedImage image = ImageIO.read(new File("C:\\Users\\Denis\\Documents\\test.png"));
            frame.canvas.graphics.drawImage(image, 0, 0, null);
           frame.repaint();
        } catch (IOException ex) { System.err.println(ex); }

    }

    private void save(ActionEvent e) {//la fel si aici
        try {
            ImageIO.write(frame.canvas.image, "PNG",
                    new FileOutputStream("C:\\Users\\Denis\\Documents\\test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

}


