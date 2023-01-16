package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import modele.Entreprise;
import modele.Facture;
import modele.Logement;
import modele.dao.DaoEntreprise;
import modele.dao.DaoFacture;
import modele.dao.DaoLogement;
import vue.AjouterEntreprise;
import vue.AjouterFacture;

public class GestionFactureImmeuble implements ActionListener{
	
	private AjouterFacture ajouterFacture;
	private DaoFacture daoFacture;
	private DaoEntreprise daoEntreprise;
	private DaoLogement daoLogement;
	
	public GestionFactureImmeuble(AjouterFacture fac) {
		this.ajouterFacture = fac ;
		this.daoFacture = new DaoFacture();
		this.daoEntreprise = new DaoEntreprise();
		this.daoLogement = new DaoLogement();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Annuler"):
			ajouterFacture.dispose();
			break;
		case("Valider"):
			Entreprise entreprise = null;
			try {
				entreprise = this.daoEntreprise.findByNom(this.ajouterFacture.getComboEntreprise().getSelectedItem().toString());
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			List<Logement> listeL = null;
			try {
				listeL = this.daoLogement.findListLogementByImmeuble(String.valueOf(GestionMesLogements.immeuble.getIdImmeuble()));
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			Facture facture = new Facture(this.ajouterFacture.getFacture(), 
										  this.ajouterFacture.getNature(), 
										  this.ajouterFacture.getDate(), 
										  Float.valueOf(this.ajouterFacture.getMontant()), 
										  Float.valueOf(this.ajouterFacture.getNDedu()),
										  listeL.get(0),
										  entreprise, 
										  true);
		
			try {
				this.daoFacture.create(facture);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			ajouterFacture.dispose();
			break;
		case("Ajouter une Entreprise"):
			AjouterEntreprise aEnt = new AjouterEntreprise();
			aEnt.setVisible(true);
			aEnt.toFront();
			break;
		}
		}
	}
