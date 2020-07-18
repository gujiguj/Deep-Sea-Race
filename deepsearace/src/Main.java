import java.awt.BorderLayout;

import javax.swing.*;

/* Draw everything, run to interact */
class Main implements Runnable {

	@Override
	public void run() {
        final JFrame frame = new JFrame("Deep Sea Race");
        frame.setLocation(100, 100);

        /* Status panel (updated by `func`) */
        final JPanel statusPanel = new JPanel();
        frame.add(statusPanel, BorderLayout.SOUTH);
        
        final JLabel status = new JLabel();
        statusPanel.add(status);
        
        /* Main racing area */
        Animal a1 = new Animal(5, "Octopus", null, null);
        Animal a2 = new Animal(10, "Squid", null, null);
        
        final Functions func = new Functions(a1, a2, status);
        frame.add(func, BorderLayout.CENTER);

        /* Control panel with reset and start buttons */
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);

        final JButton reset = new JButton("Reset");
        reset.addActionListener(e -> func.reset());
        control_panel.add(reset);

        final JButton start = new JButton("Start");
        start.addActionListener(e -> func.start());
        control_panel.add(start);
        
        /* Put frame on screen */
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        /* Start */
        func.reset();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main());
	}
		
}