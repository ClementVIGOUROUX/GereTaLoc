package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.data.category.DefaultCategoryDataset;

import modele.Bail;
import modele.Immeuble;
import modele.Locataire;
import modele.Logement;
import modele.Proprietaire;
import modele.dao.CictOracleDataSource;
import modele.dao.DaoBail;
import modele.dao.DaoImmeuble;
import modele.dao.DaoLocataire;
import modele.dao.DaoLogement;
import modele.dao.DaoProprietaire;
import modele.dao.Iterateur;
import vue.Accueil;
import vue.Charge;
import vue.Connexion;
import vue.DeclarationFiscale;
import vue.InformationProp;
import vue.MesLocataires;
import vue.MesLocation;
import vue.MesLogements;
import vue.Statistiques;

public class GestionAccueil implements ActionListener,WindowListener {
	
	private Accueil accueil ;
	private MesLogements mesLogements ;
	private MesLocataires mesLocataires ;
	private MesLocation mesLocation ;
	private Charge charge ;
	private DeclarationFiscale declarationFiscale ;
	private Statistiques statistiques ;
	
	public GestionAccueil(Accueil accueil) {
		this.accueil = accueil ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Mes informations"):
			InformationProp info = new InformationProp();
			DaoProprietaire daoProp = new DaoProprietaire();
			Proprietaire p = null ;
			try {
				p = daoProp.findById("1");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			info.setTnom(p.getNom());
			info.setTprenom(p.getPrenom());
			info.setTmail(p.getEmail());
			info.setTnum(p.getTelephone());
			accueil.getContentPane().add(info);
			info.setVisible(true);
			break;
			
			
		case("Se connecter"):
			Connexion con = new Connexion();
			accueil.getContentPane().add(con);
			con.setVisible(true);
			//accueil.setNomCo("thierry.millan");
			break;
			
			
		case("Se deconnecter"):
			try {
				CictOracleDataSource.Deconnecter();
				JOptionPane.showMessageDialog(accueil,"Deconnexion reussie", "Information", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			accueil.activerItems(false);
			//accueil.setNomCo("Connexion");
			break;
			
		
		case("Mes Logements"):
			DaoImmeuble daoImmeuble =  new DaoImmeuble();
			Iterateur<Immeuble> iterateurImmeuble = null;
			this.mesLogements = new MesLogements();
			try {
				iterateurImmeuble = daoImmeuble.findAllIterateur();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			int i = 0 ;
			while (iterateurImmeuble.hasNext() && i < 20) {
				GestionMesLogements.ecrireLigneTableImmeuble(mesLogements.getTableimmeuble(), i, iterateurImmeuble.next());
				i++;
			}
			mesLogements.setVisible(true);
			mesLogements.toFront();
			break;
			
			
			
			
		case("Mes Locations"):
			this.mesLocation = new MesLocation();
			DaoLogement daoLogement = new DaoLogement();
			Iterateur<Logement> iterateurLogement = null;
			
			try {
				iterateurLogement = daoLogement.findAllIterateur();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			int ix = 0 ;
			while (iterateurLogement.hasNext() && ix < 20) {
				GestionMesLocations.ecrireLigneTableLogement(mesLocation.getTablelogement(), ix, iterateurLogement.next());
				ix++;
			}
			
			this.mesLocation.setVisible(true);
			this.mesLocation.toFront();
			break;
			
			
		case("Mes Locataires"):
			DaoLocataire daoLocataire =  new DaoLocataire();
		Iterateur<Locataire> iterateurLocataire = null;
		this.mesLocataires = new MesLocataires();
		try {
			iterateurLocataire = daoLocataire.findAllIterateur();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		int i2 = 0 ;
		while (iterateurLocataire.hasNext() && i2 < 20) {
			GestionMesLocataires.ecrireLigneTableLocataire(mesLocataires.getTablelocataire(), i2, iterateurLocataire.next());
			i2++;
		}
		mesLocataires.setVisible(true);
		mesLocataires.toFront();
		break;
			
			
		case("Charges"):
			DaoLocataire dl = new DaoLocataire();
		DaoBail db = new DaoBail();
		Iterateur<Locataire> il = null;
		this.charge = new Charge();
		
		try {
			il = dl.findAllAvecBail();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		int x = 0 ;
		while (il.hasNext() && x < 10) {
			Locataire l = il.next();
			System.out.println(l);
			Bail b = null;
			try {
				b = db.findByLocataireIterateurUnique(Integer.toString(l.getIdLoc())).next();
				System.out.println(b);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			GestionCharge.ecrireLigneTableLogement(this.charge.getTableLogement(),x,b,l);
			x++;
		}
		this.charge.setVisible(true);
		this.charge.toFront();
			break;
		
			
		case("D?claration Fiscale"):
			this.declarationFiscale = new DeclarationFiscale();
			DaoBail dbz = new DaoBail();
			double revenu = 0;
			double tf = 0;
			double travaux = 0;
			try {
				revenu = dbz.getRevenuImmobilier();
				tf = dbz.getTaxeFonciere();
				travaux = dbz.getMontantTravaux();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
			this.declarationFiscale.getLabelMontantTravaux().setText(String.format("%.2f ???",travaux));
			this.declarationFiscale.getLabelAdeclarer().setText(String.format("%.2f ???",tf));
			this.declarationFiscale.getLabelRI().setText(String.format("%.2f ???",revenu));
			
			this.declarationFiscale.setVisible(true);
			this.declarationFiscale.toFront();
			break ;
			
		case("Statistiques"):
			System.out.println(e.getActionCommand() + " : Pas encore fait.");
			
			/*
			DaoLocataire daoLocataireStats = new DaoLocataire();
			Iterateur<Locataire> iterateurLocataireStats = null ;
			try {
				iterateurLocataireStats = daoLocataireStats.findAllAvecBail();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			*/
			
			//DefaultCategoryDataset datasetAge = new DefaultCategoryDataset();
			//Locataire locataire = null ;
			//while(iterateurLocataireStats.hasNext()) {
				//locataire = iterateurLocataireStats.next();
				//datasetAge.addValue(locataire, null, null);
			//}
				 //datasetAge.addValue(20, "Series 1", "Data Point 1");
			       //datasetAge.addValue(45, "Series 1", "Data Point 2");
			       //datasetAge.addValue(83, "Series 1", "Data Point 3");
			/*
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			DaoBail daoBail = new DaoBail();
			List<Bail> listBaux = new ArrayList<Bail>();
			try {
				listBaux = daoBail.findAll();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			for (Bail bail : listBaux) {
				dataset.addValue(bail.getDateDebut(), null, null);
			}
			
			*/
			
			DaoLocataire daoLocataireStats = new DaoLocataire();
			Iterateur<Locataire> iterateurLocataireStats = null ;
			try {
				iterateurLocataireStats = daoLocataireStats.findAllAvecBail();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			DefaultCategoryDataset datasetSexe = new DefaultCategoryDataset();
			Locataire locataire = null ;
			int nbHommes = 0 ;
			int nbFemmes = 0 ;
			int nbAutres = 0 ;
			while(iterateurLocataireStats.hasNext()) {
				locataire = iterateurLocataireStats.next();
				if (locataire.getSexe().equals("M")) {
					nbHommes ++ ;
				} else if (locataire.getSexe().equals("F")) {
					nbFemmes++ ;
				} else {
					nbAutres++ ;
				}
			}
			
			datasetSexe.addValue(nbHommes, "Series 1", "Hommes");
			datasetSexe.addValue(nbFemmes, "Series 1", "Femmes");
	       	datasetSexe.addValue(nbAutres, "Series 1", "Autres");
	       
			
			/*
	       DaoBail daoBail = new DaoBail();
			try {
				System.out.println(daoBail.getNbBauxParMois()); 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			*/
	       
	       
			this.statistiques = new Statistiques(datasetSexe);
			this.statistiques.setVisible(true);
			this.statistiques.toFront();
			break;
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		if (this.accueil.getEstConnecte() == true) {
			try {
				CictOracleDataSource.Deconnecter();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("d??connexion");
		}
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void viderTable(JTable table) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		int nbCol = modeleTable.getColumnCount();
		int nbLignes = modeleTable.getRowCount();
		
		for (int i = 0; i < nbCol; i++) {
			for (int j = 0; j < nbLignes; j++) {
				modeleTable.setValueAt(null, j, i);
			}
		}
	}

}
