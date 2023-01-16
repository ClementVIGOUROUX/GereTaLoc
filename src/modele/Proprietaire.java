package modele ;

import java.util.Objects;

public class Proprietaire {
	
	private int id_Prop ;
	private String nom ;
	private String prenom ;
	private String email ;
	private String telephone ;
	//private Collection<Logement> logements ;
	
	
	public Proprietaire(int id_Prop, String nom, String prenom, String email, String telephone) {
		this.id_Prop = id_Prop;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
	}


	public int getId_Prop() {
		return id_Prop;
	}


	public void setId_Prop(int id_Prop) {
		this.id_Prop = id_Prop;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
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


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id_Prop);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Proprietaire)) {
			return false;
		}
		Proprietaire other = (Proprietaire) obj;
		return id_Prop == other.id_Prop;
	}


	@Override
	public String toString() {
		return "Proprietaire [id_Prop=" + id_Prop + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", telephone=" + telephone + "]";
	}
	
	public String toStringRapport() {
		return "M. " + this.prenom + " " + this.nom.toUpperCase() + "\n Tel : " + this.telephone ; 
	}
	
	
	
	
	
	
	
}