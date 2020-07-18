import java.awt.Color;

import javax.swing.*;
import java.awt.*;

/* Holds all the logic */
@SuppressWarnings("serial")
public class Functions extends JPanel {
	private Animal a1, a2;
	
	public static final int INTERVAL = 35; 
	public static final int A1_INIT_Y = 100, A2_INIT_Y = 300, INIT_X = 25;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	JLabel status;
	Timer timer;
	
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
		
		timer = new Timer(INTERVAL, e -> tick());
	}
	
	public void reset() {
		a1.posX = INIT_X;
		a2.posX = INIT_X;
		status.setText("Ready to start!");
	}
	
	public void start() {
		timer.start();
		status.setText("Running...");
	}
	
	private void tick() { 
		if (a1.posX < screenSize.width - 10 && a2.posX < screenSize.width - 10) {
			a1.posX += a1.speedConversion();
			a2.posX += a2.speedConversion();
		} else {
			timer.stop();
			if (a1.posX  >= screenSize.width - 10) {
				status.setText(a1.name + " wins!");
			} else if (a1.posX  >= screenSize.width - 10) {
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
}
