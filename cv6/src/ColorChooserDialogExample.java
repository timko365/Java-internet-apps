import java.awt.BorderLayout; 
import java.awt.Color; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import javax.swing.BorderFactory; 
import javax.swing.ImageIcon; 
import javax.swing.JButton; 
import javax.swing.JColorChooser; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JToolBar; 
public class ColorChooserDialogExample extends JFrame { 
	private JPanel mainPanel; 
	private JPanel drawingPanel; 
	private Color chooseColor() { 
		// metóda otvorí dialóg a vracia farbu 
		JColorChooser colorChooser = new JColorChooser(); 
		// zobrazíme dialógové okno, návratová hodnota je zvolená farba 
		Color color = colorChooser.showDialog(mainPanel, "Choose Color", Color.white); 
		drawingPanel.setBackground(color); 
		return color; 
		} 
	public ColorChooserDialogExample() { // konštruktor 
		setTitle("Color Chooser Dialog Example"); 
		mainPanel = new JPanel(); 
		mainPanel.setLayout(new BorderLayout()); 
		drawingPanel = new JPanel(); 
		drawingPanel.setBackground(Color.WHITE); 
		ImageIcon colorTableIcon = new ImageIcon("palette.png"); 
		JToolBar toolbar = new JToolBar(); 
		JButton openButton = new JButton(colorTableIcon); 
		openButton.addActionListener(new ActionListener() { 
			// obsluha udalostí 
			public void actionPerformed(ActionEvent event) { 
				// po kliknutí na tlaèidlo sa zavolá metóda chooseColor() 
				drawingPanel.setBackground(chooseColor()); 
				}// a nastaví sa nová farba panelu 
			}); 
		// Keï sa myšou klikne na panel, tak sa tiež vyvolá dialóg pre výber farby 
		drawingPanel.addMouseListener(new MouseListener() { 
			public void mouseClicked(MouseEvent e) { 
				drawingPanel.setBackground(chooseColor());
				} 
			 
			public void mouseReleased(MouseEvent e) { } 
			 
			public void mouseEntered(MouseEvent e) { } 
			 
			public void mouseExited(MouseEvent e) { } 
			 
			public void mousePressed(MouseEvent e) { } 
			}); 
		toolbar.add(openButton);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50)); 
		mainPanel.add(drawingPanel); 
		add(mainPanel); 
		add(toolbar, BorderLayout.NORTH); 
		setSize(400, 400); 
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true); 
		} 
	public static void main(String[] args) { 
		new ColorChooserDialogExample(); 
		} 
}

