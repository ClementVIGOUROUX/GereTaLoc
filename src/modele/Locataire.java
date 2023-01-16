package modele;

import java.util.Objects;

public class Locataire {
	
	private int idLoc;
	private String nom;
	private String telephone;
	private String prenom;
	private String email;
	private String sexe ;
	private String profession;
	//private List<Bail> listBaux ; // connaitre tous les baux d'un locataire ? 
	
	
	public Locataire(int idLoc, String nom, String telephone, String prenom, String email, String sexe,
			String profession) {
		super();
		this.idLoc = idLoc;
		this.nom = nom;
		this.telephone = telephone;
		this.prenom = prenom;
		this.email = email;
		this.sexe = sexe;
		this.profession = profession;
	}


	public int getIdLoc() {
		return idLoc;
	}


	public void setIdLoc(int idLoc) {
		this.idLoc = idLoc;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, idLoc, nom, prenom, profession, sexe, telephone);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Locataire)) {
			return false;
		}
		Locataire other = (Locataire) obj;
		return Objects.equals(email, other.email) && idLoc == other.idLoc && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(profession, other.profession)
				&& Objects.equals(sexe, other.sexe) && Objects.equals(telephone, other.telephone);
	}


	@Override
	public String toString() {
		return this.nom + this.prenom ;
	}
	
	
	public String toStringIHM() {
		return "Locataire [idLoc=" + idLoc + ", nom=" + nom + ", telephone=" + telephone + ", prenom=" + prenom
				+ ", email=" + email + ", sexe=" + sexe + ", profession=" + profession + "]";
	}
	
	
	
	

	

}
