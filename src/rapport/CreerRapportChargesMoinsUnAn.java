package rapport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import modele.Bail;
import modele.Charge;
import modele.Locataire;
import modele.Paiement;
import modele.Proprietaire;
import modele.dao.DaoLocataire;
import modele.dao.DaoPaiement;
import modele.dao.DaoProprietaire;
import modele.dao.Iterateur;

public class CreerRapportChargesMoinsUnAn {
	
	
	public CreerRapportChargesMoinsUnAn(Bail bail, List<Charge> listeCharges) throws SQLException, IOException, ParseException {
		OutputStream fileOut = new FileOutputStream("src/ChargeLocataireMoins1an.docx");
		InputStream modele = new FileInputStream("src/vide.docx");
		XWPFDocument document = new XWPFDocument(modele);
		
		
			
			XWPFParagraph paragraph = document.createParagraph();
			paragraph.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun run = paragraph.createRun();
			run.setBold(false);
			run.setItalic(false);
			Proprietaire p = null ;
			DaoProprietaire daoProprietaire = new DaoProprietaire();
			p = daoProprietaire.findById("1");
			run.setText(p.toStringRapport());
			
			XWPFParagraph paragraphA = document.createParagraph();
			paragraphA.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun runA = paragraphA.createRun();
			runA.setText("à");
			
			DaoLocataire daoLocataire = new DaoLocataire();
			Iterateur<Locataire> iterateurLocataire = daoLocataire.findByBailIterateur(Integer.toString(bail.getIdBail()));
			XWPFParagraph paragraph2 = document.createParagraph();
			paragraph2.setAlignment(ParagraphAlignment.RIGHT);
			XWPFRun runLocataire = paragraph2.createRun();
			runLocataire.setBold(true);
			while (iterateurLocataire.hasNext()) {
				Locataire locataire = iterateurLocataire.next();
				runLocataire.setText(locataire.getNom().toUpperCase() +" "+ locataire.getPrenom());
				runLocataire.addCarriageReturn();
			
			}
			
			runLocataire.setBold(false);
			LocalDate date = java.time.LocalDate.now();
			DateTimeFormatter formatterNormal = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dateAjd = date.format(formatterNormal);

			
			runLocataire.setText("Toulouse, le " + dateAjd);
			runLocataire.addCarriageReturn();
			
			
			XWPFParagraph paragraph3 = document.createParagraph();
			paragraph3.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun runObjet = paragraph3.createRun();
			runObjet.setText("Objet : Régularisation des charges");
			runObjet.setBold(true);
			runObjet.addCarriageReturn();
			runObjet.addCarriageReturn();
			
			Date dateRenouvellement = new SimpleDateFormat("yyyy-MM-dd").parse(bail.getDateDebutRenouvellement());
			String dateRenouvellementString = new SimpleDateFormat("dd/MM/yyyy").format(dateRenouvellement);
			
			
			XWPFRun runPrincipal = paragraph3.createRun();
			runPrincipal.setText("Je vous prie de bien vouloir trouver, ci-dessous, le détail des charges qui vous incombent."
					 			  +".Ces charges portent sur une période allant du " + dateRenouvellementString + " au " + dateAjd+ " :");
			runPrincipal.addCarriageReturn();
			
			
			List<Charge> listeChargesIndex = new LinkedList<Charge>();
			List<Charge> listeChargesSansIndex = new LinkedList<Charge>();
			//DaoCharge daocharge = new DaoCharge();
			//listeCharges = daocharge.findChargeByIdBail();
			//listeCharges = daocharge.findAll();//
			
			
			for (Charge c : listeCharges) {
				if (c.getIndex_c() > 0) {
					listeChargesIndex.add(c);
				}else {
					listeChargesSansIndex.add(c);
				}
			}
			
			
			XWPFParagraph paragraph4 = document.createParagraph();
			paragraph4.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun detailCharge = paragraph4.createRun();
			float totalCharge = 0.00F;
			
			//on ecris toute les charge avec indexs
			//et on met la valeur dans somme
			for (Charge c : listeChargesIndex) {
				 int DiffIndexs = c.getIndex_final() - c.getIndex_c();
				 float res = DiffIndexs * c.getPrixUnite();
				 int strlong = c.getNom().length();
				 String espace="‎    ";
				 for(int i = 0 ; i <= strlong ; i++) {
					 espace = espace + "  ";
				 }
				detailCharge.setText(c.getNom() + " :Index final : " + c.getIndex_final() + " : "  + DiffIndexs + " x " + c.getPrixUnite() + " = "  +  res);
				detailCharge.addCarriageReturn();
				detailCharge.setText(espace+"Index initial :" + c.getIndex_c());
				detailCharge.addCarriageReturn();
				totalCharge += res ;
			}
			
			
			LocalDate debut = LocalDate.parse(bail.getDateDebut(), DateTimeFormatter.ISO_LOCAL_DATE);
			
			Date dateAjd_2 = new SimpleDateFormat("dd/MM/yyyy").parse(dateAjd);
			String dateAjdString = new SimpleDateFormat("yyyy-MM-dd").format(dateAjd_2);
			
	        LocalDate fin = LocalDate.parse(dateAjdString, DateTimeFormatter.ISO_LOCAL_DATE);
	        
	        
	        
	        Period period = Period.between(debut, fin);
	        int month = Math.abs(period.getMonths());
	        int years = Math.abs(period.getYears());
	        int days = Math.abs(period.getDays());
	        int nbmois = 0 ;
	        if (days > 0 ) {
	        	nbmois = years * 12 + month + 1;
	        } else {
	        	nbmois = years * 12 + month;
	        }
	       
			
			
			
			for(Charge c : listeChargesSansIndex) {
				detailCharge.setText(c.getNom() + " : " + c.getMontant() + " x " + nbmois + " = " + (c.getMontant() * nbmois));
				detailCharge.addCarriageReturn();
				totalCharge += (c.getMontant() * nbmois);
			}
			
			XWPFRun phrase = paragraph4.createRun();
			detailCharge.setText("Soit un total de ");
			phrase.setText(totalCharge+" Euros");
			phrase.addCarriageReturn();
			phrase.setColor("FF0000");
			
			
			
			XWPFParagraph paragraph5 = document.createParagraph();
			paragraph5.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun deduction = paragraph5.createRun();
			deduction.setText("À déduire :");
			deduction.addCarriageReturn();
			deduction.setText("Les provisions pour charges du " + dateRenouvellementString + " au "+ dateAjd +" :");
			
			
			//
			XWPFParagraph paragraph6 = document.createParagraph();
			paragraph6.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun calculDeduction = paragraph6.createRun();
			
			DaoPaiement daoPaiement = new DaoPaiement();
			Iterateur<Paiement> iterateurPaiement =  daoPaiement.findByBail(Integer.toString(bail.getIdBail()));
			Paiement paiement = iterateurPaiement.next();		
		    
	        
			float calculDedu = paiement.getProvisionCharges() * nbmois;//pb paiement
			calculDeduction.setText(" "+ paiement.getProvisionCharges() + " x "+nbmois + " = " + calculDedu);//probleme  select * from SAE_BAIL where id_paiement = ?
			calculDeduction.addCarriageReturn();
			int montantFinal = (int) (calculDedu - totalCharge) ;
			
			
			XWPFParagraph paragraph9 = document.createParagraph();
			paragraph9.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun conclusion = paragraph9.createRun();
			
			if (montantFinal >= 0) {
				conclusion.setText("Nous restons vous devoir : " + calculDedu + " - " + totalCharge + " = ");
			}else {
				conclusion.setText("Vous restez nous devoir : " + totalCharge + "-" + calculDedu + " = ");
			}
;			XWPFRun totalGras = paragraph9.createRun();
			totalGras.setText( Math.abs(montantFinal) +" Euros.");
			totalGras.setBold(true);
			totalGras.setColor("FF0000");
			totalGras.addCarriageReturn();
			
			XWPFRun aLaBanque = paragraph9.createRun();
			
			if (montantFinal > 0 ) {
				aLaBanque.setText("Veuillez trouver ci-joint le chèque du compte de M. " + p.getPrenom() + " " + p.getNom().toUpperCase() + "pour le montant restant vous devoir" );
			}
			
			//a faire ici
			XWPFRun RunCalculProvision = paragraph9.createRun();
			
			Date anneeCourantePlusUn = new SimpleDateFormat("yyyy-MM-dd").parse(bail.getDateFin());
			String anneeCourantePlusUnString = new SimpleDateFormat("yyyy").format(anneeCourantePlusUn);
			
			int nouveauProvisionCharges = 0 ;
			if (montantFinal >= 0 ) {
				nouveauProvisionCharges = (int) (paiement.getProvisionCharges() - (montantFinal / 12)) ;
			} else {
				nouveauProvisionCharges = (int) (paiement.getProvisionCharges() + (montantFinal / 12));
			}
			
			RunCalculProvision.setText("A partir du 1er janvier " + anneeCourantePlusUnString + " :");
			RunCalculProvision.addCarriageReturn();
			RunCalculProvision.setText("Loyer :");
			RunCalculProvision.setText(paiement.getMontant() - nouveauProvisionCharges +" Euros");
			RunCalculProvision.addCarriageReturn();
			RunCalculProvision.setText("Provision pour charges :");
			
			RunCalculProvision.setText(nouveauProvisionCharges +" Euros");
			RunCalculProvision.addCarriageReturn();
			RunCalculProvision.setText("Soit un total de ");
			RunCalculProvision.setText((paiement.getMontant()) + " Euros");
			RunCalculProvision.addCarriageReturn();
			RunCalculProvision.setText("Je vous prie de croire, Madame, Monsieur, à ma considération distinguée.");
			
		
			
			document.write(fileOut);
			
			fileOut.close();
			modele.close();
			document.close();
			
			
			
			
	}

}