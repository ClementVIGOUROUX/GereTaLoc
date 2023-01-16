package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modele.Entreprise;
import modele.dao.DaoEntreprise;
import vue.AjouterEntreprise;

public class GestionEntreprise implements ActionListener{
	
	private AjouterEntreprise ajouterEntreprise;
	private DaoEntreprise daoEntreprise;
	
	public GestionEntreprise (AjouterEntreprise ent) {
		this.ajouterEntreprise = ent ;
		this.daoEntreprise = new DaoEntreprise();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Annuler"):
			ajouterEntreprise.dispose();
			break;
		case("Valider"):
			
			Entreprise entreprise = new Entreprise(this.ajouterEntreprise.getFieldSiret(),
												   this.ajouterEntreprise.getFieldNom(),
												   this.ajouterEntreprise.getFieldAdresse(),
												   this.ajouterEntreprise.getFieldCp(),
												   this.ajouterEntreprise.getFieldVille(),
												   this.ajouterEntreprise.getFiedlEmail(),
												   this.ajouterEntreprise.getFieldTel());
		
			try {
				this.daoEntreprise.create(entreprise);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			ajouterEntreprise.dispose();
			break;
		}
	}
}