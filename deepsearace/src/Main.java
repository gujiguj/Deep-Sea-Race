import java.awt.BorderLayout;

import javax.swing.*;

/* Draw everything, run to interact */
class Main implements Runnable {

	boolean instructions = true, select = false, running = false;
	Animal a1, a2;
	
	@Override
	public void run() {
        final JFrame frame = new JFrame("Explore the Ocean!");
        frame.setLocation(100, 100);
        

        /* Back/forwards buttons */
        final JButton continueToRace = new JButton("To Race");
        final JButton continueToSelector = new JButton("To Animal Selector");
        
        /* Panels */
        Instructions instrPanel = new Instructions(continueToSelector);
        continueToSelector.addActionListener(e -> {
	    		running = false;
	    		instructions = false;
	    		select = true; 
	    		frame.dispose();
	    		run();
			}
		);
        AnimalSelector selectorPanel = new AnimalSelector(continueToRace);
        continueToRace.addActionListener(e -> {
	        	try {
	        		a1 = ((AnimalSelector) selectorPanel).getSelectedAnimals()[0];
	        		a2 = ((AnimalSelector) selectorPanel).getSelectedAnimals()[1];
	        		running = true;
	        		instructions = false;
	        		select = false;
	        		frame.dispose();
	        		run();
	        	} catch (IllegalArgumentException ex) { 
	        		running = false;
	        	} 
			}
		);
    	
    	final JPanel controlPanel = new JPanel();
        frame.add(controlPanel, BorderLayout.NORTH);
        
        final JPanel statusPanel = new JPanel();
        frame.add(statusPanel, BorderLayout.SOUTH);
        
        final JLabel status = new JLabel();
        statusPanel.add(status);
        
        /* Changing main area */
        JPanel main = instrPanel;
        if (instructions) {
        	main = instrPanel;
        } else if (select) {
        	main = selectorPanel;
		} else {
			Functions funcPanel = new Functions(a1, a2, status, continueToSelector);
        	
			controlPanel.add(continueToSelector);
        	
        	final JButton reset = new JButton("Reset");
            reset.addActionListener(e -> funcPanel.reset());
            controlPanel.add(reset);

            final JButton start = new JButton("Start");
            start.addActionListener(e -> funcPanel.start());
            controlPanel.add(start);
            main = funcPanel;
        }

        frame.add(main, BorderLayout.CENTER);

        /* Put frame on screen */
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main());
	}
		
}