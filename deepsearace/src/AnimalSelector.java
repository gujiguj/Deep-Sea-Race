import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class AnimalSelector extends JPanel {

	public AnimalSelector(JButton cont) {
		final JLabel label = new JLabel(
				"This is where you select animals");
		this.add(label);
		this.add(cont);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Functions.WIDTH, Functions.HEIGHT);
	}
	
}
