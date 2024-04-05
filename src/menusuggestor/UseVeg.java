package menusuggestor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UseVeg extends JFrame {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    private JLabel lblSelectedVegetable;
    private JComboBox<String> cboVegetables;
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> cboWeightUnit;
    private JTextField txtWeight;
    private JButton btnUse;
    private JButton btnBack;

    public UseVeg() {
        initComponents();
        connectToDatabase();
        loadVegetables();
        displayVegetableData();
    }

    private void initComponents() {
        setTitle("Use Vegetables");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lblSelectedVegetable = new JLabel("Select Vegetable:");
        cboVegetables = new JComboBox<>();
        table = new JTable();
        tableModel = new DefaultTableModel();
        table.setModel(tableModel);
        cboWeightUnit = new JComboBox<>(new String[]{"Kg", "Gm", "Qty"});
        txtWeight = new JTextField();
        btnUse = new JButton("Use");
        btnBack = new JButton("Back");

        setLayout(null);

        lblSelectedVegetable.setBounds(20, 20, 120, 25);
        cboVegetables.setBounds(150, 20, 200, 25);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 60, 400, 200);
        cboWeightUnit.setBounds(20, 280, 80, 25);
        txtWeight.setBounds(120, 280, 100, 25);
        btnUse.setBounds(250, 280, 80, 25);
        btnBack.setBounds(350, 280, 80, 25);

        add(lblSelectedVegetable);
        add(cboVegetables);
        add(scrollPane);
        add(cboWeightUnit);
        add(txtWeight);
        add(btnUse);
        add(btnBack);

        cboVegetables.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayVegetableData();
            }
        });

        btnUse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                useVegetable();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/msuggestion", "root", "shubhs#R83");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UseVeg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadVegetables() {
        try {
            pst = con.prepareStatement("SELECT name FROM vegetable_tbl");
            rs = pst.executeQuery();
            while (rs.next()) {
                cboVegetables.addItem(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UseVeg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displayVegetableData() {
        try {
            String selectedVegetable = cboVegetables.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT * FROM vegetable_tbl WHERE name = ?");
            pst.setString(1, selectedVegetable);
            rs = pst.executeQuery();

            tableModel.setRowCount(0);
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("id"));
                row.add(rs.getString("date"));
                row.add(rs.getString("name"));
                row.add(rs.getString("weight"));
                row.add(rs.getString("unit"));
                row.add(rs.getString("use_before"));
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UseVeg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void useVegetable() {
        try {
            String selectedVegetable = cboVegetables.getSelectedItem().toString();
            String weight = txtWeight.getText();
            String unit = cboWeightUnit.getSelectedItem().toString();

            if (weight.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the weight");
                return;
            }

            Float.parseFloat(weight);

            String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());

            pst = con.prepareStatement("UPDATE vegetable_tbl SET weight = weight - ? WHERE name = ? AND use_before >= ?");
            pst.setString(1, weight);
            pst.setString(2, selectedVegetable);
            pst.setString(3, currentDate);
            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Vegetable used successfully!");
                displayVegetableData();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to use vegetable. Check the entered data.");
            }

        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please check the entered data.");
            Logger.getLogger(UseVeg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UseVeg().setVisible(true);
            }
        });
    }
}
