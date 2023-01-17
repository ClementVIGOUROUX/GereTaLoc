package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionConnexion;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Connexion extends JInternalFrame{
	
	private JPanel contentPane;
	private JPasswordField fieldmdp;
	private JTextField fieldnom;
	private GestionConnexion gestionClic ;

	public Connexion() {
		
		this.gestionClic = new GestionConnexion(this);
		
		setTitle("Se Connecter");
		setFrameIcon(new ImageIcon(Connexion.class.getResource("/vue/icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		setBounds(100, 100, 870, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(new Color(236, 248, 255));
		
		JPanel contenumidle = new JPanel();
		contentPane.add(contenumidle);
		contenumidle.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panellogin = new JPanel();
		contenumidle.add(panellogin);
		panellogin.setLayout(new GridLayout(0, 2, 0, 0));
		panellogin.setBackground(new Color(236, 248, 255));
		
		
		JPanel gaucheo = new JPanel();
		panellogin.add(gaucheo);
		gaucheo.setBackground(new Color(236, 248, 255));
		gaucheo.setLayout(new GridLayout(2, 0, 0, 0));
		gaucheo.setBackground(new Color(236, 248, 255));
		
		JPanel g2 = new JPanel();
		FlowLayout fl_g2 = (FlowLayout) g2.getLayout();
		fl_g2.setVgap(50);
		fl_g2.setAlignment(FlowLayout.RIGHT);
		gaucheo.add(g2);
		g2.setBackground(Color.WHITE);
		
		JLabel login = new JLabel("Nom d'utilisateur :");
		login.setHorizontalAlignment(SwingConstants.LEFT);
		g2.add(login);
		login.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		
		JPanel g3 = new JPanel();
		FlowLayout fl_g3 = (FlowLayout) g3.getLayout();
		fl_g3.setAlignment(FlowLayout.RIGHT);
		gaucheo.add(g3);
		g3.setBackground(Color.WHITE);
		
		JLabel mdp = new JLabel("Mot de passe :");
		g3.add(mdp);
		mdp.setHorizontalAlignment(SwingConstants.RIGHT);
		mdp.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		
		JPanel droiteo = new JPanel();
		panellogin.add(droiteo);
		droiteo.setLayout(new GridLayout(2, 0, 0, 0));
		droiteo.setBackground(new Color(236, 248, 255));
		
		JPanel d2 = new JPanel();
		FlowLayout fl_d2 = (FlowLayout) d2.getLayout();
		fl_d2.setVgap(50);
		fl_d2.setAlignment(FlowLayout.LEFT);
		droiteo.add(d2);
		d2.setBackground(Color.WHITE);
		
		fieldnom = new JTextField();
		fieldnom.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		d2.add(fieldnom);
		fieldnom.setColumns(10);
		
		JPanel d3 = new JPanel();
		FlowLayout fl_d3 = (FlowLayout) d3.getLayout();
		fl_d3.setAlignment(FlowLayout.LEFT);
		droiteo.add(d3);
		d3.setBackground(Color.WHITE);
		
		fieldmdp = new JPasswordField();
		fieldmdp.addKeyListener(this.gestionClic);
		d3.add(fieldmdp);
		fieldmdp.setColumns(10);
		fieldmdp.setHorizontalAlignment(SwingConstants.CENTER);
		fieldmdp.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		
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
		
		JButton valider = new JButton("Connecter");
		valider.addActionListener(this.gestionClic);

		valider.setBackground(new Color(0, 255, 0));
		valider.setForeground(Color.WHITE);
		valider.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelvalider.add(valider);
		
		JPanel haut = new JPanel();
		contentPane.add(haut, BorderLayout.NORTH);
		haut.setBackground(new Color(28, 12, 78));
		
		JLabel seco = new JLabel("Se Connecter");
		seco.setFont(new Font("Roboto Condensed", Font.PLAIN, 25));
		seco.setForeground(Color.WHITE);
		haut.add(seco);
		
		JPanel gauche = new JPanel();
		contentPane.add(gauche, BorderLayout.WEST);
		gauche.setBackground(new Color(28, 12, 78));
		
		JPanel droite = new JPanel();
		contentPane.add(droite, BorderLayout.EAST);
		droite.setBackground(new Color(28, 12, 78));
	}
	
	public String getValeurChLogin() {
		return this.fieldnom.getText();
	}
	
	public char[] getValeurPasswordField() {
		return this.fieldmdp.getPassword();
	}
	
}
