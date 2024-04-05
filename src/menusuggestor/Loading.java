package menusuggestor;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loading {
    private JFrame frame;
    private JProgressBar progressBar;
    private JLabel upperLabel;
    private JLabel lowerLabel;
    private Timer timer;
    private Color[] timingColors = {
            new Color(50, 158, 168),  
            new Color(255, 165, 0),    
            new Color(166, 168, 50),     
            new Color(166, 168, 50),
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Loading();
        });
    }

    public Loading() {
        frame = new JFrame();
        frame.setSize(400, 300);
        frame.setLocation(400, 90);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        upperLabel = new JLabel("Wash Vegetables before use:");
        upperLabel.setFont(new Font("Tahoma",Font.BOLD,15));
        upperLabel.setBounds(50, 40, 250, 30);
        frame.add(upperLabel);

        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(50, 90, 300, 30);
        frame.add(progressBar);

        lowerLabel = new JLabel("Please Wait while opening the Door");
        lowerLabel.setBounds(50, 140, 280, 20);
        lowerLabel.setFont(new Font("Tahoma",Font.BOLD,15));
        frame.add(lowerLabel);

        timer = new Timer(30, new ActionListener() {
            int progress = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                progress++;
                progressBar.setValue(progress);

                if (progress % 20 == 0) { 
                    int colorIndex = (progress / 20) % timingColors.length;
                    frame.getContentPane().setBackground(timingColors[colorIndex]);
                }

                if (progress == 100) {
                    timer.stop();
                    openNewClass();
                }
            }
        });

        timer.start();

        frame.setVisible(true);
    }

    private void openNewClass() {
        frame.dispose();  
        DisplayVegetablesFrame addvegetables = new DisplayVegetablesFrame();
        addvegetables.setVisible(true);
    }
}
