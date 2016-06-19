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
				
		setPreferredSize(new Dimension(400, 400));
		setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.drawRect(25, 25, 350, 350);
		rocketFlight(g);
		
	}
	
	public void rocketFlight(Graphics g){
	
		double x2 = 0;
		double y2 = 0;
		
		for(int i = 0; i <= time; i++) {
			x = 25 + xvel * i;
			y = 370 - yvel * i - 0.5 * (-9.8) * Math.pow(i, 2);
			g.setColor(Color.blue);
			g.fillOval((int)x, (int)y, 5, 5);
		}				
	}
	
	public void setFlightParameters(int v, int a){
		
		x = 25;
		y = 375;
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
