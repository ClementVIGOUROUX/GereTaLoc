package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionAccueil;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;

public class Accueil extends JFrame{

	private JPanel contentPane;		
	private boolean estConnecte = false;
	private JMenuItem sedeco ;
	private JMenuItem seco;
	private JMenuItem mesinfo;
	private JButton mleg;
	private JButton mloc;
	private JButton mloca;
	private JButton mCharge;
	private JButton mStats;
	private JButton mDF;
	private GestionAccueil gestionClic ;
	private JMenu nom;
	

	//Main de l'application GereTaLoc
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {	
				try {
					Accueil frame = new Accueil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Accueil() {
		this.gestionClic = new GestionAccueil(this);
		addWindowListener(this.gestionClic);
		setTitle("Geretaloc");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Accueil.class.getResource("/vue/icone3.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 544);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));
		
		JPanel HAUT = new JPanel();
		header.add(HAUT, BorderLayout.NORTH);
		HAUT.setBackground(Color.WHITE);
		HAUT.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(20);
		HAUT.add(panel, BorderLayout.EAST);
		panel.setBackground(Color.WHITE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel.add(menuBar);
		
		nom = new JMenu("Login");
		
		nom.setHorizontalAlignment(SwingConstants.CENTER);
		nom.setForeground(Color.BLACK);
		nom.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		menuBar.add(nom);
		
		mesinfo = new JMenuItem("Mes informations");
		mesinfo.addActionListener(this.gestionClic);
		
		mesinfo.setHorizontalAlignment(SwingConstants.CENTER);
		mesinfo.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		nom.add(mesinfo);
		
		seco = new JMenuItem("Se connecter");
		seco.addActionListener(this.gestionClic);
		
		seco.setHorizontalAlignment(SwingConstants.CENTER);
		seco.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		nom.add(seco);
		
		sedeco = new JMenuItem("Se deconnecter");
		sedeco.addActionListener(this.gestionClic);
		
		
		sedeco.setHorizontalAlignment(SwingConstants.CENTER);
		sedeco.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		nom.add(sedeco);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Accueil.class.getResource("/vue/geretaloca.png")));
		HAUT.add(lblNewLabel, BorderLayout.WEST);
		
		JPanel BAS = new JPanel();
		BAS.setBackground(new Color(28, 12, 78));
		header.add(BAS, BorderLayout.SOUTH);
		
		JLabel Titre = new JLabel("Page d'accueil");
		Titre.setFont(new Font("Roboto Condensed", Font.PLAIN, 24));
		Titre.setForeground(Color.WHITE);
		BAS.add(Titre);
		
		JPanel mid = new JPanel();
		header.add(mid, BorderLayout.CENTER);
		mid.setLayout(new BorderLayout(0, 0));
		
		JPanel navigation = new JPanel();
		mid.add(navigation, BorderLayout.CENTER);
		navigation.setBackground(new Color(45, 72, 224));
		
		mleg = new JButton("Mes Logements");
		mleg.setBackground(Color.WHITE);
		mleg.setToolTipText("");
		navigation.add(mleg);
		mleg.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		
		mloc = new JButton("Mes Locataires");
		mloc.addActionListener(this.gestionClic);
		mloc.setBackground(Color.WHITE);
		mloc.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		navigation.add(mloc);
		
		mloca = new JButton("Mes Locations");
		mloca.setBackground(Color.WHITE);
		mloca.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		navigation.add(mloca);
		
		mCharge = new JButton("Charges");
		mCharge.addActionListener(this.gestionClic);
		mCharge.setBackground(Color.WHITE);
		mCharge.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		navigation.add(mCharge);
		
		mStats = new JButton("Statistiques");
		mStats.addActionListener(this.gestionClic);
		
		mDF = new JButton("Déclaration Fiscale");
		mDF.addActionListener(this.gestionClic);
		mDF.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		mDF.setBackground(Color.WHITE);
		navigation.add(mDF);
		mStats.setBackground(Color.WHITE);
		mStats.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		navigation.add(mStats);
		mleg.addActionListener(this.gestionClic);
		mloca.addActionListener(this.gestionClic);
		
		activerItems(estConnecte);
	}
	
	public void activerItems(boolean b) {
		if(b == true) {
			nom.setText("Thierry Millan");
		}else {
			nom.setText("Login");
		}
		this.setEstConnecte(b);
		sedeco.setEnabled(b);
		seco.setEnabled(!b);
		mesinfo.setEnabled(b);
        mleg.setEnabled(b);
        mloc.setEnabled(b);
        mloca.setEnabled(b);
        mDF.setEnabled(b);
        mStats.setEnabled(b);
        mCharge.setEnabled(b);
    }
	
	public boolean getEstConnecte() {
		return estConnecte;
	}

	public void setEstConnecte(boolean estConnecte) {
		this.estConnecte = estConnecte;
	}
}
