package controleur;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modele.Immeuble;
import modele.Logement;
import modele.dao.DaoImmeuble;
import modele.dao.DaoLogement;
import modele.dao.Iterateur;
import vue.MesLogements;



public class GestionTableImmeuble implements ListSelectionListener {

	MesLogements mesLogements;
	DaoImmeuble daoImmeuble;
	
	public GestionTableImmeuble(MesLogements mesLogements) {
		this.mesLogements = mesLogements ;
		this.daoImmeuble = new DaoImmeuble();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int index = mesLogements.getTableimmeuble().getSelectedRow();
		Iterateur<Immeuble> iterateurImmeuble = null;
		try {
			iterateurImmeuble = daoImmeuble.findAllIterateur();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		List<Immeuble> lc = new LinkedList<Immeuble>() ;
		int i = 0 ;
		while (iterateurImmeuble.hasNext() && i < 10) {
			lc.add(iterateurImmeuble.next());
		}
		DaoLogement daoLogement = new DaoLogement();
		String str =Integer.toString(lc.get(index).getIdImmeuble()) ;
		List<Logement>  ListLogement = null ;
		try {
			ListLogement = daoLogement.findListLogementByImmeuble(str);
			System.out.println(ListLogement);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	    Iterator<Logement> iteratorLogement = ListLogement.iterator();
	    int j = 0 ;
	    while(iteratorLogement.hasNext()) {
	       this.ecrireLigneTableLogement(mesLogements.getTablelogement(), j, iteratorLogement.next());
	       j++ ;
	        
	    }
	   
	}
	
	
	public void ecrireLigneTableLogement(JTable table, int numLigne, Logement logement) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		modeleTable.setValueAt(logement.getNumero(), numLigne, 0);
		modeleTable.setValueAt(logement.getSurface(), numLigne, 1);
		modeleTable.setValueAt(logement.getNbPieces(), numLigne, 2);
		modeleTable.setValueAt(logement.isGarage(), numLigne, 3);
		modeleTable.setValueAt(logement.getParking(), numLigne, 4);
	}
	
	
	
}
