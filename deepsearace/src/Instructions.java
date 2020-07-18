import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

@SuppressWarnings("serial")
public class Instructions extends JPanel {
	Image bg;
	
	public Instructions(JButton cont) {
		try {
			bg = ImageIO.read(new File("/Users/ayang19/Documents/Programming/Deep-Sea-Race/deepsearace/files/front.png"));
		} catch (Exception e) {
			System.out.println(e);
		}
		this.setLayout(new BorderLayout());
		this.add(cont, BorderLayout.SOUTH);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, null);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Functions.WIDTH, Functions.HEIGHT);
	}
}
