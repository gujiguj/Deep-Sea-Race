import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.*;
import java.awt.*;

/* Holds all the logic */
@SuppressWarnings("serial")
public class Functions extends JPanel {
	private Animal a1, a2;
	
	public static final int INTERVAL = 35; 
	public static final int A1_INIT_Y = 100, A2_INIT_Y = 300, INIT_X = 25;
	public static final int WIDTH = 2500, HEIGHT = 500;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	JLabel status;
	final Timer timer = new Timer(INTERVAL, e -> tick());
	
	private boolean running;
	
	public Functions(Animal a1, Animal a2, JLabel status) {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		this.a1 = a1;
		this.a2 = a2;
		
		a1.posY = A1_INIT_Y;
		a2.posY = A2_INIT_Y;
		a1.posX = INIT_X;
		a2.posX = INIT_X;
		 
		this.status = status;
		status.setText("Ready to start!");
		
		running = false;
	}
	
	/* Resets animal position to initial if not running */
	public void reset() {
		if (!running) {
			a1.posX = INIT_X;
			a2.posX = INIT_X;
			repaint();
			status.setText("Ready to start!");
		}
	}
	
	/* Starts the timer so animals move */
	public void start() {
		reset();
		timer.restart();
		running = true;
		status.setText("Running...");
	}
	
	/* Called every 35ms by timer.
	 * 
	 * Moves animals if not at the end of the screen, stops and displays winner otherwise */
	private void tick() { 
		if (running && a1.posX < screenSize.width - 10 && a2.posX < screenSize.width - 10) {
			a1.posX += a1.speedConversion();
			a2.posX += a2.speedConversion();
			repaint();
		} else {
			running = false;
			timer.stop();
			
			if (a1.posX  >= screenSize.width - 10) {
				status.setText(a1.name + " wins!");
			} else if (a2.posX  >= screenSize.width - 10) {
				status.setText(a2.name + " wins!");
			} else {
				status.setText("It's a draw!");
			}
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		a1.draw(g);
		a2.draw(g);
	} 
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
}
