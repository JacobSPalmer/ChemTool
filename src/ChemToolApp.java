import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class ChemToolApp {

	private JFrame frame;
	private moleculeTypeWindow newMoleculeFrame = new moleculeTypeWindow();
	private moleculeDatabaseFrame newMolDataFrame = new moleculeDatabaseFrame();
	private calcIdealGasLawFrame idealGasLawFrame = new calcIdealGasLawFrame();
	private calcFreeEnergyFrame freeEnergyCalc = new calcFreeEnergyFrame();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChemToolApp window = new ChemToolApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChemToolApp() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewMolecule = new JButton("Store a New Molecule");
		btnNewMolecule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				newMoleculeFrame.setVisible(true);
				
			}
		});
		btnNewMolecule.setBounds(21, 90, 165, 29);
		frame.getContentPane().add(btnNewMolecule);
		
		JButton btnIdealGasLaw = new JButton("Ideal Gas Law");
		btnIdealGasLaw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				idealGasLawFrame.setVisible(true);
				
			}
		});
		btnIdealGasLaw.setBounds(228, 90, 187, 29);
		frame.getContentPane().add(btnIdealGasLaw);
		
		JButton btnSearchMolecule = new JButton("Search Exisiting Molecules");
		btnSearchMolecule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				newMolDataFrame.setVisible(true);
				
			}
		});
		btnSearchMolecule.setBounds(6, 118, 200, 29);
		frame.getContentPane().add(btnSearchMolecule);
		
		JLabel lblMolecularRepository = new JLabel("Molecular Repository");
		lblMolecularRepository.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblMolecularRepository.setBounds(30, 71, 156, 16);
		frame.getContentPane().add(lblMolecularRepository);
		
		JLabel lblChemicalFormulaCalculators = new JLabel("Chemical Formula Calculators");
		lblChemicalFormulaCalculators.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblChemicalFormulaCalculators.setBounds(216, 71, 216, 16);
		frame.getContentPane().add(lblChemicalFormulaCalculators);
		
		JButton btnGibbsFreeEnergy = new JButton("Gibbs Free Energy");
		btnGibbsFreeEnergy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				freeEnergyCalc.setVisible(true);
				
			}
		});
		btnGibbsFreeEnergy.setBounds(248, 118, 156, 29);
		frame.getContentPane().add(btnGibbsFreeEnergy);
		
		JButton btnOpenReadMe = new JButton("Open Read Me");
		btnOpenReadMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("README.txt");        
		        Desktop desktop = Desktop.getDesktop();
		        try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOpenReadMe.setBounds(157, 185, 117, 29);
		frame.getContentPane().add(btnOpenReadMe);
		
		JButton btnSetDirector = new JButton("Set Directory");
		btnSetDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("MolecularRepositoryMenu.java");
				String strD = file.getAbsolutePath();
				String strDP = strD.replace("MolecularRepositoryMenu.java", "");
				FileWriter fileWriter;
				try {
					fileWriter = new FileWriter("directoryconfig.txt");
					PrintWriter printWriter = new PrintWriter(fileWriter);		
					printWriter.print(strDP + "molecules/");
					printWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSetDirector.setBounds(157, 213, 117, 29);
		frame.getContentPane().add(btnSetDirector);
		
		JButton btnOpenDirectory = new JButton("Open Directory");
		btnOpenDirectory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("directoryconfig.txt");
		        Desktop desktop = Desktop.getDesktop();
		        try {
					desktop.open(file);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOpenDirectory.setBounds(145, 243, 139, 29);
		frame.getContentPane().add(btnOpenDirectory);
		
		JLabel lblNewLabel = new JLabel("Configuration");
		lblNewLabel.setBounds(171, 167, 94, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Chem Tool V0.1");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel_1.setBounds(6, 6, 200, 44);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
