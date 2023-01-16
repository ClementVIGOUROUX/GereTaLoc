package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Immeuble;
import modele.Locataire;
import modele.Logement;
import modele.dao.DaoImmeuble;
import modele.dao.DaoLocataire;
import modele.dao.DaoLogement;
import modele.dao.Iterateur;
import vue.AjouterBail;
import vue.AjouterPaiement;
import vue.ArchiverBail;
import vue.MesLocation;

public class GestionMesLocations implements ActionListener {

	private MesLocation mesLocation ;
	
	public GestionMesLocations(MesLocation locations) {
		this.mesLocation = locations ;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Quitter"):
			mesLocation.dispose();
			break;
		case("Ajouter"):
			AjouterBail aln = new AjouterBail();
			DaoImmeuble daoImmeuble = new DaoImmeuble();
			DaoLocataire daoLocataire = new DaoLocataire();
			JComboBox<Immeuble> comboBox1 = aln.getComboImmeuble();
			JComboBox<Locataire> comboBox2 = aln.getComboLocataire();
			Iterateur<Immeuble> iterateurImmeuble = null;
			Iterateur<Locataire> iterateurLocataire = null;
			
			// Mettre les logements dans la liste deroulante de logements
			try {
				iterateurImmeuble = daoImmeuble.findAllIterateur();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			List<Immeuble> listImmeuble = new LinkedList<Immeuble>() ;
			int i = 0 ;
			while (iterateurImmeuble.hasNext() && i < 10) {
				listImmeuble.add(iterateurImmeuble.next());
			}
			
			DefaultComboBoxModel<Immeuble> dme1 = new DefaultComboBoxModel<Immeuble>();
			for (int j = 0; j < listImmeuble.size(); j++) {
				dme1.addElement(listImmeuble.get(j));
			}
	
			comboBox1.setModel(dme1);
			
			// Mettre les locataires dans la liste deroulante de locataires
			try {
				iterateurLocataire = daoLocataire.findSansBailIterateur();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			List<Locataire> listLocataire = new LinkedList<Locataire>() ;
			int k = 0 ;
			while (iterateurLocataire.hasNext() && k < 10) {
				listLocataire.add(iterateurLocataire.next());
			}
			
			DefaultComboBoxModel<Locataire> dme2 = new DefaultComboBoxModel<Locataire>();
			for (int j = 0; j < listLocataire.size(); j++) {
				dme2.addElement(listLocataire.get(j));
			}
	
			comboBox2.setModel(dme2);
		
			aln.setVisible(true);
			aln.toFront();
	
			break;
		case("Ajouter Loyer"):
			AjouterPaiement ajtp =  new AjouterPaiement();
			ajtp.setVisible(true);
			ajtp.toFront();
			break;
		case("Archiver"):
			ArchiverBail archiverBail = new ArchiverBail();
			DaoLogement daoLogement = new DaoLogement();
			
			JComboBox<Logement> comboBox = archiverBail.getComboLogement();
			Iterateur<Logement> iterateurLogement = null;
			
			try {
				iterateurLogement = daoLogement.findAllIterateur();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			List<Logement> listLogements = new LinkedList<Logement>() ;
			int i2 = 0 ;
			while (iterateurLogement.hasNext() && i2 < 10) {
				listLogements.add(iterateurLogement.next());
			}
			
			DefaultComboBoxModel<Logement> dml= new DefaultComboBoxModel<Logement>();
			for (int j = 0; j < listLogements.size(); j++) {
			  dml.addElement(listLogements.get(j));
			}

			comboBox.setModel(dml);
			
			
			//comboBox.setModel(new DefaultComboBoxModel<String>(.toArray(new String[0])));
			archiverBail.setVisible(true);
			archiverBail.toFront();
			break;
			
			
			
	}
	}
	
	public static void ecrireLigneTableLogement(JTable tablelogement, int numLigne, Logement logement) {
		DefaultTableModel modeleTable = (DefaultTableModel) tablelogement.getModel();
		modeleTable.setValueAt(logement.getNumero(), numLigne, 0);
		modeleTable.setValueAt(logement.getImmeuble().getVille(), numLigne, 1);
		modeleTable.setValueAt(logement.getImmeuble().getRue(), numLigne, 2);
	}
	
}
