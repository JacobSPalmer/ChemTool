import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class calcFreeEnergyFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textTemp;
	private JTextField textEnthalpy;
	private JTextField textEntropy;
	private JTextField textGibbs;
	private JTextField textFavorability;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calcFreeEnergyFrame frame = new calcFreeEnergyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public calcFreeEnergyFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFreeEnergyCalculation = new JLabel("Free Energy Calculation");
		lblFreeEnergyCalculation.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblFreeEnergyCalculation.setBounds(6, 6, 216, 26);
		contentPane.add(lblFreeEnergyCalculation);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float Temperature, Enthalpy, Entropy, Gibbs;
				String GibbsText;
				
				try {
					Temperature = Float.parseFloat(textTemp.getText());
					Enthalpy = Float.parseFloat(textEnthalpy.getText());
					Entropy = Float.parseFloat(textEntropy.getText());
					Entropy = Entropy / 1000;
					Gibbs = Enthalpy - (Temperature * Entropy);
					GibbsText = Float.toString(Gibbs);
					textGibbs.setText(GibbsText);
					if(Gibbs >= 0) {
						textFavorability.setText("Non-spontaneuous");
					}
					else if(Gibbs < 0) {
						textFavorability.setText("Spontaneuous");
					}
				}catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Please enter a valid input (limited to integers)");
				}
			}
		});
		btnCalculate.setBounds(171, 224, 102, 29);
		contentPane.add(btnCalculate);
		
		textTemp = new JTextField();
		textTemp.setBounds(40, 131, 130, 26);
		contentPane.add(textTemp);
		textTemp.setColumns(10);
		
		JLabel lblTemperaturecelcius = new JLabel("Temperature (kelvin)");
		lblTemperaturecelcius.setBounds(40, 103, 129, 16);
		contentPane.add(lblTemperaturecelcius);
		
		textEnthalpy = new JTextField();
		textEnthalpy.setBounds(40, 194, 130, 26);
		contentPane.add(textEnthalpy);
		textEnthalpy.setColumns(10);
		
		textEntropy = new JTextField();
		textEntropy.setBounds(39, 64, 130, 26);
		contentPane.add(textEntropy);
		textEntropy.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Entropy (J/kelvin * mol)");
		lblNewLabel.setBounds(29, 44, 147, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnthalpykjmol = new JLabel("Enthalpy (kJ/mol)");
		lblEnthalpykjmol.setBounds(50, 169, 109, 16);
		contentPane.add(lblEnthalpykjmol);
		
		textGibbs = new JTextField();
		textGibbs.setBackground(SystemColor.windowBorder);
		textGibbs.setEditable(false);
		textGibbs.setBounds(273, 82, 130, 26);
		contentPane.add(textGibbs);
		textGibbs.setColumns(10);
		
		JLabel lblDeltaGkj = new JLabel("Delta G (kJ/mol)");
		lblDeltaGkj.setBounds(293, 64, 101, 16);
		contentPane.add(lblDeltaGkj);
		
		JLabel lblThermodynamicFavorability = new JLabel("Thermodynamic Favorability?");
		lblThermodynamicFavorability.setBounds(249, 127, 183, 16);
		contentPane.add(lblThermodynamicFavorability);
		
		textFavorability = new JTextField();
		textFavorability.setBackground(SystemColor.windowBorder);
		textFavorability.setEditable(false);
		textFavorability.setBounds(273, 145, 130, 26);
		contentPane.add(textFavorability);
		textFavorability.setColumns(10);
	}

}
