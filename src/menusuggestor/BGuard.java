
package menusuggestor;

import javax.swing.*;
import java.awt.*;


public class BGuard extends JFrame{
    
    BGuard(){
        setBounds(150,100,1050,540);
        
        String[] stuffed_BG={"Stuffed Bitter Gourd  ",   "Ingredients :-",  "12 Small Bitter gourd",  "4 tbsp Oil more for panfrying",   "1 large Onion chopped finely", "¼ cup Roasted Peanuts chopped finely",     "5 tbsp Gram Flour","1 tbsp Chilli Powder", "2 tsp Cumin Powder", ":-1 tsp Garam Masala Powder",":-½ tsp Turmeric Powder",":- 2 tsp Chat Masala Powder","", "","Instructions","Remove seeds from bitter gourd by making slits in them.Heat oil in a pan. Add onions and saute for 2 mins or so.","Add in gram flour and saute them for 2 mins.","Add in peanuts and mix well","Add in spice powders, salt and mix well.","Fill this inside bittergourd and place them in a pan with little oil.","Cook for few mins.","Add some water. Cover and cook till bittegourd is done.","Now flip over and cook.","Serve", "package1.jpg"};
        String[] BCurry={"Bitter Guard Curry","250 grams karela ","1  onion medium to large , chopped finely"," 1 green chilli slit (optional)","1 sprig curry leaves","2 tablespoons oil","1/2  teaspoon cumin seeds","⅛ teaspoon turmeric","1 teaspoon Kashmiri red chili powder","1 tablespoons coriander powder","1 teaspoon fennel powder","1 to 2 tablespoons Lemon juice","3 tablespoons coriander leaves","Instructions :-"," Wash and slice bitter gourd thin. ","Heat oil in a pan. Add cumin seed. when they begin to sizzle, add hing.",". Add chopped onions and curry leaves. Saute until the onions turn pink/ transparent.","Add bitter gourd slices and sprinkle salt. Saute for 2 to 3 mins on a medium heat.","Cover and cook on a low heat until slightly tender, half cooked","Then the bitter gourd is slightly tender, add turmeric, fennel powder, coriander powder, red chili powder. Mix every thing well.","Cover and cook again on a very low heat until soft cooked."," If the curry looks very dry sprinkle very some water","8. Turn off the stove. Squeeze in some lemon juice & stir","Garnish bitter gourd curry with coriander leaves. Serve with rice or roti",  "package3.jpg"};
        
        JTabbedPane tab=new JTabbedPane();
        
        JPanel p1=createPackage(stuffed_BG);
        tab.addTab("stuffed bitter guard",null ,p1);
      
       JPanel p2=createPackage(BCurry);
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
        new BGuard();
    }
}
