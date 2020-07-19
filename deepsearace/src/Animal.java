import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Animal{

	private double speed;
	private String name, info;
	private Image curFrame;
	private Image frame1, frame2;
	private String frameName1, frameName2;
	private int posX = 0, posY = 0;
	final String imgPath = "src/files/";
	
	public Animal(double speed, String name, String frame1, String frame2, String info) {
		setSpeed(speed);
		setName(name);
		setFrame1(frame1);
		setFrame2(frame2);
		curFrame = this.frame1;
		this.frameName1 = frame1;
		this.frameName2 = frame2;
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
	
	public void setFrame1(String frameName) {
		Image i;
		try {
			i = ImageIO.read(new File(imgPath + frameName));
			this.frame1 = i;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setFrame2(String frameName) {
		Image i;
		try {
			i = ImageIO.read(new File(imgPath + frameName));
			this.frame2 = i;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public Image getFrame1() {
		return frame1;
	}
	
	public Image getFrame2() {
		return frame2;
	}
	
	//convert speed into a pixel speed
	public int speedConversion() {
		return (int) speed;
	}
	
	//change curFrame
	public void changeFrame() {
		if (curFrame == frame1) {
			curFrame = frame2;
		} else {
			curFrame = frame1;
		}
	}
	
	//render graphics (i'm assuming this will use swing?)
	public void draw(Graphics g) { 
		//g.setColor(Color.BLUE);
		//g.fillOval(posX, posY, 25, 25);
		g.drawImage(curFrame, posX, posY, null);
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public Object clone() {
		return new Animal(speed, name, frameName1, frameName2, info);
	}
	
}
