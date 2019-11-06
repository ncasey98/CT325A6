import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LightsGUI extends JFrame {

	JPanel panel;
	
	// Variables for state 
	String onOrOff = "";
	String manualOrTimed = "";
	int intensityValue = 0;
	
	public LightsGUI() {
		
		panel = new JPanel();
		panel.setBackground(new Color(Color.HSBtoRGB(255, 255, 204)));
		
		JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 1, 4, 1);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		JButton manual = new JButton("MANUAL");
		manual.setBounds(20, 20, 95, 30);
		
		JButton timed = new JButton("TIMED");
		timed.setBounds(150, 20, 95, 30);
		
		JButton on = new JButton("ON");
		on.setBounds(20, 60, 95, 30);
		
		JButton off = new JButton("OFF");
		off.setBounds(150, 60, 95, 30);
		
		JButton state = new JButton("Display State of Lights");
		state.setBounds(400, 100, 95, 30);
		
		JLabel status = new JLabel("");
		Container container = this.getContentPane();
		container.setLayout(new GridLayout());
		
		// Add ChangeListener to slider
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (((JSlider) e.getSource()).getValue() == 1) {
					panel.setBackground(new Color(255, 255, 204));
					intensityValue = ((JSlider) e.getSource()).getValue();
				}
				if (((JSlider) e.getSource()).getValue() == 2) {
					panel.setBackground(new Color(255, 255, 153));
					intensityValue = ((JSlider) e.getSource()).getValue();
				}
				if (((JSlider) e.getSource()).getValue() == 3) {
					panel.setBackground(new Color(255, 255, 102));
					intensityValue = ((JSlider) e.getSource()).getValue();
				}
				if (((JSlider) e.getSource()).getValue() == 4) {
					panel.setBackground(new Color(255, 255, 51));
					intensityValue = ((JSlider) e.getSource()).getValue();
				}
			}
		});
		
		// Add ActionListener to 'on and 'off' buttons 
		on.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(new Color(255, 255, 204));
			}
		});
		
		on.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(new Color(0, 0, 0));
			}
		});
		
		// Add ActionListener to 'manual' and 'timed' buttons 
		manual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manualOrTimed = "Manual";
			}
		});
		
		timed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manualOrTimed = "Timed";
			}
		});
		
		// Add Change Listener to 'state' button
		state.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				status.setText("The lights are " + onOrOff + ", set to " + manualOrTimed + " and the intensity is " + intensityValue);
			}
		});
		
		// Add the slider to the panel
		container.add(slider);
		container.add(on);
		container.add(off);
		container.add(manual);
		container.add(timed);
		container.add(state);
		
		container.add(panel);
	}
	
	public static void main(String args[]) {
		LightsGUI gui = new LightsGUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setTitle("Lights Controller");
		gui.setSize(400, 200);
	}
	
}
