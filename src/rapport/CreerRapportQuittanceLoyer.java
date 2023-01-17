package rapport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import modele.Bail;
import modele.Immeuble;
import modele.Locataire;
import modele.Paiement;
import modele.Proprietaire;
import modele.dao.DaoImmeuble;
import modele.dao.DaoLocataire;
import modele.dao.DaoPaiement;
import modele.dao.DaoProprietaire;
import modele.dao.Iterateur;

public class CreerRapportQuittanceLoyer {
	
	
	public CreerRapportQuittanceLoyer(Bail bail) throws SQLException, IOException, ParseException {
		OutputStream fileOut = new FileOutputStream("QuittanceLoyer.docx");
		InputStream modele = new FileInputStream("src/vide.docx");
		
		XWPFDocument document = new XWPFDocument(modele);
		//titre
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run.setFontSize(15);
		run.setBold(true);
		run.setText("Quittance Loyer".toUpperCase());
		run.addCarriageReturn();
		run.addCarriageReturn();
		
		//adresse
		XWPFParagraph paragraph2 = document.createParagraph();
		XWPFRun adresse = paragraph2.createRun();
		paragraph2.setAlignment(ParagraphAlignment.LEFT);
		adresse.setText("Adresse de la Location :");
		adresse.setBold(true);
		adresse.addCarriageReturn();
		XWPFRun adres = paragraph2.createRun();
		Immeuble immeuble = null ;
		DaoImmeuble daoImmeuble = new DaoImmeuble();
		immeuble = daoImmeuble.findById(String.valueOf(bail.getLogement().getImmeuble().getIdImmeuble()));
		adres.setText("  "+immeuble.getRue() +" - "+ immeuble.getCp() +" " + immeuble.getVille());
		adres.addCarriageReturn();
		adres.addCarriageReturn();
		
		//Texte expliquant
		XWPFParagraph paragraph3 = document.createParagraph();
		XWPFRun texte = paragraph3.createRun();
		paragraph3.setAlignment(ParagraphAlignment.LEFT);
		
		//recuperation du locataire
		List<Locataire> locataires = new LinkedList<Locataire>() ;
		DaoLocataire daoLocataire = new DaoLocataire();
		Iterateur<Locataire> iterateurLocataire = daoLocataire.findByBailIterateur(Integer.toString(bail.getIdBail()));
		while(iterateurLocataire.hasNext()) {
			locataires.add(iterateurLocataire.next());
		}
		
		//recuperation du proprio
		DaoProprietaire daoProprio = new DaoProprietaire();
		Proprietaire proprio = daoProprio.findById("1");//recup le id quand on clique
		
		//prix
		List<Paiement> paiements = new LinkedList<Paiement>();
		DaoPaiement daoPaiement = new DaoPaiement();
		paiements = daoPaiement.findByLogement(bail.getLogement().getNumero(), String.valueOf(bail.getLogement().getImmeuble().getIdImmeuble()));//recup le id quand on clique
		float total = paiements.get(1).getMontant() + paiements.get(1).getProvisionCharges();
		
		String monologue = "Je soussigné M. " + proprio.getNom() + " propriétaire du logement désigné ci-dessus, déclare avoir reçu de ";
		
		
		for(Locataire locataire : locataires) {
			String sexe ="";
			if (locataire.getSexe().equals("H")) {
				sexe = "M." ;
			}else if (locataire.getSexe().equals("F")) {
				sexe = "Mme. ";
			}else {
				sexe = "Mx.";
			}
			
			monologue += sexe + " " + locataire.getNom() + ", ";
		}
		
		LocalDate currentDate = LocalDate.now();
		LocalDate beforeDate = currentDate.minusMonths(1);
			
		monologue += " la somme de "+ total + " euros , au titre du paiement du loyer et des charges pour "
				+ "la période de location du " + currentDate + " au " + beforeDate + " et lui en donne quittance, sous réserve de tous mes droits.";
		
		texte.setText(monologue);
		texte.addCarriageReturn();
		texte.addCarriageReturn();
		
		
		//recap calcul
		XWPFParagraph paragraph4 = document.createParagraph();
		XWPFRun recap = paragraph4.createRun();
		paragraph4.setAlignment(ParagraphAlignment.LEFT);
		recap.setText("Détail du règlement :");
		recap.setBold(true);
		recap.addCarriageReturn();
		
		//loyer
		XWPFParagraph paragraph5 = document.createParagraph();
		XWPFRun loyer = paragraph5.createRun();
		paragraph5.setAlignment(ParagraphAlignment.LEFT);
		loyer.setText("Loyer :                                                                 "+ paiements.get(1).getMontant() +
				" Euros");
		loyer.addCarriageReturn();
		
		//provisions
		XWPFParagraph paragraph7 = document.createParagraph();
		XWPFRun provision = paragraph7.createRun();
		paragraph7.setAlignment(ParagraphAlignment.LEFT);
		provision.setText("Provision pour charges :                                 "
				+ " " + paiements.get(1).getProvisionCharges() + " Euros");
		provision.addCarriageReturn();
		
		//total
		XWPFParagraph paragraph9 = document.createParagraph();
		XWPFRun totalLP = paragraph9.createRun();
		paragraph9.setAlignment(ParagraphAlignment.LEFT);
		totalLP.setText("Total :                                                                 " + total +" Euros");
		totalLP.setBold(true);
		totalLP.addCarriageReturn();
		
		//date
		XWPFParagraph paragraph11 = document.createParagraph();
		XWPFRun date = paragraph11.createRun();
		paragraph11.setAlignment(ParagraphAlignment.LEFT);
		date.setText("Date du paiement : "+ paiements.get(1).getDateP());
		date.addCarriageReturn();
		date.addCarriageReturn();
		
		XWPFParagraph paragraph12 = document.createParagraph();
		XWPFRun sign = paragraph11.createRun();
		paragraph12.setAlignment(ParagraphAlignment.LEFT);
		sign.setText("Signature : ");
		
		
		
		
		//fin
		document.write(fileOut);
		fileOut.close();
		modele.close();
		document.close();
		
	}
}
	