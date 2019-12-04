import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

//This is a JFrame class that sets up the creation of a polar molecule

public class newPolarFrame extends JFrame {

	private JPanel contentPane;
	private JTextField IUPACNameInput;
	private JTextField molecularFormInput;
	private JTextField molecularWeightInput;
	private JTextField PhysicalStateInput;
	private JTextField MeltingPointInput;
	private JTextField BoilingPointInput;
	private JTextField ElectronegativityInput;
	private JTextField SolubilityInput;
	private JTextField ConductiveInput;
	private JTextField[] TextArray = new JTextField[9];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newPolarFrame frame = new newPolarFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void clearTextFieldArray(JTextField[] TextFieldArray) {
		JTextField temp;
		for(int i = 1; i < TextFieldArray.length; i++) {
			temp = TextFieldArray[i];
			temp.setText("");
		}
		JOptionPane.showMessageDialog(null, "Input boxes cleared!");
	}

	public newPolarFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddMolecule = new JLabel("Add Polar Molecule:");
		lblAddMolecule.setFont(new Font("PingFang SC", Font.BOLD | Font.ITALIC, 14));
		lblAddMolecule.setBounds(6, 6, 165, 16);
		contentPane.add(lblAddMolecule);
		
		IUPACNameInput = new JTextField();
		IUPACNameInput.setBounds(6, 60, 130, 26);
		contentPane.add(IUPACNameInput);
		IUPACNameInput.setColumns(10);
		
		JLabel lblIupacName = new JLabel("IUPAC Name:");
		lblIupacName.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblIupacName.setBounds(16, 38, 124, 16);
		contentPane.add(lblIupacName);
		
		molecularFormInput = new JTextField();
		molecularFormInput.setBounds(6, 111, 130, 26);
		contentPane.add(molecularFormInput);
		molecularFormInput.setColumns(10);
		
		JLabel lblMolecularFormula = new JLabel("Molecular Formula:");
		lblMolecularFormula.setBounds(16, 92, 130, 16);
		contentPane.add(lblMolecularFormula);
		
		molecularWeightInput = new JTextField();
		molecularWeightInput.setBounds(10, 163, 130, 26);
		contentPane.add(molecularWeightInput);
		molecularWeightInput.setColumns(10);
		
		JLabel lblMolecularWeight = new JLabel("Molecular Weight (g):");
		lblMolecularWeight.setBounds(10, 142, 144, 16);
		contentPane.add(lblMolecularWeight);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					polar newPolar = new polar(IUPACNameInput.getText(), molecularFormInput.getText(), Double.parseDouble(molecularWeightInput.getText()));
					newPolar.setBoilingPoint(Double.parseDouble(BoilingPointInput.getText()));
					newPolar.setMeltingPoint(Double.parseDouble(MeltingPointInput.getText()));
					newPolar.setElectronegativity(Double.parseDouble(ElectronegativityInput.getText()));
					newPolar.setPhysicalState(PhysicalStateInput.getText());
					newPolar.setSolubility(Double.parseDouble(SolubilityInput.getText()));
					newPolar.conductElectricity(ConductiveInput.getText());
					File file = new File("newPolarFrame.java");
					String strD = file.getAbsolutePath();
					String strDP = strD.replace("newPolarFrame.java", "");
					FileWriter fileWriter = new FileWriter(strDP + "molecules/" + IUPACNameInput.getText());
					PrintWriter printWriter = new PrintWriter(fileWriter);		
					printWriter.print(newPolar);
					printWriter.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error. \n Please fill out all fields (if value isnt known please enter 0.0)!");
				}
			}
			
		});
		btnSave.setBounds(108, 220, 117, 29);
		contentPane.add(btnSave);
		
		JLabel lblPhysicalState = new JLabel("Physical State:");
		lblPhysicalState.setBounds(152, 38, 97, 16);
		contentPane.add(lblPhysicalState);
		
		JLabel lblMeltingPointc = new JLabel("Melting Point (C):");
		lblMeltingPointc.setBounds(152, 92, 117, 16);
		contentPane.add(lblMeltingPointc);
		
		JLabel lblBoilingPointc = new JLabel("Boiling Point (C): ");
		lblBoilingPointc.setBounds(152, 142, 119, 16);
		contentPane.add(lblBoilingPointc);
		
		JLabel lblElectronegativity = new JLabel("Electronegativity: ");
		lblElectronegativity.setBounds(296, 38, 119, 16);
		contentPane.add(lblElectronegativity);
		
		JLabel lblSolubility = new JLabel("Solubility (g/mL): ");
		lblSolubility.setBounds(296, 92, 130, 16);
		contentPane.add(lblSolubility);
		
		JLabel lblConducive = new JLabel("Conductive:");
		lblConducive.setBounds(296, 142, 91, 16);
		contentPane.add(lblConducive);
		
		PhysicalStateInput = new JTextField();
		PhysicalStateInput.setBounds(148, 60, 130, 26);
		contentPane.add(PhysicalStateInput);
		PhysicalStateInput.setColumns(10);
		
		MeltingPointInput = new JTextField();
		MeltingPointInput.setBounds(148, 111, 130, 26);
		contentPane.add(MeltingPointInput);
		MeltingPointInput.setColumns(10);
		
		BoilingPointInput = new JTextField();
		BoilingPointInput.setBounds(152, 163, 130, 26);
		contentPane.add(BoilingPointInput);
		BoilingPointInput.setColumns(10);
		
		ElectronegativityInput = new JTextField();
		ElectronegativityInput.setBounds(296, 60, 130, 26);
		contentPane.add(ElectronegativityInput);
		ElectronegativityInput.setColumns(10);
		
		SolubilityInput = new JTextField();
		SolubilityInput.setBounds(296, 111, 130, 26);
		contentPane.add(SolubilityInput);
		SolubilityInput.setColumns(10);
		
		ConductiveInput = new JTextField();
		ConductiveInput.setBounds(296, 163, 130, 26);
		contentPane.add(ConductiveInput);
		ConductiveInput.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TextArray[0] = IUPACNameInput;
				TextArray[1] = molecularFormInput;
				TextArray[2] = molecularWeightInput;
				TextArray[3] = PhysicalStateInput;
				TextArray[4] = MeltingPointInput;
				TextArray[5] = BoilingPointInput;
				TextArray[6] = ElectronegativityInput;
				TextArray[7] = SolubilityInput;
				TextArray[8] = ConductiveInput;
				
				clearTextFieldArray(TextArray);
				
			}
		});
		btnClear.setBounds(251, 220, 117, 29);
		contentPane.add(btnClear);
	
	}
}
