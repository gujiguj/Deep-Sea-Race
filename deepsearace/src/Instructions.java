import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Instructions extends JPanel {
	
	public Instructions(JButton cont) {
		final JLabel label = new JLabel(
				"DEEP SEA RACE\n"
				+ "Learn about sea animals, and see how fast they move!\n"
				+ "Click continue to move try it out!");
		this.add(label);
		this.add(cont);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Functions.WIDTH, Functions.HEIGHT);
	}
}
