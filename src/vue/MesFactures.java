package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.GestionMesFactures;
import controleur.GestionTableImmeuble;

public class MesFactures extends JFrame {

	private JPanel contentPane;
	private JTable tableimmeuble;
	private JTable tablelogement;
	
	private GestionMesFactures gestionClic ;
	private GestionTableImmeuble gestionTable ;

	public MesFactures() {
		
		this.gestionClic = new GestionMesFactures(this);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MesFactures.class.getResource("/vue/icone.png")));
		setTitle("Mes Logements");
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
		
		JPanel hleft_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) hleft_1.getLayout();
		flowLayout_2.setHgap(0);
		flowLayout_2.setVgap(12);
		hleft_1.setBackground(new Color(28, 12, 78));
		BAS.add(hleft_1);
		
		JLabel Titre = new JLabel("Factures");
		Titre.setHorizontalAlignment(SwingConstants.CENTER);
		Titre.setForeground(Color.WHITE);
		Titre.setFont(new Font("Roboto Condensed", Font.PLAIN, 24));
		hleft_1.add(Titre);
		
		JPanel hleft_1_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) hleft_1_1.getLayout();
		flowLayout_3.setVgap(12);
		hleft_1_1.setBackground(new Color(28, 12, 78));
		BAS.add(hleft_1_1);
		
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
		
		JPanel mid = new JPanel();
		contentPane.add(mid, BorderLayout.CENTER);
		mid.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pantab = new JPanel();
		mid.add(pantab);
		pantab.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		pantab.add(panel_4, BorderLayout.SOUTH);
		panel_4.setBackground(new Color(45, 72, 224));
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		panel_2.setBackground(new Color(45, 72, 224));
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton bajouter = new JButton("Ajouter Facture Immeuble");
		bajouter.addActionListener(this.gestionClic);
		panel_2.add(bajouter);
		bajouter.setForeground(Color.BLACK);
		bajouter.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		bajouter.setBackground(new Color(152, 251, 152));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		panel_4.add(panel);
		panel.setBackground(new Color(45, 72, 224));
		
		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3);
		panel_3.setBackground(new Color(45, 72, 224));
		
		JButton bajouter_1 = new JButton("Ajouter Facture Logement");
		bajouter_1.addActionListener(this.gestionClic);
		bajouter_1.setForeground(Color.BLACK);
		bajouter_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		bajouter_1.setBackground(new Color(152, 251, 152));
		panel_3.add(bajouter_1);
		
		JPanel centre = new JPanel();
		pantab.add(centre, BorderLayout.CENTER);
		centre.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(45, 72, 224));
		centre.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImmeuble = new JLabel("Facture Immeuble");
		lblImmeuble.setForeground(Color.WHITE);
		lblImmeuble.setBackground(Color.WHITE);
		lblImmeuble.setHorizontalAlignment(SwingConstants.CENTER);
		lblImmeuble.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		panel_6.add(lblImmeuble, BorderLayout.NORTH);
		
		
		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane, BorderLayout.CENTER);
		
		tableimmeuble = new JTable();
		tableimmeuble.getTableHeader().setReorderingAllowed(false);

		tableimmeuble.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00B0", "Type", "Date", "Montant", "Entreprise", "N\u00B0T\u00E9l\u00E9phone", "Mail", "Ville", "Adresse"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPane.setViewportView(tableimmeuble);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		centre.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(45, 72, 224));
		centre.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Facture Logements");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		panel_7.add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_7.add(scrollPane_1, BorderLayout.CENTER);
		
		tablelogement = new JTable();
		tablelogement.getTableHeader().setReorderingAllowed(false);
		tablelogement.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
				},
				new String[] {
					"N\u00B0", "Type", "Date", "Montant", "Entreprise", "N\u00B0T\u00E9l\u00E9phone", "Mail", "Ville", "Adresse"
				}
			
			
			
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			
			
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		
		});
		scrollPane_1.setViewportView(tablelogement);
		
		this.tableimmeuble.getSelectionModel().addListSelectionListener(this.gestionTable);
		
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTable getTableimmeuble() {
		return tableimmeuble;
	}

	public JTable getTablelogement() {
		return tablelogement;
	}

	public GestionMesFactures getGestionClic() {
		return gestionClic;
	}

	public GestionTableImmeuble getGestionTable() {
		return gestionTable;
	}
	
}

