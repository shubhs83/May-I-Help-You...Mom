package menusuggestor;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dashboard extends JFrame implements ActionListener {
    
    JButton addvegetables,autosuggest,chooseme,viewvegetables,use,expire;
    
    Dashboard(){
       
       setExtendedState(JFrame.MAXIMIZED_BOTH);
       setLayout(null);
       
       JPanel p1=new JPanel();
       p1.setLayout(null);
       p1.setBackground(new Color(0,0,102));
       p1.setBounds(0,0,1300,40);
       add(p1);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/dashboard.png"));
       Image i2=i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel icon=new JLabel(i3);
       icon.setBounds(4,0,50,50);
       p1.add(icon);
       
       JLabel heading=new JLabel("Dashboard");
       heading.setBounds(50,8,250,20);
       heading.setForeground(Color.WHITE);
       heading.setFont(new Font("Tahoma",Font.BOLD,20));
       p1.add(heading);
       
       JPanel p2=new JPanel();
       p2.setLayout(null);
       p2.setBackground(new Color(40,34,45));
       p2.setBackground(Color.GRAY);
       p2.setBounds(0,40,250,700);
       add(p2);
       
      
       addvegetables=new JButton("Inside The Freeze");
       addvegetables.setBounds(20,50,250,40);
       addvegetables.setBackground(new Color(0,0,102));
       addvegetables.setForeground(Color.WHITE);
       addvegetables.setFont(new Font("Tahoma",Font.PLAIN,16));
       addvegetables.addActionListener(this);
       addvegetables.setMargin(new Insets(0,0,0,45));
       p2.add(addvegetables);
       
       viewvegetables=new JButton("View Vegetables");
       viewvegetables.setBounds(20,100,250,40);
       viewvegetables.setBackground(new Color(0,0,102));
       viewvegetables.setForeground(Color.WHITE);
       viewvegetables.setFont(new Font("Tahoma",Font.PLAIN,16));
       viewvegetables.addActionListener(this);
       viewvegetables.setMargin(new Insets(0,0,0,45));
       p2.add(viewvegetables);
       
       chooseme=new JButton("Choose Me");
       chooseme.setBounds(20,150,250,40);
       chooseme.setBackground(new Color(0,0,102));
       chooseme.setForeground(Color.WHITE);
       chooseme.setFont(new Font("Tahoma",Font.PLAIN,16));
       chooseme.setMargin(new Insets(0,0,0,85));
       chooseme.addActionListener(this);
       p2.add(chooseme);
       
       
       autosuggest=new JButton("Auto Suggest");
       autosuggest.setBounds(20,200,250,40);
       autosuggest.setBackground(new Color(0,0,102));
       autosuggest.setForeground(Color.WHITE);
       autosuggest.setFont(new Font("Tahoma",Font.PLAIN,16));
       autosuggest.setMargin(new Insets(0,0,0,85));
       autosuggest.addActionListener(this);
       p2.add(autosuggest);
       
       use=new JButton("Let's Use");
       use.setBounds(20,250,250,40);
       use.setBackground(new Color(0,0,102));
       use.setForeground(Color.WHITE);
       use.setFont(new Font("Tahoma",Font.PLAIN,16));
       use.setMargin(new Insets(0,0,0,85));
       use.addActionListener(this);
       p2.add(use);
       
       
       expire=new JButton("Spoiled Vegetables");
       expire.setBounds(20,300,250,40);
       expire.setBackground(new Color(0,0,102));
       expire.setForeground(Color.WHITE);
       expire.setFont(new Font("Tahoma",Font.PLAIN,16));
       expire.setMargin(new Insets(0,0,0,85));
       expire.addActionListener(this);
       p2.add(expire);
       
       
       ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/hom.jpg"));
       Image i5=i4.getImage().getScaledInstance(1350,750,Image.SCALE_DEFAULT);
       ImageIcon i6=new ImageIcon(i5);
       JLabel image=new JLabel(i6);
       image.setBounds(0,0,1350,750);
       add(image);
     
       JLabel text=new JLabel("Let's try it Today");
       text.setBounds(290,50,850,70);
       text.setForeground(Color.BLACK);
       text.setFont(new Font("Raileway",Font.BOLD,50));
       image.add(text);
       
       setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addvegetables){
            setVisible(false);
            new AddVB().setVisible(true); 
            
        }else if(ae.getSource()==viewvegetables){
            setVisible(false);
            new Loading();
        }
        else if(ae.getSource()==autosuggest){
            setVisible(false);
            new MenuSuggestionApp().setVisible(true);
        }else if(ae.getSource()==chooseme){
            setVisible(false);
            new Items();
        }else if(ae.getSource()==use){
            setVisible(false);
            new UseVegetables().setVisible(true);
        }else if(ae.getSource()==expire){
            setVisible(false);
            new Expired().setVisible(true);
        }
         
    }
    public static void main(String args[]){
        new Dashboard();
        
    }    
}

