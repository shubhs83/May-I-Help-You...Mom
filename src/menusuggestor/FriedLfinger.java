
package menusuggestor;

import javax.swing.*;
import java.awt.*;


public class FriedLfinger extends JFrame{
    
    FriedLfinger(){
        setBounds(150,100,1050,540);
        
        String[] Fried_lfinger={"Fried Lady'd Finger ",   "Ingredients :-",  "250 gms Ladies finger ",  "3 tablespoon Rice flour",   "1 tablespoon Corn flour White corn starch", "1 teaspoon Red chilli powder",     "½ teaspoon Coriander seeds powder ","⅛ teaspoon Turmeric", "Salt", "Oil - For deep frying","","","", "","Instructions","Clean the ladies finger firstly with water and pat dry with kitchen towel, so that it is dry.","Cut it into thin circles as shown below. You can also choose to cut diagonally as in my video.","Add 2 tablespoon of buttermilk and coat the chopped ladies finder","Sprinkle all the other ingredients, except oil.","Mix it thoroughly. If needed, sprinkle very little water or buttermilk so that the mixture coats the ladies finger, yet dry. Should not be too sticky.","Heat oil and add like sprinkling the mixture and fry in a medium flame.","It is important to cook long time in medium heat for the vendakkai to get crispy. ","Turn in between to ensure even cooking. Drain over paper towel","", "package1.jpg"};
        String[] Stuffedlf={"Sruffed Lady'd Finger","¼ cup besan / gram flour / chikpea flour ","¾ tsp kashmiri chili powder / lal mirch powder "," ½ tsp turmeric / haldi","salt to taste","¾ tsp coriander powder / dhaniya powder","¼ tsp cumin powder / jeera powder","1 tsp aamchur powder / dry mango powder","½ tsp garam masala& 2 green chilli / hari mirch slit lengthwise","pinch of hing / asafoetida & 10 curry leaves / kadi patta","¼ tsp ginger paste / adrak paste","10 bhindi / okra / lady finger","3 tbsp oil & 1 tsp jeera / cumin seeds","Instructions :-","firstly, slit the bhindi and stuff the prepared spice mix powder ","keep all the stuffed bhindi aside.","further, heat oil in large kadai and splutter cumin seeds.","add in curry leaves and wait for 30 seconds.","also saute onions and green chili till they shrink in size.","further, place the stuffed bhindi into the kadai.","add leftover masala over the bhindi and give a gentle mix.","furthermore, cover and simmer for 3 minutes.","saute in between till the bhindis get cooked completely.","finally, serve bharwa bhindi / stuffed bhindi with rice or roti.",  "package3.jpg"};
        
        JTabbedPane tab=new JTabbedPane();
        
        JPanel p1=createPackage(Fried_lfinger);
        tab.addTab("stuffed bitter guard",null ,p1);
      
        
       JPanel p2=createPackage(Stuffedlf);
       tab.addTab(" BitterGuard Curry",null ,p2);
       /*
       JPanel p3=createPackage(Palak_paratha);
       tab.addTab("Palak paratha 3",null ,p3);*/
       
       add(tab);
       
        
        setVisible(true);
        
    }
      public JPanel createPackage(String[] pack){
       
       JPanel p1=new JPanel();
       p1.setLayout(null);
       p1.setBackground(Color.WHITE);
       
       JLabel l1=new JLabel(pack[0]);
       l1.setBounds(40,4,190,30);
       l1.setForeground(Color.BLUE);
       l1.setFont(new Font("Tahoma",Font.BOLD,21));
       p1.add(l1);
       
       JLabel l2=new JLabel(pack[1]);
       l2.setBounds(25,34,270,20);
       l2.setForeground(Color.RED);
       l2.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l2);
       
