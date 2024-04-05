package menusuggestor;

import javax.swing.*;
import java.awt.*;


public class TomatoRecepie extends JFrame{
    JButton back,backk,home;
    TomatoRecepie(){
        setBounds(150,100,1050,540);
        
        String[] Tomato_Chutney={"Tomato Chutney ",   "Ingredients :-",  "1 tsp Oil",  "2 tbsp Urad dal",   "5 Dry Red Chillies",    "5 large Tomatoes chopped",     ":-Salt to taste", ":- ",  ":- 1 tsp Sugar", ":- 4 tbsp Oil", ":-1 tsp Mustard Seeds",":- 1 sprig Curry Leaves",":- ¼ tsp Asafoetida | Hing", "","Instructions","Heat 1 tsp oil in a pan, add in urad dal and chillies and saute till golden.","Now add in tomatoes, salt and sugar and mix well.","Cover and simmer the pan and cook for 5 to 10 mins.","Now it is cooked. Take this in a blender and puree till smooth.","Now make seasoning, heat oil in a pan, add in mustard seeds, hing, curry leaves and mix we","Add in chutney and cook till oil separates.","Serve with dosa.","","","","", "package1.jpg"};
        String[] Tomato_Soup={"Tomato Soup"," Ingredients :-","500 grams (1.1 lbs) Tomatoes","1 tablespoon olive oil","1 small bay leaf","1 medium onion","2 large garlic","⅓ teaspoon Salt","1½ cup water","1 tablespoon sugar","¾ tablespoon corn starch","½ teaspoon pepper","¾ to 1 teaspoon dried herbs","2 stalks Basil","Instructions :-","Heat oil in a pan. Add bay leaf, garlic and onions. Saute all of these on a high flamefor 3 to 4 mins.","Then add in tomatoes and salt. Stir and cook until sof","Next add in basil and cook until tomatoes turn completely mushy. Turn off and cool.","Discard the basil & bay leaf.","Meanwhile stir in corn starch in half cup water and add it gradually to the boiling tomato soup."," Add sugar & more salt if desired. Simmer until it reaches a desired consistency.","Allow it to cool down a bit before adding the cream. If you prefer to use cashew nuts soak them in ¼ cup hot water for 30 minutes.","Transfer tomato soup to serving bowls.","Garnish with herbs & cream.","Enjoy with croutons.",  "package3.jpg"};
        String[] Tomato_Basil_pasta={"Basil pasta","Ingredients","8 ounces whole-wheat rotini","1 cup water & 2 cups low-sodium \"no-chicken\" broth or chicken broth","1 (15 ounce) can no-salt-added diced tomatoes","2 tablespoons extra-virgin olive oil","1 ½ teaspoons Italian seasoning","½ teaspoon onion powder","½ teaspoon garlic powder","½ teaspoon salt & ¼ teaspoon crushed red pepper","6 cups baby kale or baby spinach","","","","Instructions","Combine pasta, water, broth, tomatoes, oil, Italian seasoning, "," +onion powder, garlic powder, salt and crushed red pepper in a large pot "," Cover and bring to a boil over high heat","Uncover, reduce heat to medium-high and cook,","Stir in kale and cook, stirring often, until most of the liquid has been absorbed, 5 to 7 minutes more.","Stir in basil. Garnish with Parmesan, if desired.","","","","",  "package3.jpg"};
        String[] Tomato_salsa={"Tomato Salsa","Ingredients","2 to 3 medium fresh tomatoes ","1/2 medium red onion","Juice of 1 lime","1/2 cup chopped cilantro","Kosher salt and freshly ground black pepper to taste","1 pinch dried oregano","1 pinch ground cumin","","","","Instructions","Prep the ingredients: Roughly chop the tomatoes, chile peppers, and onions. Be careful while handling the chile peppers. ","","","","","","","","","","","",  "package3.jpg"};

         JTabbedPane tab=new JTabbedPane();
        
        JPanel p1=createPackage(Tomato_Chutney);
        tab.addTab("Tomato",null ,p1);
        
       JPanel p2=createPackage(Tomato_Soup);
       tab.addTab("Tomato Soup 2",null ,p2);
       
       JPanel p3=createPackage(Tomato_Basil_pasta);
       tab.addTab("Palak paratha 3",null ,p3);
       
       JPanel p4=createPackage(Tomato_salsa);
       tab.addTab("Palak paratha 3",null ,p3);
       
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
        new TomatoRecepie();
    }
}
