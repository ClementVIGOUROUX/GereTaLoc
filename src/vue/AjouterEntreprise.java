package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionEntreprise;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class AjouterEntreprise extends JFrame {

	private JPanel contentPane;
	private JTextField fieldSiret;
	private JTextField fieldNom;
	private JTextField fieldCp;
	private JTextField fieldAdresse;
	private JTextField fieldVille;
	private JTextField fiedlEmail;
	private JTextField fieldTel;
	
	private GestionEntreprise gestionClic;

	public AjouterEntreprise() {
		this.gestionClic = new GestionEntreprise(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel Haut = new JPanel();
		Haut.setBackground(new Color(28, 12, 78));
		contentPane.add(Haut, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ajouter une Entreprise");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 24));
		Haut.add(lblNewLabel);
		
		JPanel left = new JPanel();
		left.setBackground(new Color(28, 12, 78));
		contentPane.add(left, BorderLayout.WEST);
		
		JPanel right = new JPanel();
		right.setBackground(new Color(28, 12, 78));
		contentPane.add(right, BorderLayout.EAST);
		
		JPanel bas = new JPanel();
		contentPane.add(bas, BorderLayout.SOUTH);
		bas.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelanuler = new JPanel();
		panelanuler.setBackground(new Color(45, 72, 224));
		bas.add(panelanuler);
		
		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(this.gestionClic);
		annuler.setForeground(Color.WHITE);
		annuler.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		annuler.setBackground(new Color(220, 20, 60));
		panelanuler.add(annuler);
		
		JPanel panelvalider = new JPanel();
		panelvalider.setBackground(new Color(45, 72, 224));
		bas.add(panelvalider);
		
		JButton valider = new JButton("Valider");
		valider.addActionListener(this.gestionClic);
		valider.setForeground(Color.WHITE);
		valider.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		valider.setBackground(SystemColor.desktop);
		panelvalider.add(valider);
		
		JPanel mid = new JPanel();
		contentPane.add(mid, BorderLayout.CENTER);
		mid.setLayout(new GridLayout(7, 0, 0, 0));
		
		JPanel panelcp = new JPanel();
		panelcp.setBackground(Color.WHITE);
		mid.add(panelcp);
		panelcp.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel siret = new JLabel("N\u00B0Siret :");
		siret.setHorizontalAlignment(SwingConstants.RIGHT);
		siret.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		siret.setBackground(Color.WHITE);
		panelcp.add(siret);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel.setBackground(Color.WHITE);
		panelcp.add(panel);
		
		fieldSiret = new JTextField();
		fieldSiret.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		fieldSiret.setColumns(10);
		panel.add(fieldSiret);
		
		JPanel panelville = new JPanel();
		panelville.setBackground(Color.WHITE);
		mid.add(panelville);
		panelville.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNom.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelville.add(lblNom);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_1.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_1.setBackground(Color.WHITE);
		panelville.add(panel_1);
		
		fieldNom = new JTextField();
		fieldNom.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		fieldNom.setColumns(10);
		panel_1.add(fieldNom);
		
		JPanel panelpays = new JPanel();
		panelpays.setBackground(Color.WHITE);
		mid.add(panelpays);
		panelpays.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel cp = new JLabel("Code postal :");
		cp.setHorizontalAlignment(SwingConstants.RIGHT);
		cp.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelpays.add(cp);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_2.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panel_2.setBackground(Color.WHITE);
		panelpays.add(panel_2);
		
		fieldCp = new JTextField();
		fieldCp.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		fieldCp.setColumns(10);
		panel_2.add(fieldCp);
		
		JPanel panelrue = new JPanel();
		panelrue.setBackground(Color.WHITE);
		mid.add(panelrue);
		panelrue.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresse.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelrue.add(lblAdresse);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_3.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panel_3.setBackground(Color.WHITE);
		panelrue.add(panel_3);
		
		fieldAdresse = new JTextField();
		fieldAdresse.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		fieldAdresse.setColumns(10);
		panel_3.add(fieldAdresse);
		
		JPanel panel_5 = new JPanel();
		mid.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_7.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_5.add(panel_7);
		
		JLabel lblNewLabel_1 = new JLabel("Ville :");
		lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_7.add(lblNewLabel_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel_8.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_8);
		
		fieldVille = new JTextField();
		fieldVille.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_8.add(fieldVille);
		fieldVille.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		mid.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_6.add(panel_9);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail :");
		lblNewLabel_2.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_9.add(lblNewLabel_2);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) panel_10.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_10);
		
		fiedlEmail = new JTextField();
		fiedlEmail.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_10.add(fiedlEmail);
		fiedlEmail.setColumns(10);
		
		JPanel panelfibre = new JPanel();
		panelfibre.setBackground(Color.WHITE);
		mid.add(panelfibre);
		panelfibre.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNtlphone = new JLabel("N\u00B0T\u00E9l\u00E9phone :");
		lblNtlphone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNtlphone.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelfibre.add(lblNtlphone);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_4.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		panel_4.setBackground(Color.WHITE);
		panelfibre.add(panel_4);
		
		fieldTel = new JTextField();
		fieldTel.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_4.add(fieldTel);
		fieldTel.setColumns(10);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public String getFieldSiret() {
		return fieldSiret.getText();
	}

	public String getFieldNom() {
		return fieldNom.getText();
	}

	public String getFieldCp() {
		return fieldCp.getText();
	}

	public String getFieldAdresse() {
		return fieldAdresse.getText();
	}

	public String getFieldVille() {
		return fieldVille.getText();
	}

	public String getFiedlEmail() {
		return fiedlEmail.getText();
	}

	public String getFieldTel() {
		return fieldTel.getText();
	}

	public GestionEntreprise getGestionClic() {
		return gestionClic;
	}
	
	

}
