package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionAjouterCharge;
import modele.Bail;
import modele.Immeuble;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterCharge extends JFrame{

	private JPanel contentPane;
	private JTextField textFieldNomCharge;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldProvision;
	private JTextField textFieldIndex;
	private JTextField textFieldMontant;
	private JRadioButton radioChargeIndex;
	private JRadioButton radioChargePasIndex;
	
	private GestionAjouterCharge gestionClic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterCharge frame = new AjouterCharge();
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
	public AjouterCharge() {
		this.gestionClic = new GestionAjouterCharge(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Nom de la Charge");
		lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_1);
		
		textFieldNomCharge = new JTextField();
		textFieldNomCharge.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		textFieldNomCharge.setColumns(10);
		panel_3.add(textFieldNomCharge);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel.add(panel_4, BorderLayout.SOUTH);
		panel_4.setBackground(new Color(45, 72, 224));
		
		radioChargeIndex = new JRadioButton("Charge avec Index");
		radioChargeIndex.addActionListener(this.gestionClic);


		buttonGroup.add(radioChargeIndex);
		radioChargeIndex.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_4.add(radioChargeIndex);
		
		radioChargePasIndex = new JRadioButton("Charge sans Index");
		radioChargePasIndex.addActionListener(this.gestionClic);
		
		buttonGroup.add(radioChargePasIndex);
		radioChargePasIndex.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_4.add(radioChargePasIndex);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 0, 0, 0));
		panel_5.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_5.add(panel_8);
		
		JLabel lblNewLabel_3 = new JLabel("Index:");
		lblNewLabel_3.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_8.add(lblNewLabel_3);
		
		textFieldIndex = new JTextField();
		
		textFieldIndex.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_8.add(textFieldIndex);
		textFieldIndex.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_5.add(panel_7);
		
		JLabel lblNewLabel_2 = new JLabel("Provision:");
		lblNewLabel_2.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_7.add(lblNewLabel_2);
		
		textFieldProvision = new JTextField();
		textFieldProvision.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_7.add(textFieldProvision);
		textFieldProvision.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_2.add(panel_6);
		panel_6.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		
		JLabel lblNewLabel_4 = new JLabel("Montant");
		lblNewLabel_4.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_4);
		
		textFieldMontant = new JTextField();
		textFieldMontant.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_6.add(textFieldMontant);
		textFieldMontant.setColumns(10);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(28, 12, 78));
		contentPane.add(header, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ajouter Une Charge");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 22));
		header.add(lblNewLabel);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_9.add(panel_10);
		panel_10.setBackground(new Color(45, 72, 224));
		
		JButton btnAnnuler = new JButton("Annuler");
		panel_10.add(btnAnnuler);
		
		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11);
		panel_11.setBackground(new Color(45, 72, 224));
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(this.gestionClic);
		panel_11.add(btnValider);
		activerModif(true);
	}


	public void activerModif(boolean b) {
		textFieldProvision.setEditable(b);
		textFieldProvision.setEnabled(b);
	
		textFieldIndex.setEditable(b);
		textFieldIndex.setEnabled(b);
		
		textFieldMontant.setEditable(!b);
		textFieldMontant.setEnabled(!b);
		
		this.radioChargeIndex.setSelected(b);
		this.radioChargePasIndex.setSelected(!b);
	}

	public JTextField getTextFieldNomCharge() {
		return textFieldNomCharge;
	}
	
	public JTextField getTextFieldProvision() {
		return textFieldProvision;
	}

	public JTextField getTextFieldIndex() {
		return textFieldIndex;
	}

	public JTextField getTextFieldMontant() {
		return textFieldMontant;
	}
}
