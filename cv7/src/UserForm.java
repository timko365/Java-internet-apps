import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserForm {
    public static void main(String[] args) {
        // Creating the main window
        JFrame frame = new JFrame("User form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout(10, 10));

        // Panel for inserting the name
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel firstNameLabel = new JLabel("Name:");
        JTextField firstNameField = new JTextField();

        JLabel lastNameLabel = new JLabel("Surname:");
        JTextField lastNameField = new JTextField();

        JLabel titleLabel = new JLabel("Title:");
        JComboBox<String> titleComboBox = new JComboBox<>(new String[]{
                "Mr.", "Ms.", "M.Eng.", "MSc", "Ing.", "Bc.", "prof.", "Dr.", "RNDr."
        });

        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameField);
        inputPanel.add(lastNameLabel);
        inputPanel.add(lastNameField);
        inputPanel.add(titleLabel);
        inputPanel.add(titleComboBox);

        // Panel for the buttons
        JPanel listPanel = new JPanel(new BorderLayout());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> userList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(userList);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Erase");
        JButton clearButton = new JButton("Delete whole list");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        listPanel.add(scrollPane, BorderLayout.CENTER);
        listPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adding panels on the main window
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(listPanel, BorderLayout.CENTER);

        // Function of the button "Add"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText().trim();
                String lastName = lastNameField.getText().trim();
                String title = (String) titleComboBox.getSelectedItem();

                if (firstName.isEmpty() || lastName.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String fullName = title + " " + firstName + " " + lastName;
                    listModel.addElement(fullName);
                    firstNameField.setText("");
                    lastNameField.setText("");
                }
            }
        });

        // Functionality of the button "Erase"
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = userList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "Choose the item you want to erase!", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Functionality of the button "Delete whole list"
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.clear();
            }
        });

        // Showing the window
        frame.setVisible(true);
    }
}
