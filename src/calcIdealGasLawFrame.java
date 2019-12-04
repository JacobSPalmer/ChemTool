import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class calcIdealGasLawFrame extends JFrame {

	private JPanel contentPane;
	private JLabel labelUnknown;
	private JTextField textUnknown;
	private JTextField textTemperature;
	private JTextField textVolume;
	private JTextField textMoles;
	private JTextField textPressure;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private boolean pressureActive = false;
	private boolean molesActive = false;
	private boolean tempActive = false;
	private boolean volumeActive = false;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calcIdealGasLawFrame frame = new calcIdealGasLawFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public calcIdealGasLawFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JRadioButton rdbtnPressure = new JRadioButton("Pressure");
		buttonGroup.add(rdbtnPressure);
		rdbtnPressure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				prime(textVolume);
				prime(textTemperature);
				prime(textMoles);
				unknown(textPressure, textUnknown);
				pressureActive = true;
				volumeActive = false;
				tempActive = false;
				molesActive =false;
				labelUnknown.setText("Pressure");
				
			}
		});
		contentPane.setLayout(null);
		rdbtnPressure.setBounds(20, 65, 141, 23);
		contentPane.add(rdbtnPressure);
		
		JRadioButton rdbtnTemperature = new JRadioButton("Temperature");
		rdbtnTemperature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				prime(textVolume);
				prime(textPressure);
				prime(textMoles);
				unknown(textTemperature, textUnknown);
				pressureActive = false;
				volumeActive = false;
				tempActive = true;
				molesActive =false;
				labelUnknown.setText("Temperature");
				
			}
		});
		buttonGroup.add(rdbtnTemperature);
		rdbtnTemperature.setBounds(20, 100, 141, 23);
		contentPane.add(rdbtnTemperature);
		
		JRadioButton rdbtnMoles = new JRadioButton("Moles");
		rdbtnMoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				prime(textVolume);
				prime(textTemperature);
				prime(textPressure);
				unknown(textMoles, textUnknown);
				pressureActive = false;
				volumeActive = false;
				tempActive = false;
				molesActive =true;
				labelUnknown.setText("Moles");
				
			}
		});
		buttonGroup.add(rdbtnMoles);
		rdbtnMoles.setBounds(20, 135, 141, 23);
		contentPane.add(rdbtnMoles);
		
		JRadioButton rdbtnVolume = new JRadioButton("Volume");
		rdbtnVolume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				prime(textMoles);
				prime(textTemperature);
				prime(textPressure);
				unknown(textVolume, textUnknown);
				pressureActive = false;
				volumeActive = true;
				tempActive = false;
				molesActive =false;
				labelUnknown.setText("Volume");
				
			}
		});
		buttonGroup.add(rdbtnVolume);
		rdbtnVolume.setBounds(20, 170, 141, 23);
		contentPane.add(rdbtnVolume);
		
		JLabel lblSelectWhichTo = new JLabel("Select which to solve for:");
		lblSelectWhichTo.setBounds(20, 43, 158, 16);
		contentPane.add(lblSelectWhichTo);
		
		textUnknown = new JTextField();
		textUnknown.setBounds(281, 251, 181, 26);
		contentPane.add(textUnknown);
		textUnknown.setColumns(10);
		textUnknown.setEditable(false);
		
		labelUnknown = new JLabel("Unknown");
		labelUnknown.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		labelUnknown.setBounds(281, 235, 111, 16);
		contentPane.add(labelUnknown);
		
		textTemperature = new JTextField();
		textTemperature.setBounds(221, 82, 130, 26);
		contentPane.add(textTemperature);
		textTemperature.setColumns(10);
		
		textVolume = new JTextField();
		textVolume.setBounds(221, 150, 130, 26);
		contentPane.add(textVolume);
		textVolume.setColumns(10);
		
		textMoles = new JTextField();
		textMoles.setBounds(401, 150, 130, 26);
		contentPane.add(textMoles);
		textMoles.setColumns(10);
		
		textPressure = new JTextField();
		textPressure.setBackground(Color.WHITE);
		textPressure.setBounds(401, 82, 130, 26);
		contentPane.add(textPressure);
		textPressure.setColumns(10);
		
		JLabel lblTemperaturek = new JLabel("Temperature (k)");
		lblTemperaturek.setBounds(221, 65, 99, 16);
		contentPane.add(lblTemperaturek);
		
		JLabel lblVolume = new JLabel("Volume (L)");
		lblVolume.setBounds(221, 133, 106, 16);
		contentPane.add(lblVolume);
		
		JLabel lblPressureatm = new JLabel("Pressure (atm)");
		lblPressureatm.setBounds(401, 65, 99, 16);
		contentPane.add(lblPressureatm);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pressureActive == true) {
					try {
						
						float temp, volume, moles, pressure, contR = (float) .082057;
						String pressureString;
						temp = Float.parseFloat(textTemperature.getText());
						volume = Float.parseFloat(textVolume.getText());
						moles  = Float.parseFloat(textMoles.getText());
						pressure = (moles * temp * contR)/volume;
						pressureString = Float.toString(pressure);
						textUnknown.setText(pressureString);
						
					}catch(Exception e1) {
						
						JOptionPane.showMessageDialog(null, "Please enter a valid input!");
					}
				}
				if(volumeActive == true) {
					try {
						
						float temp, volume, moles, pressure, contR = (float) .082057;
						String volumeString;
						temp = Float.parseFloat(textTemperature.getText());
						moles  = Float.parseFloat(textMoles.getText());
						pressure  = Float.parseFloat(textPressure.getText());
						volume = (moles * temp * contR)/pressure;
						volumeString = Float.toString(volume);
						textUnknown.setText(volumeString);
						
						
					}catch(Exception e1) {
						
						JOptionPane.showMessageDialog(null, "Please enter a valid input!");
					}
				}
				if(molesActive == true) {
					try {
						
						float temp, volume, moles, pressure, contR = (float) .082057;
						String molesString;
						temp = Float.parseFloat(textTemperature.getText());
						volume  = Float.parseFloat(textVolume.getText());
						pressure  = Float.parseFloat(textPressure.getText());
						moles = (pressure * volume)/(temp * contR);
						molesString = Float.toString(moles);
						textUnknown.setText(molesString);
						
						
					}catch(Exception e1) {
						
						JOptionPane.showMessageDialog(null, "Please enter a valid input!");
					}
				}
				if(tempActive == true) {
					try {
						
						float temp, volume, moles, pressure, contR = (float) .082057;
						String tempString;
						moles = Float.parseFloat(textMoles.getText());
						volume  = Float.parseFloat(textVolume.getText());
						pressure  = Float.parseFloat(textPressure.getText());
						temp = (pressure * volume)/(moles * contR);
						tempString = Float.toString(temp);
						textUnknown.setText(tempString);
						
						
					}catch(Exception e1) {
						
						JOptionPane.showMessageDialog(null, "Please enter a valid input!");
					}
				}
				else if((tempActive == false) && (pressureActive == false) && (volumeActive == false) && (molesActive == false)){
					JOptionPane.showMessageDialog(null, "Please select an unknown to solve for!");
				}
				
			}
		});
		btnCalculate.setBounds(316, 194, 117, 29);
		contentPane.add(btnCalculate);
		
		JLabel lblMoles = new JLabel("Moles");
		lblMoles.setBounds(401, 135, 61, 16);
		contentPane.add(lblMoles);
		
		JLabel lblIdealGasLaw = new JLabel("Ideal Gas Law Calculator");
		lblIdealGasLaw.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblIdealGasLaw.setBounds(6, 8, 212, 23);
		contentPane.add(lblIdealGasLaw);
	}
	
	public void prime(JTextField text) {
		text.setText("");
		text.setBackground(Color.WHITE);
		text.setEditable(true);
	}
	
	public void unknown(JTextField text, JTextField unknown) {
		text.setText("");
		unknown.setText("");
		text.setBackground(SystemColor.windowBorder);
		text.setEditable(false);
	}

}
