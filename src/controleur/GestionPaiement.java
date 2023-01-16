package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modele.Paiement;
import modele.dao.DaoPaiement;
import vue.AjouterPaiement;

public class GestionPaiement implements ActionListener{
	
	private AjouterPaiement ajouterPaiement;
	private DaoPaiement daoPaiement;
	
	public GestionPaiement(AjouterPaiement pai) {
		this.ajouterPaiement = pai ;
		this.daoPaiement = new DaoPaiement();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Annuler"):
			ajouterPaiement.dispose();
			break;
		case("Valider"):
			
			Paiement paiement = new Paiement(1, this.ajouterPaiement.getFieldMoyPai(),
												Integer.valueOf(this.ajouterPaiement.getFieldMontant()),
												this.ajouterPaiement.getFieldDPaiement(),
												Float.valueOf(this.ajouterPaiement.getFieldPCharge()), 
												GestionTableBail.bail);
			
			try {
				this.daoPaiement.create(paiement);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
			ajouterPaiement.dispose();
			break;
		}
	}
}