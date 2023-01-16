package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Agence;
import modele.Bail;
import modele.Caution;
import modele.EtatdesLieux;
import modele.Immeuble;
import modele.Locataire;
import modele.Logement;
import modele.Paiement;
import modele.Revision;
import modele.dao.DaoAgence;
import modele.dao.DaoBail;
import modele.dao.DaoCaution;
import modele.dao.DaoEtatdesLieux;
import modele.dao.DaoLocataire;
import modele.dao.DaoLogement;
import modele.dao.DaoPaiement;
import modele.dao.DaoRevision;
import modele.dao.Iterateur;
import vue.AjouterBail;
import vue.MesLocataires;

public class GestionBail implements ActionListener{
	
	private AjouterBail ajouterBail ;
	private DaoBail daoBail;
	private DaoRevision daoRevision;
	private DaoEtatdesLieux daoEDL;
	private DaoPaiement daoPaiement;
	private DaoCaution daoCaution;
	private DaoAgence daoAgence;
	private List<Locataire> listLocataire;
	
	public GestionBail(AjouterBail bail) {
		this.ajouterBail = bail ;
		this.daoBail = new DaoBail();
		this.daoRevision = new DaoRevision();
		this.daoEDL = new DaoEtatdesLieux();
		this.daoPaiement = new DaoPaiement();
		this.daoCaution = new DaoCaution();
		this.daoAgence = new DaoAgence();
		this.listLocataire = new LinkedList<Locataire>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case("Annuler"):
			ajouterBail.dispose();
			break;
		case("Valider"):
			
			DaoAgence daoAgence = new DaoAgence();
			
			Logement logement = (Logement) this.ajouterBail.getComboLogement().getSelectedItem();
			
			Agence agence = null;
			
			if (!this.ajouterBail.getFieldSiret().equals("")) {
				//Ajouter agence
				agence = new Agence (this.ajouterBail.getFieldSiret(),
											this.ajouterBail.getFieldNom(),
											this.ajouterBail.getFieldAdresse(),
											this.ajouterBail.getFiedlCP(),
											this.ajouterBail.getFieldVille(),
											this.ajouterBail.getFieldTel(),
											this.ajouterBail.getFieldMail());
				System.out.println(agence);
				
				try {
					this.daoAgence.create(agence);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
			
			// Creation du bail
			Bail bail = new Bail(1, this.ajouterBail.getFieldDDebut(),
								 	(String)null,
								 	Integer.valueOf(this.ajouterBail.getFieldDepot()),
								 	logement,
								 	agence);
			
			try {
				this.daoBail.create(bail);
				bail = this.daoBail.findByLogement(bail.getLogement().getNumero(), String.valueOf(bail.getLogement().getImmeuble().getIdImmeuble()));
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			// Ajouter IRL
			
			Revision revision = new Revision(1, Float.valueOf(this.ajouterBail.getFieldIRL()),
												bail);
			
			try {
				this.daoRevision.create(revision);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			// Ajouter EDL
			
			EtatdesLieux edl = new EtatdesLieux(1, this.ajouterBail.getFieldEtat(),
												   bail);
			
			try {
				this.daoEDL.create(edl);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			// Ajouter paiement
			
			Paiement paiement = new Paiement(1, this.ajouterBail.getFieldMoyen(),
												Integer.valueOf(this.ajouterBail.getFieldMontant()),
												this.ajouterBail.getFieldDPaiement(),
												0.00F,
												bail);
			
			try {
				this.daoPaiement.create(paiement);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			// Ajouter caution
			
			Caution caution = new Caution(1, this.ajouterBail.getFieldCNom(),
											 this.ajouterBail.getFieldCmail(),
											 this.ajouterBail.getFieldCtel(),
											 bail);
			
			try {
				this.daoCaution.create(caution);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			//Insert Signer (Lier locataire avec bail)
			
			Iterator<Locataire> il = this.listLocataire.iterator();
			
			while (il.hasNext()){
				try {
					this.daoBail.insertSigner(il.next(), bail);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			ajouterBail.dispose();
			break;
		case("Valider "):
			
			Locataire locataire = (Locataire) ajouterBail.getComboLocataire().getSelectedItem();
			this.listLocataire.add(locataire);
			
			for (int i = 0; i < this.listLocataire.size(); i++) {
				this.ecrireLigneTableLocataire(ajouterBail.getTableLoca(), i, this.listLocataire.get(i));
			}
			
			break;
			
		}
	}
	
	public void ecrireLigneTableLocataire(JTable tablelocataire, int numLigne, Locataire locataire) {
		DefaultTableModel modeleTable = (DefaultTableModel) tablelocataire.getModel();
		modeleTable.setValueAt(locataire.getPrenom(), numLigne, 0);
		modeleTable.setValueAt(locataire.getNom(), numLigne, 1);
		modeleTable.setValueAt(locataire.getProfession(), numLigne, 2);
	}

}
