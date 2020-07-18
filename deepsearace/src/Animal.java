import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Animal {

	private double speed;
	private String name, info;
	private Image frame1, frame2;
	private int posX = 0, posY = 0;
	
	public Animal(double speed, String name, Image frame1, Image frame2, String info) {
		setSpeed(speed);
		setName(name);
		setFrame1(frame1);
		setFrame2(frame2);
		this.info = info;
	}
	
	//setters
	public void setSpeed(double s) {
		this.speed = s;
	}
	
	public void setName (String n) {
		this.name = n;
	}
	
	public void setPosX (int x) {
		this.posX = x;
	}
	
	public void setPosY (int y) {
		this.posY = y;
	}
	
	public void setFrame1(Image frame) {
		this.frame1 = frame;
	}
	
	public void setFrame2(Image frame) {
		this.frame2 = frame;
	}
	
	//getters
	public String getName() {
		return name;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public String getInfo() {
		return info;
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
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public Object clone() {
		return new Animal(speed, name, frame1, frame2, info);
	}
	
}
