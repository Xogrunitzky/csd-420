/*
    Xavier Grunitzky
    5/17/26
    Module 10 Assignment
   This is a Java JDBC program + GUI application that connects to a MySQL database
    and lets a user view and update records in a table called Fans.
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class FanGUI extends JFrame {

    // Database connection info
    String url = "jdbc:mysql://localhost:3306/databasedb?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    String user = "student1";
    String password = "pass";

    // GUI components
    JTextField idField = new JTextField(10);
    JTextField firstNameField = new JTextField(15);
    JTextField lastNameField = new JTextField(15);
    JTextField teamField = new JTextField(15);

    JButton displayBtn = new JButton("Display");
    JButton updateBtn = new JButton("Update");

    public FanGUI() {

        setTitle("Fans Database GUI");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // UI layout
        add(new JLabel("ID:"));
        add(idField);

        add(new JLabel("First Name:"));
        add(firstNameField);

        add(new JLabel("Last Name:"));
        add(lastNameField);

        add(new JLabel("Favorite Team:"));
        add(teamField);

        add(displayBtn);
        add(updateBtn);

        // Button actions
        displayBtn.addActionListener(e -> displayRecord());
        updateBtn.addActionListener(e -> updateRecord());

        setVisible(true);
    }

    // DISPLAY RECORD BY ID
    private void displayRecord() {

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            String sql = "SELECT * FROM fans WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(idField.getText()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                firstNameField.setText(rs.getString("FIRSTNAME"));
                lastNameField.setText(rs.getString("LASTNAME"));
                teamField.setText(rs.getString("FAVORITETEAM"));
            } else {
                JOptionPane.showMessageDialog(this, "No record found for this ID");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching record");
            e.printStackTrace();
        }
    }

    //  UPDATE RECORD
    private void updateRecord() {

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            String sql = "UPDATE fans SET FIRSTNAME=?, LASTNAME=?, FAVORITETEAM=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, firstNameField.getText());
            ps.setString(2, lastNameField.getText());
            ps.setString(3, teamField.getText());
            ps.setInt(4, Integer.parseInt(idField.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Record updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Update failed (ID not found)");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error updating record");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // Load MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Run GUI
        new FanGUI();
    }
}