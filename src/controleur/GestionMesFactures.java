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

import modele.Entreprise;
import modele.Facture;
import modele.Logement;
import modele.dao.DaoEntreprise;
import modele.dao.DaoLogement;
import modele.dao.Iterateur;
import vue.AjouterFacture;
import vue.AjouterFactureLogement;

import vue.MesFactures;

public class GestionMesFactures implements ActionListener {
	
	private MesFactures mesFactures ;
	
	public GestionMesFactures(MesFactures factures) {
		this.mesFactures = factures ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Quitter"):
			mesFactures.dispose();
			break;
		case("Ajouter Facture Immeuble"):
			AjouterFacture af = new AjouterFacture();
			DaoEntreprise daoEntreprise1 = new DaoEntreprise();
			JComboBox<String> comboBox1 = af.getComboEntreprise();
			Iterateur<Entreprise> iterateurEntreprise1 = null;
		
			try {
				iterateurEntreprise1 = daoEntreprise1.findAllIterateur();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			List<String> listEntreprise = new LinkedList<String>() ;
			int i = 0 ;
			while (iterateurEntreprise1.hasNext() && i < 10) {
				listEntreprise.add(iterateurEntreprise1.next().getNomEnteprise());
			}
			
			DefaultComboBoxModel<String> dme1 = new DefaultComboBoxModel<String>();
			for (int j = 0; j < listEntreprise.size(); j++) {
				dme1.addElement(listEntreprise.get(j));
			}

			comboBox1.setModel(dme1);
		
			af.setVisible(true);
			af.toFront();
			break;	
		case("Ajouter Facture Logement"):
			AjouterFactureLogement afl = new AjouterFactureLogement();
		
			DaoEntreprise daoEntreprise2 = new DaoEntreprise();
			JComboBox<String> comboBox2 = afl.getComboEntreprise();
			Iterateur<Entreprise> iterateurEntreprise2 = null;
		
			try {
				iterateurEntreprise2 = daoEntreprise2.findAllIterateur();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			List<String> listEntreprise2 = new LinkedList<String>() ;
			int k = 0 ;
			while (iterateurEntreprise2.hasNext() && k < 10) {
				listEntreprise2.add(iterateurEntreprise2.next().getNomEnteprise());
			}
			
			DefaultComboBoxModel<String> dme2 = new DefaultComboBoxModel<String>();
			for (int l = 0; l < listEntreprise2.size(); l++) {
				dme2.addElement(listEntreprise2.get(l));
			}
	
			comboBox2.setModel(dme2);
			
			DaoLogement daoLogement = new DaoLogement();
			JComboBox<String> comboBox3 = afl.getComboLogement();
			List<Logement> listeLogement = null;
		
			try {
				listeLogement = daoLogement.findListLogementByImmeuble(String.valueOf(GestionMesLogements.immeuble.getIdImmeuble()));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			List<String> listLogement = new LinkedList<String>() ;
			for (Logement loge : listeLogement) {
				listLogement.add(loge.getNumero());
			}
			
			DefaultComboBoxModel<String> dme3 = new DefaultComboBoxModel<String>();
			for (int m = 0; m < listLogement.size(); m++) {
				dme3.addElement(listLogement.get(m));
			}
	
			comboBox3.setModel(dme3);
		
			afl.setVisible(true);
			afl.toFront();

			break;
		}
	}
	
	public static void ecrireLigneTableFacture(JTable tablefacture, int numLigne, Facture facture) {
		DefaultTableModel modeleTable = (DefaultTableModel) tablefacture.getModel();
		modeleTable.setValueAt(facture.getnFacture(), numLigne, 0);
		modeleTable.setValueAt(facture.getTypeF(), numLigne, 1);
		modeleTable.setValueAt(facture.getDateF(), numLigne, 2);
		modeleTable.setValueAt(facture.getMontant(), numLigne, 3);
		modeleTable.setValueAt(facture.getEntreprise().getnSiret(), numLigne, 4);
		modeleTable.setValueAt(facture.getEntreprise().getTelephone(), numLigne, 5);
		modeleTable.setValueAt(facture.getEntreprise().getEmail(), numLigne, 6);
		modeleTable.setValueAt(facture.getEntreprise().getVille(), numLigne, 7);
		modeleTable.setValueAt(facture.getEntreprise().getAdresse(), numLigne, 8);
	}
}