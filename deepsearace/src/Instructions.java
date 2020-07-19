import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Instructions extends JPanel {
	
	public Instructions(JButton cont) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		final JLabel title = new JLabel("<html><h1>Deep Sea Race</h1></html>", SwingConstants.CENTER);
		this.add(title);
		
		final JLabel about = new JLabel(
				"<html><h3>Learn about different sea creatures, and see how fast they move in a race!</h3></html>", 
				SwingConstants.CENTER);
		this.add(about);
		
		final JLabel about2 = new JLabel("<html><h3>Click the button to try it out!</h3></html>", SwingConstants.CENTER);
		this.add(about2);
		
		this.add(cont);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(new javax.swing.plaf.FontUIResource("Sans serif",Font.PLAIN,12));
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, Functions.WIDTH, Functions.HEIGHT);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Functions.WIDTH, Functions.HEIGHT);
	}
}