       JLabel l3=new JLabel(pack[2]);
       l3.setBounds(25,60,270,20);
       l3.setForeground(Color.BLACK);
       l3.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l3);
       
       JLabel l4=new JLabel(pack[3]);
       l4.setBounds(25,90,270,20);
       l4.setForeground(Color.BLUE);
       l4.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l4);
       
       JLabel l5=new JLabel(pack[4]);
       l5.setBounds(25,120,270,20);
       l5.setForeground(Color.BLACK);
       l5.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l5);
       
      
       
       JLabel l6=new JLabel(pack[5]);
       l6.setBounds(25,150,270,20);
       l6.setForeground(Color.BLUE);
       l6.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l6);
       
       JLabel l7=new JLabel(pack[6]);
       l7.setBounds(25,180,270,20);
       l7.setForeground(Color.BLACK);
       l7.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l7);
       
       
       JLabel l8=new JLabel(pack[7]);
       l8.setBounds(25,210,270,20);
       l8.setForeground(Color.BLUE);
       l8.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l8);
       
       JLabel l9=new JLabel(pack[8]);
       l9.setBounds(25,240,270,20);
       l9.setForeground(Color.BLACK);
       l9.setFont(new Font("Tahoma",Font.PLAIN,20));
       p1.add(l9);
       
       JLabel l10=new JLabel(pack[9]);
       l10.setBounds(25,270,270,20);
       l10.setForeground(Color.BLUE);
       l10.setFont(new Font("Tahoma",Font.PLAIN,20));
       p1.add(l10);
       
       JLabel l11=new JLabel(pack[10]);
       l11.setBounds(25,300,270,20);
       l11.setForeground(Color.BLACK);
       l11.setFont(new Font("Tahoma",Font.PLAIN,20));
       p1.add(l11);
       
       JLabel l12=new JLabel(pack[11]);
       l12.setBounds(25,330,270,20);
       l12.setForeground(Color.BLUE);
       l12.setFont(new Font("Tahoma",Font.PLAIN,20));
       p1.add(l12);
       
       JLabel l13=new JLabel(pack[12]);
       l13.setBounds(25,360,270,20);
       l13.setForeground(Color.BLACK);
       l13.setFont(new Font("Tahoma",Font.PLAIN,20));
       p1.add(l13);
       
       
       JLabel l14=new JLabel(pack[13]);
       l14.setBounds(25,390,270,20);
       l14.setForeground(Color.BLUE);
       l14.setFont(new Font("Tahoma",Font.PLAIN,20));
       p1.add(l14);
       
       
       JLabel l15=new JLabel(pack[14]);
       l15.setBounds(330,4,260,20);
       l15.setForeground(Color.RED);
       l15.setFont(new Font("Tahoma",Font.BOLD,25));
       p1.add(l15);
       
       
        JLabel l16=new JLabel(pack[15]);
       l16.setBounds(330,34,600,30);
       l16.setForeground(Color.BLACK);
       l16.setFont(new Font("Tahoma",Font.PLAIN,14));
       p1.add(l16);
       
      JLabel l17=new JLabel(pack[16]);
       l17.setBounds(330,60,600,30);
       l17.setForeground(Color.BLACK);
       l17.setFont(new Font("Tahoma",Font.PLAIN,14));
       p1.add(l17);
       
       
       
       JLabel l18=new JLabel(pack[17]);
       l18.setBounds(330,90,600,20);
       l18.setForeground(Color.BLUE);
       l18.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l18);
       
       JLabel l19=new JLabel(pack[18]);
       l19.setBounds(330,120,600,20);
       l19.setForeground(Color.BLACK);
       l19.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l19);
       
      
       
       JLabel l20=new JLabel(pack[19]);
       l20.setBounds(330,150,600,20);
       l20.setForeground(Color.BLUE);
       l20.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l20);
       
       JLabel l21=new JLabel(pack[20]);
       l21.setBounds(330,180,700,20);
       l21.setForeground(Color.BLACK);
       l21.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l21);
       
       
       JLabel l22=new JLabel(pack[21]);
       l22.setBounds(330,210,600,20);
       l22.setForeground(Color.BLUE);
       l22.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l22);
       
       JLabel l23=new JLabel(pack[22]);
       l23.setBounds(330,240,600,20);
       l23.setForeground(Color.BLACK);
       l23.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l23);
       
       JLabel l24=new JLabel(pack[23]);
       l24.setBounds(330,270,600,20);
       l24.setForeground(Color.BLUE);
       l24.setFont(new Font("Tahoma",Font.PLAIN,20));
       p1.add(l24);
       
       return p1;
    }
    
    public static void main(String args[]){
        new FriedLfinger();
    }
}
