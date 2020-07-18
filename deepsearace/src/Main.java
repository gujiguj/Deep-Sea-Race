import java.awt.BorderLayout;

import javax.swing.*;

/* Draw everything, run to interact */
class Main implements Runnable {

	boolean instructions = true, select = false, running = false;
	
	@Override
	public void run() {
        final JFrame frame = new JFrame("Deep Sea Race");
        frame.setLocation(100, 100);

        /* Status panel (updated by `func`) */
        final JPanel statusPanel = new JPanel();
        frame.add(statusPanel, BorderLayout.SOUTH);
        
        final JLabel status = new JLabel();
        statusPanel.add(status);
        
        /* Back/forwards buttons */
        JButton continueToRace = new JButton("To Race");
        continueToRace.addActionListener(e -> {
        		running = true;
        		instructions = false;
        		select = false;
        		run();
    		}
		);
        
        JButton continueToSelector = new JButton("To Animal Selector");
        continueToSelector.addActionListener(e -> {
        		running = false;
        		instructions = false;
        		select = true;
        		run();
    		}
		);
        
        /* Main racing area */
        Animal a1 = new Animal(5, "Octopus", null, null);
        Animal a2 = new Animal(10, "Squid", null, null);
        
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);
        
        JPanel main = new Instructions(continueToSelector);
        if (instructions) {
        	main = new Instructions(continueToSelector);
        } else if (select) {
        	main = new AnimalSelector(continueToRace);
		} else {
        	main = new Functions(a1, a2, status, continueToSelector);
        	Functions func = (Functions) main;
            control_panel.add(continueToSelector);
        	
        	final JButton reset = new JButton("Reset");
            reset.addActionListener(e -> func.reset());
            control_panel.add(reset);

            final JButton start = new JButton("Start");
            start.addActionListener(e -> func.start());
            control_panel.add(start);
        }

        frame.add(main, BorderLayout.CENTER);

        /* Control panel with reset and start buttons */
        

        
        
        /* Put frame on screen */
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main());
	}
		
}