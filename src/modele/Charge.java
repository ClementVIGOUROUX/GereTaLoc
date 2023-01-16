package modele;


public class Charge {
	
	private int idCharge ;
	private String nom ;
	private int index_c ;
	private int montant ;
	private int index_final ;
	private float prixUnite ;
	private Bail bail ;
	
	
	public Charge(int idCharge, String nom, int index_c, int montant, Bail bail) {
		super();
		this.idCharge = idCharge;
		this.nom = nom ;
		this.index_c = index_c ;
		this.montant = montant ;
		this.index_final = 0 ;
		this.prixUnite = 0 ;
		this.bail = bail;
	}


	public int getIdCharge() {
		return idCharge;
	}


	public void setIdCharge(int idCharge) {
		this.idCharge = idCharge;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getIndex_c() {
		return index_c;
	}


	public void setIndex_c(int index_c) {
		this.index_c = index_c;
	}


	public int getMontant() {
		return montant;
	}


	public void setMontant(int montant) {
		this.montant = montant;
	}
	

	public int getIndex_final() {
		return index_final;
	}


	public void setIndex_final(int index_final) {
		this.index_final = index_final;
	}


	public float getPrixUnite() {
		return prixUnite;
	}


	public void setPrixUnite(float prixUnite) {
		this.prixUnite = prixUnite;
	}


	public Bail getBail() {
		return bail;
	}


	public void setBail(Bail bail) {
		this.bail = bail;
	}


	@Override
	public String toString() {
		return "Charge [idCharge=" + idCharge + ", nom=" + nom + ", index_c=" + index_c + ", montant=" + montant
				+ ", bail=" + bail + "]";
	}


	
	
	
	

}
