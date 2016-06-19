package projectileMotionSim;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PMSim extends JFrame implements ActionListener{

	private JPanel drawpanel;
	private JPanel fieldpanel;
	private JPanel flightinfo;
	private JLabel vel;
	private JLabel ang;
	private JTextField velocity;
	private JTextField angle;
	private JLabel maxalt;
	private JLabel maxdist;
	private JLabel flighttime;
	private JButton run;
	private PMSimDraw drawSim;
	
	public PMSim() {
		
		setTitle("RocketSim");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(true);
		fieldpanel = new JPanel();
		vel = new JLabel("Velocity (m/s): ");
		ang = new JLabel("Angle (degrees): ");
		velocity = new JTextField(7);
		angle = new JTextField(7);
		run = new JButton("Run");
		run.addActionListener(this);
		
		fieldpanel.add(vel);
		fieldpanel.add(velocity);
		fieldpanel.add(ang);
		fieldpanel.add(angle);
		fieldpanel.add(run);
		add(fieldpanel, BorderLayout.NORTH);
	
		flightinfo = new JPanel();
		maxalt = new JLabel();
		maxalt.setText("Max Altitude (m): ");
		maxdist = new JLabel();
		maxdist.setText("Distance Traveled (m): ");
		flighttime = new JLabel();
		flighttime.setText("Flight Time (s): ");
		flightinfo.add(maxalt);
		flightinfo.add(maxdist);
		flightinfo.add(flighttime);
		add(flightinfo, BorderLayout.SOUTH);

		
		drawSim = new PMSimDraw();
		add(drawSim, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object b = e.getSource();
		
		if(b == run){
			String v = velocity.getText();
			int vel = Integer.parseInt(v);
			String a = angle.getText();
			int ang = Integer.parseInt(a);
			
			drawSim.setFlightParameters(vel, ang);
			maxalt.setText("Max Altitude (m): " + (int) drawSim.getAltitude());
			maxdist.setText("Distance Traveled (m): " + (int) drawSim.getDist());
			flighttime.setText("Flight Time (s): " + (int) drawSim.getTime());
			drawSim.repaint();
		}
	}
}
