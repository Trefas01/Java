import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);

    }


    private void init() {
        setPreferredSize(new Dimension(W, H)); 
        setBorder(BorderFactory.createEtchedBorder()); 
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }
    private void drawShape(int x, int y) {
        Random rd1=new Random();
        Random rd2=new Random();
        Random rand=new Random();
        int radius = rd1.nextInt(200); //generez random dimensiunea figurii
        int sides =(int)frame.configPanel.sidesField.getValue();//preiau valoarea din spinner pentru numarul de laturi ;
        float r = rand.nextFloat();//pentru mixarea random a culorii
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        if(frame.configPanel.colorCombo.getSelectedItem()=="Black")
        {r=0;g=0;b=0;

        }

        Color color = new Color(r,g,b);//culoare random sau black
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }
    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}

