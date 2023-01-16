package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modele.Locataire;
import modele.dao.DaoLocataire;
import vue.AjouterLocataire;

public class GestionLocataire implements ActionListener{

	private AjouterLocataire ajouterLocataire ;
	private DaoLocataire daoLocataire ;
	
	public GestionLocataire(AjouterLocataire locataire) {
		this.ajouterLocataire = locataire ;
		this.daoLocataire = new DaoLocataire();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Annuler"):
			ajouterLocataire.dispose();
			break;
		case("Valider"):
			
			String stringSexe ;
			if (this.ajouterLocataire.getRadioSexeM().isSelected()) {
				stringSexe = "M" ;
			} else if (this.ajouterLocataire.getRadioSexeF().isSelected()) {
				stringSexe = "F" ;
			}else {
				stringSexe = "0" ;
			}
			
		Locataire locataire = new Locataire(1,this.ajouterLocataire.getFieldNom(),
							  this.ajouterLocataire.getFieldTel(), this.ajouterLocataire.getFieldPrenom(),
							  this.ajouterLocataire.getFieldMail(), stringSexe,
							  this.ajouterLocataire.getFieldProf());	
		try {
			this.daoLocataire.create(locataire);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		this.ajouterLocataire.dispose();
		break;	
		}
	}
	
}
