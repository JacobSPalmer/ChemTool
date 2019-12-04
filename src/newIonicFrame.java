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

//This is a JFrame class that sets up the creation of a new ionic molecule

public class newIonicFrame extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField[] TextArray = new JTextField[6];
	private JTextField IUPACNameInput;
	private JTextField molecularFormInput;
	private JTextField molecularWeightInput;
	private JTextField MeltingPointInput;
	private JTextField SolubilityInput;
	private JTextField PhysicalStateInput;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newIonicFrame frame = new newIonicFrame();
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

	public newIonicFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddMolecule = new JLabel("Add Ionic Molecule:");
		lblAddMolecule.setFont(new Font("PingFang SC", Font.BOLD | Font.ITALIC, 14));
		lblAddMolecule.setBounds(6, 6, 190, 16);
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
		lblMolecularWeight.setBounds(10, 142, 136, 16);
		contentPane.add(lblMolecularWeight);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ion newIonic = new ion(IUPACNameInput.getText(), molecularFormInput.getText(), Double.parseDouble(molecularWeightInput.getText()));
					newIonic.setMeltingPoint(Double.parseDouble(MeltingPointInput.getText()));;
					newIonic.setSolubility(Double.parseDouble(SolubilityInput.getText()));
					newIonic.setPhysicalState(PhysicalStateInput.getText());
					File file = new File("newIonicFrame.java");
					String strD = file.getAbsolutePath();
					String strDP = strD.replace("newIonicFrame.java", "");
					FileWriter fileWriter = new FileWriter(strDP + "molecules/" + IUPACNameInput.getText());
					PrintWriter printWriter = new PrintWriter(fileWriter);		
					printWriter.print(newIonic);
					printWriter.close();
				}catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Error #1. \n Please fill out all fields (if value isnt known please enter 0.0)!");
				} catch (Exception e1) {
						e1.printStackTrace();
				}
			}
			
		});
		btnSave.setBounds(94, 220, 117, 29);
		contentPane.add(btnSave);
		
		JLabel lblMeltingPointc = new JLabel("Melting Point (C):");
		lblMeltingPointc.setBounds(155, 38, 117, 16);
		contentPane.add(lblMeltingPointc);
		
		JLabel lblSolubilitygml = new JLabel("Solubility (g/mL):");
		lblSolubilitygml.setBounds(158, 92, 114, 16);
		contentPane.add(lblSolubilitygml);
		
		JLabel lblPhysicalState = new JLabel("Physical State:");
		lblPhysicalState.setBounds(158, 142, 130, 16);
		contentPane.add(lblPhysicalState);
		
		MeltingPointInput = new JTextField();
		MeltingPointInput.setBounds(155, 60, 130, 26);
		contentPane.add(MeltingPointInput);
		MeltingPointInput.setColumns(10);
		
		SolubilityInput = new JTextField();
		SolubilityInput.setBounds(155, 111, 130, 26);
		contentPane.add(SolubilityInput);
		SolubilityInput.setColumns(10);
		
		PhysicalStateInput = new JTextField();
		PhysicalStateInput.setBounds(158, 163, 130, 26);
		contentPane.add(PhysicalStateInput);
		PhysicalStateInput.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TextArray[0] = IUPACNameInput;
				TextArray[1] = molecularFormInput;
				TextArray[2] = molecularWeightInput;
				TextArray[3] = MeltingPointInput;
				TextArray[4] = SolubilityInput;
				TextArray[5] = PhysicalStateInput;
				
				clearTextFieldArray(TextArray);
				
			}
		});
		btnClear.setBounds(218, 220, 117, 29);
		contentPane.add(btnClear);
	}
}
