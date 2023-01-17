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
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.GestionMesLogements;
import controleur.GestionTableImmeuble;

import javax.swing.ListSelectionModel;

public class MesLogements extends JFrame {

	private JPanel contentPane;
	private JTable tableimmeuble;
	private JTable tablelogement;
	
	private GestionMesLogements gestionClic ;
	private GestionTableImmeuble gestionTable ;
	private JButton binfo ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MesLogements frame = new MesLogements();
					
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
	public MesLogements() {
		
		this.gestionClic = new GestionMesLogements(this);
		this.gestionTable = new GestionTableImmeuble(this);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MesLogements.class.getResource("/vue/icone.png")));
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
		
		JLabel Titre = new JLabel("Mes Logements");
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
		
		JPanel top = new JPanel();
		pantab.add(top, BorderLayout.NORTH);
		top.setBackground(new Color(45, 72, 224));
		top.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_1 = new JPanel();
		pantab.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		pantab.add(panel_4, BorderLayout.SOUTH);
		panel_4.setBackground(new Color(45, 72, 224));
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		panel_2.setBackground(new Color(45, 72, 224));
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton bInfoIm = new JButton("Informations Immeuble");
		bInfoIm.addActionListener(this.gestionClic);
		bInfoIm.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_2.add(bInfoIm);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		panel_4.add(panel);
		panel.setBackground(new Color(45, 72, 224));
		
		JButton bajouter = new JButton("Ajouter");
		bajouter.addActionListener(this.gestionClic);


		panel.add(bajouter);
		bajouter.setForeground(Color.BLACK);
		bajouter.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		bajouter.setBackground(new Color(152, 251, 152));
		
		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3);
		panel_3.setBackground(new Color(45, 72, 224));
		
		binfo = new JButton("Informations logement");
		binfo.addActionListener(this.gestionClic);
		panel_3.add(binfo);
		binfo.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		
		JButton btnQuittance = new JButton("Quittance");
		btnQuittance.setFont(new Font("Roboto Condensed", Font.PLAIN, 15));
		panel_3.add(btnQuittance);
		btnQuittance.addActionListener(this.gestionClic);
		
		JPanel centre = new JPanel();
		pantab.add(centre, BorderLayout.CENTER);
		centre.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(45, 72, 224));
		centre.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImmeuble = new JLabel("Immeuble");
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
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Code Postal", "Ville", "Pays", "Rue", "Fibre"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tableimmeuble);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		centre.add(panel_5);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(45, 72, 224));
		centre.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Logements");
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
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"N\u00B0","Surface", "Pi\u00E8ces", "Garage", "Parking"
			}
			
			
			
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			
			
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		
		});
		
		this.tableimmeuble.getSelectionModel().addListSelectionListener(this.gestionTable);
		this.tablelogement.getSelectionModel().addListSelectionListener(this.gestionTable);
		scrollPane_1.setViewportView(tablelogement);
		
	}
	
	
	
	public JTable getTableimmeuble() {
		return tableimmeuble;
	}

	public JTable getTablelogement() {
		return tablelogement;
	}

	public JButton getBinfo() {
		return binfo;
	}
	
	
	
}

