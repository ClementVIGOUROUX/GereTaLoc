package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modele.Locataire;
import vue.AjouterLocataire;
import vue.MesLocataires;

public class GestionMesLocataires implements ActionListener {
	
	private MesLocataires mesLocataires ;
	
	public GestionMesLocataires(MesLocataires locataires) {
		this.mesLocataires = locataires ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Quitter"):
			mesLocataires.dispose();
			break;
		case("Ajouter"):
			AjouterLocataire al = new AjouterLocataire();
			al.setVisible(true);
			al.toFront();

			break;
		}
	}
	
	
	
	public static void  ecrireLigneTableLocataire(JTable table, int numLigne, Locataire locataire) {
		
		String stringSexe ;
		if (locataire.getSexe().equals("M")) {
			stringSexe = "Homme" ;
		} else if (locataire.getSexe().equals("F")){
			stringSexe = "Femme" ;
		} else {
			stringSexe = "Non renseigné";
		}
		
		
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		modeleTable.setValueAt(locataire.getNom(), numLigne, 0);
		modeleTable.setValueAt(locataire.getPrenom(), numLigne, 1);
		modeleTable.setValueAt(locataire.getTelephone(), numLigne, 2);
		modeleTable.setValueAt(locataire.getEmail(), numLigne, 3);
		modeleTable.setValueAt(stringSexe, numLigne, 4);
		modeleTable.setValueAt(locataire.getProfession(), numLigne, 5);
	}
	
	

}
