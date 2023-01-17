package vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import controleur.GestionLocataire;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;

public class AjouterLocataire extends JFrame {
	private JTextField fieldNom;
	private JTextField fieldPrenom;
	private JTextField fieldTel;
	private JTextField fieldMail;
	private JTextField fieldProf;
	private JRadioButton radioSexeM ;
	private JRadioButton radioSexeF ;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	private GestionLocataire gestionClic ;

	public AjouterLocataire() {
		
		this.gestionClic = new GestionLocataire(this);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AjouterLocataire.class.getResource("/vue/icone3.png")));
		getContentPane().setFont(new Font("Roboto", Font.PLAIN, 20));
		getContentPane().setForeground(new Color(255, 255, 255));
		setBounds(100, 100, 532, 524);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel Haut = new JPanel();
		getContentPane().add(Haut, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ajouter un Locataire ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 24));
		Haut.add(lblNewLabel);
		Haut.setBackground(new Color(28, 12, 78));
		
		JPanel formul = new JPanel();
		formul.setBackground(new Color(236, 248, 255));
		getContentPane().add(formul, BorderLayout.WEST);
		formul.setLayout(new BorderLayout(0, 0));
		
		JPanel center = new JPanel();
		formul.add(center);
		center.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		center.add(panel_1);
		panel_1.setLayout(new GridLayout(5, 0, 0, 0));
		panel_1.setBackground(new Color(236, 248, 255));
		
		JPanel bas = new JPanel();
		getContentPane().add(bas, BorderLayout.SOUTH);
		bas.setBackground(new Color(28, 12, 78));
		bas.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("       ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		bas.add(label);
		
		JPanel milieu = new JPanel();
		getContentPane().add(milieu, BorderLayout.CENTER);
		milieu.setLayout(new BorderLayout(0, 0));
		
		JPanel separation = new JPanel();
		milieu.add(separation, BorderLayout.NORTH);
		separation.setBackground(new Color(45, 72, 224));
		
		JLabel vide = new JLabel("       ");
		separation.add(vide);
		
		JPanel midmid = new JPanel();
		milieu.add(midmid, BorderLayout.CENTER);
		midmid.setLayout(new BorderLayout(0, 0));
		
		JPanel contenu = new JPanel();
		contenu.setForeground(Color.WHITE);
		midmid.add(contenu, BorderLayout.CENTER);
		contenu.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel hautcont = new JPanel();
		contenu.add(hautcont);
		hautcont.setBackground(new Color(236, 248, 255));
		hautcont.setLayout(new GridLayout(7, 2, 0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		hautcont.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		hautcont.add(panel_14);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		hautcont.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom : ");
		lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		hautcont.add(panel_3);
		
		fieldNom = new JTextField();
		panel_3.add(fieldNom);
		fieldNom.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) panel_6.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		hautcont.add(panel_6);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom : ");
		lblNewLabel_2.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		hautcont.add(panel_4);
		
		fieldPrenom = new JTextField();
		panel_4.add(fieldPrenom);
		fieldPrenom.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		FlowLayout flowLayout_4 = (FlowLayout) panel_7.getLayout();
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		hautcont.add(panel_7);
		
		JLabel lblNewLabel_3 = new JLabel("Telephone : ");
		lblNewLabel_3.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_7.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		hautcont.add(panel_5);
		
		fieldTel = new JTextField();
		panel_5.add(fieldTel);
		fieldTel.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		FlowLayout flowLayout_6 = (FlowLayout) panel_9.getLayout();
		flowLayout_6.setAlignment(FlowLayout.RIGHT);
		hautcont.add(panel_9);
		
		JLabel lblNewLabel_4 = new JLabel("Email : ");
		lblNewLabel_4.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_9.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout_7 = (FlowLayout) panel_2.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		hautcont.add(panel_2);
		
		fieldMail = new JTextField();
		panel_2.add(fieldMail);
		fieldMail.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		FlowLayout flowLayout_8 = (FlowLayout) panel_8.getLayout();
		flowLayout_8.setAlignment(FlowLayout.RIGHT);
		hautcont.add(panel_8);
		
		JLabel lblNewLabel_5 = new JLabel("Sexe : ");
		lblNewLabel_5.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_8.add(lblNewLabel_5);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		FlowLayout flowLayout_11 = (FlowLayout) panel_11.getLayout();
		flowLayout_11.setAlignment(FlowLayout.LEFT);
		hautcont.add(panel_11);
		
		radioSexeM = new JRadioButton("M");
		buttonGroup.add(radioSexeM);
		radioSexeM.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_11.add(radioSexeM);
		
		radioSexeF = new JRadioButton("F");
		buttonGroup.add(radioSexeF);
		radioSexeF.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_11.add(radioSexeF);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		FlowLayout flowLayout_9 = (FlowLayout) panel_10.getLayout();
		flowLayout_9.setAlignment(FlowLayout.RIGHT);
		hautcont.add(panel_10);
		
		JLabel lblNewLabel_6 = new JLabel("Profession : ");
		lblNewLabel_6.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_10.add(lblNewLabel_6);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		FlowLayout flowLayout_10 = (FlowLayout) panel_12.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		hautcont.add(panel_12);
		
		fieldProf = new JTextField();
		panel_12.add(fieldProf);
		fieldProf.setColumns(10);
		
		JPanel validation = new JPanel();
		midmid.add(validation, BorderLayout.SOUTH);
		validation.setLayout(new BorderLayout(0, 0));
		validation.setBackground(new Color(45, 72, 224));
		
		JPanel panannu = new JPanel();
		FlowLayout fl_panannu = (FlowLayout) panannu.getLayout();
		fl_panannu.setHgap(60);
		validation.add(panannu, BorderLayout.WEST);
		panannu.setBackground(new Color(45, 72, 224));
		
		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(this.gestionClic);
		annuler.setForeground(Color.WHITE);
		annuler.setBackground(new Color(220, 20, 60));
		annuler.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panannu.add(annuler);
		
		JPanel panval = new JPanel();
		FlowLayout fl_panval = (FlowLayout) panval.getLayout();
		fl_panval.setHgap(60);
		validation.add(panval, BorderLayout.EAST);
		panval.setBackground(new Color(45, 72, 224));
		
		JButton valider = new JButton("Valider");
		valider.addActionListener(this.gestionClic);
		valider.setBackground(Color.GREEN);
		valider.setForeground(Color.WHITE);
		valider.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panval.add(valider);
	}

	public String getFieldNom() {
		return fieldNom.getText();
	}

	public String getFieldPrenom() {
		return fieldPrenom.getText();
	}

	public String getFieldTel() {
		return fieldTel.getText();
	}

	public String getFieldMail() {
		return fieldMail.getText();
	}

	public String getFieldProf() {
		return fieldProf.getText();
	}

	public JRadioButton getRadioSexeM() {
		return radioSexeM;
	}

	public JRadioButton getRadioSexeF() {
		return radioSexeF;
	}

	
	
	
	
	
	
}
