package modele;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class Immeuble {
	
	private int idImmeuble;
	private String cp;
	private String ville;
	private String pays;
	private String rue;
	private boolean fibre;
	private Collection<Logement> listLogement;
	
	public Immeuble(int idImmeuble, String cp, String ville, String pays, String rue, boolean fibre) {
		super();
		this.idImmeuble = idImmeuble;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
		this.rue = rue;
		this.fibre = fibre;
		this.listLogement = new LinkedList<Logement>(); 
	}

	public int getIdImmeuble() {
		return idImmeuble;
	}

	public void setIdImmeuble(int idImmeuble) {
		this.idImmeuble = idImmeuble;
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

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public boolean isFibre() {
		return fibre;
	}

	public void setFibre(boolean fibre) {
		this.fibre = fibre;
	}

	public Collection<Logement> getListlogement() {
		return listLogement;
	}

	public void setListlogement(Collection<Logement> listlogement) {
		listLogement = listlogement;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idImmeuble);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Immeuble)) {
			return false;
		}
		Immeuble other = (Immeuble) obj;
		return idImmeuble == other.idImmeuble;
	}

	@Override
	public String toString() {
		return rue + " à " + ville + " " + cp + ", " + pays.toUpperCase() ;
	}
	
	public String toStringIHM() {
		return "Immeuble [idImmeuble=" + idImmeuble + ", cp=" + cp + ", ville=" + ville + ", pays=" + pays + ", rue="
		+ rue + ", fibre=" + fibre + "]";
	}
	
	
	
	
	

}
