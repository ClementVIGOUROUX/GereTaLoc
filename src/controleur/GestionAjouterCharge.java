package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modele.Bail;
import modele.Charge;
import modele.Locataire;
import modele.dao.DaoBail;
import modele.dao.DaoCharge;
import modele.dao.DaoLocataire;
import modele.dao.Iterateur;
import vue.AjouterCharge;

public class GestionAjouterCharge implements ActionListener{

	private AjouterCharge ajouterCharge ;
	DaoCharge daoCharge;
	
	public GestionAjouterCharge(AjouterCharge ajouterCharge) {
		this.ajouterCharge = ajouterCharge;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Charge avec Index"):
			this.ajouterCharge.activerModif(true);
			this.ajouterCharge.getTextFieldMontant().setText("");
			break;
		case("Charge sans Index"):
			this.ajouterCharge.activerModif(false);
			this.ajouterCharge.getTextFieldProvision().setText("");
			this.ajouterCharge.getTextFieldIndex().setText("");
			break;
		case("Valider"):
			int index;
			int montant;
			String nom = this.ajouterCharge.getTextFieldNomCharge().getText();
			
			System.out.println("Index : " + this.ajouterCharge.getTextFieldIndex().getText());
			System.out.println("Montant : " + this.ajouterCharge.getTextFieldMontant().getText());
			
			if (this.ajouterCharge.getTextFieldIndex().getText().equals("")) {
				index = 0;
			}else {
				index = Integer.parseInt(this.ajouterCharge.getTextFieldIndex().getText());
			}
			
			if (this.ajouterCharge.getTextFieldMontant().getText().equals("")) {
				montant = 0;
			}else {
				montant = Integer.parseInt(this.ajouterCharge.getTextFieldMontant().getText());
			}
			
			DaoLocataire dl = new DaoLocataire();
			DaoBail db = new DaoBail();
			Iterateur<Locataire> il = null;
			List<Bail> listBail = new LinkedList<>();
			try {
				il = dl.findAllAvecBail();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			int x = 0 ;
			while (il.hasNext() && x < 10) {
				Locataire l = il.next();
				System.out.println(l);
				Bail b = null;
				try {
					b = db.findByLocataireIterateurUnique(Integer.toString(l.getIdLoc())).next();
					System.out.println(b);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				listBail.add(b);
				x++;
			}
			int row = GestionTableCharge.getRowSelected();
			Charge c = new Charge(0,nom,index,montant,listBail.get(row));
			
			this.daoCharge = new DaoCharge();
			
			try {
				daoCharge.create(c);
				System.out.println("Succes !");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.ajouterCharge.dispose();
			break;
		}
	}

}
