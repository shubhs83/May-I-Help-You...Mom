package menusuggestor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PalakRecepie extends JFrame implements ActionListener{
    JButton back;
    PalakRecepie(){
        
        setBounds(150,100,1050,540);
        
        String[] Palak_curry={" Palak Curry ",   "Ingredients :-",  ":- Spinach - 3 cups packed",  ":- Onion - 1 chopped finely",   ":- Tomato - 2 chopped finely",    ":- Cumin Seeds / Jeerakam - 1 tsp",     ":- Chilli powder - 1 tsp", ":- Coriander powder / malli posi - 1 tblspn",  ":- Turmeric powder / Manjal podi - 1 tsp", ":- Garam Masala powder - 1 tsp", ":- Salt to taste",":- Curd - 2 tblspn well beaten",":- Oil - 1 tblspn", ":- Butter - 1 tblspn","Instructions","Take spinach along with water in a sauce pan and cook it for 5 mins. Let it cool down.","Heat oil in a kadai. Add cumin and let it crackle.","Add onions and cook till golden brown.","Add in all the spice powder and mix well. Add in tomatoes and mix well.","Cover the pan and let it cook for 5 mins till the tomatoes turn mushy.","Now add in the spinach puree and mix well. Season with salt.","Let the gravy simmer for 10-15 mins.","Switch off the stove and add in curd and mix well.","Serve with a blob of butter along with roti.","","", "package1.jpg"};
        String[] Palak_Soup={"Palak Soup", "Ingredients :-", "1 teaspoon oil & 2 garlic cloves", "120 grams (4 cups) spinach", " ¼ teaspoon red chilli flakes", "2 tablespoons butter", "1 ½ inch cinnamon & 1 bay leaf", " 2 to 3 tablespoons cream", "2 ½ tablespoons oats flour", "2½ cups milk", "1 cup water", "½ teaspoon salt ", "1 teaspoon sugar ", "½ teaspoon crushed black pepper", "Instructions :-", "1. Pour 1 teaspoon oil to a pot and saute sliced garlic for 1 minute.", "Add the spinach and saute until it wilts and the raw smell has gone completely. ", " Cool this and blend to a smooth puree with ½ cup water or stock/broth.", "Melt butter in the same pot and reduce the heat to low. Add 1 bay leaf and cinnamon", " Add flour and saute until it loses the raw flavor, for 2 to 3 minutes.","Pour milk slowly and mix well. Simmer and let it cook until slightly thick","8. Bring this to a gentle boil and add cream.","9. Let it simmer until the soup thickens and all the raw flavor of spinach is gone.","Turn off the heat and cover the spinach soup."," Serve hot or warm with croutons or cheese toast", "package2.jpg"};
        String[] Palak_paratha={"","","","","","","","","","","","","","","","","","","","","","","","","",  "package3.jpg"};
        
        JTabbedPane tab=new JTabbedPane();
        
        JPanel p1=createPackage(Palak_curry);
        tab.addTab("Palak curry",null ,p1);
        
       JPanel p2=createPackage(Palak_Soup);
       tab.addTab("Palak Soup 2",null ,p2);
       
       JPanel p3=createPackage(Palak_paratha);
       tab.addTab("Palak paratha 3",null ,p3);
       
       add(tab);
       
        setVisible(true);
        
    }
      public JPanel createPackage(String[] pack){
       
       JPanel p1=new JPanel();
       p1.setLayout(null);
       p1.setBackground(Color.WHITE);
       
       
       
       
       JLabel l1=new JLabel(pack[0]);
       l1.setBounds(40,4,160,30);
       l1.setForeground(Color.BLACK);
       l1.setFont(new Font("Tahoma",Font.PLAIN,24));
       p1.add(l1);
       
       JLabel l2=new JLabel(pack[1]);
       l2.setBounds(25,34,300,20);
       l2.setForeground(Color.RED);
       l2.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l2);
       
       JLabel l3=new JLabel(pack[2]);
       l3.setBounds(25,60,300,20);
       l3.setForeground(Color.BLACK);
       l3.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l3);
       
       JLabel l4=new JLabel(pack[3]);
       l4.setBounds(25,90,300,20);
       l4.setForeground(Color.BLUE);
       l4.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l4);
       
       JLabel l5=new JLabel(pack[4]);
       l5.setBounds(25,120,300,20);
       l5.setForeground(Color.BLACK);
       l5.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l5);
       
      
       
       JLabel l6=new JLabel(pack[5]);
       l6.setBounds(25,150,300,20);
       l6.setForeground(Color.BLUE);
       l6.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l6);
       
       JLabel l7=new JLabel(pack[6]);
       l7.setBounds(25,180,300,20);
       l7.setForeground(Color.BLACK);
       l7.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l7);
       
       
       JLabel l8=new JLabel(pack[7]);
       l8.setBounds(25,210,300,20);
       l8.setForeground(Color.BLUE);
       l8.setFont(new Font("Tahoma",Font.PLAIN,16));
       p1.add(l8);
       
       JLabel l9=new JLabel(pack[8]);
       l9.setBounds(25,240,300,20);
       l9.setForeground(Color.BLACK);
       l9.setFont(new Font("Tahoma",Font.PLAIN,20));
       p1.add(l9);
       
       JLabel l10=new JLabel(pack[9]);
       l10.setBounds(25,270,300,20);
       l10.setForeground(Color.BLUE);
       l10.setFont(new Font("Tahoma",Font.PLAIN,20));
       p1.add(l10);
       
       JLabel l11=new JLabel(pack[10]);
       l11.setBounds(25,300,300,20);
       l11.setForeground(Color.BLACK);
       l11.setFont(new Font("Tahoma",Font.PLAIN,20));
       p1.add(l11);
       
       JLabel l12=new JLabel(pack[11]);
       l12.setBounds(25,330,300,20);
       l12.setForeground(Color.BLUE);
       l12.setFont(new Font("Tahoma",Font.PLAIN,20));
       p1.add(l12);
       
       JLabel l13=new JLabel(pack[12]);
       l13.setBounds(25,360,300,20);
       l13.setForeground(Color.BLACK);
       l13.setFont(new Font("Tahoma",Font.PLAIN,20));
       p1.add(l13);
       
       
       JLabel l14=new JLabel(pack[13]);
       l14.setBounds(25,390,300,20);
       l14.setForeground(Color.BLUE);
       l14.setFont(new Font("Tahoma",Font.PLAIN,20));
       p1.add(l14);
       
       
       JLabel l15=new JLabel(pack[14]);
       l15.setBounds(330,4,300,20);
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
       l21.setBounds(330,180,600,20);
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
       
       
       
    Font titleFont = new Font("Tahoma", Font.PLAIN, 24);
    Font subtitleFont = new Font("Tahoma", Font.PLAIN, 16);
    Font contentFont = new Font("Tahoma", Font.PLAIN, 14);
    
    l1.setFont(titleFont);

    l2.setFont(subtitleFont);
    l3.setFont(contentFont);
    l4.setFont(contentFont);
    l5.setFont(contentFont);
    l6.setFont(contentFont);
    l7.setFont(contentFont);
    l8.setFont(contentFont);
    l9.setFont(contentFont);
    l10.setFont(contentFont);
    l11.setFont(contentFont);
    l12.setFont(contentFont);
    l13.setFont(contentFont);
    l14.setFont(contentFont);
    l15.setFont(new Font("Tahoma", Font.BOLD, 20));
    l16.setFont(new Font("Tahoma", Font.PLAIN, 12));
    l17.setFont(new Font("Tahoma", Font.PLAIN, 12));
       
       return p1;
    }
      public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==back){
              setVisible(false);
              new Dashboard();
              
          }
      }
    
    public static void main(String args[]){
        new PalakRecepie();
    }
}

