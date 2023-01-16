package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;

public class DeclarationFiscale extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeclarationFiscale frame = new DeclarationFiscale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeclarationFiscale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel Haut = new JPanel();
		Haut.setBackground(new Color(28, 12, 78));
		contentPane.add(Haut, BorderLayout.NORTH);
		
		JLabel lblDeclarationFiscale = new JLabel("Declaration Fiscale");
		lblDeclarationFiscale.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeclarationFiscale.setForeground(Color.WHITE);
		lblDeclarationFiscale.setFont(new Font("Roboto Condensed", Font.PLAIN, 24));
		Haut.add(lblDeclarationFiscale);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Revenu Immobilier :");
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_2.add(lblNewLabel);
		
		JLabel labalRI = new JLabel("New label");
		labalRI.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_2.add(labalRI);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("A déclarer :");
		lblNewLabel_2.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2);
		
		JLabel labelAdeclarer = new JLabel("New label");
		labelAdeclarer.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_3.add(labelAdeclarer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Montant des travaux :");
		lblNewLabel_4.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_4);
		
		JLabel labelMontant = new JLabel("New label");
		labelMontant.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_1.add(labelMontant);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);
		panel_4.setBackground(new Color(45, 72, 224));

		JButton quitter = new JButton("Quitter");
		quitter.setForeground(Color.WHITE);
		quitter.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		quitter.setBackground(new Color(220, 20, 60));
		panel_4.add(quitter);
	}

}
