package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionFactureLogement;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class AjouterFactureLogement extends JFrame {

	private JPanel contentPane;
	private JTextField fieldFacture;
	private JTextField fieldNature;
	private JTextField fieldMontant;
	private JTextField fieldNDedu;
	private JTextField fieldDate;
	private GestionFactureLogement gestionClic;
	private JComboBox<String> comboLogement;
	private JComboBox<String> comboEntreprise;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterFactureLogement frame = new AjouterFactureLogement();
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
	public AjouterFactureLogement() {
		this.gestionClic = new GestionFactureLogement(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel Haut = new JPanel();
		Haut.setBackground(new Color(28, 12, 78));
		contentPane.add(Haut, BorderLayout.NORTH);
		
		JLabel lblFactureDeLogement = new JLabel("Facture d'un Logement   ");
		lblFactureDeLogement.setHorizontalAlignment(SwingConstants.LEFT);
		lblFactureDeLogement.setForeground(Color.WHITE);
		lblFactureDeLogement.setFont(new Font("Roboto Condensed", Font.PLAIN, 24));
		Haut.add(lblFactureDeLogement);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setBackground(new Color(45, 72, 224));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(Color.WHITE);
		panel_1.add(panel_22);
		
		JLabel lblNewLabel_7 = new JLabel("Logement :");
		panel_22.add(lblNewLabel_7);
		
		comboLogement = new JComboBox<String>();
		comboLogement.setMaximumRowCount(100);
		panel_22.add(comboLogement);
		
		JPanel panel_23 = new JPanel();
		panel_1.add(panel_23, BorderLayout.WEST);
		panel_23.setBackground(new Color(45, 72, 224));
		
		JPanel panel_24 = new JPanel();
		panel_1.add(panel_24, BorderLayout.NORTH);
		panel_24.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_8 = new JLabel("Choisir un Logement");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Roboto Condensed", Font.PLAIN, 18));
		panel_24.add(lblNewLabel_8);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_5.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Enteprise :");
		panel_7.add(lblNewLabel_1);
		
		comboEntreprise = new JComboBox<String>();
		comboEntreprise.setMaximumRowCount(100);
		panel_7.add(comboEntreprise);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_5.add(panel_8, BorderLayout.CENTER);
		
		JButton bajtEntreprise = new JButton("Ajouter une Entreprise");
		bajtEntreprise.addActionListener(this.gestionClic);
		bajtEntreprise.setBackground(Color.WHITE);
		panel_8.add(bajtEntreprise);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.NORTH);
		panel_6.setBackground(new Color(28, 12, 78));
		
		JLabel lblNewLabel = new JLabel("Ajouter une Entreprise ");
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		panel_6.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		panel_4.setBackground(new Color(45, 72, 224));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_4.add(panel_9);
		panel_9.setBackground(new Color(45, 72, 224));
		
		JButton bAnnuler = new JButton("Annuler");
		bAnnuler.addActionListener(this.gestionClic);
		bAnnuler.setForeground(Color.WHITE);
		bAnnuler.setBackground(new Color(220, 20, 60));
		panel_9.add(bAnnuler);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_4.add(panel_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_10.setBackground(new Color(45, 72, 224));
		
		JButton bValider = new JButton("Valider");
		bValider.addActionListener(this.gestionClic);
		bValider.setForeground(Color.WHITE);
		bValider.setBackground(new Color(152, 251, 152));
		panel_10.add(bValider);
		
		JPanel panel_21 = new JPanel();
		panel.add(panel_21, BorderLayout.WEST);
		panel_21.setBackground(new Color(28, 12, 78));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_11.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_11);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00B0 Facture :");
		panel_11.add(lblNewLabel_2);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		FlowLayout flowLayout_5 = (FlowLayout) panel_12.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_12);
		
		fieldFacture = new JTextField();
		panel_12.add(fieldFacture);
		fieldFacture.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel_13.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_13);
		
		JLabel lblNewLabel_3 = new JLabel("Nature/Type :");
		panel_13.add(lblNewLabel_3);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		FlowLayout flowLayout_6 = (FlowLayout) panel_14.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_14);
		
		fieldNature = new JTextField();
		panel_14.add(fieldNature);
		fieldNature.setColumns(10);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) panel_15.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_15);
		
		JLabel lblNewLabel_4 = new JLabel("Montant :");
		panel_15.add(lblNewLabel_4);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		FlowLayout flowLayout_7 = (FlowLayout) panel_16.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_16);
		
		fieldMontant = new JTextField();
		panel_16.add(fieldMontant);
		fieldMontant.setColumns(10);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.WHITE);
		FlowLayout flowLayout_4 = (FlowLayout) panel_17.getLayout();
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_17);
		
		JLabel lblNewLabel_5 = new JLabel("Montant non d\u00E9ductible :");
		panel_17.add(lblNewLabel_5);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(Color.WHITE);
		FlowLayout flowLayout_8 = (FlowLayout) panel_18.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_18);
		
		fieldNDedu = new JTextField();
		panel_18.add(fieldNDedu);
		fieldNDedu.setColumns(10);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_19.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_19);
		
		JLabel lblNewLabel_6 = new JLabel("Date :");
		panel_19.add(lblNewLabel_6);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(Color.WHITE);
		FlowLayout flowLayout_9 = (FlowLayout) panel_20.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_20);
		
		fieldDate = new JTextField();
		panel_20.add(fieldDate);
		fieldDate.setColumns(10);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public String getFacture() {
		return fieldFacture.getText();
	}

	public String getNature() {
		return fieldNature.getText();
	}

	public String getMontant() {
		return fieldMontant.getText();
	}

	public String getNDedu() {
		return fieldNDedu.getText();
	}

	public String getDate() {
		return fieldDate.getText();
	}

	public GestionFactureLogement getGestionClic() {
		return gestionClic;
	}

	public JComboBox<String> getComboLogement() {
		return comboLogement;
	}

	public JComboBox<String> getComboEntreprise() {
		return comboEntreprise;
	}

	
	
}