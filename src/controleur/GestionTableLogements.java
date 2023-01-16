package controleur;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modele.Logement;
import modele.dao.DaoLogement;
import modele.dao.Iterateur;
import vue.MesLogements;



public class GestionTableLogements implements ListSelectionListener {

	MesLogements mesLogements;
	DaoLogement daoLogement;
	
	public GestionTableLogements(MesLogements mesLogements) {
		this.mesLogements = mesLogements ;
		this.daoLogement = new DaoLogement();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int index = mesLogements.getTablelogement().getSelectedRow();
		if (index == -1) {
			mesLogements.getBinfo().setVisible(false);
		}else {
			mesLogements.getBinfo().setVisible(true);
			Iterateur<Logement> iterateurLogement = null;
			try {
				iterateurLogement = daoLogement.findAllIterateur();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			List<Logement> listLogement = new LinkedList<Logement>() ;
			int i = 0 ;
			while (iterateurLogement.hasNext() && i < 10) {
				listLogement.add(iterateurLogement.next());
			}
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
