package rapport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import modele.Immeuble;
import modele.Locataire;
import modele.Paiement;
import modele.Proprietaire;
import modele.dao.CictOracleDataSource;
import modele.dao.DaoImmeuble;
import modele.dao.DaoLocataire;
import modele.dao.DaoPaiement;
import modele.dao.DaoProprietaire;

public class CreerRapportQuittanceLoyer {
	
	
	public static void main(String[] args) throws IOException, SQLException {
		OutputStream fileOut = new FileOutputStream("QuittanceLoyer.docx");
		InputStream modele = new FileInputStream("src/vide.docx");
		
		CictOracleDataSource.creerAcces("VGC4458A", "$iutinfo");
		
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
		immeuble = daoImmeuble.findById("1");//recup le id quand on clique
		adres.setText("  "+immeuble.getRue() +" - "+ immeuble.getCp() +" " + immeuble.getVille());
		adres.addCarriageReturn();
		adres.addCarriageReturn();
		
		//Texte expliquant
		XWPFParagraph paragraph3 = document.createParagraph();
		XWPFRun texte = paragraph3.createRun();
		paragraph3.setAlignment(ParagraphAlignment.LEFT);
		
		//recuperation du locataire
		Locataire locataire = null ;
		DaoLocataire daoLocataire = new DaoLocataire();
		locataire = daoLocataire.findById("1");//recup le id quand on clique
		String sexe ="";
		if (locataire.getSexe()== "H") {
			sexe = "M." ;
		}else if (locataire.getSexe() == "F") {
			sexe = "Mme. ";
		}else {
			sexe = "Mx .";
		}
		//recuperation du proprio
		Proprietaire proprio = null ;
		DaoProprietaire daoProprio = new DaoProprietaire();
		proprio = daoProprio.findById("1");//recup le id quand on clique
		
		//prix
		float total =0.00F;
		Paiement paiement = null ;
		DaoPaiement daoPaiement = new DaoPaiement();
		//paiement = daoPaiement.findById("1");//recup le id quand on clique
		//total = paiement.getProvisionCharges() + paiement.getProvisionCharges();
			
		String monologue = "Je soussign� M. " + /**proprio.getNom()+**/ " propri�taire du logement d�sign� ci-dessus, d�clare avoir re�u de"
				+ /**sexe + locataire.getNom() +**/ " , la somme de "+ /**total +**/" euros , au titre du paiement du loyer et des charges pour "
				+ "la p�riode de location du /**les mois la **//**"
				+ "X au X et lui en donne quittance, sous r�serve de tous mes droits.";
		
		texte.setText(monologue);
		texte.addCarriageReturn();
		texte.addCarriageReturn();
		
		//recap calcul
		XWPFParagraph paragraph4 = document.createParagraph();
		XWPFRun recap = paragraph4.createRun();
		paragraph4.setAlignment(ParagraphAlignment.LEFT);
		recap.setText("D�tail du r�glement :");
		recap.setBold(true);
		recap.addCarriageReturn();
		
		//loyer
		XWPFParagraph paragraph5 = document.createParagraph();
		XWPFRun loyer = paragraph5.createRun();
		paragraph5.setAlignment(ParagraphAlignment.LEFT);
		loyer.setText("Loyer :                                                                 "/**+paiement.getMontant()**/+
				"Euros");
		loyer.addCarriageReturn();
		
		//provisions
		XWPFParagraph paragraph7 = document.createParagraph();
		XWPFRun provision = paragraph7.createRun();
		paragraph7.setAlignment(ParagraphAlignment.LEFT);
		provision.setText("Provision pour charges :                                 "
				+ " "/**+paiement.getProvisionCharges()**/+"Euros");
		provision.addCarriageReturn();
		
		//total
		XWPFParagraph paragraph9 = document.createParagraph();
		XWPFRun totalLP = paragraph9.createRun();
		paragraph9.setAlignment(ParagraphAlignment.LEFT);
		totalLP.setText("Total :                                                                 "/**+total**/+"Euros");
		totalLP.setBold(true);
		totalLP.addCarriageReturn();
		
		//date
		XWPFParagraph paragraph11 = document.createParagraph();
		XWPFRun date = paragraph11.createRun();
		paragraph11.setAlignment(ParagraphAlignment.LEFT);
		date.setText("Date du paiement : "/**+ paiement.getDateP()**/);
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
		CictOracleDataSource.Deconnecter();
		
	}
}
	