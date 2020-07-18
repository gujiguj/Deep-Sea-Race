import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Animal {

	double speed;
	String name;
	Image frame1, frame2;
	int posX = 0, posY = 0;
	
	public Animal(double speed, String name, Image frame1, Image frame2) {
		this.speed = speed;
		this.name = name;
	}
	
	//convert speed into a pixel speed
	public int speedConversion() {
		return (int) speed;
	}
	
	//render graphics (i'm assuming this will use swing?)
	public void draw(Graphics g) { 
		g.setColor(Color.BLUE);
		g.fillOval(posX, posY, 25, 25);
	}
	
}
