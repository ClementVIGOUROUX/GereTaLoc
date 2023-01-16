package controleur;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Bail;
import modele.Locataire;
import modele.Logement;
import modele.dao.DaoLogement;
import modele.dao.Iterateur;
import vue.AjouterCharge;
import vue.Charge;
import vue.RegularisationDesCharges;

public class GestionCharge implements ActionListener{
	
	private Charge charge;
	
	public GestionCharge(Charge cha) {
		this.charge = cha;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Quitter"):
			this.charge.dispose();
			break;
		case("Imprimer Total"):
			this.charge.dispose();
			break;
		case("Ajouter une charge"):
			AjouterCharge ajouterCharge = new AjouterCharge();
			ajouterCharge.setVisible(true);
			ajouterCharge.toFront();
			break;
		case("Regularisation"):
			RegularisationDesCharges regularisationCharges = new RegularisationDesCharges();
			DaoLogement daoLogement = new DaoLogement();
			JComboBox<Logement> comboBox =  regularisationCharges.getComboBoxLogement();
			Iterateur<Logement> iterateurLogement = null ;
			
			try {
				iterateurLogement = daoLogement.findAllIterateur();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			DefaultComboBoxModel<Logement> dml = new DefaultComboBoxModel<Logement>();
			while(iterateurLogement.hasNext()) {
				dml.addElement(iterateurLogement.next());
			}
			comboBox.setModel(dml);
			
			
			
			regularisationCharges.setVisible(true);
			regularisationCharges.toFront();
			break ;
		}
	}
	
	public static void ecrireLigneTableLogement(JTable table, int numLigne, Bail b, Locataire locataire) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		modeleTable.setValueAt(b.getLogement().getImmeuble().getRue(), numLigne, 0);
		modeleTable.setValueAt(b.getLogement().getImmeuble().getCp(), numLigne, 1);
		modeleTable.setValueAt(b.getLogement().getNumero(), numLigne, 2);
		modeleTable.setValueAt(locataire.getNom(), numLigne, 3);
		modeleTable.setValueAt(locataire.getPrenom(), numLigne, 4);
	}
}