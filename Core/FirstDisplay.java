import javax.swing.*;
import java.awt.event.*;

//Include pour parser Json
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//Fin include pour parseur Json

import java.util.ArrayList;
import java.util.List;



//Je suis un commentaire
class FirstDisplay extends JFrame implements ActionListener{
    JRadioButton rb1,rb2;
    JButton b;
    JTextField text1,text2;
    JLabel label, labael1,label2;
    JComboBox listPlayer1,listPlayer2;

    FirstDisplay(){

        JLabel label = new JLabel("Chose your mode");
        label.setBounds(20, 20, 150, 20);

        JLabel label1 = new JLabel("Enter player's names");
        label1.setBounds(20, 150, 150, 20);

        JLabel label2 = new JLabel("Chose your Pokemon");
        label2.setBounds(20, 240, 150, 20);

        rb1=new JRadioButton("PVP");
        rb1.setBounds(10,50,100,30);

        rb2=new JRadioButton("PVC");
        rb2.setBounds(10,100,100,30);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rb1);bg.add(rb2);

        b=new JButton("Let's go !!");
        b.setBounds(100,550,150,50);
        b.addActionListener(this);

        text1= new JTextField("player 1");
        text1.setBounds(50,180,110,35);

        text2= new JTextField("player 2");
        text2.setBounds(220,180,110,35);

        //String poukimoune[]={"pika","Butterfree","Blastoise","Wartortle","Venusaur","pidgeot" ,
        //        "Pidgey"};

        JSONParser parser = new JSONParser();
        List<String> pkmone = new ArrayList<String>();

		try{
		    Object obj = parser.parse(new FileReader("./poukimone.json"));

		    JSONArray pkm = (JSONArray) obj;

		    for(Object objd : pkm) {
                JSONObject root = (JSONObject) objd;
                pkmone.add((String) root.get("name"));
            }
		}catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		} catch (ParseException e) {
		e.printStackTrace();
		}

        String poukimoune[] = (String[]) pkmone.toArray(new String[0]);

        JComboBox listPlayer1=new JComboBox(poukimoune);
        listPlayer1.setBounds(50,280,110,35);

        JComboBox listPlayer2=new JComboBox(poukimoune);
        listPlayer2.setBounds(220,280,110,35);

        add(rb1);add(rb2);add(b);add(label);add(label1);add(label2);add(text1);add(text2);add(listPlayer1);
        add(listPlayer2);


        setSize(600,600);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(rb1.isSelected()){
            JOptionPane.showMessageDialog(this,"you chosed mode PVP");
        }
        if(rb2.isSelected()){
            JOptionPane.showMessageDialog(this,"you chosed mode PVC");
        }
    }
    public static void main(String args[]){
        new FirstDisplay();
    }
}