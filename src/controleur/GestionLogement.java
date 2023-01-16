package controleur;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import modele.Immeuble;
import modele.Logement;
import modele.dao.DaoLogement;
import vue.AjouterImmeuble;
import vue.AjouterLogement;

public class GestionLogement implements ActionListener {

	private AjouterLogement ajouterLogement ;
	private DaoLogement daoLogement ;
	
	public GestionLogement(AjouterLogement logement) {
		this.ajouterLogement = logement ;
		this.daoLogement = new DaoLogement();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Annuler"):
			ajouterLogement.dispose();
			break;
		case("Valider"):
			Logement logement = new Logement(this.ajouterLogement.getFieldnum(), this.ajouterLogement.getFieldsurf(),
											(int) this.ajouterLogement.getSpinnerNbPieces().getValue(), 
											 this.ajouterLogement.getCheckBoxGarage().isSelected(), 
											this.ajouterLogement.getFieldParking(),
											(Immeuble) this.ajouterLogement.getComboImmeuble().getSelectedItem(), null);
		try {
			this.daoLogement.create(logement);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		ajouterLogement.dispose();
		break;
	
		
		case("Ajouter un Immeuble"):
			AjouterImmeuble aim = new AjouterImmeuble();
			aim.setVisible(true);
			aim.toFront();
			break;
		}
	}
	
	
	
}
