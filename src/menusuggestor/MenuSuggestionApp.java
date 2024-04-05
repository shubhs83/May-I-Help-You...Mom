
package menusuggestor;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MenuSuggestionApp extends JFrame implements ActionListener {
    public JComboBox<String> freezerComboBox;
    public JButton suggestButton,add,back;
    public JTextArea suggestionTextArea;

    public List<String> availableMenus = Arrays.asList("Idali", "Paratha", "Samosa", "Gulab Jamaun", "Barfi");

    public MenuSuggestionApp() {
        setTitle("Menu Suggestion App");
         setBounds(300,150,600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        addComponents();
        addListeners();
        
        
    }

    public void initComponents() {
        freezerComboBox = new JComboBox<>(availableMenus.toArray(new String[0]));
        suggestButton = new JButton("Suggest Menu");
        suggestionTextArea = new JTextArea();
        suggestionTextArea.setEditable(false);
         
       back=new JButton("Dashboard");
       back.setBounds(180,200,150,50);
       back.setBackground(new Color(0,60,102));
       back.setForeground(Color.WHITE);
       back.setFont(new Font("Tahoma",Font.BOLD,18));
       back.addActionListener(this);
       add(back);
    }

    public void addComponents() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select Item from Freezer:"));
        topPanel.add(freezerComboBox);
        topPanel.add(suggestButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(suggestionTextArea), BorderLayout.CENTER);
       
    }

    public void addListeners() {
        suggestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suggestMenu();
            }
        });
    }

    public void suggestMenu() {
        String selectedMenu = (String) freezerComboBox.getSelectedItem();
        if (selectedMenu != null) {
            String suggestedMenu = getRandomMenuExcept(selectedMenu);
            suggestionTextArea.setText("Suggested Menu: " + suggestedMenu);
        }
    }

    public String getRandomMenuExcept(String excludedMenu) {
        List<String> remainingMenus = new ArrayList<>(availableMenus);
        remainingMenus.remove(excludedMenu);
        if (!remainingMenus.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(remainingMenus.size());
            return remainingMenus.get(randomIndex);
        } else {
            return "No other menu available";
        }
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==add){
           
       }else{
           setVisible(false);
           new Dashboard().setVisible(true);
       }
       
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuSuggestionApp().setVisible(true);
            }
        });
    }
}
