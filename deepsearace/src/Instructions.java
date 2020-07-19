import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Instructions extends JPanel {
	
	public Instructions(JButton cont) {
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(25, 250, 25, 250));
		
		final JLabel title = new JLabel("<html><h1>EXPLORE THE OCEAN!</h1></html>", SwingConstants.CENTER);
		this.add(title);
		
		final JLabel about1 = new JLabel(
				"<html><h3 style='text-align: center;'>About three-quarters of the Earth is covered by seas and oceans. "
				+ "It's what makes Earth look so blue from space! <br>Underneath the ocean's surface, "
				+ "there are a lot of plants and animals, living in waters from as shallow as just "
				+ "beyond the beach to as deep as 7 miles at the bottom of the Mariana Trench.<br><br>"
				+ "There's a lot to explore, and a lot we still don't know!</h3></html>", 
				SwingConstants.CENTER);
		this.add(about1);
		final JLabel about2 = new JLabel(
				"<html><h3>With this app, you can learn about different sea creatures, "
				+ "and see how fast they move in a race.<br></h3></html>", 
				SwingConstants.CENTER);
		this.add(about2);
		
		final JLabel clickButton = new JLabel("<html><h3>Click the button to try it out!</h3></html>", SwingConstants.CENTER);
		this.add(clickButton);

		cont.setAlignmentX(JButton.CENTER_ALIGNMENT);
		this.add(cont);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, Functions.WIDTH, Functions.HEIGHT);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Functions.WIDTH, Functions.HEIGHT);
	}
}
