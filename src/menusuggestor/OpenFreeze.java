package menusuggestor;

import javax.swing.*;
import java.awt.*;

public class OpenFreeze extends JFrame implements Runnable {

    Thread t;

    OpenFreeze() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/freeze4.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 390, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

      
       getContentPane().setBackground(new Color(225,220,225));

        setVisible(true);

        int x = 1;
        for (int i = 2; i < 500; i += 4, x += 1) {
            setSize(i + x, i);
            setLocation(650 - ((i + x) / 2), 350 - (i / 2));
            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        t = new Thread(this);
        t.start();

        setVisible(true);
    }

    public void run() {
        try {
            Thread.sleep(3000);
            setVisible(false);

             new AddVegetables().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new OpenFreeze();
    }
}
