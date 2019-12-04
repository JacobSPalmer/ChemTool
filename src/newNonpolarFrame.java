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

public class newNonpolarFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField IUPACNameInput;
	private JTextField molecularFormInput;
	private JTextField molecularWeightInput;
	private JTextField PhysicalStateInput;
	private JTextField MeltingPointInput;
	private JTextField BoilingPointInput;
	private JTextField ElectronegativityInput;
	private JTextField DipoleMomentInput;
	private JTextField[] TextArray = new JTextField[8];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newNonpolarFrame frame = new newNonpolarFrame();
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

	public newNonpolarFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddMolecule = new JLabel("Add Non-Polar Molecule:");
		lblAddMolecule.setFont(new Font("PingFang SC", Font.BOLD | Font.ITALIC, 14));
		lblAddMolecule.setBounds(6, 6, 193, 16);
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
		lblMolecularWeight.setBounds(10, 142, 139, 16);
		contentPane.add(lblMolecularWeight);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					nonpolar newNonpolar = new nonpolar(IUPACNameInput.getText(), molecularFormInput.getText(), Double.parseDouble(molecularWeightInput.getText()));
					newNonpolar.setBoilingPoint(Double.parseDouble(BoilingPointInput.getText()));
					newNonpolar.setMeltingPoint(Double.parseDouble(MeltingPointInput.getText()));
					newNonpolar.setDipoleMoment(Double.parseDouble(DipoleMomentInput.getText()));
					newNonpolar.setElectronegativity(Double.parseDouble(ElectronegativityInput.getText()));
					newNonpolar.setPhysicalState(PhysicalStateInput.getText());
					File file = new File("newNonpolarFrame.java");
					String strD = file.getAbsolutePath();
					String strDP = strD.replace("newNonpolarFrame.java", "");
					FileWriter fileWriter = new FileWriter(strDP + "molecules/" + IUPACNameInput.getText());
					PrintWriter printWriter = new PrintWriter(fileWriter);		
					printWriter.print(newNonpolar);
					printWriter.close();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Error #1. \n Please fill out all fields (if value isnt known please enter 0.0)!");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			});
		btnSave.setBounds(104, 220, 117, 29);
		contentPane.add(btnSave);
		
		JLabel lblPhysicalState = new JLabel("Physical State:");
		lblPhysicalState.setBounds(152, 38, 101, 16);
		contentPane.add(lblPhysicalState);
		
		PhysicalStateInput = new JTextField();
		PhysicalStateInput.setBounds(152, 60, 130, 26);
		contentPane.add(PhysicalStateInput);
		PhysicalStateInput.setColumns(10);
		
		JLabel lblMeltingPoint = new JLabel("Melting Point (C):");
		lblMeltingPoint.setBounds(152, 92, 124, 16);
		contentPane.add(lblMeltingPoint);
		
		MeltingPointInput = new JTextField();
		MeltingPointInput.setBounds(152, 111, 130, 26);
		contentPane.add(MeltingPointInput);
		MeltingPointInput.setColumns(10);
		
		JLabel lblBoilingPointc = new JLabel("Boiling Point (C):");
		lblBoilingPointc.setBounds(152, 142, 124, 16);
		contentPane.add(lblBoilingPointc);
		
		BoilingPointInput = new JTextField();
		BoilingPointInput.setBounds(152, 163, 130, 26);
		contentPane.add(BoilingPointInput);
		BoilingPointInput.setColumns(10);
		
		JLabel lblElectronegativity = new JLabel("Electronegativity:");
		lblElectronegativity.setBounds(288, 38, 124, 16);
		contentPane.add(lblElectronegativity);
		
		JLabel lblDipoleMoment = new JLabel("Dipole Moment:");
		lblDipoleMoment.setBounds(288, 92, 124, 16);
		contentPane.add(lblDipoleMoment);
		
		ElectronegativityInput = new JTextField();
		ElectronegativityInput.setBounds(294, 60, 130, 26);
		contentPane.add(ElectronegativityInput);
		ElectronegativityInput.setColumns(10);
		
		DipoleMomentInput = new JTextField();
		DipoleMomentInput.setBounds(294, 111, 130, 26);
		contentPane.add(DipoleMomentInput);
		DipoleMomentInput.setColumns(10);
		
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
				TextArray[7] = DipoleMomentInput;
				
				clearTextFieldArray(TextArray);
			}
		});
		btnClear.setBounds(241, 220, 117, 29);
		contentPane.add(btnClear);
	}
}
