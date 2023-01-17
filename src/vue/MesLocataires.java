package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.GestionLocataire;
import controleur.GestionMesLocataires;
import controleur.GestionMesLogements;

public class MesLocataires extends JFrame{

	private JPanel contentPane;
	private JTable tablelocataire;
	
	private GestionMesLocataires gestionClic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MesLocataires frame = new MesLocataires();
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
	public MesLocataires() {
		System.out.println();
		this.gestionClic = new GestionMesLocataires(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 872, 552);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));
		
		JPanel HAUT = new JPanel();
		header.add(HAUT, BorderLayout.NORTH);
		HAUT.setLayout(new GridLayout(0, 3, 0, 0));
		HAUT.setBackground(new Color(236, 248, 255));
		
		JPanel BAS = new JPanel();
		BAS.setBackground(new Color(28, 12, 78));
		header.add(BAS, BorderLayout.SOUTH);
		BAS.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel hleft = new JPanel();
		FlowLayout flowLayout = (FlowLayout) hleft.getLayout();
		flowLayout.setVgap(12);
		flowLayout.setHgap(0);
		BAS.add(hleft);
		hleft.setBackground(new Color(28, 12, 78));
		
		JLabel Titre = new JLabel("Mes Locataires");
		Titre.setHorizontalAlignment(SwingConstants.CENTER);
		Titre.setForeground(Color.WHITE);
		Titre.setFont(new Font("Roboto Condensed", Font.PLAIN, 24));
		BAS.add(Titre);
		
		JPanel hright = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) hright.getLayout();
		flowLayout_1.setVgap(12);
		flowLayout_1.setHgap(0);
		BAS.add(hright);
		hright.setBackground(new Color(28, 12, 78));
		
		JPanel cote = new JPanel();
		contentPane.add(cote, BorderLayout.EAST);
		cote.setBackground(new Color(28, 12, 78));
		
		JPanel cote2 = new JPanel();
		contentPane.add(cote2, BorderLayout.WEST);
		cote2.setBackground(new Color(28, 12, 78));
		
		JPanel bottom = new JPanel();
		contentPane.add(bottom, BorderLayout.SOUTH);
		bottom.setBackground(new Color(28, 12, 78));
		bottom.setLayout(new BorderLayout(0, 0));
		
		JPanel panquit = new JPanel();
		bottom.add(panquit, BorderLayout.WEST);
		panquit.setBackground(new Color(28, 12, 78));
		
		
		JButton quitter = new JButton("Quitter");
		quitter.addActionListener(this.gestionClic);
		quitter.setBackground(new Color(255, 0, 51));
		quitter.setForeground(Color.WHITE);
		quitter.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		quitter.setHorizontalAlignment(SwingConstants.LEFT);
		panquit.add(quitter);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setBackground(new Color(45, 72, 224));
		
		JButton bajouter_1 = new JButton("Ajouter");
		bajouter_1.addActionListener(this.gestionClic);
		bajouter_1.setForeground(Color.BLACK);
		bajouter_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		bajouter_1.setBackground(new Color(152, 251, 152));
		panel_1.add(bajouter_1);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tablelocataire = new JTable();
		tablelocataire.getTableHeader().setReorderingAllowed(false);
		tablelocataire.setForeground(new Color(0, 0, 0));
		tablelocataire.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Nom", "Pr\u00E9nom", "N\u00B0 T\u00E9l\u00E9phone", "Email", "Sexe", "Profession"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablelocataire.getColumnModel().getColumn(2).setPreferredWidth(85);
		scrollPane.setViewportView(tablelocataire);
		
	}

	public JTable getTablelocataire() {
		return tablelocataire;
	}
	
	
	
}
