package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.GestionBail;
import controleur.GestionComboLogements;
import modele.Immeuble;
import modele.Locataire;
import modele.Logement;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class AjouterBail extends JFrame {

	private JPanel contentPane;
	private JTable tableLoca;
	private JTextField fieldDDebut;
	private JTextField fieldEtat;
	private JTextField fieldDepot;
	private JTextField fieldMoyen;
	private JTextField fieldMontant;
	private JTextField fieldDPaiement;
	private JTextField fieldSiret;
	private JTextField fieldNom;
	private JTextField fiedlCP;
	private JTextField fieldAdresse;
	private JTextField fieldVille;
	private JTextField fieldTel;
	private JTextField fieldMail;
	private JTextField fieldCNom;
	private JTextField fieldCmail;
	private JTextField fieldCtel;
	private JTextField fieldIRL;
	private JComboBox<Logement> comboLogement;
	private JComboBox<Immeuble> comboImmeuble;
	private JComboBox<Locataire> comboLocataire;
	
	private GestionBail gestionClic;
	private GestionComboLogements gestionComboLogements;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterBail frame = new AjouterBail();
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
	public AjouterBail() {
		this.gestionClic = new GestionBail(this);
		this.gestionComboLogements = new GestionComboLogements(this);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 963, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel top = new JPanel();
		contentPane.add(top, BorderLayout.NORTH);
		top.setBackground(new Color(28, 12, 78));
		
		JLabel titre = new JLabel("Ajouter un Bail ");
		titre.setForeground(Color.WHITE);
		titre.setFont(new Font("Roboto Condensed", Font.PLAIN, 22));
		top.add(titre);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_1.setBackground(new Color(45, 72, 224));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_36 = new JPanel();
		panel_4.add(panel_36);
		panel_36.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_39 = new JPanel();
		panel_39.setBackground(Color.WHITE);
		panel_36.add(panel_39, BorderLayout.CENTER);
		panel_39.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		comboImmeuble = new JComboBox<Immeuble>();
		comboImmeuble.setMaximumRowCount(100);
		panel_39.add(comboImmeuble);
		
		this.comboImmeuble.addActionListener(this.gestionComboLogements);
		
		JPanel panel_41 = new JPanel();
		panel_4.add(panel_41);
		panel_41.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_42 = new JPanel();
		panel_42.setBackground(new Color(45, 72, 224));
		panel_41.add(panel_42, BorderLayout.NORTH);
		panel_42.setLayout(new BoxLayout(panel_42, BoxLayout.X_AXIS));
		
		JLabel tlogement = new JLabel("Ajouter un Logement");
		panel_42.add(tlogement);
		tlogement.setForeground(Color.WHITE);
		tlogement.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		tlogement.setBackground(Color.WHITE);
		
		JPanel panel_37 = new JPanel();
		panel_37.setBackground(Color.WHITE);
		panel_41.add(panel_37, BorderLayout.CENTER);
		
		comboLogement = new JComboBox<Logement>();
		comboLogement.setMaximumRowCount(100);
		panel_37.add(comboLogement);
		
		JPanel panel_38 = new JPanel();
		panel_1.add(panel_38, BorderLayout.NORTH);
		panel_38.setBackground(new Color(45, 72, 224));
		panel_38.setLayout(new BoxLayout(panel_38, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_10 = new JLabel("Ajouter Immeuble");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_38.add(lblNewLabel_10);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		panel_5.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_5.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel = new JLabel("Ajouter des Locataires");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_5.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_5.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_6.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		comboLocataire = new JComboBox<Locataire>();
		comboLocataire.setMaximumRowCount(100);
		panel_7.add(comboLocataire);
		
		JButton btnValiderLoc = new JButton("Valider ");
		btnValiderLoc.addActionListener(this.gestionClic);
		panel_7.add(btnValiderLoc, BorderLayout.EAST);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane, BorderLayout.CENTER);
		
		tableLoca = new JTable();
		tableLoca.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Pr\u00E9nom", "Nom", "Profession"
			}
		));
		scrollPane.setViewportView(tableLoca);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		panel_8.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_8.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		panel_11.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_11.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter un Bail");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_11.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		panel_11.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Date de debut");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_12.add(lblNewLabel_3);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_12.add(panel_13);
		
		fieldDDebut = new JTextField();
		fieldDDebut.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_13.add(fieldDDebut);
		fieldDDebut.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_14.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_14.setBackground(Color.WHITE);
		panel_12.add(panel_14);
		panel_14.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_4 = new JLabel("Indice de r\u00E9f\u00E9rence des loyers");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_14.add(lblNewLabel_4);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(Color.WHITE);
		panel_12.add(panel_21);
		
		JLabel lblNewLabel_8 = new JLabel("IRL");
		lblNewLabel_8.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_21.add(lblNewLabel_8);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(Color.WHITE);
		panel_12.add(panel_22);
		
		fieldIRL = new JTextField();
		fieldIRL.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_22.add(fieldIRL);
		fieldIRL.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		panel_10.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_10.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_2 = new JLabel("Etat Des Lieux");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_10.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		panel_10.add(panel_15, BorderLayout.CENTER);
		panel_15.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Date de l'Etat Des Lieux");
		lblNewLabel_5.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_15.add(lblNewLabel_5);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		panel_15.add(panel_16);
		
		fieldEtat = new JTextField();
		fieldEtat.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_16.add(fieldEtat);
		fieldEtat.setColumns(10);
		
		JPanel panel_40 = new JPanel();
		panel_40.setBackground(Color.WHITE);
		panel_15.add(panel_40);
		
		JButton bAjouterFichier = new JButton("Ajouter Fichier");
		panel_40.add(bAjouterFichier);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		panel_9.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_9.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));
		panel_18.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_18.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_6 = new JLabel("D\u00E9pot de Garantie");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_18.add(lblNewLabel_6, BorderLayout.NORTH);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.WHITE);
		panel_18.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("D\u00E9pot de Garantie");
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblNewLabel_7);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(Color.WHITE);
		panel_19.add(panel_20);
		
		fieldDepot = new JTextField();
		panel_20.add(fieldDepot);
		fieldDepot.setColumns(10);
		
		JPanel panel_17 = new JPanel();
		panel_9.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));
		panel_17.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_17.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_11 = new JLabel("Paiement");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_17.add(lblNewLabel_11, BorderLayout.NORTH);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(Color.WHITE);
		panel_17.add(panel_23, BorderLayout.CENTER);
		panel_23.setLayout(new GridLayout(8, 0, 0, 0));
		
		JLabel lblNewLabel_12 = new JLabel("Moyen");
		lblNewLabel_12.setBackground(Color.WHITE);
		lblNewLabel_12.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		panel_23.add(lblNewLabel_12);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(Color.WHITE);
		panel_23.add(panel_24);
		
		fieldMoyen = new JTextField();
		panel_24.add(fieldMoyen);
		fieldMoyen.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Montant");
		lblNewLabel_13.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel_23.add(lblNewLabel_13);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(Color.WHITE);
		panel_23.add(panel_25);
		
		fieldMontant = new JTextField();
		panel_25.add(fieldMontant);
		fieldMontant.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Date de Paiement");
		lblNewLabel_14.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		panel_23.add(lblNewLabel_14);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBackground(Color.WHITE);
		panel_23.add(panel_26);
		
		fieldDPaiement = new JTextField();
		panel_26.add(fieldDPaiement);
		fieldDPaiement.setColumns(10);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBackground(Color.WHITE);
		panel_23.add(panel_27);
		
		JPanel panel_28 = new JPanel();
		panel.add(panel_28);
		panel_28.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_30 = new JPanel();
		panel_28.add(panel_30);
		panel_30.setLayout(new BorderLayout(0, 0));
		panel_30.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_30.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_16 = new JLabel("Agence (facultatif)");
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_30.add(lblNewLabel_16, BorderLayout.NORTH);
		
		JPanel panel_31 = new JPanel();
		panel_31.setBackground(Color.WHITE);
		panel_30.add(panel_31, BorderLayout.CENTER);
		panel_31.setLayout(new GridLayout(7, 1, 0, 0));
		
		JLabel lblNewLabel_17_1 = new JLabel("Siret");
		lblNewLabel_17_1.setBackground(Color.WHITE);
		lblNewLabel_17_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		lblNewLabel_17_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_31.add(lblNewLabel_17_1);
		
		fieldSiret = new JTextField();
		panel_31.add(fieldSiret);
		fieldSiret.setColumns(10);
		
		JLabel lblNewLabel_17_2 = new JLabel("Nom");
		lblNewLabel_17_2.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		lblNewLabel_17_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_31.add(lblNewLabel_17_2);
		
		fieldNom = new JTextField();
		panel_31.add(fieldNom);
		fieldNom.setColumns(10);
		
		JLabel lblNewLabel_17_3 = new JLabel("Adresse");
		lblNewLabel_17_3.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		lblNewLabel_17_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_31.add(lblNewLabel_17_3);
		
		fieldAdresse = new JTextField();
		panel_31.add(fieldAdresse);
		fieldAdresse.setColumns(10);
		
		JLabel lblNewLabel_17_5 = new JLabel("Code Postal");
		lblNewLabel_17_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_17_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_31.add(lblNewLabel_17_5);
		
		fiedlCP = new JTextField();
		panel_31.add(fiedlCP);
		fiedlCP.setColumns(10);
		
		JLabel lblNewLabel_17_6 = new JLabel("Ville");
		lblNewLabel_17_6.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		lblNewLabel_17_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_31.add(lblNewLabel_17_6);
		
		fieldVille = new JTextField();
		panel_31.add(fieldVille);
		fieldVille.setColumns(10);
		
		JLabel lblNewLabel_17_4 = new JLabel("N\u00B0 T\u00E9l\u00E9phone");
		lblNewLabel_17_4.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		lblNewLabel_17_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_31.add(lblNewLabel_17_4);
		
		fieldTel = new JTextField();
		panel_31.add(fieldTel);
		fieldTel.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("E-mail");
		lblNewLabel_17.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		panel_31.add(lblNewLabel_17);
		
		fieldMail = new JTextField();
		panel_31.add(fieldMail);
		fieldMail.setColumns(10);
		
		JPanel panel_29 = new JPanel();
		panel_28.add(panel_29);
		panel_29.setLayout(new BorderLayout(0, 0));
		panel_29.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_29.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_18 = new JLabel("Caution");
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_29.add(lblNewLabel_18, BorderLayout.NORTH);
		
		JPanel panel_32 = new JPanel();
		panel_32.setBackground(Color.WHITE);
		panel_29.add(panel_32, BorderLayout.CENTER);
		panel_32.setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel lblNewLabel_19 = new JLabel("Nom");
		lblNewLabel_19.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		panel_32.add(lblNewLabel_19);
		
		JPanel panel_33 = new JPanel();
		panel_33.setBackground(Color.WHITE);
		panel_32.add(panel_33);
		
		fieldCNom = new JTextField();
		panel_33.add(fieldCNom);
		fieldCNom.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("E-mail");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		panel_32.add(lblNewLabel_20);
		
		JPanel panel_34 = new JPanel();
		panel_34.setBackground(Color.WHITE);
		panel_32.add(panel_34);
		
		fieldCmail = new JTextField();
		panel_34.add(fieldCmail);
		fieldCmail.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("N\u00B0 T\u00E9l\u00E9phone");
		lblNewLabel_21.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		panel_32.add(lblNewLabel_21);
		
		JPanel panel_35 = new JPanel();
		panel_35.setBackground(Color.WHITE);
		panel_32.add(panel_35);
		
		fieldCtel = new JTextField();
		panel_35.add(fieldCtel);
		fieldCtel.setColumns(10);
		
		JPanel bas = new JPanel();
		contentPane.add(bas, BorderLayout.SOUTH);
		bas.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		bas.add(panel_2);
		panel_2.setBackground(new Color(45, 72, 224));
		
		
		JButton bannuler = new JButton("Annuler");
		bannuler.setForeground(Color.WHITE);
		bannuler.setBackground(new Color(220, 20, 60));
		bannuler.addActionListener(this.gestionClic);
		bannuler.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_2.add(bannuler);
		
		JPanel panel_3 = new JPanel();
		bas.add(panel_3);
		panel_3.setBackground(new Color(45, 72, 224));
		
		JButton bvalider = new JButton("Valider");
		bvalider.setForeground(Color.WHITE);
		bvalider.setBackground(new Color(0, 255, 127));
		bvalider.addActionListener(this.gestionClic);
		bvalider.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_3.add(bvalider);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTable getTableLoca() {
		return tableLoca;
	}

	public String getFieldDDebut() {
		return fieldDDebut.getText();
	}

	public String getFieldEtat() {
		return fieldEtat.getText();
	}

	public String getFieldDepot() {
		return fieldDepot.getText();
	}

	public String getFieldMoyen() {
		return fieldMoyen.getText();
	}

	public String getFieldMontant() {
		return fieldMontant.getText();
	}

	public String getFieldDPaiement() {
		return fieldDPaiement.getText();
	}

	public String getFieldSiret() {
		return fieldSiret.getText();
	}

	public String getFieldNom() {
		return fieldNom.getText();
	}

	public String getFiedlCP() {
		return fiedlCP.getText();
	}

	public String getFieldAdresse() {
		return fieldAdresse.getText();
	}

	public String getFieldVille() {
		return fieldVille.getText();
	}

	public String getFieldTel() {
		return fieldTel.getText();
	}

	public String getFieldMail() {
		return fieldMail.getText();
	}

	public String getFieldCNom() {
		return fieldCNom.getText();
	}

	public String getFieldCmail() {
		return fieldCmail.getText();
	}

	public String getFieldCtel() {
		return fieldCtel.getText();
	}

	public GestionBail getGestionClic() {
		return gestionClic;
	}

	public String getFieldIRL() {
		return fieldIRL.getText();
	}

	public JComboBox<Logement> getComboLogement() {
		return comboLogement;
	}

	public JComboBox<Immeuble> getComboImmeuble() {
		return comboImmeuble;
	}

	public JComboBox<Locataire> getComboLocataire() {
		return comboLocataire;
	}
	
}