
package menusuggestor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalakCurry extends JFrame implements ActionListener{
     JButton button1, button2, button3, button4, button5, button6;

    PalakCurry() {

        setBounds(300, 150, 700, 500);
        setLayout(null);
        getContentPane().setBackground(new Color(189, 20,210));
        
        
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/pc1.jpg"));
       Image i2=i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel icon=new JLabel(i3);
       icon.setBounds(60,30,400,400);
       add(icon);
       
       ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/dashboard.png"));
       Image i5=i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
       ImageIcon i6=new ImageIcon(i5);
       JLabel icons=new JLabel(i6);
       icon.setBounds(4,0,50,50);
       add(icon);

    
        button1 = new JButton("Back");
        button1.setBounds(130, 400, 150, 20);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Dashboard");
        button2.setBounds(300, 400, 150, 20);
        button2.addActionListener(this);
        add(button2);

        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button1) {
            setVisible(false);
            // new
        } else if (ae.getSource() == button2) {
            setVisible(false);
            // new
        } else if (ae.getSource() == button3) {
            setVisible(false);
            // new
        } else if (ae.getSource() == button4) {
            setVisible(false);
            // new
        } else if (ae.getSource() == button5) {
            setVisible(false);
            // new
        } else {
            setVisible(false);
            // new
        }
    }
    public void ACtionPerformed(ActionEvent ae){
        if(ae.getSource()==button1){
            setVisible(false);
            //new NewClass2();
            new PalakRecepie();
            
        }else{
            setVisible(false);
            new Dashboard();
        }
    }

    public static void main(String args[]) {
        new PalakCurry();
    }
}

    

