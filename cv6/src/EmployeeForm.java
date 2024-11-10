import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeForm {
    public static void main(String[] args) {
        // Creating the main window
        JFrame frame = new JFrame("Employee form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Panel for inserting the name and surname
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel firstNameLabel = new JLabel("Name:");
        JTextField firstNameField = new JTextField();
        JLabel lastNameLabel = new JLabel("Surname:");
        JTextField lastNameField = new JTextField();

        JButton submitButton = new JButton("Show");

        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameField);
        inputPanel.add(lastNameLabel);
        inputPanel.add(lastNameField);
        inputPanel.add(new JLabel());
        inputPanel.add(submitButton);

        // Panel for output - full name
        JPanel outputPanel = new JPanel();
        JLabel outputLabel = new JLabel("Full name:");
        outputPanel.add(outputLabel);

        // Adding panel on the frame
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(outputPanel, BorderLayout.SOUTH);

        // Functionality of the button, where u need to fill avery field after that it will perform action to show full name
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                if (firstName.isEmpty() || lastName.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
                    outputLabel.setText("Please fill in all fields!");
                } else {
                    outputLabel.setText("Full name: " + firstName + " " + lastName);
                }
            }
        });

        // Showing the window
        frame.setVisible(true);
    }
}
