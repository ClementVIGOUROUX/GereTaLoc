package modele;
import java.util.Objects;

public class Agence {

	private String nSiret ;
	private String nom ;
	private String adresse ;
	private String cp ;
	private String ville ;
	private String telephone ;
	private String email ;
	public Agence(String nSiret, String nom, String adresse, String cp, String ville, String telephone, String email) {
		super();
		this.nSiret = nSiret;
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.telephone = telephone;
		this.email = email;
	}


	public String getnSiret() {
		return nSiret;
	}


	public void setnSiret(String nSiret) {
		this.nSiret = nSiret;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int hashCode() {
		return Objects.hash(nSiret);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Agence)) {
			return false;
		}
		Agence other = (Agence) obj;
		return Objects.equals(nSiret, other.nSiret);
	}


	@Override
	public String toString() {
		return "Agence [nSiret=" + nSiret + ", nom=" + nom + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville
				+ ", telephone=" + telephone + ", email=" + email + "]";
	}
	
	
	
	
}
