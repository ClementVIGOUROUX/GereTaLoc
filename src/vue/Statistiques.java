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
import javax.swing.border.MatteBorder;
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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;



import controleur.GestionMesLogements;
import controleur.GestionStatistiques;
import controleur.GestionTableImmeuble;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Statistiques extends JFrame {

	private JPanel contentPane;
	private GestionStatistiques gestionClic ;
	
	private static final long serialVersionUID = 1L;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistiques frame = new Statistiques(null);
					
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
	public Statistiques(DefaultCategoryDataset dataset) {
		
		this.gestionClic = new GestionStatistiques(this);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Statistiques.class.getResource("/vue/icone.png")));
		setTitle("Stats");
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
		
		JLabel Titre = new JLabel("Statistiques");
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
		
		JPanel Milieu = new JPanel();
		contentPane.add(Milieu, BorderLayout.CENTER);
		Milieu.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		

        // Legende
        JFreeChart chart = ChartFactory.createBarChart(
                "Statistiques", // Chart title
                "Axe X", // X Axis Label
                "Axe Y", // Y Axis Label
                dataset);

        // Ajout chart au chartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        Milieu.add(chartPanel);
        
        JPanel panel = new JPanel();
        Milieu.add(panel);
    }


	
	
	
		
		
		
}
			
			
	
	
	
	


