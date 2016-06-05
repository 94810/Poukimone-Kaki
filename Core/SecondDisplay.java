import java.awt.*;
import javax.swing.JFrame;

public class SecondDisplay extends Canvas{


    public void paint(Graphics g) {

        Toolkit sacha=Toolkit.getDefaultToolkit();
        Image S=sacha.getImage("sacha.gif");
        g.drawImage(S, 10,110,this);


        Toolkit pierre=Toolkit.getDefaultToolkit();
        Image P=pierre.getImage("pierre.png");
        g.drawImage(P, 600,110,this);

      
    }



    public static void main(String[] args) {
        SecondDisplay m=new SecondDisplay();
        JFrame f=new JFrame();
        f.add(m);



        f.setSize(800,600);
        f.setVisible(true);
    }

}