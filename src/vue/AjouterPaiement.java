package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controleur.GestionPaiement;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Toolkit;

public class AjouterPaiement extends JFrame {

	private JPanel contentPane;
	private JTextField fieldPCharge;
	private JTextField fieldDPaiement;
	private JTextField fieldMontant;
	private JTextField fieldMoyPai;
	
	private GestionPaiement gestionClic;

	public AjouterPaiement() {
		this.gestionClic = new GestionPaiement(this);
		setBackground(Color.WHITE);
		setTitle("Ajouter un Diagnostic ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AjouterPaiement.class.getResource("/vue/icone3.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		

		JPanel Haut = new JPanel();
		getContentPane().add(Haut, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ajouter Paiement");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 24));
		Haut.add(lblNewLabel);
		Haut.setBackground(new Color(28, 12, 78));
		
		JPanel mid = new JPanel();
		contentPane.add(mid, BorderLayout.CENTER);
		mid.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panelcp = new JPanel();
		mid.add(panelcp);
		panelcp.setLayout(new GridLayout(0, 2, 0, 0));
		panelcp.setBackground(Color.WHITE);
		
		JLabel moyPai = new JLabel("Moyen de Paiement :");
		moyPai.setBackground(Color.WHITE);
		moyPai.setHorizontalAlignment(SwingConstants.RIGHT);
		moyPai.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelcp.add(moyPai);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel.getLayout();
		flowLayout_4.setVgap(22);
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panelcp.add(panel);
		panel.setBackground(Color.WHITE);
		
		fieldMoyPai = new JTextField();
		fieldMoyPai.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel.add(fieldMoyPai);
		fieldMoyPai.setColumns(10);
		
		JPanel panelville = new JPanel();
		mid.add(panelville);
		panelville.setLayout(new GridLayout(0, 2, 0, 0));
		panelville.setBackground(Color.WHITE);
		
		JLabel montant = new JLabel("Montant :");
		montant.setHorizontalAlignment(SwingConstants.RIGHT);
		montant.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelville.add(montant);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		flowLayout_2.setVgap(22);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelville.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		
		fieldMontant = new JTextField();
		fieldMontant.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_1.add(fieldMontant);
		fieldMontant.setColumns(10);
		
		JPanel panelpays = new JPanel();
		mid.add(panelpays);
		panelpays.setLayout(new GridLayout(0, 2, 0, 0));
		panelpays.setBackground(Color.WHITE);
		
		JLabel cp = new JLabel("Date de Paiement :");
		cp.setHorizontalAlignment(SwingConstants.RIGHT);
		cp.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelpays.add(cp);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_2.getLayout();
		flowLayout_3.setVgap(22);
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelpays.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		
		fieldDPaiement = new JTextField();
		fieldDPaiement.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_2.add(fieldDPaiement);
		fieldDPaiement.setColumns(10);
		
		JPanel panelrue = new JPanel();
		mid.add(panelrue);
		panelrue.setLayout(new GridLayout(0, 2, 0, 0));
		panelrue.setBackground(Color.WHITE);
		
		JLabel pCharge = new JLabel("Provision Charge :");
		pCharge.setHorizontalAlignment(SwingConstants.RIGHT);
		pCharge.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelrue.add(pCharge);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setVgap(22);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelrue.add(panel_3);
		panel_3.setBackground(Color.WHITE);
		
		fieldPCharge = new JTextField();
		fieldPCharge.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_3.add(fieldPCharge);
		fieldPCharge.setColumns(10);
		
		JPanel bas = new JPanel();
		contentPane.add(bas, BorderLayout.SOUTH);
		bas.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelanuler = new JPanel();
		bas.add(panelanuler);
		panelanuler.setBackground(new Color(45, 72, 224));
		
		JButton annuler = new JButton("Annuler");
		annuler.addActionListener(this.gestionClic);
		annuler.setForeground(Color.WHITE);
		annuler.setBackground(new Color(220, 20, 60));
		annuler.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelanuler.add(annuler);
		
		JPanel panelvalider = new JPanel();
		bas.add(panelvalider);
		panelvalider.setBackground(new Color(45, 72, 224));
		
		JButton valider = new JButton("Valider");
		valider.addActionListener(this.gestionClic);
		valider.setBackground(SystemColor.desktop);
		valider.setForeground(Color.WHITE);
		valider.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelvalider.add(valider);
		
		JPanel left = new JPanel();
		contentPane.add(left, BorderLayout.WEST);
		left.setBackground(new Color(28, 12, 78));
		
		JPanel right = new JPanel();
		contentPane.add(right, BorderLayout.EAST);
		right.setBackground(new Color(28, 12, 78));
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public String getFieldPCharge() {
		return fieldPCharge.getText();
	}

	public String getFieldDPaiement() {
		return fieldDPaiement.getText();
	}

	public String getFieldMontant() {
		return fieldMontant.getText();
	}

	public String getFieldMoyPai() {
		return fieldMoyPai.getText();
	}

	public GestionPaiement getGestionClic() {
		return gestionClic;
	}

	
	
}

