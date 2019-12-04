import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

//This is a JFrame class that prompts the user to select which type of molecule to create and is quite simplistic in nature

public class moleculeTypeWindow extends JFrame {

	private JPanel contentPane;
	private static moleculeTypeWindow frame = new moleculeTypeWindow();;
	private newNonpolarFrame NPF = new newNonpolarFrame();
	private newPolarFrame PF = new newPolarFrame();
	private newIonicFrame IF = new newIonicFrame();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public moleculeTypeWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectMoleculeType = new JLabel("Select Molecule Type:");
		lblSelectMoleculeType.setBounds(142, 72, 153, 16);
		contentPane.add(lblSelectMoleculeType);
		
		JButton btnIonic = new JButton("Ionic");
		btnIonic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				IF.setVisible(true);

			}
		});
		btnIonic.setBounds(152, 100, 117, 29);
		contentPane.add(btnIonic);
		
		JButton btnNonpolar = new JButton("Non-Polar");
		btnNonpolar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				NPF.setVisible(true);
			}
		});
		btnNonpolar.setBounds(152, 133, 117, 29);
		contentPane.add(btnNonpolar);
		
		JButton btnPolar = new JButton("Polar");
		btnPolar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				PF.setVisible(true);
			}
		});
		btnPolar.setBounds(152, 163, 117, 29);
		contentPane.add(btnPolar);
		
		JLabel lblCreateANew = new JLabel("Create A New Molecule:");
		lblCreateANew.setFont(new Font("PingFang SC", Font.BOLD | Font.ITALIC, 16));
		lblCreateANew.setBounds(6, 6, 209, 16);
		contentPane.add(lblCreateANew);
	}
}
