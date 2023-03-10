package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.GestionMesLocations;
import controleur.GestionTableBail;
import controleur.GestionTableEDLBail;

public class MesLocation extends JFrame {

	private JPanel contentPane;
	private JTable tablelogement;
	private JTable tablebail;
	private JTable tableetat;
	private JTable tablecaution;
	private JTable tablecharge;
	private JTable tablelocataire;
	private JTable tableloyer;
	private JTable tableagence;
	private JButton btnAjouter;
	private JButton btnTelecharger;
	
	private GestionMesLocations gestionClic;
	private GestionTableBail gestionTableBail ;
	private GestionTableEDLBail gestionTableEDLBail;

	public MesLocation() {
		this.gestionClic = new GestionMesLocations(this);
		this.gestionTableBail = new GestionTableBail(this);
		this.gestionTableEDLBail = new GestionTableEDLBail(this);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MesLocation.class.getResource("/vue/icone.png")));
		setResizable(true);
		setTitle("Mes Locations");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 872, 552);
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
		
		JButton bajouter = new JButton("Ajouter");
		bajouter.addActionListener(this.gestionClic);
		
		bajouter.setForeground(new Color(0, 0, 0));
		bajouter.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		bajouter.setBackground(new Color(0, 255, 0));
		hleft.add(bajouter);
		
		JLabel Titre = new JLabel("Mes Locations");
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
		
		JButton btnArchiver = new JButton("Archiver");
		btnArchiver.addActionListener(this.gestionClic);
		btnArchiver.setForeground(Color.BLACK);
		btnArchiver.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		btnArchiver.setBackground(new Color(221, 160, 221));
		hright.add(btnArchiver);
		
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
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		panel_5.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_5.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel = new JLabel("Logements");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_5.add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane, BorderLayout.CENTER);
		
		tablelogement = new JTable();
		tablelogement.getTableHeader().setReorderingAllowed(false);
		tablelogement.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"N\u00B0", "Ville", "Rue"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.tablelogement.getSelectionModel().addListSelectionListener(this.gestionTableBail);
		scrollPane.setViewportView(tablelogement);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_4.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_1 = new JLabel("Bails");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);
		
		tablebail = new JTable();
		tablebail.getTableHeader().setReorderingAllowed(false);
		tablebail.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"Date D\u00E9but", "Date Fin"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(tablebail);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_4.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_2.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		panel_11.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_5 = new JLabel("Locataires");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_11.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		panel_11.add(scrollPane_5, BorderLayout.CENTER);
		
		tablelocataire = new JTable();
		tablelocataire.getTableHeader().setReorderingAllowed(false);
		tablelocataire.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Nom", "Pr\u00E9nom", "Profession"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_5.setViewportView(tablelocataire);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_2.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		panel_12.setBackground(new Color(45, 72, 224));
		
		JScrollPane scrollPane_6 = new JScrollPane();
		panel_12.add(scrollPane_6, BorderLayout.CENTER);
		
		tableloyer = new JTable();
		tableloyer.getTableHeader().setReorderingAllowed(false);
		tableloyer.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Mode", "Montant", "Date", "Provisions"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_6.setViewportView(tableloyer);
		
		JPanel panel_1 = new JPanel();
		panel_12.add(panel_1, BorderLayout.NORTH);
		panel_1.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_6 = new JLabel("Loyer");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_6);
		
		JButton bAjouterLoyer = new JButton("Ajouter Loyer");
		bAjouterLoyer.addActionListener(this.gestionClic);
		bAjouterLoyer.setBackground(new Color(255, 255, 255));
		panel_1.add(bAjouterLoyer);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_2.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		panel_10.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_7 = new JLabel("Agence");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_10.add(lblNewLabel_7, BorderLayout.NORTH);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		panel_10.add(scrollPane_7, BorderLayout.CENTER);
		
		tableagence = new JTable();
		tableagence.getTableHeader().setReorderingAllowed(false);
		tableagence.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Siret", "Nom", "Adresse", "Code Postal", "Ville", "N\u00B0 T\u00E9l\u00E9phone", "Mail"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_7.setViewportView(tableagence);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_6.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		panel_8.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_4 = new JLabel("Charges");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_8.add(lblNewLabel_4, BorderLayout.NORTH);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_8.add(scrollPane_4, BorderLayout.CENTER);
		
		tablecharge = new JTable();
		tablecharge.getTableHeader().setReorderingAllowed(false);
		tablecharge.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Partie Fixe", "Index initial", "Index Final"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_4.setViewportView(tablecharge);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_6.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		panel_9.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_3 = new JLabel("Caution");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_9.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_9.add(scrollPane_3, BorderLayout.CENTER);
		
		tablecaution = new JTable();
		tablecaution.getTableHeader().setReorderingAllowed(false);
		tablecaution.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Nom", "Email", "N\u00B0 T\u00E9l\u00E9phone"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_3.setViewportView(tablecaution);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_6.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_7.add(scrollPane_2, BorderLayout.CENTER);
		
		tableetat = new JTable();
		tableetat.getTableHeader().setReorderingAllowed(false);
		tableetat.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
			},
			new String[] {
				"Date"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_2.setViewportView(tableetat);
		
		this.tableetat.getSelectionModel().addListSelectionListener(gestionTableEDLBail);
		
		JPanel panel_13 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(28, 12, 78), 2));
		panel_13.setForeground(Color.WHITE);
		panel_7.add(panel_13, BorderLayout.NORTH);
		panel_13.setBackground(new Color(45, 72, 224));
		
		JLabel lblNewLabel_2 = new JLabel("Etat Des Lieux");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_13.add(lblNewLabel_2);
		
		JPanel panel_14 = new JPanel();
		panel_7.add(panel_14, BorderLayout.SOUTH);
		
		btnAjouter = new JButton(" Ajouter");
		panel_14.add(btnAjouter);
		btnAjouter.addActionListener(gestionClic);
		btnAjouter.setEnabled(false);
		
		btnTelecharger = new JButton("Telecharger");
		panel_14.add(btnTelecharger);
		btnTelecharger.addActionListener(gestionClic);
		btnTelecharger.setEnabled(false);
		
	}

	public JTable getTablelogement() {
		return tablelogement;
	}

	public JTable getTablebail() {
		return tablebail;
	}

	public JTable getTableetat() {
		return tableetat;
	}

	public JTable getTablecaution() {
		return tablecaution;
	}

	public JTable getTablecharge() {
		return tablecharge;
	}

	public JTable getTablelocataire() {
		return tablelocataire;
	}

	public JTable getTableloyer() {
		return tableloyer;
	}

	public JTable getTableagence() {
		return tableagence;
	}

	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	public JButton getBtnTelecharger() {
		return btnTelecharger;
	}

	public void setBtnAjouter(JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
	}

	public void setBtnTelecharger(JButton btnTelecharger) {
		this.btnTelecharger = btnTelecharger;
	}
	
}
