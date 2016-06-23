package projectileMotionSim;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;

/**
 * Class handles drawing the flight data in the sim window
 * 
 * @author Garrett Singletary
 */
  
public class PMSimDraw extends JPanel {

	private int velocity;
	private double angle;
	private double xvel;
	private double yvel;
	private double time;
	
	/**
	 * Constructor
	 */
	public PMSimDraw(){
				
		setPreferredSize(new Dimension(550, 550));
		setBackground(Color.WHITE);
	}
	
	/**
	 * Paint override
	 * 
	 * @param g Graphics
	 */
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		// sim window outline
		g.drawRect(50, 50, 450, 450);
		
		int xcor = 50;
		int ycor = 500;
		int tickcounter = 0;
		
		// x axis reference marks every 50m
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
		
		// y axis reference marks every 50m
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
		
		// gernerate flight path plot
		rocketFlight(g);	
	}
	
	/**
	 * Plots the projectile flight path using dots
	 *
	 * @param g Graphics
	 */
	public void rocketFlight(Graphics g){
		
		double x;
		double y;
		
		// plot trajectory once per second of flight time
		for(int i = 0; i <= time; i++) {
			x = 50 + xvel * i;
			y = 495 - yvel * i - 0.5 * (-9.8) * Math.pow(i, 2);
			g.setColor(Color.blue);
			g.fillOval((int)x, (int)y, 5, 5);
		}				
	}
	
	/**
	 * Computes x and y velocities and total flight time
	 * 
	 * @param v Initial velocity
	 * @param a Initial angle
	 */
	public void setFlightParameters(int v, int a){
		
		angle = a;
		velocity = v;
		// compute x and y velocities
		xvel = velocity * Math.cos(angle);
		yvel = velocity * Math.sin(angle);
		// compute flight time
		time = -yvel / (0.5 * -9.8);	
	}
	
	/**
	 * @return Total flight time
	 */
	public double getTime(){
		return time;
	}
	
	/**
	 * @return Max altitude reached
	 */
	public double getAltitude(){
		return (yvel * yvel)* Math.pow(Math.sin(angle), 2) / (2 * 9.8);
	}
	
	/**
	 * @return Total distance traveled
	 */
	public double getDist(){
		return xvel * time;
	}
	

	

}
