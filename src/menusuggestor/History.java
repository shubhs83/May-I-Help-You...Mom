package menusuggestor;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class History {
    private List<UsageRecord> usageRecords;

    public History() {
        this.usageRecords = new ArrayList<>();
    }

    public void addUsageRecord(String vegetableName, Date dateUsed) {
        UsageRecord record = new UsageRecord(vegetableName, dateUsed);
        usageRecords.add(record);
    }

    public List<UsageRecord> getUsageRecords() {
        return usageRecords;
    }

    // Inner class to represent a usage record
    public static class UsageRecord {
        private String vegetableName;
        private Date dateUsed;
        private String dayOfWeek;

        public UsageRecord(String vegetableName, Date dateUsed) {
            this.vegetableName = vegetableName;
            this.dateUsed = dateUsed;

            // Calculate day of the week
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
            this.dayOfWeek = sdf.format(dateUsed);
        }

        public String getVegetableName() {
            return vegetableName;
        }

        public Date getDateUsed() {
            return dateUsed;
        }

        public String getDayOfWeek() {
            return dayOfWeek;
        }
    }

    // TableModel for JTable
    public class UsageTableModel extends AbstractTableModel {
        private final String[] columnNames = {"Vegetable Name", "Date", "Day of Week"};
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        @Override
        public int getRowCount() {
            return usageRecords.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            UsageRecord record = usageRecords.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return record.getVegetableName();
                case 1:
                    return dateFormat.format(record.getDateUsed()); // Format the date
                case 2:
                    return record.getDayOfWeek();
                default:
                    return null;
            }
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }

    // Example usage
    public static void main(String[] args) {
        History history = new History();

        // Adding usage records
        history.addUsageRecord("Palak", new Date());
        history.addUsageRecord("Tomato", new Date());
        history.addUsageRecord("Bitter Guard", new Date());

        // Displaying usage records in a JTable
        UsageTableModel tableModel = history.new UsageTableModel();
        JTable jTable = new JTable(tableModel);

        // Example: Adding the JTable to a JFrame for display
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(jTable));
        frame.pack();
        frame.setVisible(true);
    }
}
