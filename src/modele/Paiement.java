package modele;

import java.util.Objects;

public class Paiement {
	
	private int idPaiement;
	private String moyen;
	private int montant;
	private String dateP;
	private float provisionCharges;
	private Bail bail ;
	
	
	public Paiement(int idPaiement, String moyen, int montant, String dateP, float provisionCharges, Bail bail) {
		super();
		this.idPaiement = idPaiement;
		this.moyen = moyen;
		this.montant = montant;
		this.dateP = dateP;
		this.provisionCharges = provisionCharges;
		this.bail = bail;
	}


	public int getIdPaiement() {
		return idPaiement;
	}


	public void setIdPaiement(int idPaiement) {
		this.idPaiement = idPaiement;
	}


	public String getMoyen() {
		return moyen;
	}


	public void setMoyen(String moyen) {
		this.moyen = moyen;
	}


	public int getMontant() {
		return montant;
	}


	public void setMontant(int montant) {
		this.montant = montant;
	}


	public String getDateP() {
		return dateP;
	}


	public void setDateP(String dateP) {
		this.dateP = dateP;
	}


	public float getProvisionCharges() {
		return provisionCharges;
	}


	public void setProvisionCharges(float provisionCharges) {
		this.provisionCharges = provisionCharges;
	}


	public Bail getBail() {
		return bail;
	}


	public void setBail(Bail bail) {
		this.bail = bail;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idPaiement);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Paiement)) {
			return false;
		}
		Paiement other = (Paiement) obj;
		return idPaiement == other.idPaiement;
	}


	@Override
	public String toString() {
		return "Paiement [idPaiement=" + idPaiement + ", moyen=" + moyen + ", montant=" + montant + ", dateP=" + dateP
				+ ", provisionCharges=" + provisionCharges + ", bail=" + bail + "]";
	}
	
	
	
	
	
	
	

}
