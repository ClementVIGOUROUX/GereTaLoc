package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controleur.GestionImmeuble;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterImmeuble extends JFrame {

	private JPanel contentPane;
	private JTextField fieldrue;
	private JTextField fieldcp;
	private JTextField fieldville;
	private JTextField fieldpays;
	private JCheckBox checkfibre ;
	private GestionImmeuble gestionClic ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterImmeuble frame = new AjouterImmeuble();
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
	public AjouterImmeuble() {
		
		this.gestionClic = new GestionImmeuble(this);
		
		setBackground(Color.WHITE);
		setTitle("Ajouter un Immeuble");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AjouterImmeuble.class.getResource("/vue/icone3.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		

		JPanel Haut = new JPanel();
		getContentPane().add(Haut, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ajouter un Immeuble ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 24));
		Haut.add(lblNewLabel);
		Haut.setBackground(new Color(28, 12, 78));
		
		JPanel mid = new JPanel();
		contentPane.add(mid, BorderLayout.CENTER);
		mid.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panelcp = new JPanel();
		mid.add(panelcp);
		panelcp.setLayout(new GridLayout(0, 2, 0, 0));
		panelcp.setBackground(Color.WHITE);
		
		JLabel pays = new JLabel("Pays :");
		pays.setBackground(Color.WHITE);
		pays.setHorizontalAlignment(SwingConstants.RIGHT);
		pays.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelcp.add(pays);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel.getLayout();
		flowLayout_4.setVgap(22);
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panelcp.add(panel);
		panel.setBackground(Color.WHITE);
		
		fieldpays = new JTextField();
		fieldpays.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel.add(fieldpays);
		fieldpays.setColumns(10);
		
		JPanel panelville = new JPanel();
		mid.add(panelville);
		panelville.setLayout(new GridLayout(0, 2, 0, 0));
		panelville.setBackground(Color.WHITE);
		
		JLabel ville = new JLabel("Ville :");
		ville.setHorizontalAlignment(SwingConstants.RIGHT);
		ville.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelville.add(ville);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		flowLayout_2.setVgap(22);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelville.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		
		fieldville = new JTextField();
		fieldville.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_1.add(fieldville);
		fieldville.setColumns(10);
		
		JPanel panelpays = new JPanel();
		mid.add(panelpays);
		panelpays.setLayout(new GridLayout(0, 2, 0, 0));
		panelpays.setBackground(Color.WHITE);
		
		JLabel cp = new JLabel("Code postal :");
		cp.setHorizontalAlignment(SwingConstants.RIGHT);
		cp.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelpays.add(cp);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_2.getLayout();
		flowLayout_3.setVgap(22);
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelpays.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		
		fieldcp = new JTextField();
		fieldcp.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_2.add(fieldcp);
		fieldcp.setColumns(10);
		
		JPanel panelrue = new JPanel();
		mid.add(panelrue);
		panelrue.setLayout(new GridLayout(0, 2, 0, 0));
		panelrue.setBackground(Color.WHITE);
		
		JLabel rue = new JLabel("Rue :");
		rue.setHorizontalAlignment(SwingConstants.RIGHT);
		rue.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelrue.add(rue);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setVgap(22);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelrue.add(panel_3);
		panel_3.setBackground(Color.WHITE);
		
		fieldrue = new JTextField();
		fieldrue.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_3.add(fieldrue);
		fieldrue.setColumns(10);
		
		JPanel panelfibre = new JPanel();
		mid.add(panelfibre);
		panelfibre.setLayout(new GridLayout(0, 2, 0, 0));
		panelfibre.setBackground(Color.WHITE);
		
		JLabel fibre = new JLabel("Fibre :");
		fibre.setHorizontalAlignment(SwingConstants.RIGHT);
		fibre.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panelfibre.add(fibre);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setVgap(25);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelfibre.add(panel_4);
		panel_4.setBackground(Color.WHITE);
		
		checkfibre = new JCheckBox("");
		checkfibre.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_4.add(checkfibre);
		
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
	
	
	public String getPays() {
		return this.fieldpays.getText();
	}
	
	public String getVille() {
		return this.fieldville.getText();
	}
	
	public String getCP() {
		return this.fieldcp.getText();
	}
	
	public String getRue() {
		return this.fieldrue.getText();
	}

	public boolean isFibre() {
		return this.checkfibre.isSelected();
	}
	
}
