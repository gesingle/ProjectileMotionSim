package projectileMotionSim;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
public class PMSimDraw extends JPanel {

	private int velocity;
	private double angle;
	private double xvel;
	private double yvel;
	private double x;
	private double y;
	private double time;
	
	public PMSimDraw(){
				
		setPreferredSize(new Dimension(550, 550));
		setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.drawRect(50, 50, 450, 450);
		
		int xcor = 50;
		int ycor = 500;
		int tickcounter = 0;
		
		for(int i = 0; i < 10; i++){
			g.drawLine(xcor, 500, xcor, 505);
			if(i == 0){
				g.drawString("" + tickcounter + "", xcor, 525);
			}
			else if(i == 2){
				g.drawString("" + tickcounter + "", xcor - 8, 525);
			}
			else{
				g.drawString("" + tickcounter + "", xcor - 12, 525);
			}
			xcor += 50;
			tickcounter += 50;
		}
		
		tickcounter = 0;
		
		for(int i = 0; i < 10; i++){
			g.drawLine(45, ycor, 50, ycor);
			if(i == 0){
				g.drawString("" + tickcounter + "", 25, ycor + 5);
			}
			else if(i == 1){
				g.drawString("" + tickcounter + "", 20, ycor + 5);
			}
			else{
				g.drawString("" + tickcounter + "", 15, ycor + 5);
			}
			ycor -= 50;
			tickcounter += 50;
		}
		
		rocketFlight(g);	
	}
	
	public void rocketFlight(Graphics g){
		
		double x;
		double y;
		
		for(int i = 0; i <= time; i++) {
			x = 50 + xvel * i;
			y = 495 - yvel * i - 0.5 * (-9.8) * Math.pow(i, 2);
			g.setColor(Color.blue);
			g.fillOval((int)x, (int)y, 5, 5);
		}				
	}
	
	public void setFlightParameters(int v, int a){
		
		angle = a;
		velocity = v;
		xvel = velocity * Math.cos(Math.toRadians(angle));
		yvel = velocity * Math.sin(Math.toRadians(angle));
		time = -yvel / (0.5 * -9.8);	
	}
	
	public double getTime(){
		return time;
	}
	
	public double getAltitude(){
		return (yvel * time) / 2;
	}
	
	public double getDist(){
		return xvel * time;
	}
	

	

}
