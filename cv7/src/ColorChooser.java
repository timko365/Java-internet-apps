import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorChooser {
    public static void main(String[] args) {
        // Creating the main window
        JFrame frame = new JFrame("Color chooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout(10, 10));

        // Panel for changing the color
        JPanel colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(400, 150));
        colorPanel.setBackground(Color.BLACK); // Default color

        // Panel for RGB
        JPanel sliderPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        // Red slider
        JSlider redSlider = new JSlider(0, 255, 0);
        redSlider.setMajorTickSpacing(50);
        redSlider.setMinorTickSpacing(10);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(true);

        // Green slider
        JSlider greenSlider = new JSlider(0, 255, 0);
        greenSlider.setMajorTickSpacing(50);
        greenSlider.setMinorTickSpacing(10);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(true);

        // Blue slider
        JSlider blueSlider = new JSlider(0, 255, 0);
        blueSlider.setMajorTickSpacing(50);
        blueSlider.setMinorTickSpacing(10);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(true);

        // Adding sliders to the panel
        sliderPanel.add(createSliderPanel("Red:", redSlider));
        sliderPanel.add(createSliderPanel("Green:", greenSlider));
        sliderPanel.add(createSliderPanel("Blue:", blueSlider));

        // Listener for changing the value of the slider
        ChangeListener changeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int red = redSlider.getValue();
                int green = greenSlider.getValue();
                int blue = blueSlider.getValue();

                // Changing the color of the panel
                Color newColor = new Color(red, green, blue);
                colorPanel.setBackground(newColor);
            }
        };

        // Connecting the action to the slider
        redSlider.addChangeListener(changeListener);
        greenSlider.addChangeListener(changeListener);
        blueSlider.addChangeListener(changeListener);

        // Adding panels to the main window
        frame.add(colorPanel, BorderLayout.CENTER);
        frame.add(sliderPanel, BorderLayout.SOUTH);

        // Showing the window
        frame.setVisible(true);
    }

    // Creating the private class for creating the panel for every slider
    private static JPanel createSliderPanel(String label, JSlider slider) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel sliderLabel = new JLabel(label);
        panel.add(sliderLabel, BorderLayout.NORTH);
        panel.add(slider, BorderLayout.CENTER);
        return panel;
    }
}
