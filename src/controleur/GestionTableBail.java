package controleur;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modele.Agence;
import modele.Bail;
import modele.Caution;
import modele.EtatdesLieux;
import modele.Locataire;
import modele.Logement;
import modele.Paiement;
import modele.dao.DaoAgence;
import modele.dao.DaoBail;
import modele.dao.DaoCaution;
import modele.dao.DaoEtatdesLieux;
import modele.dao.DaoLocataire;
import modele.dao.DaoLogement;
import modele.dao.DaoPaiement;
import modele.dao.Iterateur;
import vue.MesLocation;


public class GestionTableBail implements ListSelectionListener {

	private MesLocation mesLocation;
	private DaoBail daoBail;
	private DaoLogement daoLogement;
	private DaoLocataire daoLocataire;
	private DaoCaution daoCaution;
	private DaoAgence daoAgence;
	private DaoEtatdesLieux daoEDL;
	private DaoPaiement daoPaiement;
	public static Bail bail;
	public static int idImmeuble;
	public static String numeroLogement;
	
	public GestionTableBail(MesLocation mesLocation) {
		this.mesLocation = mesLocation ;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		//Table Bail
		GestionAccueil.viderTable(mesLocation.getTablebail());
		GestionAccueil.viderTable(mesLocation.getTablelocataire());
		GestionAccueil.viderTable(mesLocation.getTablecaution());
		GestionAccueil.viderTable(mesLocation.getTableagence());
		GestionAccueil.viderTable(mesLocation.getTableetat());
		GestionAccueil.viderTable(mesLocation.getTableloyer());
		
		daoLocataire = new DaoLocataire();
		daoLogement = new DaoLogement();
		daoBail = new DaoBail();
		daoCaution = new DaoCaution();
		daoAgence = new DaoAgence();
		daoEDL = new DaoEtatdesLieux();
		daoPaiement = new DaoPaiement();
		
		int index = mesLocation.getTablelogement().getSelectedRow();
		
		Iterateur<Logement> iterateurLogement = null;
		try {
			iterateurLogement = daoLogement.findAllIterateur();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		List<Logement> ll = new LinkedList<Logement>() ;
		int i = 0 ;
		while (iterateurLogement.hasNext()) {
			ll.add(iterateurLogement.next());
		}
		
		idImmeuble = ll.get(index).getImmeuble().getIdImmeuble();
		numeroLogement = ll.get(index).getNumero();
		
		
		Iterateur<Bail> iterateurBail = null;
		try {
			iterateurBail = daoBail.findByLogementImmeubleIterateur(numeroLogement,Integer.toString(idImmeuble));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		List<Bail> lb = new LinkedList<Bail>() ;
		i = 0 ;
		while (iterateurBail.hasNext() && i < 20) {
			lb.add(iterateurBail.next());
		}
		Iterator<Bail> ilb = lb.iterator();
	    bail = lb.get(0);
		
		//Table locataire
		Iterateur<Locataire> iterateurLocataire = null;
		try {
			iterateurLocataire = daoLocataire.findByLogementImmeubleIterateur(numeroLogement,Integer.toString(idImmeuble));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		List<Locataire> llc = new LinkedList<Locataire>() ;
		i = 0 ;
		while (iterateurLocataire.hasNext() && i < 20) {
			llc.add(iterateurLocataire.next());
		}
		Iterator<Locataire> illc = llc.iterator();
		
		//Table Caution
		Iterateur<Caution> iterateurCaution = null;
		try {
			iterateurCaution = daoCaution.findByLogementImmeubleIterateur(numeroLogement,Integer.toString(idImmeuble));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		List<Caution> lc = new LinkedList<Caution>();
		i = 0 ;
		while (iterateurCaution.hasNext() && i < 20) {
			lc.add(iterateurCaution.next());
		}
		Iterator<Caution> ilc = lc.iterator();
		
		//Table Agence
		Iterateur<Agence> iterateurAgence = null;
		try {
			iterateurAgence = daoAgence.findByLogementImmeubleIterateur(numeroLogement,Integer.toString(idImmeuble));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		List<Agence> la = new LinkedList<Agence>();
		i = 0 ;
		while (iterateurAgence.hasNext() && i < 20) {
			la.add(iterateurAgence.next());
		}
		Iterator<Agence> ila = la.iterator();
		
		// Table loyer
		Iterateur<Paiement> iterateurPaiement = null;
		try {
			iterateurPaiement = daoPaiement.findByLogementImmeubleIterateur(numeroLogement,Integer.toString(idImmeuble));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		List<Paiement> lp = new LinkedList<Paiement>();
		i = 0 ;
		while (iterateurPaiement.hasNext() && i < 20) {
			lp.add(iterateurPaiement.next());
		}
		Iterator<Paiement> ilp = lp.iterator();
		
		
		//Ecrire table Bail
		int j = 0 ;
	    while(ilb.hasNext()) {
	       this.ecrireLigneTableBail(this.mesLocation.getTablebail(), j, ilb.next());
	       j++;
	    }
	    
	    //Table EDL
  		Iterateur<EtatdesLieux> iterateurEDL = null;
  		try {
  			iterateurEDL = daoEDL.findByLogementImmeubleIterateur(numeroLogement,Integer.toString(idImmeuble));
  		} catch (SQLException e1) {
  			e1.printStackTrace();
  		}
  		
  		List<EtatdesLieux> ledl = new LinkedList<EtatdesLieux>();
  		i = 0 ;
  		while (iterateurEDL.hasNext() && i < 20) {
  			ledl.add(iterateurEDL.next());
  		}
  		Iterator<EtatdesLieux> iledl = ledl.iterator();
   
  		//Ecrire table Locataire
  		j = 0 ;
  	    while(illc.hasNext()) {
  	       this.ecrireLigneTableLocataire(this.mesLocation.getTablelocataire(), j, illc.next());
  	       j++;
  	    }
  	    
	  	//Ecrire table Caution
  		j = 0 ;
  	    while(ilc.hasNext()) {
  	       this.ecrireLigneTableCaution(this.mesLocation.getTablecaution(), j, ilc.next());
  	       j++;
  	    }
  	    
  	    //Ecrire table Agence
  		j = 0 ;
  	    while(ila.hasNext()) {
  	       this.ecrireLigneTableAgence(this.mesLocation.getTableagence(), j, ila.next());
  	       j++;
  	    }
  	    
  	    //Ecrire table EDL
  		j = 0 ;
  	    while(iledl.hasNext()) {
  	       this.ecrireLigneTableEDL(this.mesLocation.getTableetat(), j, iledl.next());
  	       j++;
  	    }
  	    
  	    //Ecrire table Loyer
  	    j = 0 ;
	    while(ilp.hasNext()) {
	       this.ecrireLigneTableLoyer(this.mesLocation.getTableloyer(), j, ilp.next());
	       j++;
	    }
	}
	
	
	public void ecrireLigneTableBail(JTable table, int numLigne, Bail bail) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		modeleTable.setValueAt(bail.getDateDebut(), numLigne, 0);
		modeleTable.setValueAt(bail.getDateFin(), numLigne, 1);
	}
	
	public void ecrireLigneTableLocataire(JTable table, int numLigne, Locataire locataire) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		modeleTable.setValueAt(locataire.getNom(), numLigne, 0);
		modeleTable.setValueAt(locataire.getPrenom(), numLigne, 1);
		modeleTable.setValueAt(locataire.getProfession(), numLigne, 2);
	}
	
	public void ecrireLigneTableCaution(JTable table, int numLigne, Caution caution) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		modeleTable.setValueAt(caution.getNom(), numLigne, 0);
		modeleTable.setValueAt(caution.getEmail(), numLigne, 1);
		modeleTable.setValueAt(caution.getTelephone(), numLigne, 2);
	}
	
	public void ecrireLigneTableAgence(JTable table, int numLigne, Agence agence) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		modeleTable.setValueAt(agence.getnSiret(), numLigne, 0);
		modeleTable.setValueAt(agence.getNom(), numLigne, 1);
		modeleTable.setValueAt(agence.getAdresse(), numLigne, 2);
		modeleTable.setValueAt(agence.getCp(), numLigne, 3);
		modeleTable.setValueAt(agence.getVille(), numLigne, 4);
		modeleTable.setValueAt(agence.getTelephone(), numLigne, 5);
		modeleTable.setValueAt(agence.getEmail(), numLigne, 6);
	}
	
	public void ecrireLigneTableEDL(JTable table, int numLigne, EtatdesLieux edl) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		modeleTable.setValueAt(edl.getDateEDL(), numLigne, 0);
	}
	
	public void ecrireLigneTableLoyer(JTable table, int numLigne, Paiement paiement) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		modeleTable.setValueAt(paiement.getMoyen(), numLigne, 0);
		modeleTable.setValueAt(paiement.getMontant(), numLigne, 1);
		modeleTable.setValueAt(paiement.getDateP(), numLigne, 2);
		modeleTable.setValueAt(paiement.getProvisionCharges(), numLigne, 3);
	}
}
