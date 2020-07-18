import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

@SuppressWarnings("serial")
public class AnimalSelector extends JPanel {
	
	/* List of animals and speeds such that list[j] corresponds to speeds[j] */
	final String[] animalList = {"Sea Anemone", "Great White Shark", 
			"Beluga Whale", "Seal", "Emperor Penguin", "Marlin", "Box Jellyfish", 
			"Green Sea Turtle", "Blue-Ring Octopus", "Blue Crab", "Giant Clam", 
			"Sea Sponge", "Anemonefish"};
	final int[] animalSpeeds = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	final String[] animalInfo = { 
			"Sea Anemone info here", 
			"Great White Shark", 
			"Beluga Whale", 
			"Seal", 
			"Emperor Penguin", 
			"Marlin", 
			"Box Jellyfish", 
			"Green Sea Turtle", 
			"Blue-Ring Octopus", 
			"Blue Crab", 
			"Giant Clam", 
			"Sea Sponge", 
			"Anemonefish" 
		};
	HashMap<String, Animal> animals;
	
	Animal[] selected;
	int i = 0;
	final JLabel selectedLabel, nameLabel, infoLabel;
	final JPanel btnPanel1, btnPanel2, infoPanel;
	final JButton selectBtn;
	
	public AnimalSelector(JButton cont) {	
		this.setLayout(new BorderLayout());
		
		final JPanel north = new JPanel();
		this.add(north, BorderLayout.NORTH);
		final JPanel south = new JPanel();
		this.add(south, BorderLayout.SOUTH);
		
		final JLabel instr = new JLabel("Click on a button to learn more about the animal! \n"
				+ "Select 2 animals to race, and click \"To Race\" to proceed.");
		north.add(instr);
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		
		animals = new HashMap<>();
		btnPanel1 = new JPanel();
		btnPanel2 = new JPanel();
		addAnimalChoices();
		north.add(btnPanel1);
		north.add(btnPanel2);
		
		selected = new Animal[2];
		
		infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoLabel = new JLabel();
		nameLabel = new JLabel();
		selectBtn = new JButton("Select this animal!");
		selectBtn.addActionListener(e -> setAnimal(e, nameLabel.getText()));
		nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		selectBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		infoPanel.add(nameLabel);
		infoPanel.add(infoLabel);
		infoPanel.add(selectBtn);
		
		this.add(infoPanel, BorderLayout.CENTER);
		infoPanel.setVisible(false);
		
		selectedLabel = new JLabel("Selected: None");
		south.add(selectedLabel);
		south.add(cont);	
	}
	
	/* Creates the buttons and maps name to object */
	private void addAnimalChoices() {
		for (int j = 0; j < animalList.length; j++) {
			animals.put(animalList[j], new Animal(animalSpeeds[j], 
					animalList[j], null, null, animalInfo[j]));
			
			final JButton btn = new JButton(animalList[j]);
			btn.addActionListener(e -> {
				infoPanel.setVisible(true);
				infoLabel.setText(animals.get(btn.getText()).getInfo());
				nameLabel.setText(btn.getText());
			});
			
			if (j < animalList.length / 2) {
				btnPanel1.add(btn);
			} else {
				btnPanel2.add(btn);
			}
			
		}
	}
	
	/* Uses button presses to select which animals to use */
	private void setAnimal(ActionEvent e, String name) {
		((JButton) e.getSource()).setBackground(Color.BLUE);
		
		if (i == 0) {
			selected[0] = animals.get(name);
			i++;
			selectedLabel.setText("Selected: " + selected[0].toString());
		} else if (selected[1] == null) {
			selected[1] = animals.get(name);
			selectedLabel.setText("Selected: " + selected[0].toString() + ", " + selected[1].toString());
		} else {
			selected[1] = selected[0];
			selected[0] = animals.get(name);
			selectedLabel.setText("Selected: " + selected[0].toString() + ", " + selected[1].toString());
		}
	}
	
	/* Return function for the race panel to use */
	public Animal[] getSelectedAnimals() {
		if (selected[0] == null || selected[1] == null) {
			throw new IllegalArgumentException("Need to select 2 animals!");
		}
		
		if (selected[0] == selected[1]) {
			selected[1] = (Animal) selected[0].clone();
		}
		
		return selected;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Functions.WIDTH, Functions.HEIGHT);
	}
	
}
