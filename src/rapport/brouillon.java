package rapport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/*
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

*/
import modele.Bail;
import modele.Charge;
import modele.Locataire;
import modele.Proprietaire;
import modele.dao.CictOracleDataSource;
import modele.dao.DaoProprietaire;

public class brouillon {

	public static void main(String[] args) throws IOException, SQLException {
		OutputStream fileOut = new FileOutputStream("test.docx");
		InputStream modele = new FileInputStream("src/vide.docx");
		
		/*
		XWPFDocument document = new XWPFDocument(modele);
		XWPFParagraph paragraph = document.createParagraph();
		//paragraph.setStyle("Titre");
		paragraph.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run = paragraph.createRun();
		run.setBold(false);
		run.setItalic(false);
		
		Proprietaire p = null ;
		DaoProprietaire daoProprietaire = new DaoProprietaire();
		p = daoProprietaire.findById("1");
		
		run.setText(p.toStringRapport());
		
		XWPFParagraph paragraph2 = document.createParagraph();
		paragraph2.setAlignment(ParagraphAlignment.RIGHT);
		XWPFRun runLocataire = paragraph2.createRun();
		runLocataire.setBold(true);
		Locataire locataire = null ;
		//FINIR ICI
		
		runLocataire.setText(locataire.getNom().toUpperCase() + locataire.getPrenom());
		runLocataire.addCarriageReturn();
		runLocataire.setBold(false);
		runLocataire.setText("Toulouse, le " + java.time.LocalDate.now());
		runLocataire.addCarriageReturn();
		
		XWPFParagraph paragraph3 = document.createParagraph();
		paragraph3.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runObjet = paragraph3.createRun();
		runObjet.setText("Objet : Solde de tout compte");
		runObjet.addCarriageReturn();
		runObjet.addCarriageReturn();
		XWPFRun runPrincipal = paragraph3.createRun();
		Bail bail = null ;
		runPrincipal.setText("Je vous prie de bien vouloir trouver, ci-dessous, le détail du solde de tout compte." + 
				 			 "Les charges énumérées ci-dessous porte sur la période allant du" + bail.getDateDebut() + "au " + bail.getDateFin());
		runPrincipal.addCarriageReturn();
		List<Charge> listeCharges = new LinkedList<Charge>(); 
		
		for(Charge c : listeCharges) {
			//runPrincipal.setText("Eau : index au " + bail.getDateFin() + ": 	" + )
		}
		
		*/
		
		/*
		
		run2.addCarriageReturn();
		run2.addCarriageReturn();
		run2.setText("Veuillez trouver ci-joint, l'ensemble des créneaux affichés dans la table");
		run2.addCarriageReturn();
		run2.addCarriageReturn();
		
		CictOracleDataSource.creerAcces("VGC4458A", "$iutinfo");
		
		DaoCreneau dao = new DaoCreneau();
		List<Creneau> creneaux = dao.findAll();
		XWPFTable tab = document.createTable(1, 1);
		XWPFTableRow row = tab.createRow();
		row.getCell(0).setText("Début de semaine");
		row.addNewTableCell().setText("Jour de la semaine");
		row.addNewTableCell().setText("Groupe");
		row.addNewTableCell().setText("Heure de début du cours");
		row.addNewTableCell().setText("Heure de fin de cours");
		row.addNewTableCell().setText("Type du cours");
		row.addNewTableCell().setText("Matière");
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
		run3.setText("Pour toute modification, vous devez contacter le service des plannings ou le secrétariat");
		run3.addCarriageReturn();
		
		document.write(fileOut);
		
		fileOut.close();
		modele.close();
		document.close();
		CictOracleDataSource.Deconnecter();
		
		*/
	}
	
	
	/*
	public static void miseEnFormeCellules(XWPFTableRow ligne, String codeCouleurCellule, boolean isBold, boolean isItalic) {
		List<XWPFTableCell> listCellules = ligne.getTableCells();
		for (XWPFTableCell cell : listCellules) {
			XWPFParagraph paragraph = cell.getParagraphs().get(0) ;
			paragraph.setIndentationFirstLine(0);
			paragraph.getRuns().get(0).setBold(isBold);
			paragraph.getRuns().get(0).setItalic(isItalic);
			cell.setColor(codeCouleurCellule);
		}
		
	}
	
	*/
	

}