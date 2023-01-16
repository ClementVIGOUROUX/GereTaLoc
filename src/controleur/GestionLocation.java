package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.AjouterImmeuble;
import vue.AjouterBail;

public class GestionLocation implements ActionListener {

	private AjouterBail ajouterBail ;
	
	public GestionLocation(AjouterBail location) {
		this.ajouterBail = location ;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Annuler"):
			ajouterBail.dispose();
			break;
		case("Valider"):
			ajouterBail.dispose();
			break;
		case("Ajouter un Immeuble"):
			AjouterImmeuble aim = new AjouterImmeuble();
			aim.setVisible(true);
			aim.toFront();
			break;
		}
	}
	
}
