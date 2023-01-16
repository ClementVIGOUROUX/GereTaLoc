package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controleur.GestionInfoProp;

import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class InformationProp extends JInternalFrame {

	private JPanel contentPane;
	private JTextField tnom;
	private JTextField tprenom;
	private JTextField tmail;
	private JTextField tnum;
	private JCheckBox checkm;
	private GestionInfoProp gestionClic ;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformationProp frame = new InformationProp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JCheckBox getCheckm() {
		return checkm;
	}

	/**
	 * Create the frame.
	 */
	public InformationProp() {
		
		this.gestionClic = new GestionInfoProp(this);
		
		setFrameIcon(new ImageIcon(InformationProp.class.getResource("/vue/icone.png")));
		setTitle("Mes Informations");
		setBounds(100, 100, 939, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel Haut = new JPanel();
		getContentPane().add(Haut, BorderLayout.NORTH);
		Haut.setBackground(new Color(28, 12, 78));
		Haut.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Mes Informations");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 24));
		Haut.add(lblNewLabel);
		
		checkm = new JCheckBox("Modifier");
		checkm.addActionListener(this.gestionClic);
		checkm.setForeground(Color.WHITE);
		checkm.setHorizontalAlignment(SwingConstants.CENTER);
		checkm.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		Haut.add(checkm);
		checkm.setBackground(new Color(28, 12, 78));
		
		
		
		JPanel mid = new JPanel();
		contentPane.add(mid, BorderLayout.CENTER);
		mid.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel gauche = new JPanel();
		mid.add(gauche);
		gauche.setLayout(new GridLayout(4, 4, 0, 0));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setVgap(30);
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		gauche.add(panel_4);
		panel_4.setBackground(Color.WHITE); 
		
		JLabel nom = new JLabel("Nom : ");
		nom.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		nom.setVerticalAlignment(SwingConstants.TOP);
		nom.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(nom);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setVgap(30);
		flowLayout_5.setAlignment(FlowLayout.RIGHT);
		gauche.add(panel_5);
		panel_5.setBackground(Color.WHITE); 
		
		JLabel prenom = new JLabel("Prenom : ");
		prenom.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_5.add(prenom);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setVgap(30);
		flowLayout_6.setAlignment(FlowLayout.RIGHT);
		gauche.add(panel_6);
		panel_6.setBackground(Color.WHITE); 
		
		JLabel email = new JLabel("Email : ");
		email.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_6.add(email);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
		flowLayout_7.setVgap(30);
		flowLayout_7.setAlignment(FlowLayout.RIGHT);
		gauche.add(panel_7);
		panel_7.setBackground(Color.WHITE);
		
		JLabel tel = new JLabel("Num\u00E9ro de T\u00E9l\u00E9phone : ");
		tel.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_7.add(tel);
		
		JPanel droite = new JPanel();
		mid.add(droite);
		droite.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(30);
		flowLayout.setAlignment(FlowLayout.LEFT);
		droite.add(panel);
		panel.setBackground(Color.WHITE);
		
		tnom = new JTextField();
		tnom.setEnabled(false);
		tnom.setEditable(false);
		panel.add(tnom);
		tnom.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(30);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		droite.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		
		tprenom = new JTextField();
		tprenom.setEnabled(false);
		tprenom.setEditable(false);
		panel_1.add(tprenom);
		tprenom.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(30);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		droite.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		
		tmail = new JTextField();
		tmail.setEditable(false);
		tmail.setEnabled(false);
		panel_2.add(tmail);
		tmail.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setVgap(30);
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		droite.add(panel_3);
		panel_3.setBackground(Color.WHITE);
		
		tnum = new JTextField();
		tnum.setEditable(false);
		tnum.setEnabled(false);
		panel_3.add(tnum);
		tnum.setColumns(10);
		
		
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
	}
	
	public void activerModif(boolean b) {
			tnom.setEditable(b);
			tnom.setEnabled(b);
			
			tprenom.setEditable(b);
			tprenom.setEnabled(b);
			
			tmail.setEditable(b);
			tmail.setEnabled(b);
			
			tnum.setEditable(b);
			tnum.setEnabled(b);
		}
	
	public String getTnom() {
		return tnom.getText();
	}

	public void setTnom(String tnom) {
		this.tnom.setText(tnom);
	}

	public String getTprenom() {
		return tprenom.getText();
	}

	public void setTprenom(String tprenom) {
		this.tprenom.setText(tprenom); 
	}

	public String getTmail() {
		return tmail.getText();
	}

	public void setTmail(String tmail) {
		this.tmail.setText(tmail);
	}

	public String getTnum() {
		return tnum.getText();
	}

	public void setTnum(String tnum) {
		this.tnum.setText(tnum);
	}
	
	
	

}
