import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

//This is the frame for searching through the stored database of molecules
//It utilizes a series of file searches and native directory windows the automatically pull up the molecules folder and access its contents

public class moleculeDatabaseFrame extends JFrame {

	private JPanel contentPane;
	private static moleculeDatabaseFrame newframe;
	
	public static void main(String... args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newframe = new moleculeDatabaseFrame();
					newframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public moleculeDatabaseFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
//This piece of code sets the directory for the JFileChooser module that opens the file directory
		File fileSource = new File("moleculeDatabaseFrame.java");
		String strD = fileSource.getAbsolutePath();
		String strDP = strD.replace("moleculeDatabaseFrame.java", "");
		JFileChooser moleculeSelectDialogWindow = new JFileChooser(strDP + "molecules/");
		
	    JTextArea textArea = new JTextArea();
	    textArea.setBounds(6, 31, 438, 217);
	    textArea.setEditable(false);
	    contentPane.add(textArea);
		
	    JButton readButton = new JButton("Select A Molecule");
	    readButton.setBounds(123, 256, 193, 16);
	    readButton.addActionListener(ev -> {
	      int returnVal = moleculeSelectDialogWindow.showOpenDialog(newframe);
	      if (returnVal == JFileChooser.APPROVE_OPTION) {
	        File file = moleculeSelectDialogWindow.getSelectedFile();
	        try {
	          BufferedReader input = new BufferedReader(new InputStreamReader(
	              new FileInputStream(file)));
	          textArea.read(input, "");
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
	      }
	    });
	    contentPane.add(readButton);
	    
	    JLabel lblMolecularDatabase = new JLabel("Molecular Database:");
	    lblMolecularDatabase.setFont(new Font("PingFang SC", Font.BOLD | Font.ITALIC, 14));
	    lblMolecularDatabase.setBounds(6, 6, 139, 16);
	    contentPane.add(lblMolecularDatabase);
	    
	}
}
