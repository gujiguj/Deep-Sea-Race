import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

@SuppressWarnings("serial")
public class AnimalSelector extends JPanel {
	
	/* List of animals and speeds such that list[j] corresponds to speeds[j] */
	final String[] animalList = {"Sea Anemone", "Great White Shark", 
			"Beluga Whale", "Harbor Seal", "Emperor Penguin", "Blue Marlin", "Box Jellyfish", 
			"Green Sea Turtle", "Blue-Ring Octopus", "Blue Crab", "Giant Clam", 
			"Sea Sponge", "Anemonefish"};
	final int[] animalSpeeds = {1, 16, 8, 8, 3, 30, 2, 16, 11, 1, 0, 0, 1};
	final String[] animalInfo = { 
			"An anemone might look like a flower, it is really an animal! Anemones are in the same class as other animals such as coral. They are brightly colored and live in warm water, and they eat fish.", 
			"Great White Sharks are in class Chondrichthyes, meaning that they are bony fish. They are the largest predatory fish on Earth, at around 15 feet and up to 5000 pounds. They are gray and blend in with the sea floor, and they swim very fast.", 
			"Beluga Whales are mammals, just like us, even though they live underwater! They are small for whales, even though they are usually 13 to 20 feet long and weigh around 1 ton. They eat fish, worms, and other small creatures. They are very social, using different clicks, whistles, and more to talk to each other.", 
			"Seals can be found on every continent, though most live in colder waters. They have lots of blubber and fur to keep themselves warm. Harbor seals weigh about 130 pounds and are usually around 5 feet long. They eat small sea creatures such as squid, fish, and mollusks. They also don't chew their food!", 
			"Emperor Penguins live in Antarctica. They are birds. Instead of flying, they are adapted to swim. They are around 45 inches tall and can weight up to 88 pounds, and they eat fish.", 
			"The Blue Marlin are one of the largest and fastest fish. They are blue and silver, with an upper jaw shaped like a spear. They can be up to 14 feet long and weight almost 2000 pounds. They usually eat smaller fish on the warmer surface of the ocean, but sometimes they dive deeper to eat squid.", 
			"Box Jellyfish are simple creatures that can be clear or a vibrant color (such as pink, yellow, blue, etc.). They can be found floating with the currents all across the ocean. They have small stinging cells to stun their prey, which includes fish, shrimp, crabs, and tiny plants.", 
			"Green Sea Turtles are the largest species of hard-shelled sea turtle. They can be up to 5 feet long and weight up to 700 pounds. Sea turtles live along of the coastlines of almost every continent. They live underwater, but sometime sunbathe on land. As herbivores (plant eaters), they eat seaweed and sea grass.", 
			"The Blue-Ring Octopus has a round body with two bulging eyes and eight long arms. They live in warm, tropical waters. They are usually 1 to 3 feet long and weigh anywhere from 6 to 22 pounds. Their diet includes crabs, shrimp, and lobsters, though they sometimes attack other predators, such as sharks.", 
			"Blue Crabs are swimming crustaceans with blue claws and olive-green shells. They live mainly in the Chesapeake Bay. They can be up to 4 inches long and 9 inches wide and weight 1 to 2 pounds. They will eat almost anything, including clams, mussels, fish, and plants.", 
			"Giant Clams are giant – they can be 4 feet long, and weigh more than 500 pounds. They reach this size by eating the sugars and proteins from the billions of algae living in their tissue. They sit in one place for their entire lives, which is in the warms waters of the South Pacific and Indian Oceans.", 
			"Sea Sponges are the least complex animal. They don't have tissues, organs, or a central nervous system. They don't usually move. Their cell walls completely cover the body and are dominated by small pores.", 
			"Anemonefish (also called Clownfish) are about 4.3 inches long. They live in sea anemone in warm, tropical waters, since they are adapted be immune to the anemone's sting. In exchange for a place to live, the clownfish drives off intruders and eats the anemone's parasites." 
		};
	final String[] seaAnemone = {"sea anemone1.png", "sea anemone2.png"};
	final String[] greatWhiteShark = {"great white shark1.png", "great white shark2.png"};
	final String[] belugaWhale = {"beluga whale1.png", "beluga whale2.png"};
	final String[] harborSeal = {"harbor seal1.png", "harbor seal2.png"};
	final String[] emperorPenguin = {"emperor penguin1.png", "emperor penguin2.png"};
	final String[] marlin = {"marlin1.png", "marlin2.png"};
	final String[] boxJellyfish = {"box jellyfish1.png", "box jellyfish2.png"};
	final String[] greenSeaTurtle = {"green sea turtle1.png", "green sea turtle2.png"};
	final String[] blueRingedOctopus = {"blue-ringed octopus1.png", "blue-ringed octopus2.png"};
	final String[] blueCrab = {"blue crab1.png", "blue crab2.png"};
	final String[] giantClam = {"giant clam1.png", "giant clam2.png"};
	final String[] seaSponge = {"sea sponge1.png", "sea sponge2.png"};
	final String[] anemonefish = {"anemonefish1.png", "anemonefish2.png"};
	final String[][] animalImages = {
			seaAnemone, 
			greatWhiteShark, 
			belugaWhale, 
			harborSeal, 
			emperorPenguin, 
			marlin, 
			boxJellyfish,
			greenSeaTurtle,
			blueRingedOctopus,
			blueCrab,
			giantClam,
			seaSponge,
			anemonefish
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
		
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		final JLabel instr = new JLabel(
				"<html>There are 228,450 known species of animals that live in the ocean, and there could be about 2 millions more that we don't know about! Below are just a few. <br> Click on a button to learn more about the animal! Select 2 animals to race, and click \"To Race\" to proceed.</html>");
		north.add(instr);
		
		
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
		infoLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 25, 0));
		infoPanel.add(selectBtn);
		infoPanel.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 200));
		
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
					animalList[j], animalImages[j][0], animalImages[j][1], animalInfo[j]));
			
			final JButton btn = new JButton(animalList[j]);
			btn.addActionListener(e -> {
				infoPanel.setVisible(true);
				infoLabel.setText("<html>" + animals.get(btn.getText()).getInfo() + "</html>");
				nameLabel.setText("<html><h1>" + btn.getText() + "</h1></html>");
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
		name = name.replaceAll("<\\/*html>", "");
		name = name.replaceAll("<\\/*h1>", "");
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
