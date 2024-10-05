import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class AttendanceManagementSystemGUI extends JFrame {
    private final Map<String, Boolean> attendanceRecord;
    private final JTextArea displayArea;
    private final JTextField studentNameField;
    private final JCheckBox presentCheckBox;
    private Connection connection;

    public AttendanceManagementSystemGUI() {
        attendanceRecord = new HashMap<>();
        connectToDatabase();
        createAttendanceTable();

        // Set up the frame
        setTitle("Attendance Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create components
        JLabel nameLabel = new JLabel("Student Name:");
        studentNameField = new JTextField(15);
        presentCheckBox = new JCheckBox("Present");
        JButton markButton = new JButton("Mark Attendance");
        JButton viewButton = new JButton("View Attendance");
        JButton saveButton = new JButton("Save Attendance");
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        // Add action listeners
        markButton.addActionListener(_ -> {
            String studentName = studentNameField.getText();
            boolean isPresent = presentCheckBox.isSelected();
            markAttendance(studentName, isPresent);
            studentNameField.setText("");
            presentCheckBox.setSelected(false);
        });

        viewButton.addActionListener(_ -> displayAttendance());

        saveButton.addActionListener(_ -> saveAttendanceToDatabase());

        // Add components to frame
        add(nameLabel);
        add(studentNameField);
        add(presentCheckBox);
        add(markButton);
        add(viewButton);
        add(saveButton);
        add(new JScrollPane(displayArea));

        setVisible(true);
    }

    private void connectToDatabase() {
        try {
            // Update with your MySQL credentials
            String url = "jdbc:mysql://localhost:3306/attendance_db"; // Adjust database URL
            String user = "yourUsername"; // Replace with your MySQL username
            String password = "yourPassword"; // Replace with your MySQL password

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createAttendanceTable() {
        String sql = "CREATE TABLE IF NOT EXISTS attendance (name VARCHAR(255) PRIMARY KEY, is_present BOOLEAN)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void markAttendance(String studentName, boolean isPresent) {
        attendanceRecord.put(studentName, isPresent);
        JOptionPane.showMessageDialog(this, "Attendance marked for " + studentName);
    }

    public void displayAttendance() {
        StringBuilder attendanceDisplay = new StringBuilder("Attendance Record:\n");
        for (Map.Entry<String, Boolean> entry : attendanceRecord.entrySet()) {
            attendanceDisplay.append("Student: ").append(entry.getKey())
                    .append(" - ").append(entry.getValue() ? "Present" : "Absent").append("\n");
        }
        displayArea.setText(attendanceDisplay.toString());
    }

    public void saveAttendanceToDatabase() {
        String sql = "INSERT INTO attendance (name, is_present) VALUES (?, ?) " +
                "ON DUPLICATE KEY UPDATE is_present = VALUES(is_present)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            for (Map.Entry<String, Boolean> entry : attendanceRecord.entrySet()) {
                pstmt.setString(1, entry.getKey());
                pstmt.setBoolean(2, entry.getValue());
                pstmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(this, "Attendance saved to database.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error saving attendance: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AttendanceManagementSystemGUI::new);
    }
}
