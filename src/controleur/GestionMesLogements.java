package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Bail;
import modele.Diagnostics;
import modele.Facture;
import modele.Immeuble;
import modele.Logement;
import modele.dao.DaoBail;
import modele.dao.DaoDiagnostics;
import modele.dao.DaoFacture;
import modele.dao.DaoImmeuble;
import modele.dao.Iterateur;
import rapport.CreerRapportQuittanceLoyer;
import vue.AjouterLogement;
import vue.InfoLogement;
import vue.MesFactures;
import vue.MesLogements;

public class GestionMesLogements implements ActionListener {
	
	private MesLogements mesLogements ;
	private InfoLogement infoLogement ;
	private MesFactures mesFactures;
	public static Immeuble immeuble;
	
	public GestionMesLogements(MesLogements logements) {
		this.mesLogements = logements ;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Quitter"):
			mesLogements.dispose();
			break;
		case("Ajouter"):
			AjouterLogement al = new AjouterLogement();
			DaoImmeuble daoImmeuble = new DaoImmeuble();
			JComboBox<Immeuble> comboBox = al.getComboImmeuble();
			Iterateur<Immeuble> iterateurImmeuble = null;
			
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
			
			DefaultComboBoxModel<Immeuble> dml= new DefaultComboBoxModel<Immeuble>();
			for (int j = 0; j < listImmeuble.size(); j++) {
			  dml.addElement(listImmeuble.get(j));
			}

			comboBox.setModel(dml);
			
			
			//comboBox.setModel(new DefaultComboBoxModel<String>(.toArray(new String[0])));
			al.setVisible(true);
			al.toFront();
			break;
		case("Archiver"):
			mesLogements.dispose();
			break;
			
		case("Informations logement"):
		
			DaoDiagnostics daoDiagnostic = new DaoDiagnostics();
			Logement logement = null ;
			Iterateur<Diagnostics> iterateurDiagnostic = null ;
			
			try {
				logement = this.lireLigneTableLogement(mesLogements.getTablelogement(), mesLogements.getTablelogement().getSelectedRow());
				iterateurDiagnostic = daoDiagnostic.findDiagnosticByLogementImmeubleIterateur(Integer.toString(logement.getImmeuble().getIdImmeuble()), logement.getNumero());
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			Diagnostics d = null ;
			this.infoLogement = new InfoLogement(d);
			if (iterateurDiagnostic.hasNext()) {
				d = iterateurDiagnostic.next();
				infoLogement.setFileDia(new File(d.getRepertoire()));
				infoLogement.setDiagnostic(d);
				infoLogement.getbTelecharger().setEnabled(true);
			}else {
				d = null ;
				infoLogement.getbTelecharger().setEnabled(false);
			}
			infoLogement.setDiagnostic(d);
			infoLogement.setLogement(logement);
			
			
			if(logement.getBail() == null) {
				this.infoLogement.getLabelRevision().setText("Ce logement n'est li� � aucun bail");
				this.infoLogement.getLabelJourRevision().setText("");
				this.infoLogement.getbValiderIRL().setEnabled(false);
			} else {
				LocalDate from = java.time.LocalDate.now();
				LocalDate to = LocalDate.parse(logement.getBail().getDateDebut()).plusYears(1);
				Period period = Period.between(from, to);
				this.infoLogement.getLabelJourRevision().setText(period.getMonths() + " mois et " + period.getDays() + " jours");
				this.infoLogement.getbValiderIRL().setEnabled(true);
				
				if(period.getYears() <= 0 && period.getMonths() <= 0 && period.getDays() <= 0) {
					to = LocalDate.parse(logement.getBail().getDateDebut()).plusYears(1);
					period = Period.between(from, to);
					this.infoLogement.getLabelJourRevision().setText(period.getMonths() + " mois et " + period.getDays() + " jours");
					this.infoLogement.getbValiderIRL().setEnabled(true);
				}
				
			}
					
			
			
			/*
			
			DaoFacture daoFacture = new DaoFacture();
			Iterateur<Facture> iterateurFacture = null;
			
			try {
				iterateurFacture = daoFacture.findByLogementImmeubleIterateur(logement.getNumero(), Integer.toString(logement.getImmeuble().getIdImmeuble()));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			int ix = 0 ;
			while (iterateurFacture.hasNext() && ix < 10) {
				GestionInfoLogement.ecrireLigneTableFacture(infoLogement.getTablefacture(), ix, iterateurFacture.next());
				ix++;
			}
			
			*/
			
			
			
			
			infoLogement.setVisible(true);
			infoLogement.toFront();
			
			break;

			
		case("Informations Immeuble"):
			
			this.mesFactures = new MesFactures();
			
			DaoFacture daoFacture = new DaoFacture();
			DaoImmeuble daoIm = new DaoImmeuble();
			Iterateur<Facture> iterateurFactureI = null;
			Iterateur<Facture> iterateurFactureL = null;
			
			try {
				Immeuble im = this.lireLigneTableImmeuble(this.mesLogements.getTableimmeuble(), this.mesLogements.getTableimmeuble().getSelectedRow());
				immeuble = daoIm.findById(Integer.toString(im.getIdImmeuble()));
				iterateurFactureI = daoFacture.findByImmeubleIterateur(Integer.toString(im.getIdImmeuble()));
				iterateurFactureL = daoFacture.findByLogementImmeubleIterateur(Integer.toString(im.getIdImmeuble()));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			int ix = 0 ;
			while (iterateurFactureI.hasNext() && ix < 10) {
				GestionMesFactures.ecrireLigneTableFacture(this.mesFactures.getTableimmeuble(), ix, iterateurFactureI.next());
				ix++;
			}
			
			int iy = 0 ;
			while (iterateurFactureL.hasNext() && iy < 10) {
				GestionMesFactures.ecrireLigneTableFacture(this.mesFactures.getTablelogement(), iy, iterateurFactureL.next());
				iy++;
			}
			
			this.mesFactures.setVisible(true);
			this.mesFactures.toFront();
			break;
		
		case("Quittance"):
			
			Logement loge = null;
			try {
				loge = this.lireLigneTableLogement(mesLogements.getTablelogement(), mesLogements.getTablelogement().getSelectedRow());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			try {
				new CreerRapportQuittanceLoyer(loge.getBail());
			} catch (SQLException | IOException | ParseException e1) {
				e1.printStackTrace();
			}
		
		}
		
			
	}
	
	
	public Logement lireLigneTableLogement(JTable table, int numLigne) throws SQLException {
			DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
			Immeuble immeuble = lireLigneTableImmeuble(mesLogements.getTableimmeuble(), mesLogements.getTableimmeuble().getSelectedRow());
			DaoBail daoBail = new DaoBail();
			Bail bail = daoBail.findByLogement((String)modeleTable.getValueAt(numLigne, 0), Integer.toString(immeuble.getIdImmeuble()));
			Logement l = new Logement((String)modeleTable.getValueAt(numLigne, 0), (String) modeleTable.getValueAt(numLigne, 1), 
					     (int) modeleTable.getValueAt(numLigne, 2), (boolean) modeleTable.getValueAt(numLigne, 3), (String) modeleTable.getValueAt(numLigne, 4), 
						immeuble, bail);
			return l ;
			
		}
		
	
		
		
		public Immeuble lireLigneTableImmeuble(JTable table, int numLigne) throws SQLException {
			//DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
			//ID A REVOIR 
			DaoImmeuble daoImmeuble = new DaoImmeuble();
			Iterateur<Immeuble> iterateurImmeuble = daoImmeuble.findAllIterateur();
			List<Immeuble> listImmeuble = new LinkedList<Immeuble>();
			int i = 0 ;
	  		while (iterateurImmeuble.hasNext() && i < 10) {
	  			listImmeuble.add(iterateurImmeuble.next());
	  		}

			Immeuble immeuble = listImmeuble.get(mesLogements.getTableimmeuble().getSelectedRow());
			return immeuble ;		
					
			
			//Logement l = new Logement((String)modeleTable.getValueAt(numLigne, 0), (int) modeleTable.getValueAt(numLigne, 1), 
				//	     (int) modeleTable.getValueAt(numLigne, 2), (boolean) modeleTable.getValueAt(numLigne, 3), (String) modeleTable.getValueAt(numLigne, 4), 
					//	immeuble);
			//return l ;
			
		}
		
	
	
	
	public static void  ecrireLigneTableImmeuble(JTable table, int numLigne, Immeuble immeuble) {
		DefaultTableModel modeleTable = (DefaultTableModel) table.getModel();
		modeleTable.setValueAt(immeuble.getCp(), numLigne, 0);
		modeleTable.setValueAt(immeuble.getVille(), numLigne, 1);
		modeleTable.setValueAt(immeuble.getPays(), numLigne, 2);
		modeleTable.setValueAt(immeuble.getRue(), numLigne, 3);
		modeleTable.setValueAt(immeuble.isFibre(), numLigne, 4);

	}

}
