package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Bail;
import modele.Locataire;
import vue.Statistiques;

public class GestionStatistiques implements ActionListener {
		private Statistiques statistiques;
	
	public GestionStatistiques(Statistiques statistiques) {
		this.statistiques = statistiques ;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Quitter"):
			statistiques.dispose();
			break;
			}
	}	
	
	public static void ecrireLigneTableStatistiques(JTable table, int numLigne, Bail b, Locataire locataire) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		
	}

}