
package menusuggestor;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class Items extends JFrame implements ActionListener{
    
    JButton back,Palak,Tomato,BGuard,lfinger,cab;
    JComboBox palakmenu,tomatomenu,bguardmenu,fmenu,cmenu;
    Items(){
        
        setBounds(300,150,700,500);
        setLayout(null);
        getContentPane().setBackground(new Color(182, 3, 252));
        
         
        JLabel Vegetables= new JLabel("Name");
        Vegetables.setBounds(40, 10, 80, 30);
        Vegetables.setFont(new Font("Tahoma",Font.BOLD,20));
        Vegetables.setForeground(Color.YELLOW);
        add(Vegetables);
        
        JLabel submenu= new JLabel("we make");
        submenu.setBounds(170, 10, 150, 30);
        submenu.setFont(new Font("Tahoma",Font.BOLD,20));
        submenu.setForeground(Color.YELLOW);
        add(submenu);
        
        JLabel recepie= new JLabel("Recipe");
        recepie.setBounds(350, 10, 200, 30);
        recepie.setFont(new Font("Tahoma",Font.BOLD,20));
        //recepie.setForeground(new Color(3, 252, 215));
        recepie.setForeground(Color.YELLOW);
        add(recepie);
        
        JLabel palak= new JLabel("Palak");
        palak.setBounds(40, 60, 100, 30);
        palak.setForeground(Color.YELLOW);
        palak.setFont(new Font("Raileway",Font.BOLD,14));
        add(palak);
        
        
        String pmenu[] = {"  ","1.Palak Curry","2.Palak Paratha","3.Palak Soup","4.Palak Dal","5.Palak Pulao","6.Palak Raita"};
        palakmenu = new JComboBox(pmenu);
        palakmenu.setBackground(Color.WHITE);
        palakmenu.setBounds(150, 60, 150, 25);
        add(palakmenu);
        
        
        
        Palak = new JButton("Palak Recipe");
        Palak.setBounds(350, 60, 150,25);
        Palak.setBackground(Color.BLACK);
        Palak.setForeground(Color.WHITE);
        Palak.addActionListener(this);
        add(Palak);
        
        
        JLabel tomato  = new JLabel("Tomato");
        tomato.setBounds(40, 90, 100, 30);
        tomato.setForeground(Color.YELLOW);
        tomato.setFont(new Font("Raileway",Font.BOLD,14));

        add(tomato);
        
        
        String tmenu[] = {"  ","1.Tomato Chutney","2.Tomato Soup","3.Tomato Basil Pasta","4.Stuffed Tomatoes","5.Tomato and Onion Salsa"};
        tomatomenu = new JComboBox(tmenu);
        tomatomenu.setBackground(Color.WHITE);
        tomatomenu.setBounds(150, 90, 150, 25);
        add(tomatomenu);
        
        Tomato = new JButton("Tomato Recipe");
        Tomato.setBounds(350, 90, 150,25);
        Tomato.setBackground(Color.BLACK);
        Tomato.setForeground(Color.WHITE);
        Tomato.addActionListener(this);
        add(Tomato);
        
        
        JLabel bguard = new JLabel("Bitter Guard");
        bguard.setBounds(40, 120, 100, 30);
        bguard.setForeground(Color.YELLOW);
        bguard.setFont(new Font("Raileway",Font.BOLD,14));

        add(bguard);
        
        
        String bmenu[] = {"  ","1.Stuffed Bitter Gourd ","2.Bitter Gourd Chips","3.Bitter Gourd Curry ","4.Bitter Gourd Soup","5.Bitter Gourd Salad ","6.Bitter Gourd and Coconut Curry","7.Bitter Gourd Pakoras" };
        bguardmenu = new JComboBox(bmenu);
        bguardmenu.setBackground(Color.WHITE);
        bguardmenu.setBounds(150, 120, 150, 25);
        add(bguardmenu);
        
        BGuard = new JButton("BGuard Recipe");
        BGuard.setBounds(350, 120, 150,25);
        BGuard.setBackground(Color.BLACK);
        BGuard.setForeground(Color.WHITE);
        BGuard.addActionListener(this);
        add(BGuard);
        
        
        JLabel Lfinger = new JLabel("Lady's Finger");
        Lfinger.setBounds(40, 150, 100, 30);
        Lfinger.setForeground(Color.YELLOW);
        Lfinger.setFont(new Font("Raileway",Font.BOLD,14));

        add(Lfinger);
        
        
        String lfmenu[] = {"  ","1.Stuffed Ladyfinger","2.Fried Ladyfinger", };
        fmenu = new JComboBox(lfmenu);
        fmenu.setBackground(Color.WHITE);
        fmenu.setBounds(150, 150, 150, 25);
        add(fmenu);
        
        lfinger = new JButton("LFinger Recipe");
        lfinger.setBounds(350, 150, 150,25);
        lfinger.setBackground(Color.BLACK);
        lfinger.setForeground(Color.WHITE);
        lfinger.addActionListener(this);
        add(lfinger);
        
        JLabel Cabbege = new JLabel("Potato");
        Cabbege.setBounds(40, 180, 100, 30);
        Cabbege.setForeground(Color.YELLOW);
        Cabbege.setFont(new Font("Raileway",Font.BOLD,14));
        add(Cabbege);
        
        
        String cfmenu[] = {"  ","Aloo Tikki","2.French Fries", "3.Grilled Potatoes"};
        cmenu = new JComboBox(cfmenu);
        cmenu.setBackground(Color.WHITE);
        cmenu.setBounds(150, 180, 150, 25);
        add(cmenu);
        
        cab = new JButton("Potato Recipe");
        cab.setBounds(350, 180, 150,25);
        cab.setBackground(Color.BLACK);
        cab.setForeground(Color.WHITE);
        cab.addActionListener(this);
        add(cab);
        
        
        back = new JButton("Back");
        back.setBounds(220, 370, 150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Dashboard();
        } else if(ae.getSource()==Palak){
            setVisible(true);
            new PalakRecepie();
        } else if(ae.getSource()==Tomato){
            setVisible(true);
            new TomatoRecepie();
        }else if(ae.getSource()==BGuard){
            setVisible(true);
            new BGuard();
        }else if(ae.getSource()==lfinger){
            setVisible(true);
           new FriedLfinger();
        }else if(ae.getSource()==cab){
            setVisible(true);
            //new Cabbege(); 
            
        }
    }
    public static void main(String args[]){
        new Items();
    }
}
