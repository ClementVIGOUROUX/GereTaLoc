package controleur;

import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modele.Locataire;
import modele.dao.DaoCharge;
import modele.dao.DaoLocataire;
import modele.dao.Iterateur;
import vue.Charge;



public class GestionTableCharge implements ListSelectionListener {

	static Charge charge;
	DaoCharge daoCharge;
	DaoLocataire daoLocataire;
	
	public GestionTableCharge(Charge c) {
		charge = c ;
		this.daoCharge = new DaoCharge();
		}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		GestionAccueil.viderTable(charge.getTableCharges());
		daoLocataire = new DaoLocataire();
		Iterateur<Locataire> il = null;
		try {
			il = daoLocataire.findAllAvecBail();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		LinkedList<Locataire> ll = new LinkedList<>();
		int index = charge.getTableLogement().getSelectedRow();
		Locataire loc = null;
		while (il.hasNext()) {
			ll.add(il.next());
		}
		if (index != -1) {
			this.enableButtons(true);
			Iterateur<modele.Charge> iterateurCharge = null;
			loc = ll.get(index);
			try {
				iterateurCharge = daoCharge.findByLocataireIterateur(Integer.toString(loc.getIdLoc()));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		int i = 0;
		
		while (iterateurCharge.hasNext() && i < 10) {
			ecrireLigneTableCharge(charge.getTableCharges(), i, iterateurCharge.next());
			i++;
		}
			
		}
		else {
			this.enableButtons(false);
		}
		
	   
	}
	
	
	public static void ecrireLigneTableCharge(JTable table, int numLigne, modele.Charge charge) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		modeleTable.setValueAt(charge.getNom(), numLigne, 0);
		modeleTable.setValueAt(charge.getIndex_c(), numLigne, 1);
		modeleTable.setValueAt(charge.getMontant(), numLigne, 2);
	}
	
	public void enableButtons (Boolean b) {
		charge.getbAjouterCharge().setEnabled(b);
		charge.getbImprimerTotal().setEnabled(b);
	}
	
	public static int getRowSelected() {
		return charge.getTableLogement().getSelectedRow();
	}
}
