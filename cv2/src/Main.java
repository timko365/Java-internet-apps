import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Simple Swing App");

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        frame.setSize(300, 200);

        // Create a JPanel to hold components
        JPanel panel = new JPanel();

        // Create a button
        JButton button = new JButton("Klikni tu!");

        // Another button
        JButton button2 = new JButton("Click me!");

        // Add an ActionListener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show a message dialog when the button is clicked
                JOptionPane.showMessageDialog(frame, "Button Clicked!");
            }
        });

        //Add action to the new button
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent f) {
                // Show a message dialog when the button is clicked
                JOptionPane.showMessageDialog(frame, "Just quit!");
            }
        });

        // Add the button to the panel
        panel.add(button);

        // Add another button
        panel.add(button2);
        // Add the panel to the frame
        frame.add(panel);
        // Set the frame to be visible
        frame.setVisible(true);
    }
}
