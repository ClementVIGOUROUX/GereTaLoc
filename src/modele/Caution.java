package modele;

import java.util.Objects;

public class Caution {

	private int idCaution ;
	private String nom ;
	private String email ;
	private String telephone ;
	private Bail bail ;
	
	
	public Caution(int idCaution, String nom, String email, String telephone, Bail bail) {
		super();
		this.idCaution = idCaution;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.bail = bail;
	}


	public int getIdCaution() {
		return idCaution;
	}


	public void setIdCaution(int idCaution) {
		this.idCaution = idCaution;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
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


	public Bail getBail() {
		return bail;
	}


	public void setBail(Bail bail) {
		this.bail = bail;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idCaution);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Caution)) {
			return false;
		}
		Caution other = (Caution) obj;
		return idCaution == other.idCaution;
	}


	@Override
	public String toString() {
		return "Caution [idCaution=" + idCaution + ", nom=" + nom + ", email=" + email + ", telephone=" + telephone
				+ ", bail=" + bail + "]";
	}
	
	
	
	
}
