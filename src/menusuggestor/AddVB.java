package menusuggestor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class AddVB extends JFrame implements ActionListener {
    JButton addButton, back;
    JLabel imageLabel1;

    AddVB() {
        setBounds(170, 50, 650, 550);
        setLayout(null);

        Container contentPane = getContentPane();
        contentPane.setBackground(new Color(173, 5, 148));

        Border outerBorder = new LineBorder(new Color(0, 0, 0), 4);
        Border innerBorder = new LineBorder(Color.WHITE, 4);
        Border additionalBorder = new LineBorder(new Color(0, 0, 0), 4);

        Border tripleLayerBorder = BorderFactory.createCompoundBorder(outerBorder,
        BorderFactory.createCompoundBorder(innerBorder, additionalBorder));
        ((JComponent) contentPane).setBorder(tripleLayerBorder);

        JLabel click = new JLabel("Add Here --> ");
        click.setBounds(20, 90, 180, 30);
        click.setForeground(Color.WHITE);
        click.setFont(new Font("Tahoma", Font.BOLD, 22));
        contentPane.add(click);

        ImageIcon addIcon1=new ImageIcon(ClassLoader.getSystemResource("icon/VB1.JPG"));
        imageLabel1 = new JLabel(addIcon1);
        imageLabel1.setBounds(340, 180, 220, 390); 
        contentPane.add(imageLabel1);
        
        addButton = new JButton("Add");
        addButton.setBounds(175, 90, 100, 50);
        addButton.setBackground(new Color(0, 0, 0));
        addButton.setForeground(new Color(42, 212, 135));
        addButton.setFont(new Font("Tahoma", Font.BOLD, 22));
        addButton.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK, 2), addButton.getBorder()));
        addButton.addActionListener(this);
        contentPane.add(addButton);

        back = new JButton("Back");
        back.setBounds(175, 180, 100, 50);
        back.setBackground(new Color(0, 0, 0));
        back.setForeground(new Color(42, 212, 135));
        back.setFont(new Font("Tahoma", Font.BOLD, 22));
        back.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK, 2), back.getBorder()));
        back.addActionListener(this);
        contentPane.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addButton) {
            setVisible(false);
            new OpenFreeze();
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Dashboard();
        }
    }

    public static void main(String args[]) {
        new AddVB();
    }
}
