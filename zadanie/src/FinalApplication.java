import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class FinalApplication {

    public static void main(String[] args) {
        // Vytvorenie hlavného okna aplikácie
        JFrame frame = new JFrame("Electricity_v0.1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout(10, 10));

        // Vytvorenie Menu baru
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        JMenu graphMenu = new JMenu("Graph");
        JMenuItem openGraphItem = new JMenuItem("Show");
        openGraphItem.addActionListener(e -> showGraphFrame());

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> showAboutDialog(frame));

        JMenuItem guideItem = new JMenuItem("Guide");
        guideItem.addActionListener(e -> showGuideDialog(frame));

        fileMenu.add(exitItem);
        graphMenu.add(openGraphItem);
        helpMenu.add(aboutItem);
        helpMenu.add(guideItem);

        menuBar.add(fileMenu);
        menuBar.add(graphMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);

        // Vytvorenie rozloženia panelu formulára
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        // Vytvorenie poľa pre zápis dátumu
        JLabel dateLabel = new JLabel("Date:");
        JTextField dateField = new JTextField(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        formPanel.add(dateLabel);
        formPanel.add(dateField);

        // Vytvorenie poľa pre zápis času v polhodinových intervaloch
        JLabel timeLabel = new JLabel("Time:");
        JComboBox<String> timeComboBox = new JComboBox<>();
        for (int i = 0; i < 24; i++) {
            timeComboBox.addItem(String.format("%02d:00", i));
            timeComboBox.addItem(String.format("%02d:30", i));
        }
        formPanel.add(timeLabel);
        formPanel.add(timeComboBox);

        // Vytvorenie poľa pre zápis ceny od 0 po 2600
        JLabel priceLabel = new JLabel("Price:");
        JSlider priceSlider = new JSlider(0, 2600, 0);
        priceSlider.setMajorTickSpacing(500);
        priceSlider.setMinorTickSpacing(100);
        priceSlider.setPaintTicks(true);
        priceSlider.setPaintLabels(true);
        formPanel.add(priceLabel);
        formPanel.add(priceSlider);

        // Tlačidlo na potvrdenie zápisu z formulára
        JButton confirmButton = new JButton("Submit");

        // Akcia tlačidla
        confirmButton.addActionListener(e -> {
            String date = dateField.getText();
            String time = (String) timeComboBox.getSelectedItem();
            int price = priceSlider.getValue();

            if (date.isEmpty() || time == null) {
                JOptionPane.showMessageDialog(frame, "Fill in all blank spaces!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String message = String.format("Submitted:\nDate: %s\nTime: %s\nPrice: %d", date, time, price);
            JOptionPane.showMessageDialog(frame, message, "Submission Successful", JOptionPane.INFORMATION_MESSAGE);
        });

        // Vytvorenie layoutu pre formulár
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(confirmButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Vytvorenie zobrazenia grafu
    private static void showGraphFrame() {
        JFrame graphFrame = new JFrame("Graph");
        graphFrame.setSize(800, 600);
        graphFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        TimeSeries series = new TimeSeries("Price");
        Random random = new Random();
        Date now = new Date();

        // Definovanie náhodných hodnôt
        for (int i = 0; i < 10; i++) {
            series.addOrUpdate(new Second(new Date(now.getTime() + i * 1000)), random.nextInt(2600));
        }

        // Vytvorenie popisu grafu
        TimeSeriesCollection dataset = new TimeSeriesCollection(series);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Future graph of electricity prices",
                "Time",
                "Price",
                dataset,
                false,
                true,
                false
        );

        // Definovanie rozloženia layoutu pre graf
        ChartPanel chartPanel = new ChartPanel(chart);
        graphFrame.add(chartPanel, BorderLayout.CENTER);

        graphFrame.setVisible(true);
    }

    // Zobrazenie okna "O aplikácii"
    private static void showAboutDialog(JFrame parentFrame) {
        String aboutText = "Electricity_v0.1\n\nThis application allows users to:\n" +
                "- Input electricity usage data (date, time, price)\n" +
                "- View randomly generated electricity price trends in a graph\n\n" +
                "Created as a Java GUI project with dynamic graphing functionality.";
        JOptionPane.showMessageDialog(parentFrame, aboutText, "About", JOptionPane.INFORMATION_MESSAGE);
    }

    // Zobrazenie okna "Návod"
    private static void showGuideDialog(JFrame parentFrame) {
        String guideText = "Guide for using the application:\n\n" +
                "1. Enter a date in the Date field.\n" +
                "2. Select a time from the dropdown menu.\n" +
                "3. Adjust the price using the slider.\n" +
                "4. Click the 'Submit' button to log the data.\n" +
                "5. To view a graph of electricity prices, select 'Graph -> Show' from the menu.\n" +
                "6. Use 'File -> Exit' to close the application.";
        JOptionPane.showMessageDialog(parentFrame, guideText, "Guide", JOptionPane.INFORMATION_MESSAGE);
    }
}
