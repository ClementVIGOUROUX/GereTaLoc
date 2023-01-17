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

public class CreerRapportSoldeToutCompte {
	
	
	public CreerRapportSoldeToutCompte(Bail bail, List<Charge> listeCharges,  int resteCaution) throws SQLException, IOException, ParseException {
		OutputStream fileOut = new FileOutputStream("src/SoldeToutCompte.docx");
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
			runObjet.setText("Objet : Solde de tout compte");
			runObjet.setBold(true);
			runObjet.addCarriageReturn();
			runObjet.addCarriageReturn();
			XWPFRun runPrincipal = paragraph3.createRun();
			
			Date dateRenouvellement = new SimpleDateFormat("yyyy-MM-dd").parse(bail.getDateDebutRenouvellement());
			String dateRenouvellementString = new SimpleDateFormat("dd/MM/yyyy").format(dateRenouvellement);
			
			Date dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(bail.getDateFin());
			String dateFinString = new SimpleDateFormat("dd/MM/yyyy").format(dateFin);
			
			runPrincipal.setText("Je vous prie de bien vouloir trouver, ci-dessous, le détail du solde de tout compte." + 
					 			 " Les charges Ã©numÃ©rÃ©es ci-dessous porte sur la période allant du " + dateRenouvellementString + " au " + dateFinString + " :");
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
	        LocalDate fin = LocalDate.parse(bail.getDateFin(), DateTimeFormatter.ISO_LOCAL_DATE);
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
				totalCharge += c.getMontant() * nbmois;
			}
			
			XWPFRun phrase = paragraph4.createRun();
			detailCharge.setText("Soit un sous total de ");
			phrase.setText(totalCharge+" Euros");
			phrase.addCarriageReturn();
			phrase.setColor("FF0000");
			
			
			
			XWPFParagraph paragraph5 = document.createParagraph();
			paragraph5.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun deduction = paragraph5.createRun();
			deduction.setText("À déduire :");
			deduction.addCarriageReturn();
			deduction.setText("Les provisions pour charges du " + dateRenouvellementString + " au " + dateFinString + " :");
			
			
			
			XWPFParagraph paragraph6 = document.createParagraph();
			paragraph6.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun calculDeduction = paragraph6.createRun();
			
			DaoPaiement daoPaiement = new DaoPaiement();
			Iterateur<Paiement> iterateurPaiement =  daoPaiement.findByBail(Integer.toString(bail.getIdBail()));
			Paiement paiement = iterateurPaiement.next();		
	        
	        
			float calculDedu = paiement.getProvisionCharges() * nbmois;//pb paiement
			calculDeduction.setText(" "+ paiement.getProvisionCharges() + " x "+nbmois + " = " + calculDedu);//probleme  select * from SAE_BAIL where id_paiement = ?
			calculDeduction.addCarriageReturn();
			
			
			
			XWPFParagraph paragraph7 = document.createParagraph();
			paragraph7.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun caution = paragraph7.createRun();
			caution.setText("La caution versée lors de l'entrée dans votre appartement : " + resteCaution+ " Euros");
			caution.addCarriageReturn();
			
			
			
			XWPFParagraph paragraph8 = document.createParagraph();
			paragraph8.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun totalcaut = paragraph8.createRun();
			float totalProvEtCaution = calculDedu + resteCaution;//mettre vrai valeur caution 
			totalcaut.setText("Soit un total de : " );
			XWPFRun totalcaut2 = paragraph8.createRun();
			totalcaut2.setText(totalProvEtCaution +" Euros");
			totalcaut2.addCarriageReturn();
			totalcaut2.setColor("FF0000");
			
			
			
			
			XWPFParagraph paragraph9 = document.createParagraph();
			paragraph9.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun conclusion = paragraph9.createRun();
			float total = totalProvEtCaution - totalCharge ;
			
			conclusion.setText("Nous restons vous devoir : " + totalProvEtCaution +" - "+ totalCharge + " = ");
			XWPFRun totalGras = paragraph9.createRun();
			totalGras.setText(total +" Euros.");
			totalGras.setBold(true);
			totalGras.setColor("FF0000");
			totalGras.addCarriageReturn();
			XWPFRun aLaBanque = paragraph9.createRun();
			aLaBanque.setText("Solde de tout compte remis ce jour à l'intéressé par chèque à la banque");
			aLaBanque.addCarriageReturn();
			aLaBanque.addCarriageReturn();
			aLaBanque.setText("Je vous prie de croire, Madame, Monsieur, à ma considération distinguée.");
		
		document.write(fileOut);
		
		fileOut.close();
		modele.close();
		document.close();
		
		
	}
		
        
        
		
		
		
		
		
		
		
		
		/**
		run2.addCarriageReturn();
		run2.addCarriageReturn();
		run2.setText("Veuillez trouver ci-joint, l'ensemble des crÃ©neaux affichÃ©s dans la table");
		run2.addCarriageReturn();
		run2.addCarriageReturn();
		
		CictOracleDataSource.creerAcces("VGC4458A", "$iutinfo");
		
		DaoCreneau dao = new DaoCreneau();
		List<Creneau> creneaux = dao.findAll();
		XWPFTable tab = document.createTable(1, 1);
		XWPFTableRow row = tab.createRow();
		row.getCell(0).setText("DÃ©but de semaine");
		row.addNewTableCell().setText("Jour de la semaine");
		row.addNewTableCell().setText("Groupe");
		row.addNewTableCell().setText("Heure de dÃ©but du cours");
		row.addNewTableCell().setText("Heure de fin de cours");
		row.addNewTableCell().setText("Type du cours");
		row.addNewTableCell().setText("MatiÃ¨re");
		miseEnFormeCellules(row, "92D050", true, false);
		
		int i = 0 ;
		for (Creneau c : creneaux) {
			XWPFTableRow rowValeurs = tab.createRow();
			rowValeurs.getCell(0).setText(c.getDebsemc());
			rowValeurs.addNewTableCell().setText(c.getJourc());
			rowValeurs.addNewTableCell().setText(c.getGrpc().toString());
			rowValeurs.addNewTableCell().setText(c.getHeuredc());
			rowValeurs.addNewTableCell().setText(c.getHeurefc());
			rowValeurs.addNewTableCell().setText(c.getTypec());
			rowValeurs.addNewTableCell().setText("matiere");
			
			if (i % 2 == 0) {
				miseEnFormeCellules(rowValeurs, "CCFF66", false, false);
			} else {
				miseEnFormeCellules(rowValeurs, "99CCFF", false, false);
			}
			i++ ;
			
		}
		
		

		XWPFParagraph paragraph4 = document.createParagraph();
		XWPFRun run3 = paragraph3.createRun();
		run3.addCarriageReturn();
		run3.addCarriageReturn();
		run3.setText("Pour toute modification, vous devez contacter le service des plannings ou le secrÃ©tariat");
		run3.addCarriageReturn();
		**/
		
	
	
	/**
	public static void miseEnFormeCellules(XWPFTableRow ligne, String codeCouleurCellule, boolean isBold, boolean isItalic) {
		List<XWPFTableCell> listCellules = ligne.getTableCells();
		for (XWPFTableCell cell : listCellules) {
			XWPFParagraph paragraph = cell.getParagraphs().get(0) ;
			paragraph.setIndentationFirstLine(0);
			paragraph.getRuns().get(0).setBold(isBold);
			paragraph.getRuns().get(0).setItalic(isItalic);
			cell.setColor(codeCouleurCellule);
		}
		
	}**/
	

}