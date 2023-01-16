package rapport;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import modele.Bail;
import modele.Charge;
import modele.Immeuble;
import modele.Locataire;
import modele.Paiement;
import modele.Proprietaire;
import modele.dao.CictOracleDataSource;
import modele.dao.DaoBail;
import modele.dao.DaoCharge;
import modele.dao.DaoImmeuble;
import modele.dao.DaoLocataire;
import modele.dao.DaoPaiement;
import modele.dao.DaoProprietaire;

public class CreerRapportChargesMoinsUnAn {

	
	public CreerRapportChargesMoinsUnAn(Bail bail, List<Charge> listeCharges) {
		  
		OutputStream fileOut = new FileOutputStream("RapportChargesMoinsUnAn.docx");
		InputStream modele = new FileInputStream("src/vide.docx");
		CictOracleDataSource.creerAcces("VGC4458A", "$iutinfo");
		XWPFDocument document = new XWPFDocument(modele);
		
		Locataire locataire = null ;
		DaoLocataire daoLocataire = new DaoLocataire();
		locataire = daoLocataire.findById("1");//recup le id quand on clique
		String sexe ="";
		if (locataire.getSexe()== "H") {
			sexe = " Monsieur" ;
		}else if (locataire.getSexe() == "F") {
			sexe = " Madame";
		}else {
			sexe = " Mx ";
		}
		
		
		XWPFParagraph paragraph = document.createParagraph();
		//paragraph.setStyle("Titre");
		paragraph.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run = paragraph.createRun();
		run.setBold(false);
		run.setItalic(false);
		
		Proprietaire p = null ;
		DaoProprietaire daoProprietaire = new DaoProprietaire();
		p = daoProprietaire.findById("1");
		
		Immeuble i = null ;
		DaoImmeuble daoImmeuble = new DaoImmeuble();
		i = daoImmeuble.findById("1");
		
		run.setText(p.toStringRapport());
		
		XWPFParagraph paragraph2 = document.createParagraph();
		paragraph2.setAlignment(ParagraphAlignment.RIGHT);
		XWPFRun runLocataire = paragraph2.createRun();
		runLocataire.setBold(true);
		//FINIR ICI
		
		runLocataire.setText(locataire.getNom().toUpperCase() +" "+ locataire.getPrenom());
		runLocataire.addCarriageReturn();
		runLocataire.setText(i.getRue()+"");
		runLocataire.addCarriageReturn();
		runLocataire.setText(i.getCp()+" "+i.getVille());
		runLocataire.addCarriageReturn();
		runLocataire.setBold(false);
		runLocataire.addCarriageReturn();
		
		XWPFParagraph paragraph3 = document.createParagraph();
		paragraph3.setAlignment(ParagraphAlignment.RIGHT);
		XWPFRun Endroit = paragraph3.createRun();
		Endroit.setText("Toulouse, le " + java.time.LocalDate.now());
		Endroit.addCarriageReturn();
		
		XWPFParagraph paragraph4 = document.createParagraph();
		paragraph4.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runObjet = paragraph4.createRun();
		runObjet.setText("Objet : Régularisation des charges");
		runObjet.addCarriageReturn();
		runObjet.setBold(true);
		
		XWPFParagraph paragraph5 = document.createParagraph();
		paragraph5.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun runObjet2 = paragraph5.createRun();
		runObjet2.setText(sexe);
		runObjet2.addCarriageReturn();
		
		XWPFParagraph paragraph6 = document.createParagraph();
		paragraph6.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runObjet3 = paragraph6.createRun();
		Bail bail = null ;
		DaoBail daoBail = new DaoBail();
		bail = daoBail.findById("1");
		runObjet3.setText("Je vous prie de bien vouloir trouver, ci-dessous, le détail des charges qui vous incombent "
				+ "et qui sera porté sur "
				+ "votre quittance de loyer de décembre 2021. Ces charges portent sur une période allant du "
				+ bail.getDateDebut() + " au "+bail.getDateFin()+".");
		runObjet3.addCarriageReturn();
		
		
		List<Charge> listeCharges = new LinkedList<Charge>();
		List<Charge> ListeChargeSansIndex = new LinkedList<Charge>();
		List<Charge> listeChargesIndex = new LinkedList<Charge>();
		DaoCharge daocharge = new DaoCharge();
		//listeCharges = daocharge.findChargeByIdBail();
		listeCharges = daocharge.findAll();//
		
		for (Charge c : listeCharges) {
			if (c.getIndex_c()>= 0) {
				listeChargesIndex.add(c);
			}else {
				ListeChargeSansIndex.add(c);
			}
		}
		
		XWPFParagraph paragraph7 = document.createParagraph();
		paragraph7.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun detailCharge = paragraph7.createRun();
		float total = 0.00F;
		
		//on ecris toute les charge avec indexs
		//et on met la valeur dans somme
		for (Charge c : listeChargesIndex) {
			detailCharge.setText(c.getNom() + "Premier Index : " + c.getIndex_c()  /**+faire le calcul**/ + " Euros");
			detailCharge.addCarriageReturn();
			total = total + (/**bail.getIndexFin()**/ - c.getIndex_c());
			
			
		}
		
		//charge sans index
		for(Charge c : ListeChargeSansIndex) {
			detailCharge.setText(c.getNom() +" : "+ c.getMontant() +" Euros");
			detailCharge.addCarriageReturn();
			total = total + c.getMontant();
		}
			
		detailCharge.setText("Soit un sous total de :" + total+" Euros");
		detailCharge.addCarriageReturn();
		
		
		XWPFParagraph paragraph8 = document.createParagraph();
		paragraph8.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun aDeduire = paragraph8.createRun();
		
		Paiement paiement = null;
		DaoPaiement daoPaiement = new DaoPaiement();
		//paiement = daoPaiement.findById("1");
		
		LocalDate debut = LocalDate.parse(bail.getDateDebut(), DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate fin = LocalDate.parse(bail.getDateFin(), DateTimeFormatter.ISO_LOCAL_DATE);
        Period period = Period.between(debut, fin);
        
        int month = Math.abs(period.getMonths());
        
        float calculDedu = 150 * month;//paiement.getProvisionCharges() * nbmois ;//pb paiement
        
		aDeduire.setText("A déduire les provisions pour charges :");
		aDeduire.addCarriageReturn();
		aDeduire.setText(bail.getDateDebut() + " au "+bail.getDateFin()+" : 150 x "+month+" = "+calculDedu+" Euros");
		aDeduire.addCarriageReturn();
		aDeduire.setText("Nous restons vous devoir : "+calculDedu+" - "+ total+" = "); 
		
		XWPFRun aDevoir = paragraph8.createRun();
		aDevoir.setText(calculDedu - total+" Euros");
		aDevoir.setColor("FF0000");
		aDevoir.addCarriageReturn();
		aDevoir.addCarriageReturn();
		
		

		XWPFParagraph paragraph9 = document.createParagraph();
		paragraph9.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun phrase = paragraph9.createRun();
		phrase.setText("Veuillez trouver ci-joint le chèque émis à la caisse d’épargne de Midi-Pyrénées"
				+ " du compte de M. "+p.getPrenom()+" "+p.getNom()+" pour le montant restant vous devoir.");
		phrase.setColor("FF0000");
		phrase.addCarriageReturn();
		

		XWPFParagraph paragraph10 = document.createParagraph();
		paragraph10.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun aPartir = paragraph10.createRun();
		aPartir.setText("A partir du "+debut+" : "); 
		aPartir.addCarriageReturn();
		aPartir.addCarriageReturn();
		XWPFRun paye = paragraph10.createRun();
		paye.setText("Loyer : "+150/**+paiement.getMontant()**/+" Euros");
		paye.addCarriageReturn();
		paye.addCarriageReturn();
		paye.setText("Provision pour charges : "+45/**paiement.getProvisionCharges()**/+" Euros");
		paye.addCarriageReturn();
		paye.addCarriageReturn();
		XWPFRun payeTotal = paragraph10.createRun();
		paye.setText("Soit un total de : ");
		payeTotal.setText(195/**paiement.getProvisionCharges()+paiement.getMontant()**/ +" Euros");
		payeTotal.setColor("FF0000");
		payeTotal.addCarriageReturn();
		payeTotal.addCarriageReturn();
		XWPFRun finale = paragraph10.createRun();
		finale.setText("Je vous prie de croire, Messieurs, à ma considération distinguée.");
		
		
		
		//fin
				document.write(fileOut);
				fileOut.close();
				modele.close();
				document.close();
				CictOracleDataSource.Deconnecter();
	}

	public static void main(String[] args) throws IOException, SQLException {
		

}
	}
