package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controleur.GestionCharge;
import controleur.GestionTableCharge;

import java.awt.Font;

public class Charge extends JFrame{

	private JPanel contentPane;
	private JTable tableLogement;
	private JTable tableCharges;
	private GestionTableCharge gestionTable;
	private GestionCharge gestionClic;
	private JButton bAjouterCharge;
	private JButton bImprimerTotal;
	private JButton bRegularisation ;

	public Charge() {
		this.gestionClic = new GestionCharge(this);
		this.gestionTable = new GestionTableCharge(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setBackground(new Color(28, 12, 78));
		
		JLabel Charges = new JLabel("Charges");
		Charges.setForeground(Color.WHITE);
		Charges.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		panel.add(Charges);
		
		JPanel mid = new JPanel();
		contentPane.add(mid, BorderLayout.CENTER);
		mid.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_1 = new JPanel();
		mid.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.NORTH);
		panel_4.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel = new JLabel("Logement");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_4.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		tableLogement = new JTable();
		tableLogement.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Rue", "Code Postal", "N\u00B0", "Nom", "Pr\u00E9nom"
			}
		));
		this.tableLogement.getSelectionModel().addListSelectionListener(this.gestionTable);
		scrollPane_1.setViewportView(tableLogement);
		
		JPanel taxe = new JPanel();
		mid.add(taxe);
		taxe.setLayout(new BorderLayout(0, 0));
		taxe.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		
		JPanel panel_3 = new JPanel();
		taxe.add(panel_3, BorderLayout.NORTH);
		panel_3.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_1 = new JLabel("Charges");
		lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_3.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		taxe.add(scrollPane, BorderLayout.CENTER);
		
		tableCharges = new JTable();
		tableCharges.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Nom", "Index", "Montant"
			}
		));
		scrollPane.setViewportView(tableCharges);
		
		JPanel panel_2 = new JPanel();
		mid.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Taxe Fonciere");
		panel_5.add(lblNewLabel_3);
		
		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10, BorderLayout.CENTER);
		
		JLabel lblNewLabel_6 = new JLabel("Revenu a D\u00E9clarer :");
		panel_10.add(lblNewLabel_6);
		
		JLabel lblTotal = new JLabel("Somme Loyer * nbmois  appart d'un logement - ordure");
		panel_10.add(lblTotal);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		panel_9.setBackground(new Color(45, 72, 224));
		
		JButton bQuit = new JButton("Quitter");
		bQuit.addActionListener(this.gestionClic);
		bQuit.setBackground(new Color(220, 20, 60));
		bQuit.setForeground(Color.WHITE);
		panel_9.add(bQuit);
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		panel_8.setBackground(new Color(45, 72, 224));
		
		bImprimerTotal = new JButton("Imprimer Total");
		bImprimerTotal.addActionListener(this.gestionClic);
		
		bAjouterCharge = new JButton("Ajouter une charge");
		bAjouterCharge.addActionListener(this.gestionClic);
		panel_8.add(bAjouterCharge);
		bImprimerTotal.setBackground(Color.WHITE);
		bAjouterCharge.setEnabled(false);
		bImprimerTotal.setEnabled(false);
		panel_8.add(bImprimerTotal);
		
		this.bRegularisation = new JButton("Regularisation");
		this.bRegularisation.addActionListener(this.gestionClic);
		this.bRegularisation.setEnabled(true);
		this.bRegularisation.setBackground(Color.WHITE);
		panel_8.add(this.bRegularisation);
	}

	public JTable getTableLogement() {
		return tableLogement;
	}

	public void setTableLogement(JTable tableLogement) {
		this.tableLogement = tableLogement;
	}

	public JTable getTableCharges() {
		return tableCharges;
	}

	public void setTableCharges(JTable tableCharges) {
		this.tableCharges = tableCharges;
	}

	public JButton getbAjouterCharge() {
		return bAjouterCharge;
	}
	
	public JButton getbImprimerTotal() {
		return bImprimerTotal;
	}

	public JButton getbRegularisation() {
		return bRegularisation;
	}

	public void setbRegularisation(JButton bRegularisation) {
		this.bRegularisation = bRegularisation;
	}
	
	
	
}
