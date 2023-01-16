package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modele.Entreprise;
import modele.Facture;
import modele.Logement;
import modele.dao.DaoEntreprise;
import modele.dao.DaoFacture;
import modele.dao.DaoLogement;
import vue.AjouterEntreprise;
import vue.AjouterFactureLogement;

public class GestionFactureLogement implements ActionListener{
	
	private AjouterFactureLogement ajouterFactureLogement;
	private DaoFacture daoFacture;
	private DaoEntreprise daoEntreprise;
	private DaoLogement daoLogement;
	
	public GestionFactureLogement(AjouterFactureLogement facL) {
		this.ajouterFactureLogement = facL ;
		this.daoFacture = new DaoFacture();
		this.daoEntreprise = new DaoEntreprise();
		this.daoLogement = new DaoLogement();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Annuler"):
			ajouterFactureLogement.dispose();
			break;
		case("Valider"):
			Entreprise entreprise = null;
			try {
				entreprise = this.daoEntreprise.findByNom(this.ajouterFactureLogement.getComboEntreprise().getSelectedItem().toString());
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			Logement logement = null;
			try {
				logement = this.daoLogement.findById(String.valueOf(GestionMesLogements.immeuble.getIdImmeuble()), this.ajouterFactureLogement.getComboLogement().getSelectedItem().toString());
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			Facture facture = new Facture(this.ajouterFactureLogement.getFacture(), 
										  this.ajouterFactureLogement.getNature(), 
										  this.ajouterFactureLogement.getDate(), 
										  Float.valueOf(this.ajouterFactureLogement.getMontant()), 
										  Float.valueOf(this.ajouterFactureLogement.getNDedu()),
										  logement,
										  entreprise, 
										  false);
			
			try {
				this.daoFacture.create(facture);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			ajouterFactureLogement.dispose();
			break;
		case("Ajouter une Entreprise"):
			AjouterEntreprise a2Ent = new AjouterEntreprise();
			a2Ent.setVisible(true);
			a2Ent.toFront();
			break;
		}
		
		}
	}