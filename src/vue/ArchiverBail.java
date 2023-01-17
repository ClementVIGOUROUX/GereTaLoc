package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionArchiverBail;
import modele.Logement;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ArchiverBail extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private GestionArchiverBail gestionClic;
	private JTable table;
	private JTextField fieldPrix;
	private JTextField fieldIndexFinal;
	private JTextField fieldDeduireCaution;
	private JComboBox<Logement> comboLogement ;
	private JButton bValiderLogement ;

	public ArchiverBail() {
		this.gestionClic = new GestionArchiverBail(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setBackground(new Color(28, 12, 78));
		
		JLabel lblNewLabel = new JLabel("Archiver un Bail");
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setBackground(new Color(28, 12, 78));
		
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setBackground(new Color(28, 12, 78));
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setBackground(new Color(45, 72, 224));
		
		JButton bAnnuler = new JButton("Annuler");
		bAnnuler.setForeground(Color.WHITE);
		bAnnuler.setBackground(new Color(220, 20, 60));
		bAnnuler.addActionListener(this.gestionClic);
		panel_5.add(bAnnuler);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setBackground(new Color(45, 72, 224));
		
		JButton bAjouter = new JButton("  Valider  ");
		bAjouter.setForeground(Color.WHITE);
		bAjouter.setBackground(new Color(152, 251, 152));
		bAjouter.addActionListener(this.gestionClic);
		panel_4.add(bAjouter);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_6.add(panel_9);
		
		JLabel lblNewLabel_2 = new JLabel("Logement");
		lblNewLabel_2.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		panel_9.add(lblNewLabel_2);
		
		this.comboLogement = new JComboBox<Logement>();
		this.comboLogement.addActionListener(this.gestionClic);
		this.comboLogement.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		panel_9.add(this.comboLogement);
		
		this.bValiderLogement = new JButton("Valider");
		this.bValiderLogement.addActionListener(this.gestionClic);
		this.bValiderLogement.setForeground(Color.WHITE);
		this.bValiderLogement.setBackground(new Color(152, 251, 152));
		panel_9.add(this.bValiderLogement);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_6.add(panel_8);
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter la Date de Fin de Bail :");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.BLACK);
		panel_8.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_8.add(textField);
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		textField.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_6.add(panel_11);
		
		JLabel lblNewLabel_5 = new JLabel("D\u00E9duire de la caution");
		lblNewLabel_5.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_11.add(lblNewLabel_5);
		
		fieldDeduireCaution = new JTextField();
		fieldDeduireCaution.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_11.add(fieldDeduireCaution);
		fieldDeduireCaution.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_10.add(scrollPane);
		
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
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_6.add(panel_7);
		
		JLabel lblNewLabel_4 = new JLabel("Index Final :");
		panel_7.add(lblNewLabel_4);
		
		fieldIndexFinal = new JTextField();
		panel_7.add(fieldIndexFinal);
		fieldIndexFinal.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Prix � l'unit� :");
		panel_7.add(lblNewLabel_3);
		
		fieldPrix = new JTextField();
		panel_7.add(fieldPrix);
		fieldPrix.setColumns(10);
		
		JButton bValiderCharge = new JButton(" Valider ");
		bValiderCharge.addActionListener(this.gestionClic);
		bValiderCharge.setForeground(Color.WHITE);
		bValiderCharge.setBackground(new Color(152, 251, 152));
		panel_7.add(bValiderCharge);
	}

	public JComboBox<Logement> getComboLogement() {
		return comboLogement;
	}

	public void setComboLogement(JComboBox<Logement> comboLogement) {
		this.comboLogement = comboLogement;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public String getFieldPrix() {
		return fieldPrix.getText();
	}

	public void setFieldPrix(JTextField fieldPrix) {
		this.fieldPrix = fieldPrix;
	}

	public String getFieldIndexFinal() {
		return fieldIndexFinal.getText();
	}

	public void setFieldIndexFinal(JTextField fieldIndexFinal) {
		this.fieldIndexFinal = fieldIndexFinal;
	}

	public String getFieldDeduireCaution() {
		return fieldDeduireCaution.getText();
	}

	public void setFieldDeduireCaution(JTextField fieldDeduireCaution) {
		this.fieldDeduireCaution = fieldDeduireCaution;
	}
}
