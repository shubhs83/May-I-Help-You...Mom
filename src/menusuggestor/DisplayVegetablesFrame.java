package menusuggestor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class DisplayVegetablesFrame extends JFrame {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    private JTable vegetableTable;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JButton backButton; 

    public DisplayVegetablesFrame() {
        initComponents();
        Connect();
        fetchVegetables();
        setLocationRelativeTo(null);
    }

    private void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/msuggestion", "root", "shubhs#R83");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DisplayVegetablesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetchVegetables() {
        try {
            pst = con.prepareStatement("SELECT * FROM vegetable_tbl");
            rs = pst.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Date");
            model.addColumn("Name");
            model.addColumn("Weight");
            model.addColumn("Unit");
            model.addColumn("Use Before");

            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("id"));
                row.add(rs.getString("date"));
                row.add(rs.getString("name"));
                row.add(rs.getString("weight"));
                row.add(rs.getString("unit"));
                row.add(rs.getString("use_before"));

                model.addRow(row);
            }

            vegetableTable.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(DisplayVegetablesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        vegetableTable = new JTable();
        jLabel1 = new JLabel();
        backButton = new JButton("Dashboard"); 

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(210,220,210));

        vegetableTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jScrollPane1.setViewportView(vegetableTable);

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jLabel1.setText("Vegetable Information");
        jLabel1.setForeground(Color.BLACK);

       
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new Dashboard().setVisible(true); 
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(34, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(125, 125, 125)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(backButton))) // Add the back button here
                                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(backButton) // Add the back button here
                                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new DisplayVegetablesFrame().setVisible(true));
    }
}
