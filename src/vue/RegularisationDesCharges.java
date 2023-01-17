package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionRegularisationCharges;
import modele.Logement;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegularisationDesCharges extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField fieldIndexFinal;
	private JTextField fieldPrix;
	private JComboBox<Logement> comboBoxLogement ;
	private JButton bValLog ;
	private JLabel labelJour ;
	private JLabel labelRegularisation ;
	private JPanel panelDroite ;

	private GestionRegularisationCharges gestionClic ;

	public RegularisationDesCharges() {
		
		this.gestionClic = new GestionRegularisationCharges(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel Haut = new JPanel();
		Haut.setBackground(new Color(28, 12, 78));
		contentPane.add(Haut, BorderLayout.NORTH);
		
		JLabel lblRegulariserDesCharges = new JLabel("R�gularisation Annuelle");
		lblRegulariserDesCharges.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegulariserDesCharges.setForeground(Color.WHITE);
		lblRegulariserDesCharges.setFont(new Font("Roboto Condensed", Font.PLAIN, 24));
		Haut.add(lblRegulariserDesCharges);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		
		JPanel titre = new JPanel();
		titre.setBackground(new Color(28, 12, 78));
		panel_1.add(titre, BorderLayout.NORTH);
		titre.setBackground(new Color(45, 72, 224));
		
		JLabel titreeee = new JLabel("Choisir un Logement");
		titreeee.setForeground(Color.WHITE);
		titreeee.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		titre.add(titreeee);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_2.add(panel_4);
		
		this.comboBoxLogement = new JComboBox<Logement>();
		panel_4.add(this.comboBoxLogement);
		
		this.bValLog = new JButton("Valider");
		this.bValLog.addActionListener(this.gestionClic);
		this.bValLog.setForeground(Color.WHITE);
		this.bValLog.setBackground(new Color(152, 251, 152));
		panel_4.add(this.bValLog);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_5 = new JLabel("Regulariation");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_3.add(panel_8, BorderLayout.CENTER);
		
		this.labelRegularisation = new JLabel("R�gularisation possible dans");
		this.labelRegularisation.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_8.add(this.labelRegularisation);
		
		this.labelJour = new JLabel("New label");
		this.labelJour.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_8.add(this.labelJour);
		
		this.panelDroite = new JPanel();
		panel.add(this.panelDroite);
		this.panelDroite.setLayout(new GridLayout(2, 0, 0, 0));
		this.panelDroite.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		
		
		JPanel panel_5 = new JPanel();
		this.panelDroite.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"Nom", "Index", "Pr\u00E9vision"
				}
				));
		scrollPane.setViewportView(table);
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13, BorderLayout.NORTH);
		panel_13.setBackground(new Color(45, 72, 224));
		
		JLabel lblCharges = new JLabel("Charges");
		lblCharges.setForeground(Color.WHITE);
		lblCharges.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		panel_13.add(lblCharges);
		
		JPanel panel_6 = new JPanel();
		this.panelDroite.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_6.add(panel_7);
		
		JLabel lblNewLabel_4_1 = new JLabel("Index Final :");
		panel_7.add(lblNewLabel_4_1);
		
		this.fieldIndexFinal = new JTextField();
		this.fieldIndexFinal.setColumns(10);
		panel_7.add(this.fieldIndexFinal);
		
		JLabel lblNewLabel_3 = new JLabel("Prix :");
		panel_7.add(lblNewLabel_3);
		
		fieldPrix = new JTextField();
		fieldPrix.setColumns(10);
		panel_7.add(fieldPrix);
		
		JButton bValiderCharge = new JButton(" Valider ");
		bValiderCharge.addActionListener(this.gestionClic);
		bValiderCharge.setForeground(Color.WHITE);
		bValiderCharge.setBackground(new Color(152, 251, 152));
		panel_7.add(bValiderCharge);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11);
		panel_11.setBackground(new Color(45, 72, 224));
		
		JButton bAnnuler = new JButton("Annuler");
		bAnnuler.addActionListener(this.gestionClic);
		bAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bAnnuler.setForeground(Color.WHITE);
		bAnnuler.setBackground(new Color(220, 20, 60));
		panel_11.add(bAnnuler);
		
		JPanel panel_12 = new JPanel();
		panel_9.add(panel_12);
		panel_12.setBackground(new Color(45, 72, 224));
		
		JButton bAjouter = new JButton("  Valider  ");
		bAjouter.addActionListener(this.gestionClic);
		bAjouter.setForeground(Color.WHITE);
		bAjouter.setBackground(new Color(152, 251, 152));
		panel_12.add(bAjouter);
	}

	public JComboBox<Logement> getComboBoxLogement() {
		return comboBoxLogement;
	}

	public void setComboBoxLogement(JComboBox<Logement> comboBoxLogement) {
		this.comboBoxLogement = comboBoxLogement;
	}

	public JButton getbValLog() {
		return bValLog;
	}

	public void setbValLog(JButton bValLog) {
		this.bValLog = bValLog;
	}

	public JLabel getLabelJour() {
		return labelJour;
	}

	public void setLabelJour(JLabel labelJour) {
		this.labelJour = labelJour;
	}

	public JLabel getLabelRegularisation() {
		return labelRegularisation;
	}

	public void setLabelRegularisation(JLabel labelRegularisation) {
		this.labelRegularisation = labelRegularisation;
	}

	public JPanel getPanelDroite() {
		return panelDroite;
	}

	public void setPanelDroite(JPanel panelDroite) {
		this.panelDroite = panelDroite;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public String getFieldIndexFinal() {
		return fieldIndexFinal.getText();
	}

	public void setFieldIndexFinal(String fieldIndexFinal) {
		this.fieldIndexFinal.setText(fieldIndexFinal);;
	}

	public String getFieldPrix() {
		return fieldPrix.getText();
	}

	public void setFieldPrix(String fieldPrix) {
		this.fieldPrix.setText(fieldPrix);;
	}

}
