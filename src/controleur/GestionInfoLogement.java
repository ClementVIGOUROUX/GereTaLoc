package controleur;

import java.awt.event.ActionEvent;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Bail;
import modele.Diagnostics;
import modele.Facture;
import modele.Logement;
import modele.Paiement;
import modele.Revision;
import modele.dao.DaoBail;
import modele.dao.DaoDiagnostics;
import modele.dao.DaoPaiement;
import modele.dao.DaoRevision;
import vue.InfoLogement;


//NE PAS OUBLIER GESTION CLIC DANS INFO LOGEMENT (EN ATTENTE DE LA BONNE VERSION DE LA FENETRE)
public class GestionInfoLogement implements ActionListener {
	
	private InfoLogement infoLogement ;
	private DaoDiagnostics daoDiagnostics ;
	private JFileChooser chooserDia ;
	private File fileDia ;
	
	public GestionInfoLogement(InfoLogement ilogement) {
		this.infoLogement = ilogement ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Quitter"):
			infoLogement.dispose();
			break;
			
		case("Ajouter"):
			Diagnostics d = null;
			if(this.infoLogement.getDiagnostic() == null) {
				LocalDate date = java.time.LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				d = new Diagnostics(1, date.format(formatter),"", this.infoLogement.getLogement());
				this.infoLogement.setDiagnostic(d);
			}
			
				this.chooserDia = new JFileChooser();
		    	this.chooserDia.setDialogTitle("Selectionnez votre Diagnostic :");
		    	this.chooserDia.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooserDia.setVisible(true);
				chooserDia.showOpenDialog(chooserDia);
				this.fileDia = chooserDia.getSelectedFile();
				this.infoLogement.getDiagnostic().setRepertoire(this.fileDia.getAbsolutePath());
				this.daoDiagnostics = new DaoDiagnostics();
				daoDiagnostics.updateRepertoireDate(this.infoLogement.getDiagnostic());;
				System.out.println(this.fileDia.getAbsolutePath());
				infoLogement.setFileDia(this.fileDia);
			
			if (this.infoLogement.getFileDia() != null) {
				d.setRepertoire(this.infoLogement.getFileDia().getAbsolutePath());
			}
				if (d.getRepertoire() != null) {
				try {
					daoDiagnostics.create(d);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			break ;
			
		case("Telecharger"):
			if(!Desktop.isDesktopSupported()) { 
			System.out.println("not supported");  
			}
			Desktop desktop = Desktop.getDesktop();
			if (this.infoLogement.getFileDia() != null) {
				System.out.println(this.infoLogement.getFileDia().getAbsolutePath());
				try {
					desktop.open(this.infoLogement.getFileDia());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else {
				System.out.println("file null");
			}
			break ;
		
		case("Valider"):
			Logement logement = this.infoLogement.getDiagnostic().getLogement();
			DaoBail daoBail = new DaoBail();
			DaoPaiement daoPaiement = new DaoPaiement();
			//Paiement paiement = null ;
			Bail bail = null ;
			List<Paiement> paiements = null ;
			try {
				bail = daoBail.findByLogement(logement.getNumero(), Integer.toString(logement.getImmeuble().getIdImmeuble())  );
				paiements = daoPaiement.findByLogement(logement.getNumero(), Integer.toString(logement.getImmeuble().getIdImmeuble()));
				System.out.println(paiements);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			//System.out.println(paiement);
			
			System.out.println(logement);
			String nouveauIRLString = this.infoLogement.getFieldrevision().replace(',', '.');
			float nouveauIRL = Float.parseFloat(nouveauIRLString);

			
			int montantLogement = paiements.get(0).getMontant();
			
			DaoRevision daoRevision = new DaoRevision();
			Revision revision = null ;
			try {
				revision = daoRevision.findByBail(Integer.toString(bail.getIdBail()));
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			System.out.println(bail.getIdBail());
			System.out.println(revision);
			
			float nouveauMontant = (montantLogement * nouveauIRL) / revision.getIrl();
			float augmentation = nouveauMontant - montantLogement ;
			revision.setIrl(nouveauIRL);
			daoRevision.update(revision);
			this.infoLogement.getLabelAugment().setText(Math.round(augmentation) + " €");
			this.infoLogement.getLabelLoyer().setText(Math.round(nouveauMontant)  + " €");
		
		
		
		}
	}
	
	
	public static void ecrireLigneTableFacture(JTable tablefacture, int numLigne, Facture facture) {
		DefaultTableModel modeleTable = (DefaultTableModel) tablefacture.getModel();
		modeleTable.setValueAt(facture.getnFacture(), numLigne, 0);
		modeleTable.setValueAt(facture.getTypeF(), numLigne, 1);
		modeleTable.setValueAt(facture.getMontant(), numLigne, 2);
		modeleTable.setValueAt(facture.getMontantNonDeductible(), numLigne, 3);
		modeleTable.setValueAt(facture.getDateF(), numLigne, 4);
		modeleTable.setValueAt(facture.getEntreprise().getnSiret(), numLigne, 5);
	}
		
}
	

