package modele;


public class Facture {
	

	private String nFacture ;
	private String typeF;
	private String dateF ;
	private float montant ;
	private float montantNonDeductible ;
	private Logement logement;
	private Entreprise entreprise;
	private boolean isImmeuble ;
	
	
	public Facture(String nFacture, String typeF, String dateF, float montant, float montantNonDeductible,
			Logement logement, Entreprise entreprise, boolean isImmeuble) {
		super();
		this.nFacture = nFacture;
		this.typeF = typeF;
		this.dateF = dateF;
		this.montant = montant ;
		this.montantNonDeductible = montantNonDeductible ;
		this.logement = logement;
		this.entreprise = entreprise;
		this.isImmeuble = isImmeuble ;
	}


	public String getnFacture() {
		return nFacture;
	}


	public void setnFacture(String nFacture) {
		this.nFacture = nFacture;
	}


	public String getTypeF() {
		return typeF;
	}


	public void setTypeF(String typeF) {
		this.typeF = typeF;
	}


	public String getDateF() {
		return dateF;
	}


	public void setDateF(String dateF) {
		this.dateF = dateF;
	}


	public float getMontant() {
		return montant;
	}


	public void setMontant(float montant) {
		this.montant = montant;
	}


	public float getMontantNonDeductible() {
		return montantNonDeductible;
	}


	public void setMontantNonDeductible(float montantNonDeductible) {
		this.montantNonDeductible = montantNonDeductible;
	}


	public Logement getLogement() {
		return logement;
	}


	public void setLogement(Logement logement) {
		this.logement = logement;
	}


	public Entreprise getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}


	public boolean isImmeuble() {
		return isImmeuble;
	}


	public void setImmeuble(boolean isImmeuble) {
		this.isImmeuble = isImmeuble;
	}


	@Override
	public String toString() {
		return "Facture [nFacture=" + nFacture + ", typeF=" + typeF + ", dateF=" + dateF + ", montant=" + montant
				+ ", montantNonDeductible=" + montantNonDeductible + ", logement=" + logement + ", entreprise="
				+ entreprise + ", isImmeuble=" + isImmeuble + "]";
	}


	
	
	
	
	

	
	
	
}
