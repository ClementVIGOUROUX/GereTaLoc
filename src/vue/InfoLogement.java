package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controleur.GestionBail;
import controleur.GestionInfoLogement;
import modele.Diagnostics;
import modele.Immeuble;
import modele.Logement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class InfoLogement extends JFrame {

	private JPanel contentPane;
	private JTable tablefacture;
	private File fileDia ;
	private Diagnostics diagnostic ;
	private JButton bTelecharger ;
	private Logement logement ;
	private JLabel labelRevision ;
	private JLabel labelJourRevision ;
	private JButton bValiderIRL ;
	private JLabel labelAugment ;
	private JLabel labelLoyer ; 
	
	private GestionInfoLogement gestionClic;
	private JTextField fieldrevision;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoLogement frame = new InfoLogement(null);
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
	public InfoLogement(Diagnostics diagnostic) {
		this.diagnostic = diagnostic ;
		this.gestionClic = new GestionInfoLogement(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		header.setBackground(new Color(28, 12, 78));
		
		JLabel lblNewLabel = new JLabel("Information du Logement ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 22));
		header.add(lblNewLabel);
		
		JPanel centre = new JPanel();
		contentPane.add(centre, BorderLayout.CENTER);
		centre.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel UN = new JPanel();
		UN.setBackground(Color.WHITE);
		centre.add(UN);
		UN.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		UN.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		UN.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_2 = new JLabel("Ajouter nouveau Diagnostic valide");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_2, BorderLayout.SOUTH);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		panel_4.add(panel_16, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		UN.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_5.add(panel_13, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Diagnostiques :");
		panel_13.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		
		JButton ajtDiag = new JButton("Ajouter");
		panel_13.add(ajtDiag);
		ajtDiag.setForeground(Color.WHITE);
		ajtDiag.setBackground(new Color(0, 255, 127));
		ajtDiag.addActionListener(this.gestionClic);
		ajtDiag.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		ajtDiag.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		panel_5.add(panel_14, BorderLayout.CENTER);
		
		bTelecharger = new JButton("Telecharger");
		bTelecharger.addActionListener(this.gestionClic);
		bTelecharger.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		bTelecharger.setBackground(Color.WHITE);
		panel_14.add(bTelecharger);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		UN.add(panel_15);
		
		JPanel DEUX = new JPanel();
		centre.add(DEUX);
		DEUX.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		DEUX.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_5 = new JLabel("Revision");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_7.add(panel_8, BorderLayout.NORTH);
		
		this.labelRevision = new JLabel("Revision possible dans :");
		this.labelRevision.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_8.add(this.labelRevision);
		
		this.labelJourRevision = new JLabel("New label");
		this.labelJourRevision.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_8.add(this.labelJourRevision);
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_9.add(panel_10);
		
		JLabel lblNewLabel_9 = new JLabel("Ajouter IRL");
		panel_10.add(lblNewLabel_9);
		
		fieldrevision = new JTextField();
		fieldrevision.setColumns(10);
		panel_10.add(fieldrevision);
		
		this.bValiderIRL = new JButton("Valider");
		this.bValiderIRL.addActionListener(this.gestionClic);
		panel_10.add(bValiderIRL);
		bValiderIRL.setBackground(Color.WHITE);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_9.add(panel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Augmentation de :");
		panel_11.add(lblNewLabel_12);
		
		this.labelAugment = new JLabel("New label");
		panel_11.add(this.labelAugment);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		panel_9.add(panel_12);
		
		JLabel lblNewLabel_11 = new JLabel("Soit un Loyer de :");
		panel_12.add(lblNewLabel_11);
		
		this.labelLoyer = new JLabel("New label");
		panel_12.add(this.labelLoyer);
		
		JPanel TROIS = new JPanel();
		centre.add(TROIS);
		TROIS.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		TROIS.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_2.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_6 = new JLabel("Factures");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_6, BorderLayout.NORTH);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_2.add(scrollPane_4, BorderLayout.CENTER);
		
		tablefacture = new JTable();
		tablefacture.getTableHeader().setReorderingAllowed(false);
		tablefacture.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00B0", "Type", "Montant", "Montant non D�ductible","Date","N\u00B0Siret"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_4.setViewportView(tablefacture);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_6.setBackground(new Color(45, 72, 224));
		
		JButton Quitter = new JButton("Quitter");
		Quitter.setForeground(Color.WHITE);
		Quitter.setBackground(new Color(220, 20, 60));
		Quitter.addActionListener(this.gestionClic);
		panel_6.add(Quitter);
		
		
	}

	public File getFileDia() {
		return fileDia;
	}

	public void setFileDia(File fileDia) {
		this.fileDia = fileDia;
	}

	public Diagnostics getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(Diagnostics diagnostic) {
		this.diagnostic = diagnostic;
	}

	public JButton getbTelecharger() {
		return bTelecharger;
	}

	public void setbTelecharger(JButton bTelecharger) {
		this.bTelecharger = bTelecharger;
	}

	public Logement getLogement() {
		return logement;
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
	}

	public JTable getTablefacture() {
		return tablefacture;
	}

	public void setTablefacture(JTable tablefacture) {
		this.tablefacture = tablefacture;
	}

	public JLabel getLabelRevision() {
		return labelRevision;
	}

	public void setLabelRevision(JLabel labelRevision) {
		this.labelRevision = labelRevision;
	}

	public JLabel getLabelJourRevision() {
		return labelJourRevision;
	}

	public void setLabelJourRevision(JLabel labelJourRevision) {
		this.labelJourRevision = labelJourRevision;
	}

	public JButton getbValiderIRL() {
		return bValiderIRL;
	}

	public void setbValiderIRL(JButton bValiderIRL) {
		this.bValiderIRL = bValiderIRL;
	}

	public String getFieldrevision() {
		return fieldrevision.getText();
	}

	public void setFieldrevision(String fieldrevision) {
		this.fieldrevision.setText(fieldrevision);;
	}

	public JLabel getLabelAugment() {
		return labelAugment;
	}

	public void setLabelAugment(JLabel labelAugment) {
		this.labelAugment = labelAugment;
	}

	public JLabel getLabelLoyer() {
		return labelLoyer;
	}

	public void setLabelLoyer(JLabel labelLoyer) {
		this.labelLoyer = labelLoyer;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
