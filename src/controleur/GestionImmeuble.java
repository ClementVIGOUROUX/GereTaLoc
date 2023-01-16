package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modele.Immeuble;
import modele.dao.DaoImmeuble;
import vue.AjouterImmeuble;

public class GestionImmeuble implements ActionListener{
	
	private AjouterImmeuble ajouterImmeuble ;
	private DaoImmeuble daoImmeuble ;
	
	public GestionImmeuble(AjouterImmeuble immeuble) {
		this.ajouterImmeuble = immeuble ;
		this.daoImmeuble = new DaoImmeuble();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Annuler"):
			ajouterImmeuble.dispose();
			break;
		case("Valider"):
			//COMMENT AUTO INCREMENTER LID :
			// UTILISER LA METHODE CREATE QUI APPELERA LA PROCEDURE QUI AUTOINCREMENTE EN PL/SQL
			Immeuble immeuble = new Immeuble(1,this.ajouterImmeuble.getCP(),this.ajouterImmeuble.getVille(),this.ajouterImmeuble.getPays(),this.ajouterImmeuble.getRue(),this.ajouterImmeuble.isFibre());
			try {
				this.daoImmeuble.create(immeuble);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			ajouterImmeuble.dispose();
			break;
		}
	}

}
