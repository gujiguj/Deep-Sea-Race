import java.awt.Color;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import java.awt.*;

/* Holds all the logic */
@SuppressWarnings("serial")
public class Functions extends JPanel {
	private Animal a1, a2;
	
	public static final int INTERVAL = 35; 
	public static final int FRAMERATE = 1000;
	public static final int A1_INIT_Y = 100, A2_INIT_Y = 300, INIT_X = 25;
	public static final int WIDTH = 2500, HEIGHT = 500;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	JLabel status;
	JButton back;
	final Timer timer = new Timer(INTERVAL, e -> tick());
	final Timer animationTimer = new Timer(FRAMERATE, e -> shift());
	
	private boolean running;
	
	public Functions(Animal a1, Animal a2, JLabel status, JButton back) {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		this.a1 = a1;
		this.a2 = a2;
		
		a1.setPosY(A1_INIT_Y);
		a2.setPosY(A2_INIT_Y);
		a1.setPosX(INIT_X);
		a2.setPosX(INIT_X);
		 
		this.status = status;
		status.setText("Ready to start!");
		
		this.back = back;
		running = false;
	}
	
	/* Resets animal position to initial if not running */
	public void reset() {
		if (!running) {
			a1.setPosX(INIT_X);
			a2.setPosX(INIT_X);
			repaint();
			status.setText("Ready to start!");
		}
	}
	
	/* Starts the timer so animals move */
	public void start() {
		reset();
		timer.restart();
		animationTimer.restart();
		running = true;
		status.setText("Running...");
	}
	
	/* Called every 35ms by timer.
	 * 
	 * Moves animals if not at the end of the screen, stops and displays winner otherwise */
	private void tick() { 
		if (running && a1.speedConversion() == 0 && a2.speedConversion() == 0) {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			running = false;
		} else if (running && a1.getPosX() < screenSize.width - 10 && a2.getPosX() < screenSize.width - 10) {
			a1.setPosX(a1.getPosX() + a1.speedConversion());
			a2.setPosX(a2.getPosX() + a2.speedConversion());
			repaint();
		} else {
			running = false;
			timer.stop();
			
			if (a1.speedConversion() == 0 && a2.speedConversion() == 0) {
				status.setText("Doesn't look like these two are going to move today...");
			} else if (a1.getPosX()  >= screenSize.width - 10) {
				status.setText(a1.getName() + " wins!");
			} else if (a2.getPosX()  >= screenSize.width - 10) {
				status.setText(a2.getName() + " wins!");
			} else {
				status.setText("It's a draw!");
			}
		}
		
	}
	
	//Called every 1s by timer. "Animates" the animal. (2 frame animation)
	private void shift() { 
		if (running) {
			a1.changeFrame();
			a2.changeFrame();
			repaint();
		} else {
			running = false;
			animationTimer.stop();
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
