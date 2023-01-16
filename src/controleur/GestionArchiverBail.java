package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Bail;
import modele.Charge;
import modele.Logement;
import modele.dao.DaoBail;
import modele.dao.DaoCharge;
import modele.dao.Iterateur;
import rapport.CreerRapportSoldeToutCompte;
import vue.ArchiverBail;

public class GestionArchiverBail implements ActionListener{
	
	private ArchiverBail archiverBail;
	private Bail bail ;

	private List<Charge> listCharges = new LinkedList<Charge>();
	
	public GestionArchiverBail (ArchiverBail arch) {
		this.archiverBail = arch;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Annuler"):
			archiverBail.dispose();
			break;
		case("  Valider  "):
			DaoCharge daoCharge = new DaoCharge();
			Iterateur<Charge> iterateurCharge = null ;
			try {
				iterateurCharge = daoCharge.findByBailIterateur(Integer.toString(this.bail.getIdBail()));
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
			
			while(iterateurCharge.hasNext()) {
				Charge charge = iterateurCharge.next();
				if (charge.getIndex_c() == 0) {
					charge.setIndex_final(0);
					charge.setPrixUnite(0);
					this.listCharges.add(charge);
				}
			}
			
			DaoBail daoBail = new DaoBail() ;
			int resteCaution = 0 ;
			
			if (this.archiverBail.getFieldDeduireCaution() == null) {
				resteCaution = this.bail.getDepotGarantie() ;
			}else {
				resteCaution = this.bail.getDepotGarantie() - Integer.parseInt(this.archiverBail.getFieldDeduireCaution()) ;
			}
			LocalDate date = java.time.LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			this.bail.setDateFin(date.format(formatter));
			daoBail.updateDateFin(bail);
			archiverBail.dispose();
			try {
				new CreerRapportSoldeToutCompte(this.bail, this.listCharges, resteCaution);
			} catch (SQLException | IOException | ParseException e2) {
				e2.printStackTrace();
			}
			System.out.println("Fichier créé");
			break;
		case("Valider"):
			Logement logement = (Logement) this.archiverBail.getComboLogement().getSelectedItem();
			DaoBail daoBail2 = new DaoBail();
			this.bail = null ;
			try {
				this.bail = daoBail2.findByLogement(logement.getNumero(),Integer.toString(logement.getImmeuble().getIdImmeuble()));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			DaoCharge daoCharge2 = new DaoCharge();
			Iterateur<Charge> iterateur = null;
			
			try {
				iterateur = daoCharge2.findByBailIterateur(Integer.toString(this.bail.getIdBail()));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			int i = 0 ;
			while(iterateur.hasNext()) {
				ecrireLigneTableArchiver(this.archiverBail.getTable(), i, iterateur.next());
				i++ ;
			}
			break ;
			
		case(" Valider "):
			Charge charge = null ;
			try {
				charge = lireLigneTableArchiver(this.archiverBail.getTable(),this.archiverBail.getTable().getSelectedRow());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			charge.setBail(this.bail);
			charge.setIndex_final(Integer.parseInt(this.archiverBail.getFieldIndexFinal())) ;
			charge.setPrixUnite(Float.parseFloat(this.archiverBail.getFieldPrix())) ;
			JOptionPane.showMessageDialog(this.archiverBail,"L'index final et le prix à l'unité de la charge " + charge.getNom() + " a bien été pris en compte ", "Information", JOptionPane.INFORMATION_MESSAGE);
			listCharges.add(charge);
			
		}
	}
	
	
	public static void ecrireLigneTableArchiver(JTable table, int numLigne, modele.Charge charge) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		modeleTable.setValueAt(charge.getNom(), numLigne, 0);
		modeleTable.setValueAt(charge.getIndex_c(), numLigne, 1);
		modeleTable.setValueAt(charge.getMontant(), numLigne, 2);
	}
	
	
	public Charge lireLigneTableArchiver(JTable table, int numLigne) throws SQLException {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		Charge charge = new Charge(numLigne, (String) modeleTable.getValueAt(numLigne, 0), (int) modeleTable.getValueAt(numLigne, 1), (int) (modeleTable.getValueAt(numLigne, 2)), null);
		return charge ;
		
	}
	
	
}