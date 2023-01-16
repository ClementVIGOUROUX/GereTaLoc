package vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.UIManager;

import controleur.GestionLogement;
import modele.Immeuble;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class AjouterLogement extends JFrame {
	
	private JTextField fieldnum;
	private JTextField fieldsurf;
	private JComboBox<Immeuble> comboImmeuble ;
	private JSpinner spinnerNbPieces ;
	private JCheckBox checkBoxGarage ;
	private GestionLogement gestionClic ;
	private JTextField fieldParking;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterLogement frame = new AjouterLogement();
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
	public AjouterLogement() {
		
		this.gestionClic = new GestionLogement(this);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AjouterLogement.class.getResource("/vue/icone.png")));
		setTitle("Ajouter un Logement");
		getContentPane().setFont(new Font("Roboto", Font.PLAIN, 20));
		getContentPane().setForeground(new Color(255, 255, 255));
		setBounds(100, 100, 791, 524);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel Haut = new JPanel();
		getContentPane().add(Haut, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ajouter un Logement ");
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
		
		JPanel panel = new JPanel();
		center.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.setBackground(Color.WHITE);
		
		JLabel numero = new JLabel("Num\u00E9ro :");
		numero.setVerticalAlignment(SwingConstants.TOP);
		numero.setHorizontalAlignment(SwingConstants.RIGHT);
		numero.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel.add(numero);
		
		JLabel surface = new JLabel("Surface :");
		surface.setVerticalAlignment(SwingConstants.TOP);
		surface.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		surface.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(surface);
		
		JLabel nbpiece = new JLabel("Nombre de pi\u00E8ces :");
		nbpiece.setVerticalAlignment(SwingConstants.TOP);
		nbpiece.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		nbpiece.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(nbpiece);
		
		JLabel garage = new JLabel("Garage :");
		garage.setVerticalAlignment(SwingConstants.TOP);
		garage.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		garage.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(garage);
		
		JLabel parking = new JLabel("Place de  Parking :");
		parking.setVerticalAlignment(SwingConstants.TOP);
		parking.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		parking.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(parking);
		
		JPanel panel_1 = new JPanel();
		center.add(panel_1);
		panel_1.setLayout(new GridLayout(5, 0, 0, 0));
		panel_1.setBackground(new Color(236, 248, 255));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_3);
		panel_3.setBackground(Color.WHITE);
		
		fieldnum = new JTextField();
		panel_3.add(fieldnum);
		fieldnum.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setHgap(10);
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_4);
		panel_4.setBackground(Color.WHITE);
		
		fieldsurf = new JTextField();
		panel_4.add(fieldsurf);
		fieldsurf.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setHgap(10);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_5);
		panel_5.setBackground(Color.WHITE);
		
		this.spinnerNbPieces = new JSpinner();
		spinnerNbPieces.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		panel_5.add(this.spinnerNbPieces);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setHgap(10);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_6);
		panel_6.setBackground(Color.WHITE);
		
		checkBoxGarage = new JCheckBox("");
		panel_6.add(checkBoxGarage);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_2.getLayout();
		flowLayout_3.setHgap(10);
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		
		fieldParking = new JTextField();
		panel_2.add(fieldParking);
		fieldParking.setColumns(10);
		
		JPanel sepa = new JPanel();
		formul.add(sepa, BorderLayout.EAST);
		sepa.setBackground(new Color(28, 12, 78));
		
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
		
		JPanel titre = new JPanel();
		midmid.add(titre, BorderLayout.NORTH);
		titre.setBackground(new Color(28, 12, 78));
		
		JLabel titreeee = new JLabel("Ajouter un Immeuble");
		titreeee.setForeground(Color.WHITE);
		titreeee.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		titre.add(titreeee);
		
		JPanel contenu = new JPanel();
		contenu.setForeground(Color.WHITE);
		midmid.add(contenu, BorderLayout.CENTER);
		contenu.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		contenu.add(panel_7, BorderLayout.NORTH);
		panel_7.setBackground(Color.WHITE);
		
		JLabel immeubleee = new JLabel("Immeuble : ");
		immeubleee.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_7.add(immeubleee);
		
		comboImmeuble = new JComboBox<Immeuble>();
		comboImmeuble.setMaximumRowCount(100);
		comboImmeuble.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_7.add(comboImmeuble);
		
		JPanel hautcont = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) hautcont.getLayout();
		flowLayout_7.setVgap(100);
		contenu.add(hautcont, BorderLayout.CENTER);
		hautcont.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("Ajouter un Immeuble");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(this.gestionClic);
		btnNewButton.setFont(new Font("Roboto Condensed", Font.PLAIN, 17));
		btnNewButton.setForeground(new Color(0, 0, 0));
		hautcont.add(btnNewButton);
		
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
		valider.setBackground(new Color(0, 255, 0));
		valider.setForeground(Color.WHITE);
		valider.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panval.add(valider);
		
		JPanel cote = new JPanel();
		milieu.add(cote, BorderLayout.EAST);
		cote.setBackground(new Color(28, 12, 78));
	}

	public String getFieldnum() {
		return fieldnum.getText();
	}


	public String getFieldsurf() {
		return fieldsurf.getText();
	}


	public JComboBox<Immeuble> getComboImmeuble() {
		return comboImmeuble;
	}

	public void setComboImmeuble(JComboBox<Immeuble> comboImmeuble) {
		this.comboImmeuble = comboImmeuble;
	}

	public JSpinner getSpinnerNbPieces() {
		return spinnerNbPieces;
	}

	public JCheckBox getCheckBoxGarage() {
		return checkBoxGarage;
	}

	public String getFieldParking() {
		return fieldParking.getText();
	}
	
	
	
	
	
}
