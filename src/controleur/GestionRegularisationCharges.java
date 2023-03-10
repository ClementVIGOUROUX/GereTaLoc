package controleur;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Bail;
import modele.Charge;
import modele.Locataire;
import modele.Logement;
import modele.dao.DaoBail;
import modele.dao.DaoCharge;
import modele.dao.Iterateur;
import rapport.CreerRapportChargesMoinsUnAn;
import rapport.CreerRapportSoldeToutCompte;
import vue.RegularisationDesCharges;

public class GestionRegularisationCharges implements ActionListener{
	
	private RegularisationDesCharges regularisationDesCharges;
	private Bail bail ;
	private List<Charge> listCharges = new LinkedList<Charge>() ;
	private Period period ;
	private Logement logement ;
	
	public GestionRegularisationCharges(RegularisationDesCharges regularisationDesCharges) {
		this.regularisationDesCharges = regularisationDesCharges ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Annuler"):
			this.regularisationDesCharges.dispose();
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
			
			
			try {
				new CreerRapportChargesMoinsUnAn(this.bail, this.listCharges);
				System.out.println("Fichier cree");
			} catch (SQLException | IOException | ParseException e2) {
				e2.printStackTrace();
			}
			
			if(period.getYears() <= 0 && period.getMonths() <= 0 && period.getDays() <= 0) {
				LocalDate dateRenouvellement = (LocalDate.parse(this.bail.getDateDebutRenouvellement()).plusYears(1)).minusDays(1);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String dateRenouvele = dateRenouvellement.format(formatter);
				//est ce que ca save vrm ?
				// A TESTER AVEC UNE DATE SUPERIEUR A UN AN
				bail.setDateFin(dateRenouvele);
			}
			
			this.regularisationDesCharges.dispose();
			break;
		case("Valider"):
			logement = (Logement) this.regularisationDesCharges.getComboBoxLogement().getSelectedItem();
			System.out.println(logement);
			DaoBail daoBail = new DaoBail() ;
			this.bail = null ;
			try {
				this.bail = daoBail.findByLogement(logement.getNumero(), Integer.toString(logement.getImmeuble().getIdImmeuble()));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(this.bail == null) {
				this.regularisationDesCharges.getLabelRegularisation().setText("Ce logement n'est li??? ??? aucun bail"); 
				this.regularisationDesCharges.getLabelJour().setText("");
				this.regularisationDesCharges.getPanelDroite().setVisible(false);
			} else {
				LocalDate from = java.time.LocalDate.now();
				LocalDate to = LocalDate.parse(this.bail.getDateDebutRenouvellement()).plusYears(1);
				period = Period.between(from, to);
				
				if(period.getYears() <= 0 && period.getMonths() <= 0 && period.getDays() <= 0) {
					this.regularisationDesCharges.getLabelRegularisation().setText("R?gularisation annuelle possible");
					this.regularisationDesCharges.getLabelJour().setText("");
					
				} else {
					this.regularisationDesCharges.getLabelRegularisation().setText("R?gularisation annuelle dans"); 
					this.regularisationDesCharges.getLabelJour().setText(period.getMonths() + "mois et " + period.getDays() + " jours");
				}
				this.regularisationDesCharges.getPanelDroite().setVisible(true);
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
				ecrireLigneTableRegularisation(this.regularisationDesCharges.getTable(), i, iterateur.next());
				i++ ;
			}
			break ;
		case(" Valider "):
			Charge charge = null ;
			try {
				charge = lireLigneTableRegularisation(this.regularisationDesCharges.getTable(),this.regularisationDesCharges.getTable().getSelectedRow());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			charge.setBail(this.bail);
			charge.setIndex_final(Integer.parseInt(this.regularisationDesCharges.getFieldIndexFinal())) ;
			
			charge.setPrixUnite(Float.parseFloat(this.regularisationDesCharges.getFieldPrix())) ;
			JOptionPane.showMessageDialog(this.regularisationDesCharges,"L'index final et le prix ??? l'unit??? de la charge " + charge.getNom() + " a bien ???t??? pris en compte ", "Information", JOptionPane.INFORMATION_MESSAGE);
			listCharges.add(charge);
				
			
			
		}
	}
	
	public static void ecrireLigneTableRegularisation(JTable table, int numLigne, modele.Charge charge) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		modeleTable.setValueAt(charge.getNom(), numLigne, 0);
		modeleTable.setValueAt(charge.getIndex_c(), numLigne, 1);
		modeleTable.setValueAt(charge.getMontant(), numLigne, 2);
	}
	
	
	public Charge lireLigneTableRegularisation(JTable table, int numLigne) throws SQLException {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		Charge charge = new Charge(numLigne, (String) modeleTable.getValueAt(numLigne, 0), (int) modeleTable.getValueAt(numLigne, 1), (int) (modeleTable.getValueAt(numLigne, 2)), null);
		return charge ;
		
	}
}