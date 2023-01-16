package modele;

import java.util.Objects;

public class Entreprise {
	
	private String nSiret;
	private String nomEnteprise;
	private String adresse ;
	private String cp;
	private String ville;
	private String email;
	private String telephone;
	//private List<Facture> listfacture; est-ce qu'on doit chercher toutes les factures qu'une entreprise nous a faites ? a voir
	
	
	public Entreprise(String nSiret, String nomEnteprise, String adresse, String cp, String ville, String email,
			String telephone) {
		super();
		this.nSiret = nSiret;
		this.nomEnteprise = nomEnteprise;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.email = email;
		this.telephone = telephone;
	}


	public String getnSiret() {
		return nSiret;
	}


	public void setnSiret(String nSiret) {
		this.nSiret = nSiret;
	}


	public String getNomEnteprise() {
		return nomEnteprise;
	}


	public void setNomEnteprise(String nomEnteprise) {
		this.nomEnteprise = nomEnteprise;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
		if (!(obj instanceof Entreprise)) {
			return false;
		}
		Entreprise other = (Entreprise) obj;
		return Objects.equals(nSiret, other.nSiret);
	}


	@Override
	public String toString() {
		return "Entreprise [nSiret=" + nSiret + ", nomEnteprise=" + nomEnteprise + ", adresse=" + adresse + ", cp=" + cp
				+ ", ville=" + ville + ", email=" + email + ", telephone=" + telephone + "]";
	}

	
	
	
	
	
	
	
	

}
