
package menusuggestor;

import java.awt.*;
import javax.swing.*;

public class Splash extends JFrame implements Runnable {
    
    Thread t;
    
    Splash(){
        
         
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/img1.jpg"));
        Image i2=i1.getImage().getScaledInstance(576, 451,Image.SCALE_DEFAULT);

        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        
        add(image);
        
        setVisible(true);
        
        
        int x=1;
        for(int i=2;i<450;i+=4,x+=1){
           setSize(i+x,i);
           setLocation(650-((i+x)/2),350-(i/2));
            try{
                Thread.sleep(5);
            }catch(Exception e){
               e.printStackTrace();
            }
        }
        t=new Thread(this);
        t.start();
        
        setVisible(true);
    }
    public void run(){
        try{
            Thread.sleep(2000);
            setVisible(false);
            
            new Dashboard();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new Splash();
        
    }
    
}

