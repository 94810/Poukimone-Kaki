import java.awt.*;
import javax.swing.JFrame;

public class SecondDisplay extends Canvas{


    public void paint(Graphics g) {

        Toolkit sacha=Toolkit.getDefaultToolkit();
        Image S=sacha.getImage("sacha.gif");
        g.drawImage(S, 10,110,this);


        Toolkit pierre=Toolkit.getDefaultToolkit();
        Image P=pierre.getImage("pierre.png");
        g.drawImage(P, 1000,110,this);


        Toolkit poki1=Toolkit.getDefaultToolkit();
        Image P1=sacha.getImage("poki3.png");
        g.drawImage(P1, 250,160,this);

        Toolkit poki2=Toolkit.getDefaultToolkit();
        Image P2=sacha.getImage("poki2.png");
        g.drawImage(P2, 750,200,this);


        Toolkit start=Toolkit.getDefaultToolkit();
        Image st=sacha.getImage("start.png");
        g.drawImage(st, 300,10,this);



    }



    public static void main(String[] args) {
        SecondDisplay m=new SecondDisplay();
        JFrame f=new JFrame();
        f.add(m);



        f.setSize(1200,600);
        f.setVisible(true);
    }

}