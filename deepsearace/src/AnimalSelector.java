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
	HashMap<String, Animal> animals;
	
	Animal[] selected;
	int i = 0;
	final JLabel selectedLabel;
	
	public AnimalSelector(JButton cont) {
		this.add(cont);
		animals = new HashMap<>();
		addAnimalChoices();
		
		final JLabel label = new JLabel(
				"This is where you select animals");
		this.add(label);
		
		selected = new Animal[2];
		
		selectedLabel = new JLabel();
		this.add(selectedLabel);
	}
	
	/* Creates the buttons and maps name to object */
	private void addAnimalChoices() {
		for (int j = 0; j < animalList.length; j++) {
			animals.put(animalList[j], new Animal(animalSpeeds[j], animalList[j], null, null));
			
			final JButton btn = new JButton(animalList[j]);
			btn.addActionListener(e -> setAnimal(e, btn.getText()));
			this.add(btn);
		}
	}
	
	/* Uses button presses to select which animals to use */
	private void setAnimal(ActionEvent e, String name) {
		((JButton) e.getSource()).setBackground(Color.BLUE);
		
		if (i == 0) {
			selected[0] = animals.get(name);
			i++;
			selectedLabel.setText(selected[0].toString());
		} else if (selected[1] == null) {
			selected[1] = animals.get(name);
			selectedLabel.setText(selected[0].toString() + ", " + selected[1].toString());
		} else {
			selected[1] = selected[0];
			selected[0] = animals.get(name);
			selectedLabel.setText(selected[0].toString() + ", " + selected[1].toString());
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
