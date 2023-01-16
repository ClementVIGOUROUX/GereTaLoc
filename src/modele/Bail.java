package modele;

import java.util.List;
import java.util.Objects;

public class Bail {

	private int idBail ;
	private String dateDebut ;
	private String dateDebutRenouvellement ;
	private String dateFin ;
	private int depotGarantie ;
	private Logement logement ;
	private Agence agence ;
	private List<Locataire> listLocataires ;
	private List<Charge> listCharges ;
	private List<Paiement> listPaiements ;
	private List<Caution> listCautions ;
	private List<EtatdesLieux> listEtatsdesLieux ;
	
	public Bail(int idBail, String dateDebut, String dateFin, int depotGarantie, Logement logement,
			Agence agence) {
		super();
		this.idBail = idBail;
		this.dateDebut = dateDebut;
		this.dateDebutRenouvellement = dateDebut ;
		this.dateFin = dateFin;
		this.depotGarantie = depotGarantie ;
		this.logement = logement;
		this.agence = agence;
	}

	public int getIdBail() {
		return idBail;
	}

	public void setIdBail(int idBail) {
		this.idBail = idBail;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public String getDateDebutRenouvellement() {
		return dateDebutRenouvellement;
	}

	public void setDateDebutRenouvellement(String dateDebutRenouvellement) {
		this.dateDebutRenouvellement = dateDebutRenouvellement;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	
	
	public int getDepotGarantie() {
		return this.depotGarantie;
	}

	public void setDepotGarantie(int depotGarantie) {
		this.depotGarantie = depotGarantie ;
	}
	


	public Logement getLogement() {
		return logement;
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public List<Locataire> getListLocataires() {
		return listLocataires;
	}

	public void setListLocataires(List<Locataire> listLocataires) {
		this.listLocataires = listLocataires;
	}

	public List<Charge> getListCharges() {
		return listCharges;
	}

	public void setListCharges(List<Charge> listCharges) {
		this.listCharges = listCharges;
	}

	public List<Paiement> getListPaiements() {
		return listPaiements;
	}

	public void setListPaiements(List<Paiement> listPaiements) {
		this.listPaiements = listPaiements;
	}

	public List<Caution> getListCautions() {
		return listCautions;
	}

	public void setListCautions(List<Caution> listCautions) {
		this.listCautions = listCautions;
	}

	public List<EtatdesLieux> getListEtatsdesLieux() {
		return listEtatsdesLieux;
	}

	public void setListEtatsdesLieux(List<EtatdesLieux> listEtatsdesLieux) {
		this.listEtatsdesLieux = listEtatsdesLieux;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idBail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Bail)) {
			return false;
		}
		Bail other = (Bail) obj;
		return idBail == other.idBail;
	}

	@Override
	public String toString() {
		return "Bail [idBail=" + idBail + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", dateLimitePaiement="
				+  ", logement=" + logement + ", listLocataires=" + listLocataires
				+ ", listPaiements=" + listPaiements + ", listEtatsdesLieux=" + listEtatsdesLieux + "]";
	}
	
	
	
	
	
	
}
